package ca.florian.exif35.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<Exif35Database> {
    val appContext = context.applicationContext
    val name = appContext.getDatabasePath("exif_35.db").absolutePath

    return Room.databaseBuilder<Exif35Database>(
        context = appContext,
        name = name
    )
}
