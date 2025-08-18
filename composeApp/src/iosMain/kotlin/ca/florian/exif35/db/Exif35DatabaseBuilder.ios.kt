package ca.florian.exif35.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSSearchPathForDirectoriesInDomains

fun getDatabase(): Exif35Database {
    return Room.databaseBuilder<Exif35Database>(
        name = "${getRootDirectory()}//exif_35.db.db",
        factory = {Exif35Database::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
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
