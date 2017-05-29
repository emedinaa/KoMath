package com.emedinaa.komath.data

import com.emedinaa.komath.data.model.QuestionReponse
import com.emedinaa.komath.data.model.SubjectReponse
import com.emedinaa.komath.data.model.UserRaw
import com.emedinaa.komath.data.model.UserReponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.GET
/**
 * Created by emedinaa on 26/05/17.
 */
class ApiClient {

    companion object {
        private var servicesApiInterface: ServicesApiInterface? = null
        private val API_BASE_URL = "https://infinite-atoll-65414.herokuapp.com"

        private fun interceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return httpLoggingInterceptor
        }

        fun getMyApiClient(): ServicesApiInterface {
            var builder: Retrofit.Builder = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
            var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor())

            var retrofit: Retrofit = builder.client(httpClient.build()).build()
            servicesApiInterface = retrofit.create(
                    ServicesApiInterface::class.java)

            return servicesApiInterface as ServicesApiInterface
        }
    }

    interface ServicesApiInterface {

        @POST("/api/login")
        fun logIn(@Body raw: UserRaw): Call<UserReponse>

        @POST("/api/register")
        fun register(@Body raw: UserRaw): Call<UserReponse>

        @GET("/api/subjects")
        fun subjects(): Call<SubjectReponse>

        @GET("/api/questions")
        fun questions(): Call<QuestionReponse>

        //@GET("/v1/data/Contacts/{objectId}")
        //fun contact(@Path("objectId") objectId: String): Call<BaseReponse>

        //@GET("/v1/users/{objectId}")
        //fun userInfo(@Path("objectId") objectId: String): Call<UserResponse>

        //@GET("/v1/data/Users")
        //fun queryUsers(@Query("where") query: String): Call<BaseReponse>


    }
}