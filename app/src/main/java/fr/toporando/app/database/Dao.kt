package fr.toporando.app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import fr.toporando.app.database.models.CESMLReading

/**
 * Created by Rémi de Chazelles on 31/10/18.
 */
@Dao
interface Dao {

    @Query("SELECT * FROM cesml_readings")
    fun getAll(): List<CESMLReading>

    @Insert(onConflict = REPLACE)
    fun insert(reading: CESMLReading)

    @Query("DELETE FROM cesml_readings")
    fun deleteAll()
}