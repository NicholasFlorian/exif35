package ca.florian.exif35.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "shots",
    indices = [Index(value = ["filmRollId"])],
    foreignKeys = [
        ForeignKey(
            entity = FilmRoll::class,
            parentColumns = ["id"],
            childColumns = ["filmRollId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Shot(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val filmRollId: Long,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val title: String? = null,
    val aperture: String? = null,
    val lensSettings: String? = null,
    val exposureSetting: String? = null
)
