package ru.mirea.salimovaar.employeedb;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import ru.mirea.salimovaar.employeedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataBase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();

        binding.find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                employee = employeeDao.getById(Long.parseLong(String.valueOf(binding.id.getText())));
                binding.name.setText(employee.getName());
                binding.salary.setText(employee.getSalary());
            }
        });

        binding.insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee();
                employee.id = Long.parseLong(String.valueOf(binding.id.getText()));
                employee.name = String.valueOf(binding.name.getText());
                employee.salary = Integer.parseInt(String.valueOf(binding.salary.getText()));
                employeeDao.insert(employee);
            }
        });

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                employee = employeeDao.getById(Long.parseLong(String.valueOf(binding.id.getText())));

                employeeDao.delete(employee);
            }
        });
    }
}