package com.company.Labb4.New;

import java.time.LocalDateTime;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testing TollFeeCalculator")
public class TollFeeCalculatorTest {


    @Test
    @DisplayName("Test if Exception is thrown")
    void TestExceptionThrown(){
        assertThrows(TooManyDaysException.class, () -> TollFeeCalculator.calculator("src/testdata/Labb4.txt"));
        assertThrows(SortMinutesException.class, () -> TollFeeCalculator.calculator("src/testdata/unsortedDates.txt"));
        assertThrows(DateTimeParseException.class, () -> TollFeeCalculator.calculator("src/testdata/differentDays.txt"));
        assertThrows(FileNotFoundException.class, () -> TollFeeCalculator.calculator("src/testdata/missingFile.txt"));
    }

    @Test
    @DisplayName("Testing if toll free works")
    void isTollFreeDate() {
        LocalDateTime[] dates = new LocalDateTime[5];
        dates[0] = LocalDateTime.of(2020, 10, 10, 9, 0);   // Saturday
        dates[1] = LocalDateTime.of(2020, 10, 11, 9, 0);  // Sunday
        dates[2] = LocalDateTime.of(2020, 10, 6, 9, 0);  // Tuesday
        dates[3] = LocalDateTime.of(2020, 10, 7, 9, 0); // Wednesday
        dates[4] = LocalDateTime.of(2020, 7, 1, 9, 0); // July

        assertTrue(TollFeeCalculator.isTollFreeDate(dates[0]));
        assertTrue(TollFeeCalculator.isTollFreeDate(dates[1]));
        assertFalse(TollFeeCalculator.isTollFreeDate(dates[2]));
        assertFalse(TollFeeCalculator.isTollFreeDate(dates[3]));
        assertTrue(TollFeeCalculator.isTollFreeDate(dates[4]));
    }

    @Test
    @DisplayName("Testing output max 60 and if toll fee is right")
    void maxValueAndTollFee() throws TooManyDaysException, SortMinutesException {
        LocalDateTime[] dates = new LocalDateTime[13];
        dates[0] = LocalDateTime.of(2020,10,6,5,0); // 0
        dates[1] = LocalDateTime.of(2020,10,6,6,0); //8
        dates[2] = LocalDateTime.of(2020,10,6,6,35); //13
        dates[3] = LocalDateTime.of(2020,10,6,7,30); //18
        dates[4] = LocalDateTime.of(2020,10,6,8,28); //13
        dates[5] = LocalDateTime.of(2020,10,6,8,34); //8
        dates[6] = LocalDateTime.of(2020,10,6,12,0); //8
        dates[7] = LocalDateTime.of(2020,10,6,15,15); //13
        dates[8] = LocalDateTime.of(2020,10,6,16,30); //18
        dates[9] = LocalDateTime.of(2020,10,6,17,30); //13
        dates[10] = LocalDateTime.of(2020,10,6,18,20); //8
        dates[11] = LocalDateTime.of(2020,10,6,18,35); //0
        dates[12] = LocalDateTime.of(2020,10,6,22,0); //0

        assertEquals(0, TollFeeCalculator.getTollFeePerPassing(dates[0])); //0
        assertEquals(8, TollFeeCalculator.getTollFeePerPassing(dates[1])); //8
        assertEquals(13, TollFeeCalculator.getTollFeePerPassing(dates[2])); //13
        assertEquals(18, TollFeeCalculator.getTollFeePerPassing(dates[3])); //18
        assertEquals(13, TollFeeCalculator.getTollFeePerPassing(dates[4])); //13
        assertEquals(8, TollFeeCalculator.getTollFeePerPassing(dates[5])); //8
        assertEquals(8, TollFeeCalculator.getTollFeePerPassing(dates[6])); //8
        assertEquals(13, TollFeeCalculator.getTollFeePerPassing(dates[7])); //13
        assertEquals(18, TollFeeCalculator.getTollFeePerPassing(dates[8])); //18
        assertEquals(13, TollFeeCalculator.getTollFeePerPassing(dates[9])); //13
        assertEquals(8, TollFeeCalculator.getTollFeePerPassing(dates[10])); //8
        assertEquals(0, TollFeeCalculator.getTollFeePerPassing(dates[11])); //0
        assertEquals(0, TollFeeCalculator.getTollFeePerPassing(dates[12])); //0

        assertEquals(60, TollFeeCalculator.getTotalFeeCost(dates));

    }
}

