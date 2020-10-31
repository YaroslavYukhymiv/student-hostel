package ua.yaroslav.student.hostel.dao.entity;

public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private int roomNumber;
    private String faculty;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) { this.birthday = birthday; }

}
