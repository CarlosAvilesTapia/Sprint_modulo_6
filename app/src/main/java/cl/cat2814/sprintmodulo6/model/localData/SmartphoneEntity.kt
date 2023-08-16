package cl.cat2814.sprintmodulo6.model.localData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "smartphones_table")
data class SmartphoneEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String
)

@Entity(tableName = "smartphones_detail_table")
data class SmartphoneDetailEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description:String,
    val lastPrice:Int,
    val credit: Boolean
)
