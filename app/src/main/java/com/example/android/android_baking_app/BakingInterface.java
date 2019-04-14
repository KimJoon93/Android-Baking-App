package com.example.android.android_baking_app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BakingInterface {

    @GET("topher/2017/May/59121517_baking/baking.json")
        Call<List<Recipe>> getRecipies();
}
