package ma.ensa.test.driven.project.service;

import static org.junit.Assert.*;
import ma.ensa.test.driven.project.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void deviseTestCas1() {
        assertThrows(ArithmeticException.class,
                ()->{
                    float a = 1;
                    float b = 0;
                    float result = calculatorService.devise(a, b);
                }
        );
    }

    @Test
    public void deviseTestCas2() {
        float a = 2;
        float b = 1;
        float expected = 2;
        float result = calculatorService.devise(a, b);
        assertEquals(expected, result, 0.0000001);
    }

    @Test
    public void deviseTestCas3() {
        float a = -50;
        float b = -5;
        float expected = 10;
        float result = calculatorService.devise(a, b);
        assertEquals(expected, result, 0.0000001);
    }

    @Test
    public void deviseTestCas4() {
        float a = -20;
        float b = 5;
        float expected = -4;
        float result = calculatorService.devise(a, b);
        assertEquals(expected, result, 0.0000001);
    }

    @Test
    public void deviseTestCas5() {
        float a = 20;
        float b = -5;
        float expected = -4;
        float result = calculatorService.devise(a, b);
        assertEquals(expected, result, 0.0000001);
    }

    @Test
    public void deviseTestCas6() {
        assertThrows(ArithmeticException.class,
                ()->{
                    float a = -1;
                    float b = 0;
                    float result = calculatorService.devise(a, b);
                }
        );
    }
}
