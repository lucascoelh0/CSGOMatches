package com.lucascoelho.csgomatches.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.lucascoelho.csgomatches.R

class MyMatchTimeTextView(context: Context, private val attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private var _isLive: Boolean = false
    val isLive: Boolean
        get() = _isLive

    init {
        setupStyleables()
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val currentState = super.onCreateDrawableState(extraSpace + INCREASE_STATE_SIZE)
        if (isLive) {
            val newState = intArrayOf(R.attr.myMatchTimeTextViewIsLive)
            text = context.getString(R.string.now)
            mergeDrawableStates(currentState, newState)
        }
        return currentState
    }

    private fun setupStyleables() {
        context.obtainStyledAttributes(attrs, R.styleable.MyMatchTimeTextView).apply {
            try {
                _isLive = getBoolean(R.styleable.MyMatchTimeTextView_myMatchTimeTextViewIsLive, false)
            } finally {
                recycle()
            }
        }
    }

    fun setLive(isLive: Boolean) {
        if (_isLive != isLive) {
            _isLive = isLive
            refreshDrawableState()
        }
    }

    companion object {
        private const val INCREASE_STATE_SIZE = 1
    }
}