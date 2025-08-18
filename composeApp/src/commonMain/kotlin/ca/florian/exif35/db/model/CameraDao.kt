package ca.florian.exif35.db.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CameraDao {

    @Query("SELECT * FROM cameras")
    fun getAll(): Flow<List<Camera>>

    @Insert
    suspend fun insert(camera: Camera)

    @Delete
    suspend fun delete(camera: Camera)

}
