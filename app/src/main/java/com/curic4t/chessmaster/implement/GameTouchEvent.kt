package com.curic4t.chessmaster.implement

import android.os.Build
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import com.curic4t.chessmaster.util.LogUtil

class GameTouchEvent: View.OnTouchListener, View.OnDragListener {
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
               var dragShadowBuilder = View.DragShadowBuilder(view)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(null,dragShadowBuilder,view,0)
                }
            }
        }
        return false
    }

    override fun onDrag(v: View, event: DragEvent): Boolean {

        when(event.action){

            DragEvent.ACTION_DROP->{
                LogUtil.d("vvvvv",v.toString())

            }else->{
            LogUtil.d("vvvvv",event.action.toString())

        }
        }
        return true
    }

}