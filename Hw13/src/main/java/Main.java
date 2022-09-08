import Abstracts.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView app = new ConsoleView();
        while (app.run()) {
            if (!app.run()) break;
        }
    }
}
