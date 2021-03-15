package pathfinding.main;

import pathfinding.ui.BenchmarkUI;
import pathfinding.ui.UI;

public class Main {
    public static void main(String args[]) {
        if (args == null || args.length == 0) {
            UI.main(args);
        } else {
            BenchmarkUI.start(args);
        }
    }
}
