import java.util.Arrays;
import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    private final char[][] board;
    private final char blank;
    private final char black = '●';
    private final char white = '○';
    private final Scanner scanner;
    Player player1, player2;

    public Gomoku(char[][] board, Scanner scanner, Player player1, Player player2) {
        this.board = board;
        this.blank = 'ㆍ';
        this.scanner = scanner;
        this.player1 = player1;
        this.player2 = player2;
    }

    public char getBlank() {
        return blank;
    }

    @Override
    public void play(Player player, Position pos) {
        //□○●
        player.getKeyboardInput();
        String[] key = scanner.nextLine().split("[ \\t\\n\\x0B\\f\\r]");
//        System.out.println(Arrays.toString(key));
        char stone;
        int x;
        int y;
        switch (key.length){
            case 1 :
                if(key[0].equals("q")){
                    System.out.printf("%s %d - %d %s", player1.getName(), player1.getNumWin(), player2.getNumWin(), player2.getName());
                    isFinished();
                }
                break;
            case 2 :
                if(player == player1){
                    stone = white;
                }else {
                    stone = black;
                }

                pos.setX(Integer.parseInt(key[0]));
                pos.setY(Integer.parseInt(key[1]));

                x = pos.getX();
                y = pos.getY();

                if(board[y][x] == blank){
                    board[y][x] = stone;
                }else {
                    System.out.println("이미 돌이 놓여있네요.");
                    player.getKeyboardInput();
                    Main.turn--;
                }
                printStatus();
                Main.turn++;
                break;
            default:
                player.getKeyboardInput();
                Main.turn--;
        }
    }

    @Override
    public void printStatus() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            sb.append(row).append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void initialize() {
        reset();
    }

    @Override
    public void isFinished() {
        System.exit(0);
    }

    @Override
    public void reset() {
        for (char[] chars : board) {
            Arrays.fill(chars, blank);
        }
    }
    public boolean is3And3(int idx1, int idx2, char[][] board){
        boolean check = false;
        if(idx1 < 12 && idx2 < 12){

        }else {
            check = true;
        }
        return check;
    }

    @Override
    public Player getWinner() {
        
        int compare = 0;
        System.out.println(33);
        Player player = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //3-3
                int whiteCnt = 0;
                int blackCnt = 0;
                if(i >= 2 && j >= 2) {
                    if (board[i][j] == white) {
                        whiteCnt++;
                    } else if (board[i][j] == black) {
                        blackCnt++;
                    }
                    if (board[i][j - 1] == white) {
                        whiteCnt++;
                    } else if (board[i][j - 1] == black) {
                        blackCnt++;
                    }
                    if (board[i][j - 2] == white) {
                        whiteCnt++;
                    } else if (board[i][j - 2] == black) {
                        blackCnt++;
                    }
                    if (board[i - 1][j] == white) {
                        whiteCnt++;
                    } else if (board[i - 1][j] == black) {
                        blackCnt++;
                    }
                    if (board[i - 1][j - 1] == white) {
                        whiteCnt++;
                    } else if (board[i - 1][j - 1] == black) {
                        blackCnt++;
                    }
                    if (board[i - 1][j - 2] == white) {
                        whiteCnt++;
                    } else if (board[i - 1][j - 2] == black) {
                        blackCnt++;
                    }
                    if (board[i - 2][j] == white) {
                        whiteCnt++;
                    } else if (board[i - 2][j] == black) {
                        blackCnt++;
                    }
                    if (board[i - 2][j - 1] == white) {
                        whiteCnt++;
                    } else if (board[i - 2][j - 1] == black) {
                        blackCnt++;
                    }
                    if (board[i - 2][j - 2] == white) {
                        whiteCnt++;
                    } else if (board[i - 2][j - 2] == black) {
                        blackCnt++;
                    }

                    if (whiteCnt == 5) {
                        System.out.println("흰색 3x3");
                        player = player2;
                        break;
                    } else if (blackCnt == 5) {
                        System.out.println("검은색 3x3");
                        player = player1;
                        break;
                    }
                }

                // 수평
                if(j < board[i].length + 5){
                    if(board[i][j] == white
                            && board[i][j + 1] == white
                            && board[i][j + 2] == white
                            && board[i][j + 3] == white
                            && board[i][j + 4] == white ){
                        player = player1;
                        break;
                    }else if(board[i][j] == black
                            && board[i][j + 1] == black
                            && board[i][j + 2] == black
                            && board[i][j + 3] == black
                            && board[i][j + 4] == black ){
                        player = player2;
                        break;
                    }
                }

                // 수직
                if(i < board.length + 5){
                    if(board[i][j] == white
                            && board[i + 1][j] == white
                            && board[i + 2][j] == white
                            && board[i + 3][j] == white
                            && board[i + 4][j] == white ){
                        player = player1;
                        break;
                    }else if(board[i][j] == black
                            && board[i + 1][j] == black
                            && board[i + 2][j] == black
                            && board[i + 3][j] == black
                            && board[i + 4][j] == black ){
                        player = player2;
                        break;
                    }
                }

                // 대각선1
                if(i < board.length + 5 && j < board[i].length + 5){
                    if(board[i][j] == white && board[i + 1][j + 1] == white
                            && board[i + 2][j + 2] == white
                            && board[i + 3][j + 3] == white
                            && board[i + 4][j + 4] == white ){
                        player = player1;
                        break;
                    }else if(board[i][j] == black
                            && board[i + 1][j + 1] == black
                            && board[i + 2][j + 2] == black
                            && board[i + 3][j + 3] == black
                            && board[i + 4][j + 4] == black ){
                        player = player2;
                        break;
                    }
                }

                // 대각선2
                if(j > 3 && i < board.length - 5){
                    if(board[i][j] == white
                            && board[i + 1][j - 1] == white
                            && board[i + 2][j - 2] == white
                            && board[i + 3][j - 3] == white
                            && board[i + 4][j - 4] == white ){
                        player = player1;
                        break;
                    }else if(board[i][j] == black
                            && board[i + 1][j - 1] == black
                            && board[i + 2][j - 2] == black
                            && board[i + 3][j - 3] == black
                            && board[i + 4][j - 4] == black ){
                        player = player2;
                        break;
                    }
                }
            }
        }

        if(player != null){
            player.setName(player.getName());
            player.setNumWin(player.getNumWin() + 1);
        }

        return player;
    }
}
