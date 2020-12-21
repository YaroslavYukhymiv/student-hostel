package ua.yaroslav.student.hostel.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hostel {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int rooms;

    public Hostel() {
    }

    public Hostel(int id, String name, int rooms) {
        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
