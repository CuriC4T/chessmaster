package com.curic4t.chessmaster.util

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.view.Display
import android.view.WindowManager
import android.view.WindowMetrics

class DisplayManagement private constructor(private val context: Context) {

    var density = 0f
    var displayHeight = 0
    var displayWidth = 0
    fun calcWidthHeight() {
        val windowManager: WindowManager =
            context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay
        val displatMetrics = context.resources.displayMetrics

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //non-activity

            val rect: Rect = windowManager.currentWindowMetrics.bounds
            displayHeight = rect.height()
            displayWidth = rect.width()
            LogUtil.d("DisplayManagement", "width: $displayWidth height: $displayHeight")
            //activit
            //val rect : Rect? =activity?.windowManager?.currentWindowMetrics?.bounds

        } else {
            density = displatMetrics.density
            var temp =displatMetrics.densityDpi
            displayHeight = displatMetrics.heightPixels
            displayWidth = displatMetrics.widthPixels
            LogUtil.d("DisplayManagement", "density: ${density} dpi: $temp width: $displayWidth height: $displayHeight")


        }
    }

    companion object {
        private var instance: DisplayManagement? = null

        fun newInstance(context: Context) =
            instance ?: DisplayManagement(context).also { instance = it }


    }


}