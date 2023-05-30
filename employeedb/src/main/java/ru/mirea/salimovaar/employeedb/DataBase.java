package ru.mirea.salimovaar.employeedb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
