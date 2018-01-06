package chess;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.Scanner;

class MyFrame extends Frame{
	int x = 0;
	int y = 0;

	boolean isClicked = false;

	MyFrame(String name,ChessBoard board){
		super(name);
		add(board); 
		setLayout(null);  
		//setSize(424, 446);  
		setSize(414, 436);  
		setVisible(true);
	}

}


class Main { 	
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		ChessBoard chessBoard = new ChessBoard();

		MyFrame m = new MyFrame("justinsucks", chessBoard);
		m.setResizable(false);
		chessBoard.setup();
		System.out.println(chessBoard);

		boolean whiteTurn = true;

		Pos[] p = chessBoard.board[1][0].possibleMoves(chessBoard);
			System.out.println(p.toString());
		chessBoard.highlight(p);
		chessBoard.highlight(new Pos(6,6));

		while(true){

			if(m.isClicked) {
				chessBoard.highlight(new Pos(m.x/chessBoard.SCL,m.y/chessBoard.SCL));

			}

			chessBoard.render();

			System.out.println((whiteTurn ? "White" : "Black") + " move a piece\nEx: A2A3" );

			String turn = Scan.next();

			Pos piecePos = new Pos(turn.charAt(0),(int)turn.charAt(1)-48);
			Pos pieceMove = new Pos(turn.charAt(2),(int)turn.charAt(3)-48);

			chessBoard.board[piecePos.x][piecePos.y].move(pieceMove,chessBoard);

			whiteTurn = !whiteTurn;
		}
	}
}


