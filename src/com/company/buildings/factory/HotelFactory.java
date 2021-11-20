package com.company.buildings.factory;

import com.company.buildings.Dwelling.Flat;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.BuildingFactory;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.buildings.Office.Office;
import com.company.buildings.Office.OfficeBuilding;
import com.company.buildings.Office.OfficeFloor;
import com.company.buildings.hotel.Hotel;
import com.company.buildings.hotel.HotelFloor;

public class HotelFactory implements BuildingFactory {
    public Space createSpace(double area) {
        return new Flat(area);
    }
    public Space createSpace(int roomsCount, int area) {
        return new Flat(roomsCount,area);
    }

    public Floor createFloor(int spacesCount) {
        return new HotelFloor(spacesCount);
    }

    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new Hotel(floorsCount,spacesCounts);
    }

    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }
}
