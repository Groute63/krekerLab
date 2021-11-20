package com.company;
import com.company.buildings.Buildings;
import com.company.buildings.Dwelling.Dwelling;
import com.company.buildings.Dwelling.DwellingFloor;
import com.company.buildings.Dwelling.Flat;
import com.company.buildings.Interfece.Building;
import com.company.buildings.Interfece.Floor;
import com.company.buildings.Interfece.Space;
import com.company.buildings.Office.Office;
import com.company.buildings.Office.OfficeBuilding;
import com.company.buildings.Office.OfficeFloor;
import com.company.buildings.factory.DwellingFactory;
import com.company.buildings.factory.OfficeFactory;
import com.company.buildings.hotel.Hotel;
import com.company.buildings.hotel.HotelFloor;
import com.company.erors.InexchangeableSpacesException;

import java.io.*;

public class Main {

   public static void main(String[] args) throws InexchangeableSpacesException, IOException, ClassNotFoundException {
       Space[] fm = new Space[]{
             new Office(1,1),
         new Flat(2,2)};
	Space[] fm2 = new Space[]{
         new Office(3, 3),
        new Flat(1,1),
         new Flat(5,5),

        new Flat(13, 12)
        };
       Space[] fm3 = new Space[]{
               new Office(3, 3),
               new Flat(1,1),
               new Flat(5,5),

               new Flat(13, 12)
       };


System.out.println("Тест гита");
       HotelFloor dw= new HotelFloor(fm);
       Floor[] dw22={ new HotelFloor(fm)};
       Building d228 = new Dwelling(dw22);
       for(Floor floor:d228){
           System.out.println(floor);
       }

    }


}
