package com.example.pc1.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity
{
    private EditText etNombres,etApellidos,
                     etCorreo,etTelefono,
                     etEdad;

    private Button btnRegistrarse,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        etNombres=(EditText)findViewById(R.id.etNombres);
        etApellidos=(EditText)findViewById(R.id.etApellidos);
        etCorreo=(EditText)findViewById(R.id.etCorreo);
        etTelefono=(EditText)findViewById(R.id.etTelefono);
        etEdad=(EditText)findViewById(R.id.etEdad);
        btnRegistrarse=(Button)findViewById(R.id.btnRegistrarseActivityRegistrarse);
        btnCancelar=(Button)findViewById(R.id.btnCancelarActivityRegistrarse);
    }

    public void onClickRegistrarse(View view)
    {
        String nombres=etNombres.getText().toString(),
               apellidos=etApellidos.getText().toString(),
               correo=etCorreo.getText().toString(),
               telefono=etTelefono.getText().toString(),
               edad=etEdad.getText().toString();

        SqliteHelper helper=new SqliteHelper(RegistrarseActivity.this);
        SQLiteDatabase db=helper.getWritableDatabase();

        if( db == null )
        {
            Toast.makeText(RegistrarseActivity.this,getString(R.string.sinConexionRegistro),Toast.LENGTH_LONG).show();
        }
        else
        {
            long i;
            ContentValues valores=SqliteHelper.getContentValues(nombres,apellidos,correo,telefono,edad);
            i=db.insert(SqliteHelper.nombreTabla,null,valores);
            if( i < 0 )
            {
                Toast.makeText(RegistrarseActivity.this,getString(R.string.noSeRegistro),Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(RegistrarseActivity.this,getString(R.string.registroCorrecto),Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClickCancelar(View view)
    {
        startActivity(new Intent(RegistrarseActivity.this,MainActivity.class));
    }

}
