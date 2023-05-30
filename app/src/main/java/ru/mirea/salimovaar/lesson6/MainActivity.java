package ru.mirea.salimovaar.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.salimovaar.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPref = getSharedPreferences("salimova_set",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        binding.group.setText(sharedPref.getString("GROUP", "unknown"));
        binding.number.setText(sharedPref.getString("NUMBER", "unknown"));
        binding.series.setText(sharedPref.getString("SERIES ", "unknown"));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("GROUP", String.valueOf(binding.group.getText()));
                editor.putInt("NUMBER", Integer.parseInt(String.valueOf(binding.number.getText())));
                editor.putString("FILM", String.valueOf(binding.series.getText()));
                editor.putBoolean("IS_EXCELLENT", true);
                editor.apply();
            }
        });
    }
}