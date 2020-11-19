package ua.yaroslav.student.hostel.controller.models;

import org.springframework.stereotype.Component;


public class StudentBirthdayBetween {

    String birthdayOne;
    String birthdayTwo;

    public String getBirthdayOne() {
        return birthdayOne;
    }

    public void setBirthdayOne(String birthdayOne) {
        this.birthdayOne = birthdayOne;
    }

    public String getBirthdayTwo() {
        return birthdayTwo;
    }

    public void setBirthdayTwo(String birthdayTwo) {
        this.birthdayTwo = birthdayTwo;
    }
}
