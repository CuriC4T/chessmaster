package com.curic4t.chessmaster.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.curic4t.chessmaster.R
import com.curic4t.chessmaster.implement.GameTouchEvent
import com.curic4t.chessmaster.util.LogUtil
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_game_board.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class GameBoard : Fragment() {
    var rootView:View?=null
    private var param1: String? = null
    private var param2: String? = null
    val alphabet="abcdefgh"
    var list_colum : MutableMap<Int,String> = mutableMapOf()
    //var piece_blank_array =arrayOfNulls<Array<ImageView>>(8)
    var piece_blank_array = Array(8){ arrayOfNulls<ImageView>(8)}

    init {




//
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_game_board, container, false)
        this.rootView=rootView

        //splite string
        for (i in 0 .. 7){
            list_colum[i] = alphabet[i].toString()
        }

        //setting to gameboard
        for (i in 7 downTo 0 ){
            for(j in 0 .. 7){
                piece_blank_array[i][j]=(rootView.findViewById<ImageView>(resources.getIdentifier("imageview_"+(i+1)+"_"+list_colum[j],"id",context!!.packageName)))
            }
        }
        
        for (i in 7 downTo 0 ){
            for(j in 0 .. 7){
                piece_blank_array[i]?.get(j)?.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
                    when(motionEvent.action){
                        MotionEvent.ACTION_DOWN->{
                            LogUtil.d("gameboard" , "action down")
                        }
                        else ->{
                            LogUtil.d("gameboard" , "else")
                        }
                    }
                    true
                })
                piece_blank_array[i]?.get(j)?.setOnClickListener {
                    LogUtil.d("gameboard","hello")
                }

            }
        }
        settingChessBoard()
        return rootView
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    public fun settingChessBoard(){
        //ib_special.setImageResource
        //ib_special.setBackgroundResource
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            piece_blank_array[0][1]?.setImageResource(R.mipmap.bqueen)

        }
        setGameTouchEvent()
        //8...1 , a....h


    }
    public fun setGameTouchEvent(){
        piece_blank_array[0][1]?.setOnTouchListener(GameTouchEvent())
        piece_blank_array[0][1]?.setOnDragListener(GameTouchEvent())
        piece_blank_array[0][3]?.setOnTouchListener(GameTouchEvent())
        piece_blank_array[0][3]?.setOnDragListener(GameTouchEvent())

    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameBoard().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}