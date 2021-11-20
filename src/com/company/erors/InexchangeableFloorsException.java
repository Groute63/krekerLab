package com.company.erors;

public class InexchangeableFloorsException extends Exception{
    public InexchangeableFloorsException() {
        super("Ошибка несоответствия обменивающихся этажей.");
    }
}
