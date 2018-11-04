package fr.toporando.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.toporando.app.database.models.CESMLReading

/**
 * Created by Rémi de Chazelles on 31/10/18.
 */
@Database(entities = [CESMLReading::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java, "app.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}