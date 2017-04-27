package com.gabrielaangebrandt.bugsy;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Gabriela on 25.4.2017..
 */
@Root(name="item", strict = false)
class Objekt {
    @Element(name = "title")
    private String mtitle;
    @Element(name = "description")
    private String mdescription;
    @Element(name = "category")
    private String mcategory;
    @Element(name = "enclosure")
    private image menclosure;
    @Element(name = "pubDate")
    private String mpubDate;
    @Element(name = "link")
    private String mlink;

    public String getMlink() {
        return mlink;
    }

    public void setMlink(String mlink) {
        this.mlink = mlink;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMcategory() {
        return mcategory;
    }

    public void setMcategory(String mcategory) {
        this.mcategory = mcategory;
    }

    public String getMenclosure() {
        return menclosure.getImgUrl();
    }

    public void setMenclosure(image menclosure) {
        this.menclosure = menclosure;
    }

    public String getMpubDate() {
        return mpubDate;
    }

    public void setMpubDate(String mpubDate) {
        this.mpubDate = mpubDate;
    }
}
