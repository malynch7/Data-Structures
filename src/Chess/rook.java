package Chess;

public class rook extends piece{
	
	public rook(char owner) {
		this.owner = owner;
		name = 'R';
	}
	
	public boolean isValidMove(board board,int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (activeRow == potentialRow) {
			if(activeCol < potentialCol) {
				for (int i = activeCol + 1; i < potentialCol; i++) {
					if(board.board[activeRow][i] != null) {
						return false;
					}
				}
			}else if(activeCol > potentialCol) {
				for(int i = potentialCol + 1; i < activeCol; i++) {
					if(board.board[activeRow][i] != null) {
						return false;
					}
				}
			}
			return true;
		}else if (activeCol == activeCol) {
			if(activeRow < potentialRow) {
				for (int i = activeRow + 1; i < potentialRow; i++) {
					if(board.board[i][activeCol] != null) {
						return false;
					}
				}
			}else if(activeRow > potentialRow) {
				for(int i = potentialRow + 1; i < activeRow; i++) {
					if(board.board[i][activeCol] != null) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}
