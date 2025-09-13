package ca.florian.exif35.ui.util

import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

object DateFormatter {

    @OptIn(ExperimentalTime::class)
    fun format(date: Long): String {

        val instant = Instant.fromEpochMilliseconds(date)
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        val year = localDateTime.year.toString().takeLast(2)
        val month = localDateTime.month.number.toString().padStart(2, '0')
        val day = localDateTime.day.toString().padStart(2, '0')

        return "$year * $month * $day"
    }
}
