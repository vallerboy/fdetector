package pl.oskarpolak.fdetector.models.forms;


import lombok.Data;

@Data
public class NewsForm {
    private String title;
    private String newsContent;
    private String newsFakeProvement;
    private String author;
    private String newsOrigin;

}
