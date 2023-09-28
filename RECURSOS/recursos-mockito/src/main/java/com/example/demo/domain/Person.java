package com.example.demo.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Person {

    private UUID uuid;
    private String name;
    private LocalDate birthday;
    private String email;


    public Person(){}

    public Person(UUID uuid, String name, LocalDate birthday) {
        this.uuid = uuid;
        this.name = name;
        this.birthday = birthday;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
