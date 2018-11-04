package fr.toporando.app.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

/**
 * Created by Rémi de Chazelles on 31/10/18.
 */
@Entity(tableName = "cesml_readings")
data class CESMLReading(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "peak_hours") var peakHours: Int,
    @ColumnInfo(name = "off_peak_hours") var offPeakHours: Double,
    @ColumnInfo(name = "datetime") var dateTime: OffsetDateTime
)