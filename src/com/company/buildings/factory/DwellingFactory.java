package com.company.buildings.factory;

import com.company.buildings.Dwelling.Dwelling;
import com.company.buildings.Dwelling.DwellingFloor;
import com.company.buildings.Dwelling.Flat;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.BuildingFactory;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;

public class DwellingFactory implements BuildingFactory {
    public Space createSpace(double area) {
        return new Flat(area);
    }
    public Space createSpace(int roomsCount, int area) {
        return new Flat(roomsCount,area);
    }

    public Floor createFloor(int spacesCount) {
        return new DwellingFloor(spacesCount);
    }

    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new Dwelling(floorsCount,spacesCounts);
    }

    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }
}
