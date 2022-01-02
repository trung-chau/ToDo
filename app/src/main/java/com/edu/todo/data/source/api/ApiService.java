package com.edu.todo.data.source.api;


import com.edu.todo.data.model.BaseResponse;
import com.edu.todo.data.model.BaseStatusPost;
import com.edu.todo.data.model.Note;
import com.edu.todo.data.model.User;
import com.edu.todo.utils.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    Gson gson = new GsonBuilder().create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("users/email={email}")
    Call<BaseResponse<List<User>>> getUser(@Path("email") String email);

    @POST("users/add")
    @FormUrlEncoded
    Call<BaseStatusPost> postUser(@Field("firstName") String firstName,
                                  @Field("lastName") String lastName,
                                  @Field("birthDay") String birthDay,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("gender") String gender,
                                  @Field("notes") String notes);

    @GET("note/iduser={iduser}")
    Call<BaseResponse<List<Note>>> getTasks(@Path("iduser") int iduser);

    @POST("note/add")
    @FormUrlEncoded
    Call<BaseStatusPost> postTask(@Field("created") Date created,
                                  @Field("title") String title,
                                  @Field("content") String content,
                                  @Field("sendNotification") int sendNotification,
                                  @Field("remainder_time") String password,
                                  @Field("iduser") int iduser);
}
