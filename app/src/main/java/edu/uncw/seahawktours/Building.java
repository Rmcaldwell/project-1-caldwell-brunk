package edu.uncw.seahawktours;

import android.content.Context;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Building {

    @Id public long id;

    //MARK: Properties
    private String nameId;
    private int urlId;
    private int img_resourceId;
    private int captionId;
    private int buildingInfoId;

    // Constructor(s)
    public Building(String name, int url,
                    int img_resourceId, int caption, int buildingInfo) {
        this.nameId = name;
        this.urlId = url;
        this.img_resourceId = img_resourceId;
        this.captionId = caption;
        this.buildingInfoId = buildingInfo;

    }

    public Building(String name) {
        this.nameId = name;
    }

    public Building() {}

    //Array of building latitudes
    public static final double[] buildingLat = {
            34.22634, // CIS
            34.22577, // Cameron
            34.22454, // Shinn
            34.22542, // Dobo
            34.22782, // Randall
            34.22738, // Kresge
            34.22805, // Friday
    };

    // Array of building longitudes
    public static final double[] buildingLon = {
            -77.87164, // CIS
            -77.86977, // Cameron
            -77.86422, // Shinn
            -77.86851, // Dobo
            -77.87422, // Randall
            -77.86986, // Kresge
            -77.8705,  // Friday
    };

    // Array of buildings
//    public static final Building[] buildings = {
//            new Building("Cameron Hall", R.string.Cameron_url, R.drawable.cameron, R.string.CameronCaption, R.string.CameronHallInfo),
////            new Building(R.string.CISBuildingName, R.string.CIS_url, R.drawable.cis, R.string.CISCaption, R.string.CISBuildingInfo),
////            new Building(R.string.FridayHallName, R.string.Friday_url, R.drawable.cis, R.string.CISCaption, R.string.FridayHallInfo),
////            new Building(R.string.KresgeName, R.string.Kresge_url, R.drawable.kresge, R.string.KresgeCaption, R.string.KresgeInfo),
////            new Building(R.string.ShinnName, R.string.Shinn_url, R.drawable.shinn, R.string.ShinnCaption, R.string.ShinnInfo),
//    };
//
//    // Array of buildingNames
//    public static final String[] buildingNames = {
//            MainActivity.getAppContext().getResources().getString(R.string.CameronHallName),
//            MainActivity.getAppContext().getResources().getString(R.string.CISBuildingName),
//            MainActivity.getAppContext().getResources().getString(R.string.FridayHallName),
//            MainActivity.getAppContext().getResources().getString(R.string.KresgeName),
//            MainActivity.getAppContext().getResources().getString(R.string.ShinnName)
//    };


    // ******************* GETTERS AND SETTERS ********************** //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public int getImg_resourceId() {
        return img_resourceId;
    }

    public void setImg_resourceId(int img_resourceId) {
        this.img_resourceId = img_resourceId;
    }

    public int getCaptionId() {
        return captionId;
    }

    public void setCaptionId(int captionId) {
        this.captionId = captionId;
    }

    public int getBuildingInfoId() {
        return buildingInfoId;
    }

    public void setBuildingInfoId(int buildingInfoId) {
        this.buildingInfoId = buildingInfoId;
    }
}

