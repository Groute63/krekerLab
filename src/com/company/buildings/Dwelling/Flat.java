package com.company.buildings.Dwelling;

import com.company.buildings.Interfece.Space;
import com.company.erors.InvalidRoomsCountException;
import com.company.erors.InvalidSpaceAreaException;

public class Flat implements Space {
    private final double defaultSquare = 50;
    private final int defaultRoomCount = 2;
    private double square;
    private int roomCount;
    //////////task5
   public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + "  Flat : " + roomCount + "   " +square );
        return  b.toString();
    }
    public boolean equals(Object object){
        if(object == null)
            return  false;
        if(object == this)
            return  true;
        if(object instanceof Flat)
        {
            Flat o = (Flat)object;
            if(this.roomCount ==o.roomCount && this.square == o.square)
                return  true;
        }
        return  false;
    }
    public int hashCode() {
        final int prime = 2;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(square);
        result =  prime*result + (int) (temp ^ (temp >>> 32));
        result = prime * result + roomCount;
        return result;
    }public Object clone() {
        Object result = null;
        try {
            result = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        return result;
    }
    /////////////
    public Flat() {
        roomCount = defaultRoomCount;
        square = defaultSquare;
    }
    public Flat(double square) {
        if (square<0)
            throw new InvalidSpaceAreaException(square);

        roomCount = defaultRoomCount;
        this.square = square;
    }
    public Flat(double square, int roomCount) {
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
            throw new InvalidSpaceAreaException(square);

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
