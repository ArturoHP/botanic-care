package com.youi.hellooo;

//A&E
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private FirebaseRecyclerAdapter<Planta,PlantasHouseViewHolder> PlantasSelectedAdapter;
    private FirebaseRecyclerAdapter<Planta,PlantasOfficeViewHolder> PlantasOfficeAdapter;
    private FirebaseRecyclerAdapter<Planta,PlantasBackyardViewHolder> PlantasBackAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoordinatorLayout cl = findViewById(R.id.cl1);

        //Menu
        //ImageButton pbtn = findViewById(R.id.pbtnmain);
        ImageButton sbtn = findViewById(R.id.sbtnmain);
        ImageButton tbtn = findViewById(R.id.tbtnmain);
        //ImageButton cbtn = findViewById(R.id.cbtnmain);
        ImageButton qbtn = findViewById(R.id.qbtnmain);

        /*pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Primer Boton",Toast.LENGTH_SHORT).show();
            }
        });*/

       sbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MainActivity.this,"Segundo Boton",Toast.LENGTH_SHORT).show();
           }
       });

       tbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MainActivity.this,"Home Boton",Toast.LENGTH_SHORT).show();
           }
       });

       ///*cbtn.setOnClickListener(new View.OnClickListener() {
       //    @Override
       //    public void onClick(View view) {
       //        Toast.makeText(MainActivity.this,"Cuarto Boton",Toast.LENGTH_SHORT).show();
       //    }
       //});*/

       qbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent search = new Intent(getApplicationContext(),searchactivity.class);
               startActivity(search);
           }
       });
        //Menu






        TextView Saludo = findViewById(R.id.saludo);

        Date dt = new Date();
       final int hours = dt.getHours();


        if(hours>=0 && hours<=12){
            Saludo.setText("Good Morning");
            Log.i("Hora", String.valueOf(hours));
        }else if(hours>12 && hours<17){
            Saludo.setText("Good Afternoon");
            Log.i("Hora", String.valueOf(hours));
        }else if(hours>=17 && hours<=21){
            Saludo.setText("Good Evening");
            Log.i("Hora", String.valueOf(hours));
        }else if(hours>=21 && hours<=24){
            Saludo.setText("Good Night");
            Log.i("Hora", String.valueOf(hours));
        }


        FirebaseDatabase database = FirebaseDatabase.getInstance();

        LinearLayoutManager layoutManagerHoriz2
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerHoriz3
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerHoriz4
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        final DatabaseReference PlantasSelected = database.getReference().child("Plantas").child("HousePlants");//Esto se modificara para despues redirigirlo
        RecyclerView plantasselected = findViewById(R.id.TiposPlantasSelec);
        plantasselected.setLayoutManager(layoutManagerHoriz2);
        Query PlantasQuerySelec = PlantasSelected.orderByPriority();
        final FirebaseRecyclerOptions OptF = new FirebaseRecyclerOptions.Builder<Planta>().setQuery(PlantasQuerySelec,Planta.class).build();


        PlantasSelectedAdapter = new FirebaseRecyclerAdapter<Planta, PlantasHouseViewHolder>(OptF) {
            @Override
            protected void onBindViewHolder(@NonNull PlantasHouseViewHolder plantasViewHolder, int i, @NonNull final Planta planta) {
                plantasViewHolder.setNombre(MainActivity.this,planta.getName());
                plantasViewHolder.setImage(MainActivity.this,planta.getImage());
                plantasViewHolder.SetShortDesc(MainActivity.this,planta.getShortdesc());

                plantasViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentPlantBig = new Intent(MainActivity.this,BigPlantImage.class);
                        intentPlantBig.putExtra("name",planta.getName());
                        intentPlantBig.putExtra("info",planta.getInfo());
                        intentPlantBig.putExtra("imageB",planta.getImagebig());
                        intentPlantBig.putExtra("date",planta.getDate());
                       startActivity(intentPlantBig);
                    }
                });
            }

            @NonNull
            @Override
            public MainActivity.PlantasHouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_plantacardview,parent,false);
                return new MainActivity.PlantasHouseViewHolder(view);
            }
        };

        PlantasSelectedAdapter.startListening();
        plantasselected.setAdapter(PlantasSelectedAdapter);


        final DatabaseReference PlantasOficina = database.getReference().child("Plantas").child("Office Plants");//Esto se modificara para despues redirigirlo
        RecyclerView plantasoffice = findViewById(R.id.TiposPlantasOffice);
        plantasoffice.setLayoutManager(layoutManagerHoriz3);
        Query PlantasQueryOffice = PlantasOficina.orderByPriority();
        final FirebaseRecyclerOptions OptF2 = new FirebaseRecyclerOptions.Builder<Planta>().setQuery(PlantasQueryOffice,Planta.class).build();


        PlantasOfficeAdapter = new FirebaseRecyclerAdapter<Planta, PlantasOfficeViewHolder>(OptF2) {
            @Override
            protected void onBindViewHolder(@NonNull PlantasOfficeViewHolder plantasOfficeViewHolder, int i, @NonNull final Planta planta) {
                plantasOfficeViewHolder.setNombre(MainActivity.this,planta.getName());
                plantasOfficeViewHolder.setImage(MainActivity.this,planta.getImage());
                plantasOfficeViewHolder.SetShortDesc(MainActivity.this,planta.getShortdesc());


                plantasOfficeViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentPlantBig = new Intent(MainActivity.this,BigPlantImage.class);
                        intentPlantBig.putExtra("name",planta.getName());
                        intentPlantBig.putExtra("info",planta.getInfo());
                        intentPlantBig.putExtra("imageB",planta.getImagebig());
                        intentPlantBig.putExtra("date",planta.getDate());
                        startActivity(intentPlantBig);
                    }
                });
            }

            @NonNull
            @Override
            public MainActivity.PlantasOfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_plantacardview,parent,false);
                return new MainActivity.PlantasOfficeViewHolder(view);
            }
        };
        PlantasOfficeAdapter.startListening();
        plantasoffice.setAdapter(PlantasOfficeAdapter);


        final DatabaseReference PlantasBack = database.getReference().child("Plantas").child("BackyardPlants");
        RecyclerView plantasback = findViewById(R.id.TiposPlantasBack);
        plantasback.setLayoutManager(layoutManagerHoriz4);
        Query PlantasQueryBack = PlantasBack.orderByPriority();
        final FirebaseRecyclerOptions OptF3 = new FirebaseRecyclerOptions.Builder<Planta>().setQuery(PlantasQueryBack,Planta.class).build();


        PlantasBackAdapter = new FirebaseRecyclerAdapter<Planta, PlantasBackyardViewHolder>(OptF3) {
            @Override
            protected void onBindViewHolder(@NonNull PlantasBackyardViewHolder plantasBackyardViewHolder, int i, @NonNull final Planta planta) {
                plantasBackyardViewHolder.setNombre(MainActivity.this,planta.getName());
                plantasBackyardViewHolder.setImage(MainActivity.this,planta.getImage());
                plantasBackyardViewHolder.SetShortDesc(MainActivity.this,planta.getShortdesc());

                plantasBackyardViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentPlantBig = new Intent(MainActivity.this,BigPlantImage.class);
                        intentPlantBig.putExtra("name",planta.getName());
                        intentPlantBig.putExtra("info",planta.getInfo());
                        intentPlantBig.putExtra("imageB",planta.getImagebig());
                        intentPlantBig.putExtra("date",planta.getDate());
                        startActivity(intentPlantBig);
                    }
                });

            }

            @NonNull
            @Override
            public MainActivity.PlantasBackyardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_plantacardview,parent,false);
                return new MainActivity.PlantasBackyardViewHolder(view);
            }
        };

        plantasback.setAdapter(PlantasBackAdapter);
        PlantasBackAdapter.startListening();
    }



    public class PlantasHouseViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public PlantasHouseViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setNombre(Context ctx,String nombre){
            TextView tvnombreplanta = mView.findViewById(R.id.PlantName);
            tvnombreplanta.setText(nombre);
        }
        public void SetShortDesc(Context ctx,String sdesc){
            TextView tvsdescplanta = mView.findViewById(R.id.PlantShortDesc);
            tvsdescplanta.setText(sdesc);
        }
        public void setImage(Context ctx,String image){
            ImageView imageplanta = mView.findViewById(R.id.PlantImage);
            Picasso.with(ctx).load(image).into(imageplanta);
        }

    }

    public class PlantasOfficeViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public PlantasOfficeViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setNombre(Context ctx,String nombre){
            TextView tvnombreplanta = mView.findViewById(R.id.PlantName);
            tvnombreplanta.setText(nombre);
        }
        public void SetShortDesc(Context ctx,String sdesc){
            TextView tvsdescplanta = mView.findViewById(R.id.PlantShortDesc);
            tvsdescplanta.setText(sdesc);
        }
        public void setImage(Context ctx,String image){
            ImageView imageplanta = mView.findViewById(R.id.PlantImage);
            Picasso.with(ctx).load(image).into(imageplanta);
        }

    }

    public class PlantasBackyardViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public PlantasBackyardViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setNombre(Context ctx,String nombre){
            TextView tvnombreplanta = mView.findViewById(R.id.PlantName);
            tvnombreplanta.setText(nombre);
        }

        public void SetShortDesc(Context ctx,String sdesc){
            TextView tvsdescplanta = mView.findViewById(R.id.PlantShortDesc);
            tvsdescplanta.setText(sdesc);
        }

        public void setImage(Context ctx,String image){
            ImageView imageplanta = mView.findViewById(R.id.PlantImage);
            Picasso.with(ctx).load(image).into(imageplanta);
        }

    }

    @Override
    public void onBackPressed() {
        Log.i("RETURN MAIN","cancelled");
    }
}