package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner colorSpinner;
    private Spinner fontSpinner;
    private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        colorSpinner=findViewById(R.id.spinnerColor);
        textViewHello=findViewById(R.id.textHelloWorld);
        fontSpinner=findViewById(R.id.spinnerFont);

        List<String> colors = new ArrayList<>();
        colors.add(0,"Black");
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Purple");

        List<String> fonts = new ArrayList<>();
        fonts.add(0,"Normal");
        fonts.add("3D");
        fonts.add("Eraser");
        fonts.add("Weird");

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);

        ArrayAdapter<String> fontAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,fonts);
        fontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSpinner.setAdapter(fontAdapter);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = parent.getItemAtPosition(position).toString();
                switch (choice){
                    case "Red": textViewHello.setTextColor(Color.RED);
                    break;
                    case "Blue": textViewHello.setTextColor(Color.BLUE);
                        break;
                    case "Black": textViewHello.setTextColor(Color.BLACK);
                        break;
                    case "Green": textViewHello.setTextColor(Color.GREEN);
                        break;
                    case "Orange": textViewHello.setTextColor(Color.rgb(255,165,0));
                        break;
                    case "Yellow": textViewHello.setTextColor(Color.YELLOW);
                        break;
                    case "Purple": textViewHello.setTextColor(Color.rgb(102, 0, 153));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = parent.getItemAtPosition(position).toString();
                Typeface typeface;
                switch (choice){
                    case "Normal":
                        typeface = Typeface.createFromAsset(getAssets(),"normal.ttf");
                        textViewHello.setTypeface(typeface);
                        break;
                    case "3D":
                        typeface = Typeface.createFromAsset(getAssets(),"3d.ttf");
                        textViewHello.setTypeface(typeface);
                        break;
                    case "Eraser":
                        typeface = Typeface.createFromAsset(getAssets(),"eraser.ttf");
                        textViewHello.setTypeface(typeface);
                        break;
                    case "Weird":
                        typeface = Typeface.createFromAsset(getAssets(),"weird.ttf");
                        textViewHello.setTypeface(typeface);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}