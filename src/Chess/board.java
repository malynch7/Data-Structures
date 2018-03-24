package Chess;

public class board {
	piece[][] board =  new piece[8][8];
	
	public board() {
		for (int i = 0; i < 8; i++) {
			board[i][1] = new pawn('w');
			board[i][6] = new pawn('b');
		}
		board[0][0] = new rook('w');
		board[7][0] = new rook('w');
		board[1][0] = new knight('w');
		board[6][0] = new knight('w');
		board[2][0] = new bishop('w');
		board[5][0] = new bishop('w');
		board[3][0] = new king('w');
		board[4][0] = new queen('w');
		
		board[0][7] = new rook('b');
		board[7][7] = new rook('b');
		board[1][7] = new knight('b');
		board[6][7] = new knight('b');
		board[2][7] = new bishop('b');
		board[5][7] = new bishop('b');
		board[3][7] = new king('b');
		board[4][7] = new queen('b');
	}
	void display() {
		System.out.println("     1    2    3    4    5    6    7    8 \n  -----------------------------------------");
		for (int i = 0; i < 8; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < 8; j++){
				if (board[i][j] != null) {
					System.out.print("| " + board[i][j].name + board[i][j].owner + ' ');
				}else {
					System.out.print("|    ");
				}

			}
			System.out.println("|\n  -----------------------------------------");
		}

	}
}
