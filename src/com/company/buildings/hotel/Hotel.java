package com.company.buildings.hotel;

import com.company.buildings.Dwelling.Dwelling;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;

public class Hotel extends Dwelling  {
    public Hotel(Floor[] hotelFloors) {
        super(hotelFloors);
    }
    public Hotel(int floorsCount, int[] spacesCounts) {
        super(floorsCount, spacesCounts);
    }
    public int getMaxStars() {
        int result = 0;
        for (Floor floor : floors) {
            if (floor instanceof HotelFloor) {
                if (result < ((HotelFloor)floor).getStars())
                    result = ((HotelFloor)floor).getStars();
            }
        }
        return result;
    }
    public Space getBestSpace() {
        double[] coef = {0.5, 0.75, 1, 1.25, 1.5};
        Space bestSpace = null;
        double result = 0;
        for (Floor floor : floors) {
            if (floor instanceof HotelFloor) {
                for (Space flat : floor.getSpaces()) {
                    double score = coef[((HotelFloor)floor).getStars() - 1] * flat.getSquare();
                    if (result < score) {
                        result = score;
                        bestSpace = flat;
                    }
                }
            }
        }
        return bestSpace;
    }
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + "Hotel : " );
        for(int i = 0; i< this.getDwellingCount();i++)
            b.append(getDwelling()[i].toString());
        return  b.toString();
    }
    public int hashCode() {
        final int prime = 17;
        int result = super.hashCode();
        result = prime * result;
        return result;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Hotel))
            return false;
        return true;
    }
}
