package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity01 extends AppCompatActivity {
    private String[] data = {"Apple1","Apple2","Apple3","Apple4","Apple5","Apple6","Apple7","Apple8","Apple9","Apple10"
    ,"Apple11","Apple12","Apple13","Apple14","Apple15","Apple16","Apple17","Apple18","Apple19","Apple20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewActivity01.this, android.R.layout.simple_list_item_1,data);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}