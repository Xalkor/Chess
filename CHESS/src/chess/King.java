package chess;

public class King extends ChessPiece{
    boolean isWhite;
    Pos position;
    King(boolean isWhite,int x,int y){
        this.isWhite = isWhite;
        position = new Pos(x,y);
    }
    public void move(Pos position, ChessBoard board){
         board.board[this.position.x][this.position.y] = null;
         this.position = position;
         board.board[this.position.x][this.position.y] = this;   
    }
    Pos[] possibleMoves(){return new Pos[0];}
    public String toString(){return isWhite ? "[k]" : "[K]";}
}