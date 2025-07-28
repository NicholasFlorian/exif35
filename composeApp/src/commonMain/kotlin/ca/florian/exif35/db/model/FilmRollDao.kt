package ca.florian.exif35.db.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FilmRollDao {
    @Insert
    suspend fun insert(filmRoll: FilmRoll)

    @Query("SELECT * FROM film_rolls")
    suspend fun getAll(): List<FilmRoll>
}
