package com.company.buildings;

import com.company.buildings.Interfece.Space;

import java.util.Iterator;

public class FloorIterator implements Iterator<Space> {
    private Space[] floor;
    private int curCount;
    private  int count;
    public FloorIterator(Space[] floor)
    {
        this.floor = floor;
        count = floor.length;
        curCount =count;
    }
    public boolean hasNext() {return  curCount != 0;}

    @Override
    public Space next() {
        try {
            return floor[count-curCount];
        }
        finally {
            curCount--;
        }
    }
}
