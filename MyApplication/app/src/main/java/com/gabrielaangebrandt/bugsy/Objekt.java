package com.gabrielaangebrandt.bugsy;

/**
 * Created by Gabriela on 25.4.2017..
 */

class Objekt {
    String title, description, category, url, pubDate;

  /*  public Objekt(String title, String description, String category,String pubDate, String url) {
        this.title = title;
        this.description = description;
        this.category= category;
        this.url = url;
        this.pubDate = pubDate;
    }
*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
