package com.aimsmart.app.mygithubsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aimsmart.app.mygithubsample.databinding.ActivityCredactivtyBinding;

public class Credactivty extends AppCompatActivity {
ActivityCredactivtyBinding credactivtyBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        credactivtyBinding = DataBindingUtil.setContentView(this,R.layout.activity_credactivty);
        credactivtyBinding.setLifecycleOwner(this);
        credactivtyBinding.setModel(this);
        SharedPrefernce sharedPrefernce  = new SharedPrefernce();
        if((!sharedPrefernce.getToken(this).trim().equals(""))&&sharedPrefernce.getToken(this).length()==40){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Token", sharedPrefernce.getToken(this));
            startActivity(intent);
            this.finish();
        }
    }
    public void onclick(String token){
        if(token.length()<40){
            Toast.makeText(this, "Invalid Token", Toast.LENGTH_SHORT).show();
        }else {
            Log.i("TAG", "onclick: " + token);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Token", token);
            startActivity(intent);
            this.finish();
        }
    }
}