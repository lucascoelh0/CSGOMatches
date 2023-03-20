package com.lucascoelho.csgomatches.common.extensions

import android.content.Context
import android.view.View
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ViewExtensionsTest {

    private lateinit var context: Context
    private lateinit var view: View

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        view = View(context)
    }

    @Test
    fun `setVisible should set visibility to VISIBLE`() {
        view.setVisible()

        assertEquals(View.VISIBLE, view.visibility)
    }

    @Test
    fun `setGone should set visibility to GONE`() {
        view.setGone()

        assertEquals(View.GONE, view.visibility)
    }
}
