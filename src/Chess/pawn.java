package Chess;

import java.util.*;

public class pawn extends piece {
	
	public pawn(char owner) {
		this.owner = owner;
		name = 'P';
	}
	
	boolean isValidMove(board board, int activeRow, int activeCol, int potentialRow, int potentialCol) {
		
		if (owner == 'w') {
			if(activeRow == potentialRow) {
				if((potentialCol - activeCol) == 1 && board.board[potentialRow][potentialCol] == null) {
					return true;
				}else if((potentialCol - activeCol) == 2 && firstMove == true) {
					if (board.board[potentialRow][potentialCol] == null && board.board[potentialRow][potentialCol - 1] == null) {
						return true;
					}
				}
			//capture condition	
			}else if (potentialCol - activeCol == 1 && Math.abs(potentialRow - activeRow) == 1) {
				if(board.board[potentialRow][potentialCol] != null) {
					return true;
				}
			}
		}else if (owner == 'b') {
			if(activeRow == potentialRow) {
				if((potentialCol - activeCol) == -1 && board.board[potentialRow][potentialCol] == null) {
					return true;
				}else if((potentialCol - activeCol) == -2 && firstMove == true) {
					if (board.board[potentialRow][potentialCol] == null && board.board[potentialRow][potentialCol + 1] == null) {
						return true;
					}
				}
			//capture condition	
			}else if (potentialCol - activeCol == -1 && Math.abs(potentialRow - activeRow) == 1) {
				if(board.board[potentialRow][potentialCol] != null) {
					return true;
				}
			}
		}
		return false;
	}	
}
