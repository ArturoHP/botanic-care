package com.youi.hellooo;

//A&E
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BigPlantImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_plant_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        ImageButton ibreturn = findViewById(R.id.returnBtnBig);
        ibreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        String name = getIntent().getStringExtra("name"), desc = getIntent().getStringExtra("info"), image = getIntent().getStringExtra("imageB");


        TextView tvtoolbar = findViewById(R.id.NameToolbarPlant);
        tvtoolbar.setText(name);
        TextView tvinfo = findViewById(R.id.textinfoPlant);
        tvinfo.setText(desc);
        ImageView ivBig = findViewById(R.id.BigPlant);
        Picasso.with(BigPlantImage.this).load(image).into(ivBig);


    }
}