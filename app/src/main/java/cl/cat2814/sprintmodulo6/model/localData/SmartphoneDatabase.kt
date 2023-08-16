package cl.cat2814.sprintmodulo6.model.localData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SmartphoneEntity::class], version = 1)
abstract class SmartphoneDatabase: RoomDatabase() {

    abstract fun getSmartphonesFromDao(): SmartphoneDao

    companion object {
        @Volatile
        private var INSTANCE: SmartphoneDatabase? = null

        fun getDatabase(context: Context): SmartphoneDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SmartphoneDatabase::class.java,
                    "smartphones_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
