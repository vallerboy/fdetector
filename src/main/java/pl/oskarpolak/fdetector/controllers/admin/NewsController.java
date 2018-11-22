package pl.oskarpolak.fdetector.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.fdetector.models.forms.NewsForm;
import pl.oskarpolak.fdetector.models.services.NewsService;

@Controller
public class NewsController {

    final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping("/admin/news/add")
    public String showAddNewsTemplate(Model model){
        model.addAttribute("newsForm", new NewsForm());
        return "admin/addNews";
    }

    @PostMapping("/admin/news/add")
    public String getFormDataFromTemplate(@ModelAttribute NewsForm newsForm, Model model){
        newsService.addNewNews(newsForm);
        model.addAttribute("info", "Dodano newsa!");

        return "admin/addNews";
    }

}
