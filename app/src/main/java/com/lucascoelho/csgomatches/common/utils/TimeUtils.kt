package com.lucascoelho.csgomatches.common.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object TimeUtils {
    private const val DATE_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private const val DATE_MONTH_HOUR_MINUTE = "dd.MM HH:mm"

    fun formatDateStringToLocalDateString(
        value: String
    ): String {
        val localDateTime = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(DATE_TIME_ZONE_FORMAT))
        return localDateTimeToString(localDateTime)
    }

    private fun localDateTimeToString(localDateTime: LocalDateTime): String {
        val formatter = DateTimeFormatter.ofPattern(DATE_MONTH_HOUR_MINUTE)
        return formatter.format(
            localDateTime.atZone(ZoneId.systemDefault()).toLocalDateTime()
        )
    }
}
