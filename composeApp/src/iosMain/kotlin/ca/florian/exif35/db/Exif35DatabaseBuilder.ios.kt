package ca.florian.exif35.db

import androidx.room.Room
import androidx.room.RoomDatabase.Builder
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSSearchPathForDirectoriesInDomains

fun getDatabaseBuilder(): Builder<Exif35Database>{
    val dbFilePath = getRootDirectory() + "/exif_35.db"
    return Room.databaseBuilder<Exif35Database>(name = dbFilePath)
        .setDriver(BundledSQLiteDriver())
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
