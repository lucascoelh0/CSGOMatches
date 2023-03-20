package com.lucascoelho.csgomatches.common.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class TimeUtilsTest {

    @Test
    fun `should format string date correctly`() {
        val date = "2023-03-19T21:50:01Z"
        val expectedDate = "19.03 21:50"

        val result = TimeUtils.formatDateStringToLocalDateString(date)

        assertEquals(expectedDate, result)
    }
}
