package ca.florian.exif35.db.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShotDao {
    @Insert
    suspend fun insert(shot: Shot)

    @Query("SELECT * FROM shots WHERE filmRollId = :filmRollId")
    suspend fun getAllForFilmRoll(filmRollId: Long): List<Shot>
}
