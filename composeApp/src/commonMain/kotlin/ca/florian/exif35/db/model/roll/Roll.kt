package ca.florian.exif35.db.model.roll

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ca.florian.exif35.db.model.camera.Camera
import kotlin.time.ExperimentalTime

@Entity(
    tableName = "rolls",
    indices = [Index(value = ["cameraId"])],
    foreignKeys = [
        ForeignKey(
            entity = Camera::class,
            parentColumns = ["id"],
            childColumns = ["cameraId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Roll @OptIn(ExperimentalTime::class) constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cameraId: Long = 0,
    val isActive: Boolean = false,
    val dateCreated: Long = kotlin.time.Clock.System.now().toEpochMilliseconds(),
    val iso: Int,
    val name: String,
    val exposures: Int,
    val exposuresTaken: Int
)
