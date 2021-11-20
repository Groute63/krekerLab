package com.company.erors;


public class InvalidSpaceAreaException extends IllegalArgumentException {
    public InvalidSpaceAreaException(double name) {
        super("Ошибка некорретной площади помещения. Площадь помещения не может быть равна: " + name);
    }
}

