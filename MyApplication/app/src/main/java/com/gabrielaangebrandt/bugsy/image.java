package com.gabrielaangebrandt.bugsy;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Gabriela on 27.4.2017..
 */

@Root(strict = false)
public class image {
    @Attribute(name = "url")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }
}