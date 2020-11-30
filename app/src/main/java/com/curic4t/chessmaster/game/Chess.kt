package com.curic4t.chessmaster.game

class Chess private constructor(board:Array<Array<String>>?) {

    var board:Array<Array<String>>?=null
    var king: King
    var queen: Queen
    var bishop: Array<Bishop?>
    var knight: Array<Knight?>
    var rook: Array<Rook?>
    var pawn: Array<Pawn?>

    init {
        king = King()
        queen = Queen()
        bishop = arrayOfNulls<Bishop>(2)
        knight = arrayOfNulls<Knight>(2)
        rook = arrayOfNulls<Rook>(2)
        pawn = arrayOfNulls<Pawn>(8)

    }

    fun checkCanMove(tag:String){
        var arrayTag=tag.split("#")
        if(arrayTag[0]=="b"){
            when(arrayTag[1]){
                "k"->{

                }
                "q"->{

                }
                "b"->{

                }
                "k"->{

                }
                "r"->{

                }
                "p"->{

                }
            }
        }else{
            //w
            when(arrayTag[1]){
                "k"->{

                }
                "q"->{

                }
                "b"->{

                }
                "k"->{

                }
                "r"->{

                }
                "p"->{

                }
            }

        }

    }

    companion object {
        private var instance: Chess? = null
        fun newInstance(board:Array<Array<String>>?): Chess = instance ?: Chess(board).also { it.board=board}
    }


}