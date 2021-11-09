package com.aimsmart.app.mygithubsample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RepoAPI {
    @GET("/users/{owner}/repos")
    Call<ArrayList<Repos>> getallrepos(@Path("owner") String owner , @Header("Authorization") String accessToken);
}
