package com.aimsmart.app.mygithubsample;

import android.content.Context;

public class SharedPrefernce {
    public void setToken(Context context,String token){
         context.getSharedPreferences("MySharedpref",Context.MODE_PRIVATE).edit().putString("Token",token).apply();
    }
    public String getToken(Context context){
        return context.getSharedPreferences("MySharedpref",Context.MODE_PRIVATE).getString("Token","Invalid Token");
    }
}
