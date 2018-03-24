package Chess;

public class pawn extends piece {
	
	boolean firstMove = true;
	
	public pawn(char owner) {
		this.owner = owner;
		name = 'P';
	}
	
	boolean isValidMove(int activeRow, int activeCol, int potentialRow, int potentialCol) {
		if (activeRow == potentialRow && ((potentialRow - potentialCol) == 1 || ((potentialRow - potentialCol) == 2 && firstMove == false))) {
			return true;
		}else {
			return false;
		}
			
	}
}
