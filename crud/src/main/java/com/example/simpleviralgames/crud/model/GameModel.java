package com.example.simpleviralgames.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * A model class representing a Game in the MongoDB database.
 * This class is annotated with @Document to specify the MongoDB collection
 * where it belongs to.
 */
@Document(collection = "game")
public class GameModel {
    @Id
    private String id;
    private String name;
    private String url;
    private String author;
    private Date publishedDate;

    /**
     * Default constructor for the GameModel class.
     */
    public GameModel() {
    }

    /**
     * 
     * @param name          represents name of the game.
     * @param url           represents URL of the game.
     * @param author        represents for the game.
     * @param publishedDate represents date the game was published.
     */

    public GameModel(String name, String url, String author, Date publishedDate) {
        this.name = name;
        this.url = url;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
