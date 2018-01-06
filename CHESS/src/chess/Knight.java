package chess;

public class Knight extends ChessPiece{
    boolean isWhite;
    Pos position;
    Knight(boolean isWhite,int x,int y){
        this.isWhite = isWhite;
        position = new Pos(x,y);
    }
    public void move(Pos position, ChessBoard board){
         board.board[this.position.x][this.position.y] = null;
         this.position = position;
         board.board[this.position.x][this.position.y] = this;   
    }
    Pos[] possibleMoves(ChessBoard board){
        Pos[] valid = new Pos[8];
        int nullCounter = 0;
        valid[0] = new Pos(position.x+2,position.y-1);
        valid[1] = new Pos(position.x+2,position.y+1);
        valid[2] = new Pos(position.x+1,position.y-2);
        valid[3] = new Pos(position.x+1,position.y+2);
        valid[4] = new Pos(position.x-2,position.y-1);
        valid[5] = new Pos(position.x-2,position.y+1);
        valid[6] = new Pos(position.x-1,position.y-2);
        valid[7] = new Pos(position.x-1,position.y+2);
        for(int i = 0;i<8;i++) {
            if (valid[i].x > 7 || valid[i].x < 0 || valid[i].y > 7 || valid[i].y < 0||(board.board[valid[i].x][valid[i].y]!=null&&(board.board[valid[i].x][valid[i].y].isWhite==isWhite))){
                valid[i] = null;
                nullCounter++;
            }
        }
        Pos[] possibleMoves = new Pos[8-nullCounter];
        for(int i = 0,j = 0;i<possibleMoves.length;i++, j++) {
            while(valid[j]==null)j++;
            possibleMoves[i] = valid[j];
                board.board[valid[i].x][valid[i].y].position.hasPiece=board.board[valid[i].x][valid[i].y]!=null&&(board.board[valid[i].x][valid[i].y].isWhite!=isWhite);        }
        return possibleMoves;
    }
    public String toString(){return isWhite ? "[h]" : "[H]";}
}
