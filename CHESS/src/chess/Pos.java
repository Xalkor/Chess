package chess;

public class Pos{
    int x;
    int y;
    boolean hasPiece;
    
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
    Pos(int x, int y,boolean hasPiece){
        this.x = x;
        this.y = y;
        this.hasPiece = hasPiece;
    }
    Pos(char x, int y){
        this.x = (int)x-65;
        this.y = y-1;
    }
}
