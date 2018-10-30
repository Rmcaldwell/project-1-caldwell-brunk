package edu.uncw.seahawktours;

import android.media.Image;

public class Building {

    //MARK: Properties
    private String name;
    private String description;
    private String url;
    private int img_resourceID;
    private String caption;

    public


    //
    public Building(String name, String description, String url,
                    int img_resourceID, String caption) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.img_resourceID = img_resourceID;
        this.caption = caption;

    }

    public String getName() {

        return this.name;
    }

    public String getDescription() {

        return this.description;
    }

}
