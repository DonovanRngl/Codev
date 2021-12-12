package com.example.proyectov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button registrar,iniciarses;
    EditText emaill,pasl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registrar = findViewById(R.id.btn);
        emaill=findViewById(R.id.email_login);
        iniciarses=findViewById(R.id.button);
        pasl1=findViewById(R.id.editTextTextPassword);
       registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(Login.this,Registro.class);
                startActivity(a);
            }
        });
    }

    public void login(View view) {
        Intent a=new Intent(this,Registro.class);
        startActivity(a);
    }
    public void init(View view) {
            String link="http://3.16.30.229/api/register";
            if (emaill.getText().toString().equals("")) {
                Toast.makeText(this,"Ingresa un correo",Toast.LENGTH_SHORT).show();
            } else if (pasl1.getText().toString().equals("")) {
                Toast.makeText(this,"Ingresa una contraseña",Toast.LENGTH_SHORT).show();

            }else {

    /*
    String link="http://3.16.30.229/api/login";
        if (emaill.getText().toString().equals("")) {
        Toast.makeText(this,"Ingresa un nombre de ususario",Toast.LENGTH_SHORT).show();
    }else if (pasl1.getText().toString().equals("")) {
        Toast.makeText(this,"Ingresa una contraseña",Toast.LENGTH_SHORT).show();
    }
*/

                Intent b =new Intent(Login.this,MainActivity.class);
                startActivity(b);
            }

    }
}