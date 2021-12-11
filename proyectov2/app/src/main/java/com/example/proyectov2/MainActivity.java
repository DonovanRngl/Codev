package com.example.proyectov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectov2.cosasrecycler.adaptator;
import com.example.proyectov2.models.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }

    public void iniciar(){

        List<modelo> elements=new ArrayList<>();

        elements.add(new modelo("Temperatura",new Intent(this,Temperatura.class)));
        elements.add(new modelo("Humedad",new Intent(this,Humedad.class)));
        elements.add(new modelo("Humo",new Intent(this,Humo.class)));
        elements.add(new modelo("Ultrasonico",new Intent(this,Ultrasonico.class)));
        elements.add(new modelo("Movimiento",new Intent(this,Movimiento.class)));

        adaptator root=new adaptator(elements, this, new adaptator.OnItemClickListener() {
            @Override
            public void OnItemClick(adaptator item) {

            }
        });


        RecyclerView recyclerView= findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(root);
    }


}