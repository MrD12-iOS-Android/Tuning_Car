package com.example.car_tuning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Menu_02 extends AppCompatActivity {

     Button minus,plus;
     TextView txt;
     ListView listView;
     int count = 0;
     Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_02);
        init();
        // Here DATA and DAY
       // Date currentTime = Calendar.getInstance().getTime();
       // String formatDate = DateFormat.getDateInstance().format(currentTime);
      //  Log.d("myLog",formatDate);


        // Here LoadDATA
        LoadData();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                txt.setText(String.valueOf(count));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

/*
    // HEre SAVE DATABASE
    public  void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("countValue",count);
        editor.apply();
    }
    private void LoadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
        count = sharedPreferences.getInt("countValue",count);
        txt.setText(String.valueOf(count));
    }



 */
private void saveData(){
    SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("countValue", count);
    editor.apply();

}
    private void init() {
        txt = findViewById(R.id.textView);
        minus = findViewById(R.id.button_minus);
        plus = findViewById(R.id.button_plus);
        listView = findViewById(R.id.listView);

    }

    public void LoadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
        count = sharedPreferences.getInt("countValue", count);

        txt.setText(String.valueOf(count));

    }
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

/*
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

 */

}