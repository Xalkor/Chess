package chess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 

public class ChessBoard extends Canvas implements MouseListener{


	ChessPiece[][] board;
	int HEIGHT;
	int WIDTH;
	int SCL;
	Pos[] highlighted;
	Pos selected;
	ChessBoard(){
		HEIGHT = 8; 
		WIDTH = 8;
		board = new ChessPiece[HEIGHT][WIDTH]; 

		setBounds(8, 30, 400, 400);
		setSize(408, 408);
		SCL = (int)408/WIDTH;
		setBackground(ChessColor.BROWN);  

		addMouseListener(this);

	}
	public void setup(){
		for(int i = 0; i < WIDTH; i++){
			board[i][1] = new Pawn(ChessColor.WHITE,i,1);
			board[i][HEIGHT-2] = new Pawn(ChessColor.BLACK,i,HEIGHT-1);
		}
		board[0][0] = new Rook(ChessColor.WHITE,0,0);
		board[WIDTH-1][0] = new Rook(ChessColor.WHITE,WIDTH-1,0);
		board[0][HEIGHT-1] = new Rook(ChessColor.BLACK,0,HEIGHT-1);
		board[WIDTH-1][HEIGHT-1] = new Rook(ChessColor.BLACK,WIDTH-1,HEIGHT-1);

		board[1][0] = new Knight(ChessColor.WHITE,1,0);
		board[WIDTH-2][0] = new Knight(ChessColor.WHITE,WIDTH-2,0);
		board[1][HEIGHT-1] = new Knight(ChessColor.BLACK,1,HEIGHT-1);
		board[WIDTH-2][HEIGHT-1] = new Knight(ChessColor.BLACK,WIDTH-2,HEIGHT-1);

		board[2][0] = new Bishop(ChessColor.WHITE,2,0);
		board[WIDTH-3][0] = new Bishop(ChessColor.WHITE,WIDTH-3,0);
		board[2][HEIGHT-1] = new Bishop(ChessColor.BLACK,2,HEIGHT-1);
		board[WIDTH-3][HEIGHT-1] = new Bishop(ChessColor.BLACK,WIDTH-3,HEIGHT-1);

		board[3][0] = new Queen(ChessColor.WHITE,3,0);
		board[4][0] = new King(ChessColor.WHITE,4,0);

		board[3][HEIGHT-1] = new Queen(ChessColor.BLACK,3,HEIGHT-1);
		board[4][HEIGHT-1] = new King(ChessColor.BLACK,4,HEIGHT-1);
	}

	@Override public String toString(){
		String b = "";
		for(int i = WIDTH-1; i >= 0; i--){
			for(int j = 0; j < HEIGHT; j++){
				if(board[j][i] != null){
					b+=board[j][i].toString();
				}else{
					if((i % 2 == 0) == (j % 2 == 0)){
						b+="[ ]";
					}else{
						b+="[#]";
					}
				}
			}
			b+="\n";
		}
		return b;
	}

	public void render(){
		//this.repaint();
	}

	public void highlight(Pos[] poses) {
		highlighted = new Pos[poses.length];
		for(int i = 0; i < poses.length; i++) {
			highlighted[i] = poses[i];
		}
		this.repaint();
	}

	public void highlight(Pos pos) {
		selected = new Pos(pos.x,pos.y);
		this.repaint();
	}

	public void paint(Graphics g){ 
		
//------------square routine--------------------------------------
		
		for(int i = WIDTH-1; i >= 0; i--){
			for(int j = 0; j < HEIGHT; j++){
				if((i % 2 == 0) == (j % 2 == 0)){
					g.setColor(ChessColor.TAN);
					g.fillRect(i*SCL, j*SCL, SCL, SCL);
				}
			}
		}
		
//--------------highlight routine----------------------------------
		
		if(highlighted != null) {
			for(int i = 0; i < highlighted.length; i++) {
				if(highlighted[i].hasPiece) {
					g.setColor(ChessColor.CAPTURE_HIGHLIGHT);
				}else {
					g.setColor(ChessColor.EMPTY_HIGHLIGHT);
				}
				g.fillRect(highlighted[i].x*SCL, highlighted[i].y*SCL, SCL, SCL);
			} 
		}
		if(selected != null) {
			g.setColor(ChessColor.CURRENT_HIGHLIGHT);
			g.fillRect(selected.x*SCL, selected.y*SCL, SCL, SCL);
		}
//-----------pieces routine----------------------------------------		
		for(int i = WIDTH-1; i >= 0; i--){
			for(int j = 0; j < HEIGHT; j++){
				if(board[i][j] != null){
					g.setColor(Color.BLACK);
					g.drawString(board[i][j].toString(), i*SCL + (SCL/2), j*SCL + (SCL/2));
					//System.out.println(i + " " + j + " " + board[i][j]);
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX()/SCL;
		int y = e.getY()/SCL;

		Pos p = new Pos(x,y);

		if(board[p.x][p.y] != null) {
			if(selected != null && (p.x == selected.x && p.y == selected.y)) {
				selected = null;
			}else {
				selected = p;
			}
			repaint();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
