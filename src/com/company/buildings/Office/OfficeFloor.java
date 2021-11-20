package com.company.buildings.Office;

import com.company.buildings.Dwelling.DwellingFloor;
import com.company.buildings.FloorIterator;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Node;
import com.company.buildings.Interfece.Space;
import com.company.erors.SpaceIndexOutOfBoundsException;

import java.util.ArrayList;
import java.util.Iterator;

public class OfficeFloor implements Floor {


    private Node<Space> head = new Node<Space>();

    {
        head.next = head;
    }

    ////// адание 5
    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append("\n" + " OfficeFloor : ");
        for (int i = 0; i < this.getSpaceCount(); i++)
            b.append(getSpaces()[i].toString());
        return b.toString();
    }

    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object == this)
            return true;
        if (object instanceof OfficeFloor) {
            OfficeFloor o = (OfficeFloor) object;
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
        final int prime = 11;
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
    ///////
    public OfficeFloor(int flatCount) {
        for (int i = 0; i < flatCount; i++)
            addNode(i, new Office());

    }

    public OfficeFloor(Space[] flats) {
        for (int i = 0; i < flats.length; i++)
            addNode(i, flats[i]);
    }

    private Node<Space> getNode(int pos) {
        if (pos == -1)
            return head;
        Node<Space> p = head.next;
        int i = 0;
        while (i < pos) {
            if (p == head)
                throw new SpaceIndexOutOfBoundsException(pos);
            i++;
            p = p.next;
        }
        return p;
    }

    private void addNode(int pos, Space o) {

        if (pos != 0) {
            Node<Space> p = getNode(pos - 1);

            Node<Space> newNode = new Node<Space>(o, p.next);
            p.next = newNode;
        } else {
            Node<Space> newNode = new Node<Space>(o, head.next);
            head.next = newNode;
        }


    }

    private void delNode(int pos) {
        if (pos > getSpaceCount() || pos < 0) throw new SpaceIndexOutOfBoundsException(pos);
        Node<Space> p = head;
        int i = 0;
        while (i < pos) {
            i++;
            p = p.next;
        }
        p.next = p.next.next;
    }

    public int getSpaceCount() {
        Node<Space> p = head.next;
        int i = 0;
        while (p != head) {
            i++;
            p = p.next;
        }
        return i;
    }

    public double getFullSquare() {
        Node<Space> p = head.next;
        int i = 0;
        while (p != head) {
            i += p.value.getSquare();
            p = p.next;
        }
        return i;
    }

    public int getAllRoomCount() {
        Node<Space> p = head.next;
        int i = 0;
        while (p != head) {
            i += p.value.getRoomCount();
            p = p.next;
        }
        return i;
    }

    public Space[] getSpaces() {
        Node<Space> p = head.next;
        ArrayList<Space> o = new ArrayList<>();
        while (p != head) {
            o.add(p.value);
            p = p.next;
        }
        return o.toArray(new Space[0]);
    }

    public Space getSpace(int number) {
        return getNode(number).value;
    }

    public void setSpace(int number, Space sp) {
        delNode(number);
        addNode(number, sp);
    }

    public void addSpace(int number, Space sp) {
        addNode(number, (Office) sp);
    }

    public void deleteSpace(int number) {
        delNode(number);
    }

    public Space getBestSpace() {
        Node<Space> p = head.next;
        Node<Space> max = head.next;
        while (p != head) {
            if (p.value.getSquare() > max.value.getSquare())
                max = p;
            p = p.next;
        }
        return max.value;

    }
    public int compareTo(Floor o) {

        if(o.getAllRoomCount()>getAllRoomCount())
            return 1;
        else  if(o.getAllRoomCount()==getAllRoomCount())
            return 0;
        return  -1;
    }
    public Iterator<Space> iterator() {
        return new FloorIterator(getSpaces());
    }
}
