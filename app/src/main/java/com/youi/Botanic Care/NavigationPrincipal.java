package com.youi.hellooo;

//A&E

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class NavigationPrincipal extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_navigation, container, false);

        //ImageButton pbtn = view.findViewById(R.id.pbtnmain);
        //ImageButton cbtn = view.findViewById(R.id.cbtnmain);
        ImageButton sbtn = view.findViewById(R.id.sbtnmain);
        ImageButton tbtn = view.findViewById(R.id.tbtnmain);
        ImageButton qbtn = view.findViewById(R.id.qbtnmain);

        /*pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Primer Boton", Toast.LENGTH_SHORT).show();
            }
        });*/

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Segundo Boton", Toast.LENGTH_SHORT).show();
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Home Boton", Toast.LENGTH_SHORT).show();
            }
        });

        /*cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Cuarto Boton", Toast.LENGTH_SHORT).show();
            }
        });*/

        qbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Quinto Boton", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
