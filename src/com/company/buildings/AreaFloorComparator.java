package com.company.buildings;

import com.company.buildings.Interfece.Floor;

import java.util.Comparator;

public class AreaFloorComparator  implements Comparator<Floor> {
    public int compare(Floor o1, Floor o2) {
        if(o1.getFullSquare() > o2.getFullSquare()) return -1;
        else if(o1.getFullSquare() == o2.getFullSquare()) return 0;
        return 1;
    }
}

