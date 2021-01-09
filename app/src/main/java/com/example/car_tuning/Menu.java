package com.example.car_tuning;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Menu extends AppCompatActivity {

    TextView textView_b_01,textView_b_02,textView_b_03,textView_b_04,asd,dilshod;
    private int count = 0;
    private int count_02 = 0;
    private int count_03 = 0;
    private int count_04 = 0;
    Context context;
    Menu_02 menu_02;
    Button btn, btn_next;

    ImageView imageView,imageView_2,imageView_3,imageView_4;
    ListView listView;
    List<String> list;
    ArrayAdapter<String> arrayAdapter;
//asasas sxczxc
//xcxc
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_01);
        btn_next = findViewById(R.id.btn_next);
        textView_b_01 = findViewById(R.id.txt);
        textView_b_02 = findViewById(R.id.txt_2);
        textView_b_03 = findViewById(R.id.txt_3);
        textView_b_04 = findViewById(R.id.txt_4);
        imageView = findViewById(R.id.imageView);
        imageView_2 = findViewById(R.id.imageView_2);
        imageView_3 = findViewById(R.id.imageView_3);
        imageView_4 = findViewById(R.id.imageView_4);
        context = this;
        listView = findViewById(R.id.list_item);
        btn = findViewById(R.id.btn_minus);


        list = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view,list);
        listView.setAdapter(arrayAdapter);







        // Big Image Start
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                dialog.show();
            }
        });

        imageView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_2);
                dialog.show();
            }
        });

        imageView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_3);
                dialog.show();
            }
        });

        imageView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_4);
                dialog.show();
            }
        });
        // Big Image End

        LoadData();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Menu_02.class);
                startActivity(intent);
                finish();
            }
        });
        Date currentTime = Calendar.getInstance().getTime();
        final String formatDate = DateFormat.getDateInstance().format(currentTime);
        Log.d("myLog",formatDate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilshod.setText(formatDate);
                count--;
                //textView_b_01.setText(String.valueOf(count));
                dilshod.setText(String.valueOf(count));
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Here Minus--
    public void minus(View view) {

        textView_b_01.setText(asd.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        list.add("");

        textView_b_01.setText(String.valueOf(count));



    }

    public void minus_2(View view) {
        count_02--;

        textView_b_02.setText(String.valueOf(count_02));
    }

    public void minus_3(View view) {
        count_03--;
        textView_b_03.setText(String.valueOf(count_03));
    }


    public void minus_4(View view) {
        count_04--;
        textView_b_04.setText(String.valueOf(count_04));
    }





    // Here Plus++
    public void plus(View view) {
        count++;
        textView_b_01.setText(String.valueOf(count));
    }
    public void plus_2(View view) {
        count_02++;
        textView_b_02.setText(String.valueOf(count_02));
    }

    public void plus_3(View view) {
        count_03++;
        textView_b_03.setText(String.valueOf(count_03));
    }

    public void plus_4(View view) {
        count_04++;
        textView_b_04.setText(String.valueOf(count_04));
    }





    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putInt("countValue", count);
         editor.putInt("countValue_02", count_02);
         editor.putInt("countValue_03", count_03);
         editor.putInt("countValue_04", count_04);
         //editor.putInt("countValue_05", count_05);
         editor.apply();

    }


    public void LoadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("saveCount",MODE_PRIVATE);
        count = sharedPreferences.getInt("countValue", count);
        count_02 = sharedPreferences.getInt("countValue_02", count_02);
        count_03 = sharedPreferences.getInt("countValue_03", count_03);
        count_04 = sharedPreferences.getInt("countValue_04", count_04);
        //count_05 = sharedPreferences.getInt("countValue_05", count_05);
        list.add(String.valueOf(count));
        dilshod.setText(String.valueOf(count));
        textView_b_01.setText(String.valueOf(count));
        textView_b_02.setText(String.valueOf(count_02));
        textView_b_03.setText(String.valueOf(count_03));
        textView_b_04.setText(String.valueOf(count_04));
        //dilshod.setText(String.valueOf(count_05));
    }
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }





}
