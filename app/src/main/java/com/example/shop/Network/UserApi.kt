package com.example.shop.Network

import com.example.shop.Data.Loginresponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*


interface UserApi {
    //Login Méthode 1
    @POST("users/signIn")
    fun login1(
        @Body body: JsonObject
    ): Call<JsonObject>
    // A suspending function is simply a function that can be paused and resumed at a later time. They can execute a long running operation and wait for it to complete without blocking.
    //Login Méthode 2
    @POST("users/signIn")
    suspend fun login2(@Body User: Loginresponse): Response<Loginresponse>
    //
    @POST("users/signup")
    fun signup(@Body map : HashMap<String, String> ): Call<JsonObject>

    @POST("api/user/SendConfirmEmail")
    suspend fun SendConfirmEmail(@Body User: Loginresponse): Response<Loginresponse>

    @POST("users/forgetPassword")
    fun SendCodeForgot(@Body map : HashMap<String, String> ): Call<JsonObject>

    @POST("users/VerifCode")
    fun VerifCodeForgot(@Body map : HashMap<String, String> ): Call<JsonObject>

    @POST("users/changePassword")
    fun ChangePasswordForgot(@Body map : HashMap<String, String> ): Call<JsonObject>

    @POST("users/UpdateUser")
    fun EditProfil(@Body map : HashMap<String, String> ): Call<JsonObject>

    @POST("users/UpdatePassword")
    fun UpdatePassword(@Body map : HashMap<String, String> ): Call<JsonObject>


    @Multipart
    @POST("users/updateavatar")
    fun postImage(
        @Part("email") email:RequestBody,
        @Part photo: MultipartBody.Part,
    ):Call<Loginresponse>

}