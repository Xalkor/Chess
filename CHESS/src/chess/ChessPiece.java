package chess;

public abstract class ChessPiece{
    boolean isWhite;
    Pos position;
    abstract void move(Pos position, ChessBoard board);
    abstract Pos[] possibleMoves();
    abstract public String toString();
}
