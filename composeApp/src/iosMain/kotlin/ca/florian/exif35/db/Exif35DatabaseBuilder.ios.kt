package ca.florian.exif35.db

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSSearchPathForDirectoriesInDomains

fun getDatabaseBuilder(): RoomDatabase.Builder<Exif35Database> {
    val name = "${getRootDirectory()}//exif_35.db"

    return Room.databaseBuilder<Exif35Database>(
        name = name
    )
}

private fun getRootDirectory(): String {
    val paths = NSSearchPathForDirectoriesInDomains(
        directory = 9u, // documentDirectory
        domainMask = 1u, // userDomainMask
        expandTilde = true
    )

    val root = paths.firstOrNull()

    if(root === null){
        throw IllegalStateException("Searching for Directory Paths Returned Null")
    }
    if(root !is String) {
        throw IllegalStateException("Searching for Directory Paths return Non String")
    }

    return root
}
