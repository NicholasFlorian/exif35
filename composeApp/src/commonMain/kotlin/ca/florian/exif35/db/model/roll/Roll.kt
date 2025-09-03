package ca.florian.exif35.db.model.roll

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ca.florian.exif35.db.model.camera.Camera

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
data class Roll(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cameraId: Long,
    val inUse: Boolean,
    val name: String,
    val iso: Int,
    val exposures: Int,
    val exposuresTaken: Int,
)
