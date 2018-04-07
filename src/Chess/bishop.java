package Chess;

public class bishop extends piece{
	public bishop(char owner) {
		this.owner = owner;
		name = 'B';
	}

	boolean isValidMove(board board,int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (Math.abs(potentialRow - activeRow) == Math.abs(potentialCol - activeCol)) {
			if (activeRow < potentialRow) {
				if (activeCol < potentialCol) {
					for (int i = activeRow + 1, j = activeCol + 1; i < potentialRow; i++,j++ ) {
						if(board.board[i][j] != null) {
							return false;
						}
					}
					return true;
				}else {
					for (int i = activeRow + 1, j = activeCol - 1; i < potentialRow; i++,j-- ) {
						if(board.board[i][j] != null) {
							return false;
						}
					}
					return true;
				}
			}else { //activeRow > potentialRow
				if (activeCol < potentialCol) {
					for (int i = activeRow - 1, j = activeCol + 1; i > potentialRow; i--,j++ ) {
						if(board.board[i][j] != null) {
							return false;
						}
					}
					return true;
				}else {
					for (int i = activeRow - 1, j = activeCol - 1; i > potentialRow; i--,j-- ) {
						if(board.board[i][j] != null) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
}
