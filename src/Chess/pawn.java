package Chess;

public class pawn extends piece {
	
	public pawn(char owner) {
		this.owner = owner;
		name = 'P';
	}
	
<<<<<<< HEAD
	boolean isValidMove(board board, int activeRow, int activeCol, int potentialRow, int potentialCol) {
		//white pawn path
		if (owner == 'w' && activeRow == potentialRow && ((potentialCol - activeCol) == 1 || ((potentialCol - activeCol) == 2 && firstMove == true))) {
			//ensure no piece is in the path
			if ((potentialCol - activeCol) == 2 && board.board[activeRow][activeCol + 1] != null) {
				return false;
			}
			return true;
			//black pawn path	
		}else if (owner == 'b' && activeRow == potentialRow && ((potentialCol - activeCol) == -1 || ((potentialCol - activeCol) == -2 && firstMove == true))) {
			//ensure no piece is in the path
			if ((potentialCol - activeCol) == -2 && board.board[activeRow][activeCol - 1] != null) {
				return false;
			}
=======
	boolean isValidMove(char owner, int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (owner == 'w' && activeRow == potentialRow && ((potentialCol - activeCol) == 1 || ((potentialCol - activeCol) == 2 && firstMove == true))) {
			return true;
		}else if (owner == 'b' && activeRow == potentialRow && ((potentialCol - activeCol) == -1 || ((potentialCol - activeCol) == -2 && firstMove == true))){
>>>>>>> branch 'master' of https://github.com/malynch7/Data-Structures.git
			return true;
		}else {
			return false;
		}
			
	}
}
