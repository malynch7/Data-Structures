package Chess;

public class pawn extends piece {
	
	public pawn(char owner) {
		this.owner = owner;
		name = 'P';
	}
	
	boolean isValidMove(int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (owner == 'w' && activeRow == potentialRow && ((potentialCol - activeCol) == 1 || ((potentialCol - activeCol) == 2 && firstMove == true))) {
			return true;
		}else if (owner == 'b' && activeRow == potentialRow && ((potentialCol - activeCol) == -1 || ((potentialCol - activeCol) == -2 && firstMove == true))) {
			return true;
		}else {
			return false;
		}
			
	}
}
