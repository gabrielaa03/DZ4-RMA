package com.gabrielaangebrandt.bugsy;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gabriela on 27.4.2017..
 */

public interface API {
    @GET("rss/vijesti")
    Call<RSSFeed> loadRSSFeed();
}
