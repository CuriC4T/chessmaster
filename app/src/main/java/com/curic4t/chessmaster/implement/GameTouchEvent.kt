package com.curic4t.chessmaster.implement

import android.view.DragEvent
import android.view.MotionEvent
import android.view.View

interface GameTouchEvent: View.OnTouchListener, View.OnDragListener {
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }

    override fun onDrag(v: View?, event: DragEvent?): Boolean {

        return true
    }

}