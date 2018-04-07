package Chess;

import java.util.*;

public class knight extends piece{
	public knight(char owner) {
		this.owner = owner;
		name = 'k';
	}

	public boolean isValidMove(board board,int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (Math.abs(potentialRow - activeRow) == 2 && Math.abs(potentialCol - activeCol) == 1) {
			return true;
		}else if (Math.abs(potentialRow - activeRow) == 1 && Math.abs(potentialCol - activeCol) == 2) {
			return true;
		}
		return false;
	}
}
