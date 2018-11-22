package pl.oskarpolak.fdetector.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.fdetector.models.forms.NewsForm;
import pl.oskarpolak.fdetector.models.services.ImageService;
import pl.oskarpolak.fdetector.models.services.NewsService;

import java.io.IOException;

@Controller
public class NewsController {

    final NewsService newsService;
    final ImageService imageService;

    @Autowired
    public NewsController(NewsService newsService, ImageService imageService) {
        this.newsService = newsService;
        this.imageService = imageService;
    }


    @GetMapping("/admin/news/add")
    public String showAddNewsTemplate(Model model){
        model.addAttribute("newsForm", new NewsForm());
        return "admin/addNews";
    }

    @PostMapping("/admin/news/add")
    public String getFormDataFromTemplate(@ModelAttribute NewsForm newsForm,
                                          Model model){
        int id = newsService.addNewNews(newsForm);
        try {
            imageService.moveImageToPhotoDir(newsForm.getImageHeader(), id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("info", "Dodano newsa!");
        return "admin/addNews";
    }

}
