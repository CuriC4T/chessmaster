package com.curic4t.chessmaster.game

class Chess(){

 var king: King
     var queen: Queen
    var bishop: Array<Bishop?>
     var knight: Array<Knight?>
     var rook:Array<Rook?>
     var pawn: Array<Pawn?>

    init {
        king= King()
        queen=Queen()
        bishop = arrayOfNulls<Bishop>(2)
        knight = arrayOfNulls<Knight>(2)
        rook = arrayOfNulls<Rook>(2)
        pawn = arrayOfNulls<Pawn>(8)

    }

    companion object{
        fun newInstance(): Chess{
            return Chess()
        }
    }


}