package com.company.buildings.Dwelling;

import com.company.buildings.BuildingIterator;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.erors.FloorIndexOutOfBoundsException;

import java.util.Iterator;

public class Dwelling implements Building {
    protected Floor[] floors;
    /////////////task5
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + "Dwelling : " );
        for(int i = 0; i< this.getDwellingCount();i++)
            b.append(getDwelling()[i].toString());
        return  b.toString();
    }
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object == this)
            return true;
        if (object instanceof Dwelling) {
            Dwelling o = (Dwelling) object;
            Floor[] a = o.getDwelling();
            Floor[] b = this.getDwelling();
            for (int i = 0; i < a.length; i++)
                if (!a[i].equals(b[i]))
                    return false;
            return true;
        }
        return false;
    }
    public int hashCode() {
        final int prime = 5;
        int result =getDwelling().length;
        for (int i = 0;i<getDwelling().length;i++)
            result = prime * result + getDwelling()[i].hashCode();
        return result;
    }
    public Object clone() {
        Building result = null;
        Floor[] result2 = new Floor[getDwellingCount()];
            for (int i = 0; i < getDwelling().length; i++)
                result2[i] = (Floor)getFloorByNumber(i).clone();


            result = new Dwelling(result2);

        return result;
    }
    /////////////////
    public Dwelling(int floorCount, int[] arrayNumberOfSpace) {
        floors = new Floor[floorCount];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new DwellingFloor(arrayNumberOfSpace[i]);
        }
    }

    public Dwelling(Floor[] dwelling) {
        floors = dwelling;
    }

    public int getDwellingCount() {
        return floors.length;
    }

    public int getAllSpacesPerDwelling() {
        int count = 0;
        for (Floor Floor : floors) {
            count += Floor.getSpaceCount();
        }
        return count;
    }

    public double getTotalSquarePerDwelling() {
        double total = 0;
        for (Floor Floor : floors) {
            total += Floor.getFullSquare();
        }
        return total;
    }

    public int getTotalNumberOfRoomsPerDwelling() {
        int total = 0;
        for (Floor Floor : floors) {
            total += Floor.getAllRoomCount();
        }
        return total;
    }

    public Floor[] getDwelling() {
        return floors;
    }

    public Floor getFloorByNumber(int numberFloor) {
        if (numberFloor > getDwellingCount()) throw new FloorIndexOutOfBoundsException(numberFloor);
        return floors[numberFloor];
    }

    public void setFloorByNumber(int numberFloor, Floor newFloor) {
        if (numberFloor > getDwellingCount()) throw new FloorIndexOutOfBoundsException(numberFloor);
        floors[numberFloor] = newFloor;
    }


    public Space getSpace(int numberOfSpace) {
        if (numberOfSpace > getDwellingCount() || numberOfSpace <0) throw new FloorIndexOutOfBoundsException(numberOfSpace);
        int counter = 0;
        for (int i = 0; i < floors.length; i++) {
            counter += floors[i].getSpaceCount();
            if (counter >= numberOfSpace) {
                counter -= floors[i].getSpaceCount();
                int del = numberOfSpace - counter;
                return floors[i].getSpaces()[del];
            }
        }
        return null;
    }

    public void setSpace(int numberOfSpace, Space newSpace) {
        if (numberOfSpace > getDwellingCount() || numberOfSpace <0) throw new FloorIndexOutOfBoundsException(numberOfSpace);
        int counter = 0;
        for (int i = 0; i < floors.length; i++) {
            counter += floors[i].getSpaceCount();
            if (counter >= numberOfSpace) {
                counter -= floors[i].getSpaceCount();
                int del = numberOfSpace - counter;
                floors[i].getSpaces()[del] = newSpace;
            }
        }
    }

    public void addSpace(int numberOfSpace, Space newSpace) {
        if (numberOfSpace == getDwellingCount() ) throw new FloorIndexOutOfBoundsException(numberOfSpace);
        int counter = 0;
        for (int i = 0; i < floors.length; i++) {
            counter += floors[i].getSpaceCount();
        }
        if (counter + 1 == numberOfSpace)
            floors[floors.length - 1].addSpace(floors[floors.length - 1].getSpaceCount(), newSpace);
    }

    public void deleteSpaceByNumberPerDwelling(int numberOfSpace) {
        if (numberOfSpace > getDwellingCount() || numberOfSpace <0) throw new FloorIndexOutOfBoundsException(numberOfSpace);
        int counter = 0;
        for (int i = 0; i < floors.length; i++) {
            counter += floors[i].getSpaceCount();
            if (counter >= numberOfSpace) {
                counter -= floors[i].getSpaceCount();
                int del = numberOfSpace - counter;
                floors[i].deleteSpace(del);
            }
        }


    }

    public Space getBestSpace() {
        Space maxSquare = new Flat(0);
        Space buffer;
        for (Floor Floor : floors) {
            buffer = Floor.getBestSpace();
            if (maxSquare.getSquare() < buffer.getSquare()) {
                maxSquare = buffer;
            }
        }
        return maxSquare;
    }

    public Space[] getSortArraySpace() {

        int cout = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getSpaceCount(); j++) {
                cout++;
            }
        }
        Space[] f = new Space[cout];
        int t = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getSpaceCount(); j++) {
                f[t] = floors[i].getSpaces()[j];
                t++;
            }
        }
        f = bubbleSort(f);
        return f;
    }

    private Space[] bubbleSort(Space[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arr[j].getSquare() > arr[j + 1].getSquare()) {
                    double tmp = arr[j].getSquare();
                    arr[j].setSquare(arr[j + 1].getSquare());
                    arr[j + 1].setSquare(tmp);
                }
            }
        }
        return arr;
    }
    public Iterator<Floor> iterator() {
        return new BuildingIterator(getDwelling());
    }
}
