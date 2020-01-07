package com.couchDB.app.Models;
import java.util.Date;
public class Tweet extends CouchDBSchema {

    String Utilisateur;
    String Contenu;
    String Hashtag;
    Date Created;

    public Tweet() {
        Created = new Date();
    }

    public Tweet(String user, String contenu, String hashtag) {
        Utilisateur = user;
        Contenu = contenu;
        Hashtag = hashtag;
        Created = new Date();
    }

    public String getFrom() {
        return Utilisateur;
    }

    public void setFrom(String user) {
        Utilisateur = user;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public String getHash() {
        return Hashtag;
    }

    public void setHash(String hashtag) {
        Hashtag = hashtag;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }
}
