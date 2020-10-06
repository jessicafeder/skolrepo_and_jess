package com.company.Labb4;
import java.io.OptionalDataException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testing isTollFreeDate")
public class TollFeeCalculatorTest {
    @Test
    void isTollFreeDate() {
        LocalDateTime date = LocalDateTime.parse("2020-06-01 10:00", DateTimeFormatter.ofPattern("yyyy-MM-DD HH:MM"));
        assertTrue(TollFeeCalculator.isTollFreeDate(date));
    }

    @DisplayName("Testing Array length")
    @Test
    void TollFeeCalculator() {
        new TollFeeCalculator = new TollFeeCalculator("src/testdata/Labb4.txt");
    assertTrue(TollFeeCalculator. == dates.lenght);

    }
}

// vi kan köra ungefär samma som ovan till att testa bugg nr 1 som är math.max
// 10 stycken testfall skall finnas med vid inlämning

