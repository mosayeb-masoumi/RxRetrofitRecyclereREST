package com.example.rxretrofitrecyclererest.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit ourInstance ;

   public static Retrofit getInstance() {
       if(ourInstance == null)

           ourInstance = new Retrofit.Builder()
                   .baseUrl("http://jsonplaceholder.typicode.com/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();

        return ourInstance;
    }

    private APIClient() {
    }


}
