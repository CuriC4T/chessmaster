package com.curic4t.chessmaster.implement

import android.view.MotionEvent
import android.view.View

interface GameTouchEvent: View.OnTouchListener {
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }

}