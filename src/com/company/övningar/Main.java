package com.company.övningar;

public class Main {
    public static void main(String[] args) {

        int width = Math.toIntExact(Math.round(Math.random()* 9 + 1));


        double r = Math.random() * 9+1;
        System.out.println(r);
        long r2 = Math.round(r);
        System.out.println(r2);
        int height = Math.toIntExact(r2);
        System.out.println(height);

        Shape rect = new Rectangle(width, height);
        //System.out.println(rect.getArea() + " " + rect.getCircumference());
        //System.out.println(trian.getArea() + " " + trian.getCircumference());*/
    }
}

