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
import com.curic4t.chessmaster.game.Chess
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
val chess:Chess =Chess()
    init {




//
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //chess setting 함수 호출//
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
                piece_blank_array[i][j]?.setOnTouchListener(GameTouchEvent())
                piece_blank_array[i][j]?.setOnDragListener(GameTouchEvent())

            }
        }

        initChessBoard()
        return rootView
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun settingChessBoard(){
    }

    public fun initChessBoard(){
        //ib_special.setImageResource
        //ib_special.setBackgroundResource
        ///get image from chess.pawn
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            piece_blank_array[7][0]?.setImageResource(R.mipmap.wrook)
            piece_blank_array[7][7]?.setImageResource(R.mipmap.wrook)
            piece_blank_array[7][1]?.setImageResource(R.mipmap.wknight)
            piece_blank_array[7][6]?.setImageResource(R.mipmap.wknight)
            piece_blank_array[7][2]?.setImageResource(R.mipmap.wbishop)
            piece_blank_array[7][5]?.setImageResource(R.mipmap.wbishop)
            piece_blank_array[7][3]?.setImageResource(R.mipmap.wqueen)
            piece_blank_array[7][4]?.setImageResource(R.mipmap.wking)

            piece_blank_array[0][0]?.setImageResource(R.mipmap.brook)
            piece_blank_array[0][7]?.setImageResource(R.mipmap.brook)
            piece_blank_array[0][1]?.setImageResource(R.mipmap.bknight)
            piece_blank_array[0][6]?.setImageResource(R.mipmap.bknight)
            piece_blank_array[0][2]?.setImageResource(R.mipmap.bbishop)
            piece_blank_array[0][5]?.setImageResource(R.mipmap.bbishop)
            piece_blank_array[0][3]?.setImageResource(R.mipmap.bqueen)
            piece_blank_array[0][4]?.setImageResource(R.mipmap.bking)

            for(i in 0..7){
                piece_blank_array[6][i]?.setImageResource(R.mipmap.wpawn)
                piece_blank_array[1][i]?.setImageResource(R.mipmap.bpawn)
            }




        }
        //8...1 , a....h


    }

    companion object {

        final val MAX_SIZE:Int =7
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