package com.curic4t.chessmaster.util

import android.util.Log

public class LogUtil(){

    companion object{
        var isLogging:Boolean = false

        public fun d(Tag:String,msg:String){
            if(isLogging){
                Log.d(Tag,msg)
            }
        }
    }


}