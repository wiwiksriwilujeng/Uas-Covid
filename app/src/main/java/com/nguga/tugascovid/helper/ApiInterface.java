package com.nguga.tugascovid.helper;


import com.nguga.tugascovid.model.CovidModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
  @GET(".")
  Call<CovidModel> getAll();
}
