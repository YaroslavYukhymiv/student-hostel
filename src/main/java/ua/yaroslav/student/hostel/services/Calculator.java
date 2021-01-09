package ua.yaroslav.student.hostel.services;

public class Calculator {

    private int result;

    public int calcMultiplayAndDivision(int a, int b, boolean mark) {

        int result;
        if(mark == true){
            result = a * b;
        } else {
            result = a / b;
        }
        return result;
    }

    public int calcAdditionAndSubtraction(int a, int b, boolean mark){

        int result;
        if(mark == true){
            result = a + b;
        } else {
            voidMethot(a, b);
            return this.result;
        }
        return result;
    }

    public void voidMethot(int a, int b){

        result = a - b;

    }

}
