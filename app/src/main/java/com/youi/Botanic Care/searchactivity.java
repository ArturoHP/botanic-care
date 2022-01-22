package com.youi.hellooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class searchactivity extends AppCompatActivity {

    private TextView apitxt;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivity);

        ImageButton returns = findViewById(R.id.returnsearch);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        apitxt = findViewById(R.id.text4api);
        final EditText search = findViewById(R.id.heysearch);
        ImageButton btnsearch = findViewById(R.id.searchplantbtn);


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJson(search.getText().toString());
            }
        });
    }


    // http://www.quantitative-plant.org/api?type=dataset&field=FIELD&q=Q
    private void fetchJson(String search){
        String urlprueba;
        if (!search.isEmpty()){
            urlprueba = "http://www.quantitative-plant.org/api?type=dataset&field=organ&q=Q";
            Intent gotourl = new Intent(Intent.ACTION_VIEW, Uri.parse(urlprueba));
            startActivity(gotourl);
        }else{

            Toast.makeText(getApplicationContext(),"Please enter some information in the search field",Toast.LENGTH_SHORT).show();
        }
    }
}
