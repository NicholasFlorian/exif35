package ca.florian.exif35.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "film_rolls",
    foreignKeys = [
        ForeignKey(
            entity = Camera::class,
            parentColumns = ["id"],
            childColumns = ["cameraId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FilmRoll(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cameraId: Long,
    val name: String,
    val iso: Int,
    val numberOfShots: Int
)
