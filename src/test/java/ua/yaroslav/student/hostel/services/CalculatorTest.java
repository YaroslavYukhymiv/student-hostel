package ua.yaroslav.student.hostel.services;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {

    @Test
    public void multiplySuccessfulTest() {

        Calculator calculator = new Calculator();

        int result = calculator.calcMultiplayAndDivision(5, 5, true);

        Assert.assertEquals(25, result);
    }

    @Test
    public void divisionSuccessfulTest() {

        Calculator calculator = new Calculator();

        int result = calculator.calcMultiplayAndDivision(5, 5, false);

        Assert.assertEquals(1, result);
    }

    @Test
    public void additionSccessfulTest(){

        Calculator calculator = new Calculator();

        int result = calculator.calcAdditionAndSubtraction(100, 100, true);

        Assert.assertEquals(200, result);
    }

    @Test
    public void additionWithExeptionTest(){

        Calculator calculator = new Calculator();

        calculator.calcAdditionAndSubtraction(2090_000_000, 214_000_0000, true);
    }

    @Test
    public void subtractionSccessfulTest(){

        Calculator calculator = new Calculator();

        int result = calculator.calcAdditionAndSubtraction(200, 200, false);

        Assert.assertEquals(0, result);

    }


}