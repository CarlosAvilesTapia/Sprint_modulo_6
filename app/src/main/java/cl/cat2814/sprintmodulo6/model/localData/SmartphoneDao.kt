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

    // Función copiada pero cambiando el parámetro por una lista para testing.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSmartphones(smartphoneEntity: List<SmartphoneEntity>)

    @Query("SELECT * FROM smartphones_table ORDER BY id ASC")
    fun getSmartphonesListFromDatabase(): LiveData<List<SmartphoneEntity>>



    // Inserción y consulta de detalles del smartphone desde la Database.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSmartphoneDetail(smartphoneDetailEntity: SmartphoneDetailEntity)

    @Query("SELECT * FROM smartphones_detail_table WHERE id = :id")
    fun getSmartphoneDetailFromDatabase(id: Int): LiveData<SmartphoneDetailEntity>
}
