package com.curic4t.chessmaster.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curic4t.chessmaster.R
import com.curic4t.chessmaster.util.LogUtil
import com.curic4t.chessmaster.util.SettingGameDisplay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtil.isLogging =true
        supportFragmentManager.beginTransaction().replace(R.id.mainFragemt,GameBoard()).commit()

    }
}