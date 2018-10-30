package edu.uncw.seahawktours;

import android.media.Image;

public class Building {

    //MARK: Properties
    private int nameId;
    private int descriptionId;
    private int urlId;
    private int img_resourceID;
    private int captionId;

    // Constructor(s)
    public Building(int name, int description, int url,
                    int img_resourceID, int caption) {
        this.nameId = name;
        this.descriptionId = description;
        this.urlId = url;
        this.img_resourceID = img_resourceID;
        this.captionId = caption;

    }

    // Array of buildings
    public static final Building[] buildings = {

            new Building(R.string.CameronHallName, R.string.CameronHallImageDescription,
                    R.string.Cameron_url, R.drawable.cameron, R.string.CameronCaption),
            new Building(R.string.CISBuildingName, R.string.CISBuildingImageDescription,
                    R.string.CIS_url, R.drawable.cis, R.string.CISCaption),
            new Building(R.string.FridayHallName, R.string.FridayHallImageDescription,
                    R.string.Friday_url, R.drawable.cis, R.string.CISCaption)
    };



    public int getName() {

        return this.nameId;
    }

    public int getDescription() {

        return this.descriptionId;
    }

}
