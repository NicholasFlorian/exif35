package ca.florian.exif35.ui.util

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

object DateFormatter {
    fun format(date: Long?): String {
        return if (date == null || date == 0L) {
            "-- * -- * --"
        } else {
            val instant = Instant.fromEpochMilliseconds(date)
            val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
            val year = localDateTime.year.toString().takeLast(2)
            val month = localDateTime.monthNumber.toString().padStart(2, '0')
            val day = localDateTime.dayOfMonth.toString().padStart(2, '0')
            "$year * $month * $day"
        }
    }
}
