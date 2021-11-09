package com.aimsmart.app.mygithubsample;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mainviewmodel extends AndroidViewModel {
    private String BASE_URL = "https://api.github.com";
    private String Token = "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";
    Recycle1Adapter recycle1Adapter;
    MutableLiveData<ArrayList<Repos>> reposMutableLiveData;
    public Mainviewmodel(@NonNull Application application) {
        super(application);
        reposMutableLiveData = new MutableLiveData<>(new ArrayList<Repos>());
    }

    public MutableLiveData<ArrayList<Repos>> getReposMutableLiveData() {
        return reposMutableLiveData;
    }

    public void setReposMutableLiveData(MutableLiveData<ArrayList<Repos>> reposMutableLiveData) {
        this.reposMutableLiveData = reposMutableLiveData;
    }

    public void getData(String token){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RepoAPI repoAPI = retrofit.create(RepoAPI.class);
        Call<ArrayList<Repos>> call = repoAPI.getallrepos("Akashreddy1980",token);
        call.enqueue(new Callback<ArrayList<Repos>>() {
            @Override
            public void onResponse(Call<ArrayList<Repos>> call, Response<ArrayList<Repos>> response) {
                      if(response.isSuccessful()){
                          reposMutableLiveData.postValue(response.body());

                      }
                      else {
                          Log.i("TAG1", "onResponse: " + response.errorBody());
                      }

            }

            @Override
            public void onFailure(Call<ArrayList<Repos>> call, Throwable t) {
                Log.i("TAG1", "onResponse: " + t.getLocalizedMessage());
            }
        });
    }
}
