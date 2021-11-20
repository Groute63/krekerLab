package com.company.erors;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public SpaceIndexOutOfBoundsException(int name) {
        super("Ошибка выхода за границы номеров помещений. Нет помещения с номером: " + name );
    }
}
