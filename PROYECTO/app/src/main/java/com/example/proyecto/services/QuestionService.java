package com.example.proyecto.services;

import com.example.proyecto.models.Question;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QuestionService {
    @POST("game/question")
    @Headers("Content-Type: application/json")
    Call<Void> sendQuestion(@Body Question question);
}