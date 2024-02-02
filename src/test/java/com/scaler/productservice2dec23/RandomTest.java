package com.scaler.productservice2dec23;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RandomTest {

    @Test
    public void OnePlusOneTwo()
    {
        // Arrange

        // Act
        // checking if + func of Java is working fine
        int i = 1 + 1;

        // Assert
        assert i == 2;
        assert i*i == 4;

        assertTrue(i==2);
        assertEquals(2,i);
        assertEquals(3,i);

    }

}
