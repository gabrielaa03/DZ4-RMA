package com.gabrielaangebrandt.bugsy;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * Created by Gabriela on 27.4.2017..
 */
@Root(name="rss", strict=false)
public class RSSFeed {

    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<Objekt> objektList;


    public List<Objekt> getList() {
        return objektList;
    }

    public void setList(List<Objekt> objektList) {
        this.objektList= objektList;
    }

}


