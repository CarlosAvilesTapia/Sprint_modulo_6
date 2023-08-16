package cl.cat2814.sprintmodulo6.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneDatabase
import cl.cat2814.sprintmodulo6.model.remoteData.SmartphoneRetrofitClient
import cl.cat2814.sprintmodulo6.model.repository.SmartphoneRepository
import kotlinx.coroutines.launch

class SmartphoneViewModel(application: Application): AndroidViewModel(application) {

    private val smartphoneRepository: SmartphoneRepository

    // Funciones para el listado de smartphones.
    fun liveDataSmartphonesFromRepository() = smartphoneRepository.getSmartphonesFromDatabase()

    init {
        val smartphonesApi = SmartphoneRetrofitClient.getRetrofitSmartphone()
        val smartphonesDatabase =
            SmartphoneDatabase.getDatabase(application).getSmartphonesFromDao()
        smartphoneRepository = SmartphoneRepository(smartphonesApi, smartphonesDatabase)
    }

    fun getAllSmartphonesFromRepository() = viewModelScope.launch {
        smartphoneRepository.loadSmartphoneFromApiToDatabase()
    }


    // Funciones para el detalle de smartphones.
    fun liveDataSmartphoneDetailFromRepository(id: Int) =
        smartphoneRepository.getSmartphoneDetailFromDatabase(id)

    fun getSmartphoneDetailFromRepository(id: Int) = viewModelScope.launch {
        smartphoneRepository.loadSmartphoneDetailFromApiToDatabase(id)
    }
}
