package com.example.login.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.login.model.Usuario;
import com.example.login.request.ApiClient;
import com.example.login.ui.registro.RegistroActivity;

public class ViewModelMain extends AndroidViewModel {

    private Context context;
    private ApiClient api;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


    public  void logueo(String email,String pass)
    {
       Usuario res= api.login(context,email,pass);

       if(res != null)
       {
           //api.leer(context);
           Intent i= new Intent(context, RegistroActivity.class);
           i.putExtra("login", true);
           i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(i);
       }
       else {
           Toast.makeText(this.context,"Usuario Inexistente", Toast.LENGTH_LONG).show();
           Intent i= new Intent(context, MainActivity.class);
          // i.putExtra("login",false);
           i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(i);

       }
    }
}
