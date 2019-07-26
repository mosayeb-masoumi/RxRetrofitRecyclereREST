package com.example.rxretrofitrecyclererest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rxretrofitrecyclererest.adapter.PostAdapter;
import com.example.rxretrofitrecyclererest.retrofit.APIService;
import com.example.rxretrofitrecyclererest.retrofit.APIClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    APIService myAPI;
    RecyclerView recycler_post;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init api
        Retrofit retrofit = APIClient.getInstance();
        myAPI = retrofit.create(APIService.class);

        //view
        recycler_post = findViewById(R.id.recycler_post);
        recycler_post.setHasFixedSize(true);
        recycler_post.setLayoutManager(new LinearLayoutManager(this));

        fetchData();

    }

   private void fetchData() {
        compositeDisposable.add(myAPI.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Post>>() {
                       @Override
                       public void accept(List<Post> posts) throws Exception {
                           displayData(posts);

//                PostAdapter adapter = new PostAdapter(MainActivity.this,posts);
//                recycler_post.setAdapter(adapter);
                       }
                   }, new Consumer<Throwable>() {
                       @Override
                       public void accept(Throwable t) throws Exception {
                           Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }

        ));

    }



    private void displayData(List<Post> posts) {

        PostAdapter adapter = new PostAdapter(this, posts);
        recycler_post.setAdapter(adapter);
    }


    @Override
    protected void onStop() {

        compositeDisposable.clear();
        super.onStop();
    }
}
