package com.example.a1.unittests.utiles;

public class Square implements IFigure {

    private double side;

    public Square (double side){
        this.side=side;
    }

    @Override
    public boolean isValidSideLenght() {
        if (side > 0) {
            return true;
        }
        return false;
    }
    @Override
    public double getArea() {
        return side*side;
    }
    @Override
    public double Perimeter(){
        return 4*side;
    }
}
