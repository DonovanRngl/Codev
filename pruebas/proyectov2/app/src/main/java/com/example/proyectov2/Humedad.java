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

public class Humedad extends AppCompatActivity {
    TextView notas1, notas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humedad);
        notas1=findViewById(R.id.elfeed_id5);
        notas2=findViewById(R.id.valor5);
        sensorhumedad();
    }

    private void sensorhumedad() {
        String link = "http://3.16.30.229/api/gethumedad";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String a = response.getString("humedad");
                    String b = response.getString("created_at");
                    notas1.setText(a);
                    notas2.setText(b);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }
        );
        SingletonRequest.getInstance(this).addToRequestQue(registro);
    }
}