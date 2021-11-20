package com.company.buildings;

import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.erors.InexchangeableFloorsException;
import com.company.erors.InexchangeableSpacesException;
import com.company.erors.SpaceIndexOutOfBoundsException;

public class PlacementExchanger {
    private static boolean isChange(Space a, Space b) {
        if (a.getRoomCount() == b.getRoomCount() && a.getSquare() == a.getSquare())
            return true;
        return false;
    }

    private static boolean isChange(Floor a, Floor b) {
        if (a.getAllRoomCount() == b.getAllRoomCount() && a.getFullSquare() == b.getFullSquare())
            return true;
        return false;
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException {
        if (!isChange(floor1.getSpace(index1), floor2.getSpace(index2)))
            throw new InexchangeableSpacesException();
        if (index1 < 0 || floor1.getSpaces().length < index1) {
            System.out.println(floor1.getSpaces().length);
            throw new SpaceIndexOutOfBoundsException(index1);

        }
        if (index2 < 0 || floor2.getSpaces().length < index2) {
            System.out.println(floor2.getSpaces().length);
            throw new SpaceIndexOutOfBoundsException(index2);
        }
        Space a = floor2.getSpace(index2);
        Space b = floor1.getSpace(index1);

        floor1.setSpace(index1, a);
        floor2.setSpace(index2, b);
    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException {
        if (isChange(building1.getFloorByNumber(index1), building2.getFloorByNumber(index2)))
            throw new InexchangeableFloorsException();
        if (index1 > -1 || building1.getDwellingCount() < index1)
            throw new SpaceIndexOutOfBoundsException(index1);
        if (index2 > -1 || building2.getDwellingCount() < index2)
            throw new SpaceIndexOutOfBoundsException(index2);
        Floor b = building1.getFloorByNumber(index1);
        building1.setFloorByNumber(index1, building1.getFloorByNumber(index2));

        building2.setFloorByNumber(index2, b);
    }



}
