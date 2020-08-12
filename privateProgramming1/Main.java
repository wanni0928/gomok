import java.util.Scanner;

/**
 * 오목 구현하기
 *
 * Gomoku 클래스를 구현하여 오목을 플레이할 수 있도록 구현한다.
 *
 * 오목은 다음 기능을 포함한다.
 *
 * 0. 15x15 오목판을 이용한다.v
 *
 * 1. 두 명의 플레이어가 번갈아 돌을 놓을 수 있도록 한다.v
 *   1.0 돌의 위치는 키보드로 좌표를 입력 받는다.v
 *   1.1 돌을 놓을 때 둘 수 없는 곳에 돌을 놓을 경우 다시 입력 받는다.v
 *   1.2 3-3은 반칙이므로 즉시 패배한다.
 *
 * 2. 돌을 놓을 때 마다 현재 상태를 출력한다.v
 *   2.0 흑돌은 x, 백돌은 o로 표시한다.v
 *
 * 3. 한 플레이어가 게임에서 승리할 경우 즉시 다음 게임을 시작한다.v
 *
 * 4. 각 플레이어는 승리할 때 마다 승수를 외치시오. (ex. "5번 이겼다!")v
 *
 * 5. q를 입력받을 경우 플레이어의 이름과 스코어를 출력하고 프로그램을 종료한다.v
 *    (ex. "에디슨 3 - 2 테슬라")v
 */
public class Main {
    static int turn = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("플레이어1", 0, sc);
        Player player2 = new Player("플레이어2", 0, sc);
        Player currentPlayer = null;
        Player winner = null;

        Position position = new Position();

        char[][] board = new char[15][15];

        // Play gomoku here
        Gomoku gomoku = new Gomoku(board, sc, player1, player2);
        gomoku.initialize();

        while (true){
            currentPlayer = (turn % Integer.MAX_VALUE) % 2 != 0 ? player1 : player2;
            gomoku.play(currentPlayer, position);
            winner = gomoku.getWinner();
            if(winner != null){
                System.out.printf("%s 승! %d번 이겼다!\n", winner.getName(), winner.getNumWin());
                gomoku.reset();
            }
        }
    }
}
