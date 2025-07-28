package ca.florian.exif35.db.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CameraDao {
    @Insert
    suspend fun insert(camera: Camera)

    @Query("SELECT * FROM cameras")
    suspend fun getAll(): List<Camera>
}
