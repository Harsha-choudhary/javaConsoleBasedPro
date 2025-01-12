package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Override toString() to display meaningful patient info
    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }
}
