package com.company.Labb4;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TollFeeCalculator {

    public TollFeeCalculator(String inputFile) {
        try {
            Scanner sc = new Scanner(new File(inputFile));
            String[] dateStrings = sc.nextLine().split(", ");
            LocalDateTime[] dates = new LocalDateTime[dateStrings.length]; //Ny kod
            //BUGG NR 1 LocalDateTime[] dates = new LocalDateTime[dateStrings.length-1]; Gammal kod
            for(int i = 0; i < dates.length; i++) {
                dates[i] = LocalDateTime.parse(dateStrings[i], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            }
            System.out.println("The total fee for the inputfile is: " + getTotalFeeCost(dates));
        } catch(IOException e) {
            System.err.println("Could not read file " + inputFile);
        }
    }

    private int getTotalFeeCost(LocalDateTime[] dates) {
        int totalFee = 0;
        LocalDateTime intervalStart = dates[0];
        for(LocalDateTime date: dates) {
            System.out.println(date.toString());
            long diffInMinutes = intervalStart.until(date, ChronoUnit.MINUTES);
            if(diffInMinutes > 60) {
                totalFee += getTollFeePerPassing(date);
                System.out.println(totalFee);
            } else {
                totalFee -= Math.min(getTollFeePerPassing(date), getTollFeePerPassing(intervalStart)); // -= för att ta fram math.min
                totalFee += Math.max(getTollFeePerPassing(date), getTollFeePerPassing(intervalStart));
                System.out.println(totalFee);
            }
            intervalStart = date; // detta körs så att den inte kör en tid flera gånger, så intervalStart blir den innan man sett //BUGG NR3 programmet kör 10.13 två gånger
        }
        return Math.min(totalFee, 60);
        //BUGG NR2 tidigare stod Math.max(totalFee, 60); Nu får vi fram minsta värdet som är summan av tiderna
        //har ändrat en tid så värdet är nu 34
    }

    private int getTollFeePerPassing(LocalDateTime date) {
        if (isTollFreeDate(date)) return 0;
        int hour = date.getHour();
        int minute = date.getMinute();
        if (hour == 6 && minute <= 29) return 8;
        else if (hour == 6 ) return 13;
        else if (hour == 7 ) return 18;
        else if (hour == 8 && minute <= 29) return 13;
        else if (hour == 8 || hour >= 9 && hour <= 14) return 8; // BUGG NR 4 justerat så att den läser allt mellan 8-14
        // kod innan else if (hour >= 8 && hour <= 14 && minute >= 30 && minute <= 59) return 8;
        else if (hour == 15 && minute <= 29) return 13;              // BUGG NR 5 passeringar inom 60 minuter skall ej debiteras
        else if (hour == 15 || hour == 16 ) return 18;
        else if (hour == 17 ) return 13;
        else if (hour == 18 && minute <= 29) return 8;
        else return 0;
    }

    public static boolean isTollFreeDate(LocalDateTime date) {
        return date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7 || date.getMonth().getValue() == 7;
    }

    public static void main(String[] args) {

        new TollFeeCalculator("src/testdata/Labb4.txt");
    }
}

//lämna in en fixad fil, plus en fil med våra lösningar på buggar