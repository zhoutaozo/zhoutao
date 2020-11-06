package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity02 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);

        initFruits();
        FruitAdapter myFruitAdapter = new FruitAdapter(ListViewActivity02.this,R.layout.fruit_item,fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(myFruitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(ListViewActivity02.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits(){
        Fruit apple = new Fruit("Apple",R.drawable.apple);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana",R.drawable.banana);
        fruitList.add(banana);
        Fruit orange = new Fruit("orange",R.drawable.orange);
        fruitList.add(orange);
        Fruit lemon = new Fruit("lemon",R.drawable.lemon);
        fruitList.add(lemon);
        Fruit peach = new Fruit("peach",R.drawable.peach);
        fruitList.add(peach);
        Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry);
        fruitList.add(strawberry);
        Fruit mango = new Fruit("mango",R.drawable.mango);
        fruitList.add(mango);
        Fruit grape = new Fruit("grape",R.drawable.grape);
        fruitList.add(grape);
    }
}