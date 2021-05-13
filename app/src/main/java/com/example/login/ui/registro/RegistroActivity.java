package com.example.login.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.login.R;
import com.example.login.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private  EditText etDni;
    private  EditText etApellido;
    private  EditText etNombre;
    private  EditText etMail;
    private  EditText etPass;
    Button btGuardar;
    private ViewModelRegistro vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializar();
    }

    public void inicializar()
    {
        etDni=findViewById(R.id.etDni);
        etApellido=findViewById(R.id.etApellido);
        etNombre=findViewById(R.id.etNombre);
        etMail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        btGuardar=findViewById(R.id.btGuardar);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dni =Integer.parseInt(etDni.getText().toString());
                 Usuario user= new Usuario(dni,etApellido.getText().toString(),etNombre.getText().toString(),etMail.getText().toString(),etPass.getText().toString());
                 vm.guardarDatos(user);
            }
        });

        vm.getRegistro().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
               etDni.setText(""+ usuario.getDni());
               etApellido.setText(usuario.getApellido());
               etNombre.setText(usuario.getNombre());
               etMail.setText(usuario.getMail());
               etPass.setText(usuario.getPassword());

            }
        });

          boolean log = getIntent().getExtras().getBoolean("login",false);

          if(log == true)
          {
              vm.leerDatos();
          }



    }
}