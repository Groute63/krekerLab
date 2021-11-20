package com.company.buildings;

import com.company.buildings.Dwelling.Dwelling;
import com.company.buildings.Dwelling.DwellingFloor;
import com.company.buildings.Dwelling.Flat;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.BuildingFactory;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.buildings.Office.Office;
import com.company.buildings.Office.OfficeBuilding;
import com.company.buildings.Office.OfficeFloor;
import com.company.buildings.factory.DwellingFactory;

import java.io.*;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Scanner;

public class Buildings {
    public static BuildingFactory buildingFactory = new DwellingFactory();
    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }
    public static Space createSpace(double area) {
        return buildingFactory.createSpace(area);
    }

    public static Space createSpace(int roomsCount, int area) {
        return buildingFactory.createSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount) {
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] spacesCounts) {
        return buildingFactory.createBuilding(floorsCount, spacesCounts);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }
    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        Floor floor = null;
        Space space = null;
        dos.writeInt(building.getDwellingCount());
        for (int i = 0, floorsAmount = building.getDwellingCount(); i < floorsAmount; i++) {
            floor = building.getDwelling()[i];
            dos.writeInt(floor.getSpaceCount());
            for (int j = 0, spacesAmount = floor.getSpaceCount(); j < spacesAmount; j++) {
                space = floor.getSpace(j);
                dos.writeInt(space.getRoomCount());
                dos.writeDouble(space.getSquare());
            }
        }
        dos.close();
    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);
        Floor[] floors = new Floor[dis.readInt()];
        for (int i = 0, sizeFloors = floors.length; i < sizeFloors; i++) {
            Space[] flats = new Space[dis.readInt()];
            for (int j = 0, sizeFlats = flats.length; j < sizeFlats; j++) {
                flats[j] =createSpace(dis.readInt(), dis.readInt());
            }
            floors[i] = createFloor(flats);
        }
        dis.close();
        return createBuilding(floors);
    }


        public static void writeBuilding(Building building, Writer out)
        {
            PrintWriter pwo = new PrintWriter(out);
            Floor floor = null;
            Space space = null;
            pwo.println(building.getDwellingCount());
            for (int i = 0, floorsAmount = building.getDwellingCount(); i < floorsAmount; i++) {
                floor = building.getDwelling()[i];
                pwo.println(floor.getSpaceCount());
                for (int j = 0, spacesAmount = floor.getSpaceCount(); j < spacesAmount; j++) {
                    space = floor.getSpace(j);
                    pwo.println(space.getRoomCount());
                    pwo.println((int)space.getSquare());
                }
            }
            pwo.close();
        }

    public static Building readBuilding(Reader in) throws IOException {
        BufferedReader st = new BufferedReader(in);
        Floor[] floors = new Floor[Integer.parseInt(st.readLine())];
        for (int i = 0, sizeFloors = floors.length; i < sizeFloors; i++) {
            Space[] flats = new Space[Integer.parseInt(st.readLine())];
            for (int j = 0, sizeFlats = flats.length; j < sizeFlats; j++) {
                flats[j] = createSpace(Integer.parseInt(st.readLine()), Integer.parseInt(st.readLine()));
            }
            floors[i] = createFloor(flats);
        }
        return createBuilding(floors);
    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(building);

    }

    public static Building deserializeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Building v = (Building) objectInputStream.readObject();
        return v;
    }

    public static void writeBuildingFormat(Building building, Writer out)
    {
        Formatter formatter = new Formatter(out);
        if(building instanceof Dwelling)
            formatter.format("Dwelling:\n");
        else
            formatter.format("OfficeBuilding:\n");
        for(int i = 0; i < building.getDwellingCount(); i++){
            if(building.getFloorByNumber(i) instanceof DwellingFloor)
                formatter.format(" DwellingFloor %d \n",i);
            else
                formatter.format(" OfficeFloor %d \n",i);
            for (int j =0; j < building.getFloorByNumber(i).getSpaceCount(); j++){
                if(building.getFloorByNumber(i).getSpace(j) instanceof Flat)
                    formatter.format(" Flat %d (rooms:%d,square:%f) \n",j,building.getFloorByNumber(i).getSpace(j).getRoomCount(),building.getFloorByNumber(i).getSpace(j).getSquare());
                else
                    formatter.format(" Office %d (rooms:%d,square:%f)\n",j,building.getFloorByNumber(i).getSpace(j).getRoomCount(),building.getFloorByNumber(i).getSpace(j).getSquare());
            }
        }
        System.out.println(formatter.toString());
        formatter.flush();
    }


    public static <T extends Comparable<T>> void sort(T[] arr ){
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i].compareTo(arr[i + 1])==1) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }

            }
        }
    }
    public static <T> void sort(T[] arr, Comparator<T> comparator) {
        boolean swapped = true;
        int j = 0;
        T tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (comparator.compare(arr[i],arr[i + 1]) == 1) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }

            }
        }
    }
}
