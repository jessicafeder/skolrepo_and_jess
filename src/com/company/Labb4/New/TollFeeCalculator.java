package com.company.Labb4.New;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TollFeeCalculator {

    public TollFeeCalculator(String inputFile) {
        try {
           calculator(inputFile);
        } catch(TooManyDaysException | SortMinutesException e){
            System.err.println(e.getMessage());
        } catch(DateTimeParseException e) {
            System.err.println("Could not read file. Check time or date format");
        } catch(FileNotFoundException e){
            System.err.println("File cannot be accessed: " + inputFile);
        } catch(Exception e){
            System.err.println("Error");
        }
    }

    public static void calculator (String inputFile) throws TooManyDaysException, FileNotFoundException, SortMinutesException {
        Scanner sc = new Scanner(new File(inputFile));
        String[] dateStrings = sc.nextLine().split(", ");
        LocalDateTime[] dates = new LocalDateTime[dateStrings.length];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = LocalDateTime.parse(dateStrings[i], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
        System.out.println("The total fee for the inputfile is: " + getTotalFeeCost(dates));
        sc.close();
    }

    public static int getTotalFeeCost(LocalDateTime[] dates) throws TooManyDaysException, SortMinutesException {
        int totalFee = 0;
        int x = 0;
        LocalDateTime intervalStart = dates[0];
        for(LocalDateTime date: dates) {
            long diffInMinutes = intervalStart.until(date, ChronoUnit.MINUTES);
            System.out.println(date.toString());
            if (date.getDayOfWeek() != intervalStart.getDayOfWeek()) { //One day per file
                throw new TooManyDaysException("Only one day per file is allowed.");
            } else if (date.isBefore(intervalStart)) { //Sort minutes
                throw new SortMinutesException("Sort minutes in inputfile");
            } else if (diffInMinutes >= 60 || date.equals(intervalStart)) {
                totalFee += getTollFeePerPassing(date);
                System.out.println("Passage cost: " + getTollFeePerPassing(date));
                x = 0;
                if (!date.equals(intervalStart)) {
                    intervalStart = date;
                }
            } else {
                if (getTollFeePerPassing(date) > getTollFeePerPassing(intervalStart)) { //Code didn´t count passages done within 60 minutes
                    if (x == getTollFeePerPassing(date)) {
                        System.out.println("Within 60 minutes, free passage");
                    } else {
                        int diff = (getTollFeePerPassing(date) - getTollFeePerPassing(intervalStart));
                        System.out.println("Passage inside 60minutes window, +" + diff + " due to more expensive toll");
                        totalFee += diff;
                        x = getTollFeePerPassing(date);
                    }
                } else {
                    System.out.println("Free passage due to inside 60minutes window");
                }
            }
            System.out.println("Total toll: " + totalFee);
            System.out.println();
        }
        return Math.min(totalFee,60); // Previously it returned max value no matter what the output.
    }

    public static int getTollFeePerPassing(LocalDateTime date) {
        if (isTollFreeDate(date)) return 0;
        int hour = date.getHour();
        int minute = date.getMinute();
        if (hour == 6 && minute <= 29) return 8;
        else if (hour == 6 ) return 13;
        else if (hour == 7 ) return 18;
        else if (hour == 8 && minute <= 29) return 13;
        else if (hour == 8 || hour >= 9 && hour <= 14) return 8; // It now reads between 9-14
        else if (hour == 15 && minute <= 29) return 13;
        else if (hour == 15 || hour == 16 ) return 18;
        else if (hour == 17 ) return 13;
        else if (hour == 18 && minute <= 29) return 8;
        else return 0;
    }

    public static boolean isTollFreeDate(LocalDateTime date) {
        return date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7 || date.getMonth().getValue() == 7;
    }

    public static void main(String[] args) {

        /*new TollFeeCalculator("src/testdata/Labb4.txt");
        new TollFeeCalculator("src/testdata/test2.txt");
        new TollFeeCalculator("src/testdata/unsortedDates.txt");
        new TollFeeCalculator("src/testdata/differentDays.txt");
        new TollFeeCalculator("src/testdata/passagesUnder60Min.txt");*/


    }
}