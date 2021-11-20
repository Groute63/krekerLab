package com.company.buildings.Office;

import com.company.buildings.Dwelling.Flat;
import com.company.buildings.Interfece.Space;
import com.company.erors.InvalidRoomsCountException;
import com.company.erors.InvalidSpaceAreaException;

public class Office implements Space {



    private final double defaultSquare = 50;
    private final int defaultRoomCount = 2;
    private double square;
    private int roomCount;
    /////////// task 5
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + "  Office : " + roomCount + "   " +square );
        return  b.toString();
    }
   public boolean equals(Object object){
        if(object == null)
            return  false;
        if(object == this)
            return  true;
        if(object instanceof Office)
        {
            Office o = (Office)object;
            if(this.roomCount ==o.roomCount && this.square == o.square)
                return  true;
        }
        return  false;
    }
    public int hashCode() {
        final int prime = 7;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(square);
        result =  prime*result + (int) (temp ^ (temp >>> 32));
        result = prime * result + roomCount;
        return result;
    }

    public Object clone() {
        Office result = null;
        try {
            result =(Office) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return result;
    }
    //////////////
    public Office() {
        roomCount = defaultRoomCount;
        square = defaultSquare;
    }
    public Office(double square) {
        if (square<0)
            throw  new InvalidSpaceAreaException(square);
        roomCount = defaultRoomCount;
        this.square = square;
    }
    public Office(double square, int roomCount) {
        if (square<0)
            throw new InvalidSpaceAreaException(square);
        if(roomCount<0)
            throw  new InvalidRoomsCountException(roomCount);
        this.roomCount = roomCount;
        this.square = square;
    }
    public int getRoomCount(){
        return roomCount;
    }
    public void setRoomCount(int roomCount){
        if(roomCount<0)
            throw  new InvalidRoomsCountException(roomCount);
        this.roomCount= roomCount;
    }
    public double getSquare(){
        return square;
    }
    public void setSquare(double square){
        if (square<0)
            throw  new InvalidSpaceAreaException(square);
        this.square= square;
    }
    public int compareTo(Space o) {
        if(o.getSquare()>getSquare())
            return 1;
        else  if(o.getSquare()==getSquare())
            return 0;
        return  -1;
    }
}
