package com.curic4t.chessmaster.activity

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
    lateinit var rootView:View
    private var param1: String? = null
    private var param2: String? = null
    val alphabet="abcdefgh"
    lateinit var list_colum : Map<Int,String>
    var piece_blank_array =arrayOfNulls<Array<ImageView>>(8)
    init {
        for(i in 1 until  8){
            list_colum = mapOf(i to alphabet[i-1].toString())
            LogUtil.d("gameboard" , list_colum.toString())
        }


        for (i in 7 downTo 0 ){
            for(j in 0 until 7){
                piece_blank_array[i]?.set(j,  rootView.findViewById<ImageView>(resources.getIdentifier("imageview_"+(i+1)+"+"+list_colum[j],"id",context!!.packageName)))
                LogUtil.d("gameboard" , "$i $j")
                LogUtil.d("gameboard" , piece_blank_array[i]?.get(j).toString())


            }
        }
        piece_blank_array[1]?.get(1)?.setBackgroundColor(0x0000ff)
        for (i in 7 downTo 0 ){
            for(j in 0 until 7){
                //[][] -> [].?.get()
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
            }
        }
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
        return rootView
    }

    public fun settingChessBoard(){

        //8...1 , a....h

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