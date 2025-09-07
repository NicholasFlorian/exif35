package ca.florian.exif35.db.model.roll

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ca.florian.exif35.db.model.camera.Camera
import kotlinx.datetime.Clock

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
data class Roll (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cameraId: Long = 0,
    val isActive: Boolean = false,
    val iso: Int,
    val name: String,
    val exposures: Int,
    val exposuresTaken: Int,
    val dateUpdated: Long = Clock.System.now().toEpochMilliseconds()
)
