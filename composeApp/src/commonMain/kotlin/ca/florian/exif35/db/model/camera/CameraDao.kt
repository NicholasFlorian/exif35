package ca.florian.exif35.db.model.camera

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CameraDao {

    @Insert
    suspend fun insert(camera: Camera)

    @Update
    suspend fun update(camera: Camera)

    @Query("SELECT * FROM cameras WHERE id = :cameraId")
    fun getCameraById(cameraId: Long?) : Flow<Camera?>

    @Transaction
    @Query("SELECT * FROM cameras")
    fun getAllCameraGlances() : Flow<List<CameraGlance>>

    @Delete
    suspend fun delete(camera: Camera)
}
