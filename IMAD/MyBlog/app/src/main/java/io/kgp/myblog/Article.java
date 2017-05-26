package io.kgp.myblog;

import com.google.gson.annotations.SerializedName;
/**
 * Created by BREEZY on 26-May-17.
 */

public class Article {

    @SerializedName("id")
    Integer id;

    @SerializedName("heading")
    String heading;

    @SerializedName("title")
    String title;

    @SerializedName("date")
    String date;

    @SerializedName("content")
    String content;

    public Integer getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
