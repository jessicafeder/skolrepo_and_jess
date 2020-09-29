package com.company.övningar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int width = Math.toIntExact(Math.round(Math.random() * 9 + 1));


        double r = Math.random() * 9 + 1;
        System.out.println(r);
        long r2 = Math.round(r);
        System.out.println(r2);
        int height = Math.toIntExact(r2);
        System.out.println(height);

        Shape rect = new Rectangle(width, height);
        //System.out.println(rect.getArea() + " " + rect.getCircumference());
        //System.out.println(trian.getArea() + " " + trian.getCircumference());*/
<<<<<<< HEAD
=======
//verkar väll funka?
        // jajamän!
    }
}
>>>>>>> 527b74791f241efb13e888391ffa25528163e0df

        Scanner sc = new Scanner(System.in);
        try{
            while (sc.hasNextLine()) {
                int x = sc.nextInt();
                    if (x < 1) {
                        throw new IllegalArgumentException();
                    } else {
                        for (int i = 0; i < x; i++) {
                            System.out.println("Hello");
                        }

                    }
                }
            } catch (Exception e) {
            System.err.println("input a larger number");
        } finally {
            sc.close();
        }
        }

    }
