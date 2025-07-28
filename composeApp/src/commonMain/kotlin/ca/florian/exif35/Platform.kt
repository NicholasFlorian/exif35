package ca.florian.exif35

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform