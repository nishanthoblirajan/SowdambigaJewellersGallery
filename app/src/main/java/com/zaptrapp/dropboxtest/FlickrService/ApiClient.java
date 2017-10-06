package com.zaptrapp.dropboxtest.FlickrService;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nishanth on 26/09/17.
 */

public class ApiClient {
    public static final String TAG  = ApiClient.class.getSimpleName();
    private static Retrofit sRetrofit = null;


    public static Retrofit getClient(){

        if (sRetrofit ==null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.FLICKR_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }


        Log.d(TAG, "getClient: "+sRetrofit.baseUrl());
        return sRetrofit;
    }

}
