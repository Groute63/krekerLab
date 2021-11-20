package com.company.buildings.Interfece;

import java.io.Serializable;

public interface Building extends Serializable ,Cloneable,Iterable<Floor>{
    int getDwellingCount();
    int getAllSpacesPerDwelling();
    double getTotalSquarePerDwelling();
    int getTotalNumberOfRoomsPerDwelling();
    Floor[] getDwelling();
    Floor getFloorByNumber(int numberFloor);
    void setFloorByNumber(int numberFloor, Floor newFloor);
    Space getSpace(int numberOfSpace);
    void setSpace(int numberOfSpace, Space newSpace);
    void addSpace(int numberOfSpace, Space newSpace);
    void deleteSpaceByNumberPerDwelling(int numberOfSpace);
    Space getBestSpace();
    Space[] getSortArraySpace();
    Object clone();

}







