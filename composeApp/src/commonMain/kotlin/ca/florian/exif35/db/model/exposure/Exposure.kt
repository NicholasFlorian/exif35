package ca.florian.exif35.db.model.exposure

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ca.florian.exif35.db.model.roll.Roll

@Entity(
    tableName = "exposures",
    indices = [Index(value = ["exposureId"])],
    foreignKeys = [
        ForeignKey(
            entity = Roll::class,
            parentColumns = ["id"],
            childColumns = ["rollId"],
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]
)
data class Exposure(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val rollId: Long,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val title: String? = null,
    val aperture: String? = null,
    val lensSettings: String? = null,
    val exposureSetting: String? = null
)
