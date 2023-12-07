package ma.ensa.test.driven.project.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public static float devise(float a, float b) {
        if(b == 0) {
            throw new ArithmeticException("Devision Par 0");
        } else {
            return a / b;
        }
    }

    public static void main(String[] args) {
        float a = 2;
        float b = 1;
        float result = devise(a, b);
        System.out.println(String.format("La division de %s et %s est %s", a, b, result));
    }
}
