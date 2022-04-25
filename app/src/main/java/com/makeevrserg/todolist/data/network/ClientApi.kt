package com.makeevrserg.todolist.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.network.models.Characters
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException
import java.util.concurrent.TimeUnit

class ClientApi {
    private fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(10L, TimeUnit.SECONDS)
        .connectTimeout(10L, TimeUnit.SECONDS)
        .readTimeout(10L, TimeUnit.SECONDS)
        .writeTimeout(10L, TimeUnit.SECONDS)
        .build()


    private fun retrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()

    private var api = retrofit().create(RickAndMortyApi::class.java)


    suspend fun fetchCharacters(): Characters? = safeCall(api?.fetchCharacters())
    suspend fun fetchCharacter(id: Long): Character? = safeCall(api?.fetchCharacter(id))


    private suspend inline fun <T> safeCall(
        call: Call<T>?,
        onError: (Exception) -> Unit = { exception -> exception.printStackTrace() }
    ): T? {
        val req = call?.awaitResponse() ?: return null
        println("$req--------------------------")
        return when {
            req.isSuccessful -> req.body()
            else -> throw IOException()
        }
    }
}


suspend inline fun <reified T> catching(crossinline block: suspend () -> T) = try {
    block()
} catch (e: java.lang.Exception) {
    e.printStackTrace()
    null
}

