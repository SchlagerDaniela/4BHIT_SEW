package model;

import java.io.Serializable;
import java.util.Objects;

/*
        Author: Schlager Daniela
        Date: 15.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 27.11.2019

 */
public class Entry implements Serializable {

    private String website;
    private String username;
    private String password;
    private String link;

    public Entry(String website, String username, String password, String link) {
        this.website = website;
        this.username = username;
        this.password = password;
        this.link = link;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(website, entry.website) &&
                Objects.equals(username, entry.username) &&
                Objects.equals(password, entry.password) &&
                Objects.equals(link, entry.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, username, password, link);
    }
}