// javac -cp .:lib/algs4.jar baseball/BaseballElimination.java
// java -cp .:lib/algs4.jar baseball.BaseballElimination teams12.txt

package baseball;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

public class BaseballElimination {

    public BaseballElimination(String filename) {}

    public int numberOfTeams() {
        return 0;
    }

    public Iterable<String> teams() {
        return new Stack<String>();
    }

    public int wins(String team) {
        return 0;
    }

    public int losses(String team) {
        return 0;
    }

    public int against(String team1, String team2) {
        return 0;
    }

    public boolean isEliminated(String team) {
        return true;
    }

    public Iterable<String> certificateOfElimination(String team) {
        return new Stack<String>();
    }

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        for (String team : division.teams()) {
            if (division.isEliminated(team)) {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team)) {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}
