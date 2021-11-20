package com.company.buildings.factory;

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

public class OfficeFactory implements BuildingFactory {
    public Space createSpace(double area) {
        return new Office(area);
    }
    public Space createSpace(int roomsCount, int area) {
        return new Office(roomsCount,area);
    }

    public Floor createFloor(int spacesCount) {
        return new OfficeFloor(spacesCount);
    }

    public Floor createFloor(Space[] spaces) {
        return new OfficeFloor(spaces);
    }

    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new OfficeBuilding(floorsCount,spacesCounts);
    }

    public Building createBuilding(Floor[] floors) {
        return new OfficeBuilding(floors);
    }
}
