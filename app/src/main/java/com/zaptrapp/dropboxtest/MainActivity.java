package com.zaptrapp.dropboxtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zaptrapp.dropboxtest.Adapter.PhotoAdapter;
import com.zaptrapp.dropboxtest.FlickrService.ApiClient;
import com.zaptrapp.dropboxtest.FlickrService.ApiConstant;
import com.zaptrapp.dropboxtest.FlickrService.ApiInterface;
import com.zaptrapp.dropboxtest.Model.MainResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));




        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Observable<MainResponse> urlCall = apiInterface
                .getPhoto(ApiConstant.API_KEY);
        urlCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MainResponse>() {
                    @Override
                    public void onNext(@NonNull MainResponse mainResponse) {
                        Log.d(TAG, "onNext: ");
                        List<MainResponse.Photo> photoList = mainResponse.photos.photo;
                        adapter = new PhotoAdapter(photoList);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });


    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
}
