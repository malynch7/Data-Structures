package Chess;

import java.util.*;

public class Chess {
	
	public static void main(String[] args) {
		
		boolean checkmate = false, valid = false;
		board board = new board();
		int turn = 0;
		Scanner input = new Scanner(System.in);
		String activeLocation, potentialLocation;
		piece activePiece = board.board[0][0];
		char player;
		int activeRow, activeCol, potentialRow, potentialCol;
		
		do{
			turn++;
			do {
				valid = false;
				board.display();
				do {
					if (turn % 2 == 1) {
						System.out.print("White, select a piece to move (ie. A1): ");
						player = 'w';
					}else {
						System.out.print("Black, select a piece to move (ie. G8): ");
						player = 'b';
					}
					
					activeLocation = input.nextLine();
					activeRow = (int) (activeLocation.charAt(0) - 'A');
					activeCol = (int) (activeLocation.charAt(1) - '1');
					
					if(activeRow >= 0 && activeRow < 9 && activeCol >= 0 && activeCol < 9) {
						if (board.board[activeRow][activeCol] != null) {
							activePiece = board.board[activeRow][activeCol];
							if(activePiece.owner == player) {
								valid = true;
							
							}else {
							System.out.println("That is not your piece...");
							}
						}else {
							System.out.println("There's no piece there.");
						}
					}else {
						System.out.println("That's not on the board");
					}
				}while (valid == false);
				
				valid = false;
				System.out.print("select a destination (ie. A1): ");
				potentialLocation = input.nextLine();
				potentialRow = (int) (potentialLocation.charAt(0) - 'A');
				potentialCol = (int) (potentialLocation.charAt(1) - '1');
				
				if (potentialRow >= 0 && potentialRow < 9 && potentialCol >= 0 && potentialCol < 9) {
					if (activePiece.isValidMove(activeRow, activeCol, potentialRow, potentialCol)){
						if(board.board[potentialRow][potentialCol] == null || board.board[potentialRow][potentialCol].owner != player) {
							valid = true;
						}else {
							System.out.println("You may not capture a piece that belongs to you.");
						}
					}else {
						System.out.println("Invalid move");
					}
				}else {
					System.out.println("That's not on the board");
				}
			}while (valid == false);
			
			board.board[potentialRow][potentialCol] = board.board[activeRow][activeCol];
			board.board[activeRow][activeCol] = null;
			
		}while (checkmate == false);
			
	}
}
