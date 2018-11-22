package pl.oskarpolak.fdetector.controllers.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.oskarpolak.fdetector.models.services.NewsService;

@Controller
public class MainController {

    final NewsService newsService;

    @Autowired
    public MainController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/page/0";
    }

    @GetMapping("/page/{id}")
    public String indexWithPage(Model model,
                                @PathVariable("id") int id){
        model.addAttribute("news", newsService.loadPage(id));
        return "user/index";
    }

}
