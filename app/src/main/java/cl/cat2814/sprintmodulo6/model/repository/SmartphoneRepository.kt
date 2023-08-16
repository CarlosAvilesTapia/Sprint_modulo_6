package cl.cat2814.sprintmodulo6.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneDao
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneDetailEntity
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import cl.cat2814.sprintmodulo6.model.remoteData.SmartphoneApi

class SmartphoneRepository(
    private val smartphoneApi: SmartphoneApi,
    private val smartphoneDao: SmartphoneDao
) {
    // Función para cargar listado de smartphones en la database.
    suspend fun loadSmartphoneFromApiToDatabase() {
        try {
            val response = smartphoneApi.getSmartphonesFromApi()
            if (response.isSuccessful) {
                val responseSmartphones = response.body()
                responseSmartphones?.let { smartphones ->
                    val smartphonesEntities = smartphones.map { it.toEntity() }
                    smartphoneDao.insertSmartphones(smartphonesEntities)
                }
            } else {
                Log.e("Repository", response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("Repository", "")
        }
    }

    // Función para obtener listado de smartphones.
    fun getSmartphonesFromDatabase(): LiveData<List<SmartphoneEntity>> =
        smartphoneDao.getSmartphonesListFromDatabase()


    // Función para cargar detalle de smartphones en la database.
    suspend fun loadSmartphoneDetailFromApiToDatabase(id : Int){
        try {
            val response = smartphoneApi.getSmartphonesDetailFromApi(id)
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let { smartphone ->
                    val smartphoneDetailEntity = smartphone.toDetailEntity()
                    smartphoneDao.insertSmartphoneDetail(smartphoneDetailEntity)
                }
            } else {
                Log.e("Repository", response.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("Repository","")
        }
    }

    // Función para obtener detalle de smartphones.
    fun getSmartphoneDetailFromDatabase(id: Int): LiveData<SmartphoneDetailEntity> =
        smartphoneDao.getSmartphoneDetailFromDatabase(id)
}
