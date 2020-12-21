package ua.yaroslav.student.hostel.dao.entity;

public class Person {

    private String name;
    private String secondName;
    private int age;
    private String number;
    private String address;
    private int weight;
    private int hight;

    private Person(Builder builder){
        this.name = builder.name;
        this.secondName = builder.secondName;
        this.age = builder.age;
        this.weight = builder.weight;
        this.hight = builder.hight;
        this.address = builder.address;
        this.number = builder.number;
    }

    public static class Builder {

        private String name;
        private String secondName;
        private int age;
        private String number;
        private String address;
        private int weight;
        private int hight;


        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder hight(int hight) {
            this.hight = hight;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Person build() {

            return new Person(this);

        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", weight=" + weight +
                ", hight=" + hight +
                '}';
    }
}
