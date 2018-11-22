package pl.oskarpolak.fdetector.controllers.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.fdetector.models.services.NewsService;

@Controller
public class MainController {

    final NewsService newsService;

    @Autowired
    public MainController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("news", newsService.loadAllNews());
        return "user/index";
    }

}
