package com.company.buildings.hotel;

import com.company.buildings.Dwelling.DwellingFloor;
import com.company.buildings.Interfece.Space;

public class HotelFloor extends DwellingFloor {
    private int starCount;
    private static final int DEFAULT_STAR_COUNT = 1;
    public HotelFloor(int spacesAmount) {
        super(spacesAmount);
        starCount = DEFAULT_STAR_COUNT;
    }

    public HotelFloor(Space[] spaces) {
        super(spaces);
        starCount = DEFAULT_STAR_COUNT;
    }
    public int getStars() {
        return starCount;
    }

    public void setStars(int stars) {
        starCount = stars;
    }
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + " HotelFloor stars - " +starCount + "  : " );
        for(int i = 0; i< this.getSpaceCount();i++)
            b.append(getSpaces()[i].toString());
        return  b.toString();
    }
    public int hashCode() {
        final int prime = 21;
        int result = super.hashCode();
        result = prime * result + starCount;
        return result;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof HotelFloor))
            return false;
        HotelFloor other = (HotelFloor) obj;
        if (starCount != other.getStars())
            return false;
        return true;
    }
}
