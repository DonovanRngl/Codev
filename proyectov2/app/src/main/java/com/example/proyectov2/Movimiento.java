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

public class Movimiento extends AppCompatActivity {
    TextView txto1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento);
        txto1=findViewById(R.id.elfeed_id3);
        sensormvove();
    }
    private void sensormvove() {
        String link = "http://3.16.30.229/api/getmovimiento";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // final Gson gson = new Gson();
                try{
                    String a = response.getString("movimiento");
                    if(a=="1.00"){
                        txto1.setText("Movimiento Activado");
                    }else{
                        txto1.setText("Movimiento no detectado");
                    }

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