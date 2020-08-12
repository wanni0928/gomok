import java.util.Scanner;

public class Player implements Inputtable {
    private String name;
    private int numWin;
    private Scanner scanner;

    public Player() {
    }

    public Player(String name, int numWin) {
        this.name = name;
        this.numWin = numWin;
    }

    public Player(String name, int numWin, Scanner scanner) {
        this.name = name;
        this.numWin = numWin;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumWin() {
        return numWin;
    }

    public void setNumWin(int numWin) {
        this.numWin = numWin;
    }

    @Override
    public void getKeyboardInput() {
        System.out.printf("%s 당신의 차례\n", this.name);
    }
}
