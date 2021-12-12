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

public class Nfc extends AppCompatActivity {

    TextView textos1,textos2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        textos1=findViewById(R.id.elfeed_id6);
        textos2=findViewById(R.id.valor6);
        sensorhumo();
    }

    private void sensorhumo() {
        String link = "http://3.16.30.229/api/ultimonfc";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // final Gson gson = new Gson();
                try{
                    String a = response.getString("nombre_ingreso");
                    String b = response.getString("created_at");
                    textos1.setText(a);
                    textos2.setText(b);
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