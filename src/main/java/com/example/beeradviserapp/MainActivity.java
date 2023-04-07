package com.example.beeradviserapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.beeradviserapp.BeerExpert;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
//        TextView brands = (TextView) findViewById(R.id.brands);
//        brands.setText("Gottle of geer");
//
//        Spinner color = (Spinner) findViewById(R.id.color);
//        String.valueOf(color.getSelectedItemId());
//        color.getSelectedItem();

        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color =(Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
//        brands.setText(beerType);

        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        //Display the beers
        brands.setText(brandsFormatted);
    }
}