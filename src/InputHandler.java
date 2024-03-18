import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
