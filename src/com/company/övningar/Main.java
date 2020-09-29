package com.company.övningar;

public class Main {
    public static void main(String[] args) {
        int width = Math.toIntExact(Math.round(Math.random()* 9 + 1));
        int height = Math.toIntExact(Math.round(Math.random()* 9 + 1));

        Shape rect = new Rectangle(width, height);
        System.out.println(rect.getArea() + " " + rect.getCircumference());
        //System.out.println(trian.getArea() + " " + trian.getCircumference());*/
//verkar cäll funka?
        // jajamän!
    }
}

