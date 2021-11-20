package com.company.erors;

public class FloorIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public FloorIndexOutOfBoundsException(int name) {
        super("Ошибка выхода за границы номеров этажей. Не может быть этажа: " + name );
    }
}