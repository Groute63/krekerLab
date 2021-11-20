package com.company.buildings.Interfece;

public interface BuildingFactory {
    Space createSpace(double area);
    Space createSpace(int roomsCount, int area);
    Floor createFloor(int spacesCount);
    Floor createFloor(Space[] spaces);
    Building createBuilding(int floorsCount, int[] spacesCounts);
    Building createBuilding(Floor[] floors);

}
