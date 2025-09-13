package ca.florian.exif35.db.model.exposure

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ca.florian.exif35.db.model.roll.Roll
import kotlin.time.ExperimentalTime

@Entity(
    tableName = "exposures",
    indices = [Index(value = ["rollId"])],
    foreignKeys = [
        ForeignKey(
            entity = Roll::class,
            parentColumns = ["id"],
            childColumns = ["rollId"],
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]
)
data class Exposure @OptIn(ExperimentalTime::class) constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val rollId: Long,
    val location: String?,
    val latitude: Double?,
    val longitude: Double?,
    val title: String? = null,
    val aperture: String? = null,
    val lensSettings: String? = null,
    val iso: String? = null,
    val exposureSetting: String? = null,
    val dateCreated: Long = kotlin.time.Clock.System.now().toEpochMilliseconds()
)
