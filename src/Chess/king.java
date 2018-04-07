package Chess;

import java.util.*;

public class king extends piece{
	public king(char owner) {
		this.owner = owner;
		name = 'K';
	}

	boolean isValidMove(board board,int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (Math.abs(activeRow - potentialRow) < 2 && Math.abs(activeCol - potentialCol) < 2) {
			return true;
		}else {
			return false;
		}
	}
}
