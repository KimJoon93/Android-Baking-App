package com.example.android.android_baking_app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.android.android_baking_app.Constant.BAKING_BASE_URL;

public class RetrofitClient {

    private static Retrofit sRetrofit = null;
    public static Retrofit getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BAKING_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
