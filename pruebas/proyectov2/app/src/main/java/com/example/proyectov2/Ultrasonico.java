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


public class Ultrasonico extends AppCompatActivity {
    TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultrasonico);
        txt1=findViewById(R.id.elfeed_id1);
        txt2=findViewById(R.id.valor1);
        sensorultra();
    }
    private void sensorultra() {
        String link = "http://3.16.30.229/api/getdistancia";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //   final Gson gson = new Gson();
                try{
                    String a = response.getString("distancia");
                    String b = response.getString("created_at");
                    txt1.setText(a);
                    txt2.setText(b);
                }catch(JSONException e){
                    e.printStackTrace();

                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }
        );

        SingletonRequest.getInstance(this).addToRequestQue(registro);
    }
}