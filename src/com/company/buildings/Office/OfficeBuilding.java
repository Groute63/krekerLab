package com.company.buildings.Office;

import com.company.buildings.*;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.erors.FloorIndexOutOfBoundsException;
import com.company.erors.SpaceIndexOutOfBoundsException;

import java.util.ArrayList;
import java.util.Iterator;

public class OfficeBuilding  implements Building {
    public int size = 0;
    private DNode<Floor> head = new DNode<Floor>();
    {
        head.next = head;
        head.prev = head;
    }
    //////task 5
    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("\n" + "Office : " );
        for(int i = 0; i< this.getDwellingCount();i++)
            b.append(getDwelling()[i].toString());
        return  b.toString();
    }
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object == this)
            return true;
        if (object instanceof OfficeBuilding) {
            OfficeBuilding o = (OfficeBuilding) object;
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
        final int prime = 13;
        int result =getDwelling().length;
        for (int i = 0;i<getDwelling().length;i++)
            result = prime * result + getDwelling()[i].hashCode();
        return result;
    }



    public Object clone() {
        Building result = null;
        Floor[] result2 = new Floor[getDwellingCount()];

            for (int i = 0; i < getDwelling().length; i++) {
                result2[i] = (Floor) getFloorByNumber(i).clone();

            }
            result = new OfficeBuilding(result2);


        return result;
    }
    /////////////
    private Floor getNode(int pos) {
        if (pos == -1)
            return head.value;
        DNode<Floor> p = head.next;
        int i = 0;
        while (i < pos) {
            if (p == head)
                throw  new FloorIndexOutOfBoundsException(pos);
            i++;
            p = p.next;
        }
        return p.value;
    }

    private void addNode(int index, Floor newOfficeFloor) {
        if(index < 0 || index > size) throw new FloorIndexOutOfBoundsException(index);
        DNode<Floor> officeFloor = head.next;
        int i = 0;
        while (i < index && officeFloor != head){
            i++;
            officeFloor = officeFloor.next;
        }
        officeFloor.next = new DNode(newOfficeFloor, officeFloor.prev, officeFloor.next);
        officeFloor.prev.next.value = newOfficeFloor;
        officeFloor.prev.value = newOfficeFloor;
        size++;
    }

    private void delNode(int pos) {
        if (pos > getDwellingCount() || pos <0) throw new FloorIndexOutOfBoundsException(pos);
        DNode<Floor> p = head;
        int i = 0;
        while (i < pos) {
            i++;
            p = p.next;
        }
        p.next.next.prev = p;
        p.next = p.next.next;
        size--;
    }

    public OfficeBuilding(int floorCount, int[] arrayNumberOfSpace) {
        for (int i = 0; i < getDwellingCount(); i++) {
            addNode(i, new OfficeFloor(arrayNumberOfSpace[i]));
        }
    }

    public OfficeBuilding(Floor[] dwelling) {
        for (int i = 0; i < dwelling.length; i++)
        addNode(i,dwelling[i]);
    }

    public int getDwellingCount() {
        DNode<Floor> p = head.next;
        int i = 0;
        int j = 0;
        while (j<size) {
            i++;j++;
            p = p.next;
        }
        return i;
    }

    public int getAllSpacesPerDwelling() {
        DNode<Floor> p = head.next;
        int i = 0;
        int j = 0;
        while (j<size) {
            i+= p.value.getSpaceCount();
            p = p.next;
            j++;
        }
        return i;
    }

    public double getTotalSquarePerDwelling() {
        DNode<Floor> p = head.next;
        double i = 0;
        int j = 0;
        while (j<size) {

            i+=p.value.getFullSquare();
            p = p.next;
            j++;
        }
        return i;
    }

    public int getTotalNumberOfRoomsPerDwelling() {
        DNode<Floor> p = head.next;
        int i = 0;
        int j = 0;
        while (j<size) {
            i+=p.value.getAllRoomCount();
            p = p.next;
            j++;
        }
        return i;
    }

    public Floor[] getDwelling() { DNode<Floor> p = head.next;
        Floor[] o = new Floor[getDwellingCount()];
        int j = 0;
        while (j<size) {
            o[j] =p.value ;
            j++;
            p = p.next;

        }

        return o;
    }

    public Floor getFloorByNumber(int numberFloor) {
        return getNode(numberFloor);
    }

    public void setFloorByNumber(int numberFloor, Floor newFloor) {
        if (numberFloor > getDwellingCount() || numberFloor <0) throw new FloorIndexOutOfBoundsException(numberFloor);
        delNode(numberFloor);
        addNode(numberFloor, newFloor);
    }

    private Space[] getAllSpace() {
        DNode<Floor> p = head.next;
        ArrayList<Space> o = new ArrayList<>();
        int j = 0;
        while (j<size) {
            for(int i = 0; i< p.value.getSpaceCount();i++)
            o.add(p.value.getSpace(i));
            p = p.next;
            j++;
        }
        return o.toArray(new Space[0]);
    }
    public Space getSpace(int numberOfSpace) {
        if ( getAllSpace().length<numberOfSpace || numberOfSpace<0 )throw new SpaceIndexOutOfBoundsException(numberOfSpace);
        return   getAllSpace()[numberOfSpace];
    }

    public void setSpace(int index, Space office){
        if(index < 0 || index > getAllSpacesPerDwelling()) throw new SpaceIndexOutOfBoundsException(index);
        index++;
        int number = 0;
        DNode<Floor> officeFloor = head.next;
        int j = 0;
        end:
        while (j<size) {
            for (int i = 0; i < officeFloor.value.getSpaces().length; i++) {
                number++;
                if (number == index) {
                    number = i;
                    break end;
                }
            }
            officeFloor = officeFloor.next;
        }
        officeFloor.value.getSpaces()[number] = office;
    }

        public void addSpace(int index, Space office){
            if(index < 0 || index > getAllSpacesPerDwelling()) throw new SpaceIndexOutOfBoundsException(index);
            index++;
            int number = 0;
            DNode<Floor> officeFloor = head.next;
            end:
            while (officeFloor != head) {
                for (int i = 0; i < officeFloor.value.getSpaces().length; i++) {
                    number++;
                    if (number == index) {
                        number = i;
                        break end;
                    }
                }
                officeFloor = officeFloor.next;
            }
            officeFloor.value.addSpace(number,office);
    }

    public void deleteSpaceByNumberPerDwelling(int index) {
        if(index < 0 || index >getAllSpacesPerDwelling()) throw new SpaceIndexOutOfBoundsException(index);
        int number = 0;
        index++;
        DNode<Floor> officeFloor = head.next;
        end:
        while (officeFloor != head) {
            for (int i = 0; i < officeFloor.value.getSpaces().length; i++) {
                number++;
                if (number == index) {
                    number = i;
                    break end;
                }
            }
            officeFloor = officeFloor.next;
        }
        officeFloor.value.deleteSpace(number);
    }

    public Space getBestSpace() {
        Space maxSquare = head.next.value.getBestSpace();
        DNode<Floor> p = head.next;
        int j = 0;
        while (j<size){
            if(p.value.getBestSpace().getSquare()>maxSquare.getSquare())
                maxSquare = p.value.getBestSpace();
            p=p.next;
            j++;
        }
        return maxSquare;
    }

    public Space[] getSortArraySpace() {

        Space[] f = bubbleSort(getAllSpace());
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
