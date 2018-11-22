package pl.oskarpolak.fdetector.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.fdetector.models.NewsEntity;
import pl.oskarpolak.fdetector.models.forms.NewsForm;
import pl.oskarpolak.fdetector.models.repositories.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void addNewNews(NewsForm newsForm) {
        newsRepository.save(new NewsEntity(newsForm));
    }

    public Iterable<NewsEntity> loadAllNews(){
        return newsRepository.findAll();
    }

}
