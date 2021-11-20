package com.company.buildings;

import com.company.buildings.Interfece.Space;

import java.util.Comparator;

public class RoomsComparator implements Comparator<Space> {
    public int compare(Space o1, Space o2) {
        if(o1.getRoomCount() > o2.getRoomCount()) return -1;
        else if(o1.getRoomCount() == o2.getRoomCount()) return 0;
        return 1;
    }
}
