package com.example.pc1.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private EditText etUsuario,etContrasenia;
    private Button btnIniciarSecion,btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario=(EditText)findViewById(R.id.etUsuario);
        etContrasenia=(EditText)findViewById(R.id.etPassword);
        btnIniciarSecion=(Button)findViewById(R.id.btnIniciarSecion);
        btnRegistrarse=(Button)findViewById(R.id.btnRegistrarse);
    }

    public void onClickIniciarSecion(View view)
    {
        String usuario=etUsuario.getText().toString(),
               contrasenia=etContrasenia.getText().toString();
    }

    public void onClickRegistro(View vie)
    {
        startActivity(new Intent(MainActivity.this,RegistrarseActivity.class));
    }

}
