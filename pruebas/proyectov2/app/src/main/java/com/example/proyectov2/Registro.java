package com.example.proyectov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    EditText namer,emailr,pas1,pas2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        namer=findViewById(R.id.nombre_registro);
        emailr=findViewById(R.id.email_registro);
        pas1=findViewById(R.id.editTextTextPassword2);
        pas2=findViewById(R.id.editTextTextPassword3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void registrar(View view) {
        String link="http://3.16.30.229/api/register";
        if (namer.getText().toString().equals("")) {
            Toast.makeText(this,"Ingresa un nombre de ususario",Toast.LENGTH_SHORT).show();
        }
        else if (emailr.getText().toString().equals("")) {
            Toast.makeText(this,"Ingresa un correo",Toast.LENGTH_SHORT).show();
        } else if (pas1.getText().toString().equals("")) {
            Toast.makeText(this,"Ingresa una contraseña",Toast.LENGTH_SHORT).show();
        }else if (pas2.getText().toString().equals("")) {
            if (pas2.getText().toString()!=pas1.getText().toString()){
                Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Confirme la contraseña", Toast.LENGTH_SHORT).show();
            }
        }else {
            JSONObject datos = new JSONObject();
            JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    // final Gson gson = new Gson();
                    try{
                        String a = response.getString("token");
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


            /*

            String NAME=namer.getText().toString().trim();
            String correo=emailr.getText().toString().trim();
            String clave=pas1.getText().toString().trim();
            StringRequest registro=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    namer.setText("");
                    emailr.setText("");
                    pas1.setText("");
                    Toast.makeText(Registro.this,response,Toast.LENGTH_SHORT).show();
                }new Response.ErrorListener(){
                    @Override
                            public void onErrorResponse(VolleyError error){
                        Toast.makeText(Registro.this,error.getMessage().tostring(),Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                protected Map<String, String> getParams()throws AuthFailureError{
                    Map<String,String params>params=new HashMap<String,String>();
                    params.put("nombre",NAME);
                    params.put("Correo",correo);
                    params.put("Contraseña",clave);
                }
            }
            //RequestQueue peticion= Volley.newRequestQueue(Registro.this);
           // peticion.add(request);
            );
        }
      /*  JsonObjectRequest registro=new JsonObjectRequest(Request.Method.POST, link, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray token;=response.getString("token");
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });*/
    }}
}