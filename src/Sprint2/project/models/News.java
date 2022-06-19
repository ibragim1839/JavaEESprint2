package Sprint2.project.models;

import javax.sound.sampled.Line;

public class News {

    private Long id;
    private String title;
    private String short_content;
    private String content;
    private String picture;
    private String date;
    private Language language;
    private Publication publication;

    public News(Long id, String title, String short_content, String content, String picture, String date, Language language,
                Publication publication) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.picture = picture;
        this.date = date;
        this.language = language;
        this.publication = publication;
    }


    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}
