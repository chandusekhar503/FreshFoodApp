package com.example.dineshkumarreddy.kirana;

import com.example.dineshkumarreddy.kirana.model.ApiResponse;
import com.example.dineshkumarreddy.kirana.model.LoginResponse;
import com.example.dineshkumarreddy.kirana.model.SignUpRequest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class RetrofitClient {
    private static APIInterface mApiInterface;

    public static APIInterface getAPIClient() {
        if (mApiInterface == null) {
            Retrofit restAdapter = new Retrofit.Builder().baseUrl("http://192.168.1.7:3000/")//192.168.1.5 192.168.43.40
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiInterface = restAdapter.create(APIInterface.class);
        }

        return mApiInterface;
    }

    public interface APIInterface {
        @POST("users/create")
        Call<ApiResponse> signUp(
                @Body SignUpRequest body
        );


        @GET("users/login")
        Call<LoginResponse> signIn(
                @Query("username") String mobileNumber,
                @Query("password") String password
        );

        @GET("users/verifyEmail")
        Call<ApiResponse> verifyEmail(
                @Query("username") String mobileNumber
        );
    }
}
