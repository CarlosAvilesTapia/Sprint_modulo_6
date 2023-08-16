package cl.cat2814.sprintmodulo6.model.repository

import androidx.lifecycle.LiveData
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneDao
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import cl.cat2814.sprintmodulo6.model.remoteData.Smartphone
import cl.cat2814.sprintmodulo6.model.remoteData.SmartphoneApi

class SmartphoneRepository(
    private val smartphoneDao: SmartphoneDao,
    private val smartphoneApi: SmartphoneApi
) {
    suspend fun loadSmartphoneFromApiToDao() {

        val response = smartphoneApi.getSmartphonesFromApi()
        if (response.isSuccessful) {
            val responseLand = response.body()
            responseLand?.let { smartphones ->
                val smartphonesEntities = smartphones.map { it.toEntity() }
                smartphoneDao.insertSmartphones(smartphonesEntities)
            }
        }
    }

    fun getSmartphonesFromDao(): LiveData<List<SmartphoneEntity>> = smartphoneDao.getSmartphones()


}

//fun Smartphone.toEntity(): SmartphoneEntity = SmartphoneEntity(this.id, this.name, this.price, this.image)

