package com.example.rxretrofitrecyclererest.retrofit;

import com.example.rxretrofitrecyclererest.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
