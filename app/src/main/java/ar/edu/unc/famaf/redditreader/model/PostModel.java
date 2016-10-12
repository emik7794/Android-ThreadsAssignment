package ar.edu.unc.famaf.redditreader.model;


import java.net.MalformedURLException;
import java.net.URL;

public class PostModel {

    private String title;
    private String author;
    private String date;
    private int comments;
    //private int previewImageId;
    private URL urlPreviewImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    /*public int getPreviewId() {
        return previewImageId;
    }

    public void setPreviewId(int previewId) {
        this.previewImageId = previewId;
    }
    */
    public URL getUrlPreviewImage() {
        return urlPreviewImage;
    }

    public void setUrlPreviewImage(String urlString) {

        try {
            this.urlPreviewImage = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
