package com.zaptrapp.dropboxtest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nishanth on 06-Oct-17.
 */

public class MainResponse {

    @SerializedName("photos")
    public Photos photos;
    @SerializedName("stat")
    public String stat;

    public class Photo {
        @SerializedName("id")
        public String id;
        @SerializedName("owner")
        public String owner;
        @SerializedName("secret")
        public String secret;
        @SerializedName("server")
        public String server;
        @SerializedName("farm")
        public int farm;
        @SerializedName("title")
        public String title;
        @SerializedName("ispublic")
        public int ispublic;
        @SerializedName("isfriend")
        public int isfriend;
        @SerializedName("isfamily")
        public int isfamily;
    }

    public class Photos {
        @SerializedName("page")
        public int page;
        @SerializedName("pages")
        public int pages;
        @SerializedName("perpage")
        public int perpage;
        @SerializedName("total")
        public String total;
        @SerializedName("photo")
        public List<Photo> photo;
    }
}
