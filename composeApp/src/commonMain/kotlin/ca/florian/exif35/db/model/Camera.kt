package ca.florian.exif35.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cameras")
data class Camera(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val model: String,
    val brand: String
)
