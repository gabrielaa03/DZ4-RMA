package com.gabrielaangebrandt.bugsy;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * Created by Gabriela on 27.4.2017..
 */
@Root(name="rss", strict=false)
public class RSSFeed {
    @Element(name="title")
    @Path("channel")
    private String channelTitle;

    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<Objekt> objektList;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public List<Objekt> getList() {
        return objektList;
    }

    public void setList(List<Objekt> objektList) {
        this.objektList= objektList;
    }

}
