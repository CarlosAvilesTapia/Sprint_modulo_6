package cl.cat2814.sprintmodulo6.model.localData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SmartphoneDao {

    // Inserción y consulta para listado de teléfonos.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSmartphones(smartphoneEntity: SmartphoneEntity)

    // Función copiada pero cambiando el parámetro por una lista.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSmartphones(smartphoneEntity: List<SmartphoneEntity>)

    @Query("SELECT * FROM smartphones_table ORDER BY id ASC")
    fun getSmartphones(): LiveData<List<SmartphoneEntity>>
}
