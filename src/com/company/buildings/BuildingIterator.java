package com.company.buildings;

import com.company.buildings.Interfece.Floor;

import java.util.Iterator;

public class BuildingIterator implements Iterator<Floor> {
    private Floor[] building;
    private int curCount;
    private  int count;
    public BuildingIterator(Floor[] floor)
    {
        this.building = floor;
        count = floor.length;
        curCount =count;
    }
    public boolean hasNext() {return  curCount != 0;}

    @Override
    public Floor next() {
        try {
            return building[count-curCount];
        }
        finally {
            curCount--;
        }
    }
}
