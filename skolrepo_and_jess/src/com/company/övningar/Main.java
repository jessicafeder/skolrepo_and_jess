package com.company.övningar;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 6);
        Shape trian = new Triangle(6, 7, 15);
        long diceRoll = Math.round(Math.random()* 5 + 1);
        //double d =
        System.out.println(diceRoll); // matte uträkningar math.floor mm
        System.out.println(rect.getArea() + " " + rect.getCircumference());
        System.out.println(trian.getArea() + " " + trian.getCircumference());

    }
}

//övning: slumpar ut storlekar på triangel och rektangel, räknar ut area och omkrets



