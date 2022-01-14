package uz.ilhomjon.recycleviewpaging3lib.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import uz.ilhomjon.recycleviewpaging3lib.models.UserData

interface ApiService {

    @GET("users")
    suspend fun getUsers2(@Query("page") page: Int): UserData


}