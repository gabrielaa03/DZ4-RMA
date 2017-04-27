package com.gabrielaangebrandt.bugsy;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Gabriela on 25.4.2017..
 */
@Root(name="item", strict = false)
class Objekt {
    @Element(name = "title") private String mtitle;
    @Element(name = "description") private String mdescription;
    @Element(name = "category") private String mcategory;
    @Element(name = "enclosure") private image menclosure;
    @Element(name = "pubDate") private String mpubDate;

    public String getTitle() {
        return mtitle;
    }

    public void setTitle(String title) {
        this.mtitle = title;
    }

    public String getDescription() {
        return mdescription;
    }

    public void setDescription(String description) {
        this.mdescription = description;
    }

    public String getCategory() {
        return mcategory;
    }

    public void setCategory(String category) {
        this.mcategory = category;
    }

    public String getUrl() {
        return menclosure.getImgUrl();
    }


    public String getPubDate() {
        return mpubDate;
    }

    public void setPubDate(String pubDate) {
        this.mpubDate = pubDate;
    }
}
