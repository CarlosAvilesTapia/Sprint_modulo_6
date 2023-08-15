package cl.cat2814.sprintmodulo6.model.remoteData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SmartphoneRetrofitClient {

    companion object {
        private const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun getRetrofitSmartphone(): SmartphoneApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(SmartphoneApi::class.java)
        }
    }
}
