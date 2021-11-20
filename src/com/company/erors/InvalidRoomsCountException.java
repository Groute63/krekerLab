package com.company.erors;

public class InvalidRoomsCountException extends IllegalArgumentException{
    public InvalidRoomsCountException(int name) {
        super("Ошибка некорретного количества комнат в помещении. Не может быть \"" + name + "\" комнаты");
    }
}
