package com.aimsmart.app.mygithubsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.aimsmart.app.mygithubsample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Mainviewmodel mainviewmodel;
RecyclerView recyclerView;
ActivityMainBinding mainBinding;
Recycle1Adapter recycle1Adapter;
    SharedPrefernce sharedPrefernce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setLifecycleOwner(this);
        mainBinding.setClick(this);
        String token = getIntent().getStringExtra("Token");
        sharedPrefernce= new SharedPrefernce();
        recyclerView = findViewById(R.id.Recyclerview1);
        mainviewmodel =new ViewModelProvider(this).get(Mainviewmodel.class);
        mainviewmodel.getData(token);
        mainviewmodel.reposMutableLiveData.observe(this, new Observer<ArrayList<Repos>>() {
            @Override
            public void onChanged(ArrayList<Repos> repos) {
                Log.i("TAG123", "onCreate: " + repos.size());
                recycle1Adapter = new Recycle1Adapter(MainActivity.this,repos);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(recycle1Adapter);
            }
        });
    }
    public void Onclick(){
        Intent intent = new Intent(this,Credactivty.class);
        startActivity(intent);
        sharedPrefernce.setToken(MainActivity.this," ");
        this.finish();
    }
}