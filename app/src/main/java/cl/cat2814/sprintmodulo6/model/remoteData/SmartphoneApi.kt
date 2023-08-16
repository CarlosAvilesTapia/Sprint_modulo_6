package cl.cat2814.sprintmodulo6.model.remoteData

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SmartphoneApi {

    // Obtención de listado de teléfonos desde la Api.
    @GET("products")
    suspend fun getSmartphonesFromApi(): Response<List<Smartphone>>

    // Obtención de detalle de teléfonos desde la Api.
    @GET("details/{id}")
    suspend fun getSmartphonesDetailFromApi(@Path("id")id:Int): Response<SmartphoneDetail>
}
