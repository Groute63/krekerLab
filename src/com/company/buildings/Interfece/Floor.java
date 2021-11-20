package com.company.buildings.Interfece;

import java.io.Serializable;

public interface Floor extends Serializable,Cloneable,Comparable<Floor>,Iterable<Space> {
     int getSpaceCount();
     double getFullSquare();
     int getAllRoomCount();
     Space[] getSpaces();
     Space getSpace(int number);
     void setSpace(int Number, Space sp);
     void addSpace(int Number, Space sp);
     void deleteSpace(int number);
     Space getBestSpace() ;
     Object clone();

}








