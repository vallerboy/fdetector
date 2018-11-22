package pl.oskarpolak.fdetector.models;


import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.oskarpolak.fdetector.models.forms.NewsForm;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "news")
public class NewsEntity {
    private @Id @GeneratedValue int id;
    private String author;
    private String title;
    private @Column(name = "news_content") String newsContent;
    private @Column(name = "news_fake_provement") String newsFakeProvement;
    private @Column(name = "news_origin") String newsOrigin;
    private @Column(name = "create_date") LocalDateTime createDate;

    public NewsEntity(NewsForm newsForm) {
        this.author = newsForm.getAuthor();
        this.newsContent = newsForm.getNewsContent();
        this.newsFakeProvement = newsForm.getNewsFakeProvement();
        this.newsOrigin = newsForm.getNewsOrigin();
        this.title = newsForm.getTitle();
    }

    public NewsEntity() { }
}
