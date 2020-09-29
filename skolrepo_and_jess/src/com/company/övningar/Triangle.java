package com.company.övningar;

public class Triangle implements Shape {
    private int base;
    private int height;
    private int hypotenuse;

    public Triangle(int base, int height, int hypotenuse){
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }

    public int getArea(){
        return (base*height) / 2;
    }
    public int getCircumference(){
        return height + base + hypotenuse;
    }

}

