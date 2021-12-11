package com.example.proyectov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Temperatura extends AppCompatActivity {
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        text1=findViewById(R.id.dato1);
        text2=findViewById(R.id.dato2);
        sensortempe();
    }
    private void sensortempe() {
        String link1 = "http://3.16.30.229/api/gettemperatura";
        JSONObject datos1 = new JSONObject();
        JsonObjectRequest registro1 = new JsonObjectRequest(Request.Method.GET, link1, datos1, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String a = response.getString("temperatura");
                    String b = response.getString("created_at");
                    text1.setText(a);
                    text2.setText(b);

                }catch(JSONException e){
                    e.printStackTrace();
                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
        SingletonRequest.getInstance(this).addToRequestQue(registro1);
    }
}