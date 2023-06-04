import java.util.Scanner;

public class Battleship {
  public static void main(String[] args) {
//variables
    int row = -11;
    int col = -12;
    int row_1 = -13;
    int col_1 = -14;
    int row_2 = -15;
    int col_2 = -16;
    int[] duplicateCol = {-6, -7, -8, -9, -10};
    int[] duplicateRow = {-1, -2, -3, -4, -5};
    int[] player2_duplicateCol = {-6, -7, -8, -9, -10};
    int[] player2_duplicateRow = {-1, -2, -3, -4, -5};
    int[] player1_checkRow = new int[25];
    int[] player1_checkCol = new int[25];
    int[] player2_checkRow = new int[25];
    int[] player2_checkCol = new int[25];
    boolean invalid = true;
    char[][] playerOneShotsBoard = new char[5][5];
    char[][] playerTwoShotsBoard = new char[5][5];
    char[][] playerOneTargetBoard = new char[5][5];
    char[][] playerTwoTargetBoard = new char[5][5];



    System.out.println("Welcome to Battleship!");
    System.out.println();
    Scanner input = new Scanner(System.in);
    String message = "player 1, enter your ships' coordinates. Enter a number between 0-4 on the same line seperated by space.";
    System.out.println(message.toUpperCase());

//this for loop adds an underscore to every space on the 5 X 5 grid
    for (int i = 0; i < playerOneShotsBoard.length; i++) {
	for (int j = 0; j < playerOneShotsBoard[0].length; j++){
	playerOneShotsBoard[i][j] = '_';
	playerTwoShotsBoard[i][j] = '_';
	playerOneTargetBoard[i][j] = '_';
	playerTwoTargetBoard[i][j] = '_';
	}
     }
    
     for (int i = 0; i < player1_checkRow.length; i++){
	player1_checkRow[i] = -139820;
	player1_checkCol[i] = -389283;
	player2_checkRow[i] = -954963;
	player2_checkCol[i] = -129381;
	}


//for player 1 initial board fix this later and make more efficient
    for ( int i = 0; i < 5; i++){
	int num = i + 1;
	System.out.println("Enter ship " + num + " location: ");
	duplicateRow[i] = row;
	duplicateCol[i] = col;

	do {
	    try {
	    	if(input.hasNextInt()){
			row = input.nextInt();
	     		col = input.nextInt(); 
			boolean checks_1 = duplicate(row, col, duplicateRow, duplicateCol);
			if(checks_1 == true){
			    System.out.println("You already have a ship there. Choose different coordinates.");
			}
			else {
	     		    playerOneShotsBoard[row][col] = '@';
			    invalid = false; }
		} 
		
	   	 else {
			System.out.println("Invalid coordinates. Choose different coordinates.");
			input.nextLine();
}
}
	     catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Invalid coordinates. Choose different coordinates.");
		input.nextLine();
	     }
	      printBattleShip(playerOneShotsBoard);
}
	while(invalid);
	invalid = true;
		}		
 printBattleShip(playerOneShotsBoard);


     for (int i = 0; i < 100; i++) {
	System.out.println();
	}


//for player two initial board fix this later and make more efficient
row = -11;
col = -12;
String message2 = "player 2, enter your ships' coordinates. Enter a number between 0-4 on the same line seperated by space.";
System.out.println(message2.toUpperCase());
    for ( int i = 0; i < 5; i++){
	int num = i + 1;
	System.out.println("Enter ship " + num + " location: ");
	player2_duplicateRow[i] = row;
	player2_duplicateCol[i] = col;

	do {
	    try {
	    	if(input.hasNextInt()){
			row = input.nextInt();
	     		col = input.nextInt(); 
			boolean checks_2 = duplicate(row, col, player2_duplicateRow, player2_duplicateCol);
			if(checks_2 == true){
			    System.out.println("You already have a ship there. Choose different coordinates.");
			}
			else {
	     		    playerTwoShotsBoard[row][col] = '@';
			    invalid = false; }
		} 
		
	   	 else {
			System.out.println("Invalid coordinates. Choose different coordinates.");
			input.nextLine();
}
}
	     catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Invalid coordinates. Choose different coordinates.");
		input.nextLine();
	     }
	      printBattleShip(playerTwoShotsBoard);
}
	while(invalid);
	invalid = true;
		}		
 printBattleShip(playerTwoShotsBoard);

    for (int i = 0; i < 100; i++) {
	System.out.println();
	}

//START 

int count = 0; 
int count2 = 0;
int round = 0;
boolean endGame = false;
boolean player1Winner = false;
boolean player2Winner = false;
int currentPlayer = 1;


while(!endGame) {
	while(currentPlayer == 1 && !player2Winner) {
		System.out.println("Player 1, enter hit row/column:");
			player1_checkRow[round] = row_1;
			player1_checkCol[round] = col_1;
			
		    do {
	    		try {
	    		    if(input.hasNextInt()){
				row_1 = input.nextInt();
	     			col_1 = input.nextInt(); 
				boolean checks_3 = duplicate(row_1, col_1, player1_checkRow, player1_checkCol);
				if(checks_3 == true){
			   	   System.out.println("You already fired on this spot. Choose different coordinates.");
				}
				else {
	     		    	    count = checkBoard(row_1, col_1, currentPlayer, count, playerTwoShotsBoard, playerTwoTargetBoard);
				    invalid = false;
					}
				} 
		
	   	 	     else {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				input.nextLine();
			     }
			}
	     		catch (ArrayIndexOutOfBoundsException e) {
			     System.out.println("Invalid coordinates. Choose different coordinates.");
			     input.nextLine();
	     		} 
	
	if(count == 5) {
		endGame = true;	
		player1Winner = true;
		String player1 = "PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS";
		System.out.println(player1);
		break;	
			}	
}
	while(invalid);
	invalid = true;
	break;

}	
	currentPlayer = 2;



	while(currentPlayer == 2 && !player1Winner) {
		System.out.println("Player 2, enter hit row/column:");
			player2_checkRow[round] = row_2;
			player2_checkCol[round] = col_2;
		    do {
	    		try {
	    		    if(input.hasNextInt()){
				row_2 = input.nextInt();
	     			col_2 = input.nextInt(); 
				boolean checks_4 = duplicate(row_2, col_2, player2_checkRow, player2_checkCol);
				if(checks_4 == true){
			   	   System.out.println("You already fired on this spot. Choose different coordinates.");
				}
				else {
	     		    	    count2 = checkBoard(row_2, col_2, currentPlayer, count2, playerOneShotsBoard, playerOneTargetBoard);
				    if(count2 == 5) {
					endGame = true;
					String player2 = "PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS";
					System.out.println(player2);
					player2Winner = true;
					break;	
				    }
				    invalid = false;
				    //break;
					}
				} 
		
	   	 	     else {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				input.nextLine();
			     }
			}
	     		catch (ArrayIndexOutOfBoundsException e) {
			     System.out.println("Invalid coordinates. Choose different coordinates.");
			     input.nextLine();
	     		} 
}
	while(invalid);
	invalid = true;
	break;
		
}
	currentPlayer = 1;
	round = round + 1;


}

System.out.println();
System.out.println("FINAL BOARDS: ");
printBattleShip(playerOneTargetBoard);
System.out.println();
printBattleShip(playerTwoTargetBoard);
}



//methods
private static int checkBoard(int rowCoor, int colCoor, int player, int counter, char[][] Board, char[][] targetBoard) {
			int player2 = 2;
			if(player == 2) {
				player2 = player - 1;
			}
			if(Board[rowCoor][colCoor] == '@') {
				System.out.println("PLAYER " + player + " HIT PLAYER " + player2 + "'s SHIP!");
				targetBoard[rowCoor][colCoor] = 'X';
				counter = counter + 1;
				//System.out.println(counter);
				printBattleShip(targetBoard);
				System.out.println();
				System.out.println();
	     		}
			else if(Board[rowCoor][colCoor] == '_') {
				System.out.println("PLAYER " + player + " MISSED!");
				targetBoard[rowCoor][colCoor] = 'O';
				printBattleShip(targetBoard);
				System.out.println();
				System.out.println();
			}
		return counter;
	}



private static boolean duplicate(int coordinate1, int coordinate2, int[] rowArray, int[] colArray) {
    boolean result1 = false;
    boolean result2 = false;
    boolean sameIndex = false;
    int index1 = 0;
    int index2 = 0;
    for (int i = 0; i < rowArray.length; i++) {
        if ((rowArray[i] == coordinate1) && (colArray[i] == coordinate2)){
	    index1 = i;
	    index2 = i;
	    result1 = true;
            result2 = true;
            break;
        }
    }

    if(((result1 == true) && (result2 == true)) && (index1 == index2)) {
	sameIndex = true;
    }

return sameIndex;
}


private static void printBattleShip(char[][] player) {
    System.out.print("  ");
    for (int row = -1; row < 5; row++) {
	if (row > -1) {
	System.out.print(row + " ");
	}
	for (int column = 0; column < 5; column++) {
	    if (row == -1) {
		System.out.print(column + " ");
	    } 
	    else {
	        System.out.print(player[row][column] + " ");
	}
}
	System.out.println("");
		}
	}
}
