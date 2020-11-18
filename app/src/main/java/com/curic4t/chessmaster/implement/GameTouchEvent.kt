package com.curic4t.chessmaster.implement

import android.os.Build
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        var view:ImageView = event.localState as ImageView
        var viewGroup :ViewGroup= view.parent as ViewGroup

        var objectView:ImageView =v as ImageView
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED->{
                LogUtil.d("vvvvv","drag start")

            }
            DragEvent.ACTION_DRAG_ENTERED->{
                LogUtil.d("vvvvv","drag entered")

            }
            DragEvent.ACTION_DROP->{
                LogUtil.d("vvvvv","drag drop")



                //LogUtil.d("vvvvv","view: $view viewGroup: $viewGroup objectview: $objectView")

                objectView.setImageDrawable(view.drawable)
                view.setImageResource(android.R.color.transparent)


            }
            DragEvent.ACTION_DRAG_EXITED->{
                LogUtil.d("vvvvv","drag exited")


            }
            DragEvent.ACTION_DRAG_ENDED->{
                LogUtil.d("vvvvv","drag ended")
            }
            else->{
            ///LogUtil.d("vvvvv",event.action.toString())


        }
        }
        return true
    }

}