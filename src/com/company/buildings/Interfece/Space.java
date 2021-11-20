package com.company.buildings.Interfece;

import java.io.Serializable;

public interface Space extends Serializable,Cloneable,Comparable<Space> {
     int getRoomCount();
     void setRoomCount(int roomCount);
     double getSquare();
     void setSquare(double square);
     Object clone();
}
