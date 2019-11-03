package com.example.myapplication.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HomeTableOne")
public class HomeTableOne {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "age")
    private int age;

    public HomeTableOne(String firstName,String lastName,int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
