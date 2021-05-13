package com.example.login.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.login.model.Usuario;
import com.example.login.request.ApiClient;
import com.example.login.ui.login.MainActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ViewModelRegistro extends AndroidViewModel {
   private Context context;
   private ApiClient api;
    private MutableLiveData<Usuario> registro;

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Usuario> getRegistro() {

        if(registro == null)
        {
            registro= new MutableLiveData<>();
        }
        return registro;
    }

    public void guardarDatos(Usuario usuario)
    {
        api.guardar(context, usuario);
        Toast.makeText(this.context,"Operación Exitosa", Toast.LENGTH_LONG).show();




    }

    public void leerDatos()
    {
        Usuario user= api.leer(context);
        registro.setValue(user);


    }
}
