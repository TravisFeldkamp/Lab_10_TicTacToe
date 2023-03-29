import java.util.Scanner;

public class TicTacToe {
    private static final int ROW =3;//declare variables inside of class so it can be used by methods outside of main
    private static final int COL =3;
    private static String board [][]=new String[ROW][COL];//declare new array for board


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//initilize scanner
        String player = "X";
        boolean playerOne = true;
        boolean playerAnswer = true;
        boolean validMove = true;
        boolean gameOver = false;


        do {//do this block of code while condition is met
            clearBoard();//makes sure the board is clear by calling clearBoard method


    while (!gameOver) {//while !gameOver run this block of code
        int row = SafeInput.getRangedInt(in,player +" enter a row number between",1,3);//output to user, check for int within range
        int col =  SafeInput.getRangedInt(in,player + " enter a column number between",1,3);//output to user, check for int within range
        row = row - 1;//store user input as row but subtract 1
        col = col -1;//store user input as col but subtract 1


        validMove = isValidMove(row,col);//store valid user answer as validMove
        if (isValidMove(row,col)) {//if given a valid move run this block
            board[row][col] = player;
            display();


            if (isWin("X")) {//check to see if player X has met winning conditions, if so output to user
                System.out.println("Congratulations! Player X wins!");
                gameOver = true;
            } else if (isWin("O")) {//check to see if player O has met winning conditions, if so output to user
                System.out.println("Congratulations! Player O wins!");
                gameOver = true;
            } else if (isTie("X")) {//if a tie condition is met run this block
                    System.out.println("It's a tie!");
                    gameOver = true;
            }else{
                if (player.equals("X")) {//this code changes the player back and forth
                    player = "O";
                } else {
                    player = "X";
                }
            }
        }
    }
       if (validMove) {//this makes sure that user does not change if invalid move is given
           player = "O";
           if (!validMove) {
               player = "X";
           }
       }
       in.nextLine();
    playerAnswer = SafeInput.getYNConfirm(in,"Would you like to play again?");//use YNConfirm method to get player answer to playing again
       if (playerAnswer == true){
           gameOver = false;
           player = "X";
       }
       if (playerAnswer == false){
           System.exit(0);
       }

}while (playerAnswer);

    }


        private static void clearBoard () {//builds board by placing blank spaces in the board
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    board[row][col] = " ";
                }
            }
        }


        private static void display () {//builds display of board by placing |
            for (int row = 0; row < ROW; row++) {
                System.out.print("| ");
                for (int col = 0; col < COL; col++) {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }
        }



        private static boolean isValidMove(int row,int col) {
            if (row < 0 || row >= ROW || col < 0 || col >= COL){//must be inside of the rows or col
                System.out.println("That was an invalid move, you must enter between 1-3 ");
                return false;
            }
            if (!board[row][col].equals(" ")){//cannot be where a character is
                System.out.println("invalid move, that cell has been used");
                return false;
            }
            return true;
        }




        private static boolean isWin(String Player){//uses all of the possible win methods
        String player = Player;
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
        }






        private static boolean isColWin(String player)//if a col is full of the same players move then return true, if not break loop
        {
            for (int col = 0; col < COL; col++) {
            boolean win = true;
            for (int row = 0; row < ROW; row++) {
            if (!board[row][col].equals(player)) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }
    }
    return false;
}



        private static boolean isRowWin(String player)//checks row to see if it is all same if so break loop and return true
        {
            for (int row = 0; row < ROW; row++) {
                boolean win = true;
                for (int col = 0; col < COL; col++) {
                    if (!board[row][col].equals(player)) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isDiagnalWin(String player)//checks both diagonals for characters if they are equal to the player return true
        {
            boolean diagonal1 = true;
            boolean diagonal2 = true;
            for (int i = 0; i < ROW; i++) {
                if (!board[i][i].equals(player)) {
                    diagonal1 = false;
                }
                if (!board[i][COL - i - 1].equals(player)) {
                    diagonal2 = false;
                }
            }
            return diagonal1 || diagonal2;
        }
        private static boolean isTie(String player)//checks to see if there is any empty spaces, if not return true, as it must be a tie
        {
            boolean boxFilled = true;
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    if (board[row][col].equals(" ")) {
                        boxFilled = false;
                    }
                }
            }
            return boxFilled && !isWin("X") && !isWin("O");
        }




}

