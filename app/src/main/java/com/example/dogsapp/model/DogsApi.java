package com.example.dogsapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DogsApi {
    @GET("DevTides/DogsApi/master/dogs.json")   //endpoint
    Single<List<DogBreed>> getDogs();  //Single emits single value

}
