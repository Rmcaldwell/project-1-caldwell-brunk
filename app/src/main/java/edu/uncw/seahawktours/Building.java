package edu.uncw.seahawktours;

import android.media.Image;

public class Building {

    //MARK: Properties
    private int nameId;
    private int urlId;
    private int img_resourceId;
    private int captionId;
    private int buildingInfoId;

    // Constructor(s)
    public Building(int name, int url,
                    int img_resourceId, int caption, int buildingInfo) {
        this.nameId = name;
        this.urlId = url;
        this.img_resourceId = img_resourceId;
        this.captionId = caption;
        this.buildingInfoId = buildingInfo;
    }

    // Array of buildings
    public static final Building[] buildings = {
            new Building(R.string.CameronHallName, R.string.Cameron_url, R.drawable.cameron, R.string.CameronCaption, R.string.CameronHallInfo),
            new Building(R.string.CISBuildingName, R.string.CIS_url, R.drawable.cis, R.string.CISCaption, R.string.CISBuildingInfo),
            new Building(R.string.FridayHallName, R.string.Friday_url, R.drawable.cis, R.string.CISCaption, R.string.FridayHallInfo),
            new Building(R.string.KresgeName, R.string.Kresge_url, R.drawable.kresge, R.string.KresgeCaption, R.string.KresgeInfo),
            new Building(R.string.ShinnName, R.string.Shinn_url, R.drawable.shinn, R.string.ShinnCaption, R.string.ShinnInfo),
    };

    public int getName() {

        return this.nameId;
    }

    public int getImage() {

        return this.img_resourceId;
    }

    public int getCaption() {

        return this.captionId;
    }

    public int getInfo() {

        return this.buildingInfoId;
    }

    public int getURL() {

        return this.urlId;
    }

}
