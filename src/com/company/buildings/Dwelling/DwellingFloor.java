package com.company.buildings.Dwelling;

import com.company.buildings.FloorIterator;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.buildings.Office.OfficeFloor;
import com.company.erors.SpaceIndexOutOfBoundsException;

import java.util.Arrays;
import java.util.Iterator;

public class DwellingFloor implements Floor {
    private Space[] flats;
    //////////task5
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + " DwellingFloor : " );
        for(int i = 0; i< this.getSpaceCount();i++)
            b.append(getSpaces()[i].toString());
        return  b.toString();
    }
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object == this)
            return true;
        if (object instanceof DwellingFloor) {
            DwellingFloor o = (DwellingFloor) object;
            Space[] a = o.getSpaces();
            Space[] b = this.getSpaces();
            for (int i = 0; i < a.length; i++)
                if (!a[i].equals(b[i]))
                    return false;
            return true;
        }
        return false;
    }
    public int hashCode() {
        final int prime = 3;
        int result =getSpaceCount();
        for (int i = 0;i<getSpaceCount();i++)
        result = prime * result + getSpaces()[i].hashCode();
        return result;
    }
    public Object clone() {
        Floor result = null;
        Space result2 [] = new Space[getSpaceCount()];

            for (int i = 0; i < getSpaces().length; i++) {
                result2[i] = (Space)this.getSpace(i).clone();
        }
        result = new DwellingFloor(result2);
        return result;
    }



    //////////////
    public DwellingFloor(int flatCount) {
        flats = new Space[flatCount];
        for(int i = 0; i< flats.length;i++)
            flats[i] = new Flat();
    }

    public DwellingFloor(Space[] flats) {
        this.flats = flats;
    }

    public int getSpaceCount() {
        return flats.length;
    }

    public double getFullSquare() {
        double fullSquare = 0;
        for (int i = 0; i < flats.length; i++)
            fullSquare += flats[i].getSquare();
        return fullSquare;
    }

    public int getAllRoomCount() {
        int allRoomCount = 0;
        for (int i = 0; i < flats.length; i++)
            allRoomCount += flats[i].getRoomCount();
        return allRoomCount;
    }

    public Space[] getSpaces() {
        return flats;
    }

    public Space getSpace(int number) {
        if (number >= getSpaceCount()  || number<0)throw new SpaceIndexOutOfBoundsException(number);

        return flats[number];
    }

    public void setSpace(int number, Space flat) {
        if (number >= getSpaceCount()  || number<0)throw new SpaceIndexOutOfBoundsException(number);
        if (number >= 0 && number < flats.length)
            flats[number] = flat;
    }

    public void addSpace(int Number, Space flat) {
        if (Number != flats.length)throw new SpaceIndexOutOfBoundsException(Number);
        if (Number == flats.length) {
            Space[] newFlats = Arrays.copyOf(flats, flats.length + 1);
            newFlats[flats.length] = new Flat();
            flats = newFlats;
        }

    }

    public void deleteSpace(int number) {
        if (number >= getSpaceCount() || number<0)throw new SpaceIndexOutOfBoundsException(number);
        if (number > 0 && number < flats.length) {
            Space[] newFlats = Arrays.copyOf(flats, flats.length - 1);
            System.arraycopy(flats, number + 1, newFlats, number, flats.length - (number + 1));
            flats = newFlats;
        }
    }

    public Space getBestSpace() {
        Space bestFlat = flats[0];
        for (int i = 1; i < flats.length; i++)
            if (bestFlat.getSquare() < flats[i].getSquare())
                bestFlat = flats[i];
        return bestFlat;
    }
    public int compareTo(Floor o) {

        if(o.getAllRoomCount()>getAllRoomCount())
            return 1;
        else  if(o.getAllRoomCount()==getAllRoomCount())
            return 0;
        return  -1;
    }
    @Override
    public Iterator<Space> iterator() {
        return new FloorIterator(flats);
    }
}
