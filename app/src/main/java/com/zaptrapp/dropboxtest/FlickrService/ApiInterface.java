package com.zaptrapp.dropboxtest.FlickrService;

import com.zaptrapp.dropboxtest.Model.MainResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nishanth on 26/09/17.
 */

public interface ApiInterface {

    @GET("services/rest/?method=flickr.people.getPhotos&format=json&nojsoncallback=1&user_id=143467064@N07")
    Observable<MainResponse> getPhoto(@Query("api_key") String api_key);
}
