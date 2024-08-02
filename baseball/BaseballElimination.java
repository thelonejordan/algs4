// javac-algs4 baseball/BaseballElimination.java
// java-algs4 baseball.BaseballElimination baseball/teams12.txt

package baseball;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;

public class BaseballElimination {

    private final int numTeams;
    private final ST<String, Integer> teamsMap = new ST<>();
    private final String[] teamsMapInv;
    private final int[] wins;
    private final int[] losses;
    private final int[] remaining;
    private final int[][] against;
    private Bag<String> cert;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In in = new In(filename);
        numTeams = in.readInt();
        wins = new int[numTeams];
        losses = new int[numTeams];
        remaining = new int[numTeams];
        against = new int[numTeams][numTeams];
        teamsMapInv = new String[numTeams];
        for (int i = 0; i < numTeams; i++) {
            String team = in.readString();
            teamsMap.put(team, i);
            teamsMapInv[i] = team;
            wins[i] = in.readInt();
            losses[i] = in.readInt();
            remaining[i] = in.readInt();
            for (int j = 0; j < numTeams; j++) {
                against[i][j] = in.readInt();
            }
        }
    }

    // number of teams
    public int numberOfTeams() {
        return numTeams;
    }

    // all teams
    public Iterable<String> teams() {
        return teamsMap.keys();
    }

    private void validateTeam(String team) {
        if (!teamsMap.contains(team)) throw new IllegalArgumentException();
    }

    // number of wins for given team
    public int wins(String team) {
        validateTeam(team);
        return wins[teamsMap.get(team)];
    }

    // number of losses for given team
    public int losses(String team) {
        validateTeam(team);
        return losses[teamsMap.get(team)];
    }

    // number of remaining games for given team
    public int remaining(String team) {
        validateTeam(team);
        return remaining[teamsMap.get(team)];
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        validateTeam(team1);
        validateTeam(team2);
        return against[teamsMap.get(team1)][teamsMap.get(team2)];
    }

    private int vertexToTeam(int v, int teamID, int offset) {
        int ret = v - offset;
        if (ret < teamID) return ret;
        return ret + 1;
    }

    private boolean computeEliminated(int teamID) {
        int n = numTeams-1;
        int matchups = n*(n-1)/2;
        int numNodes = matchups + n + 2;

        int s = 0; // source node
        int t = numNodes-1; // target node
        
        FlowNetwork network = new FlowNetwork(numNodes);
        int matchupID = 1;
        int offset = matchups + 1;
        double targetMaxFlow = 0;
        for (int i = 0; i < n - 1; i++) {
            int vertexA = i + offset;
            int teamA = vertexToTeam(vertexA, teamID, offset);
            for (int j = i + 1; j < n; j++) {
                int vertexB = j + offset;
                int teamB = vertexToTeam(vertexB, teamID, offset);
                // add edges
                targetMaxFlow += against[teamA][teamB];
                network.addEdge(new FlowEdge(s, matchupID, against[teamA][teamB]));
                network.addEdge(new FlowEdge(matchupID, vertexA, Double.POSITIVE_INFINITY));
                network.addEdge(new FlowEdge(matchupID, vertexB, Double.POSITIVE_INFINITY));
                matchupID += 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int vertex = i + offset;
            int teamX = vertexToTeam(vertex, teamID, offset);
            network.addEdge(new FlowEdge(vertex, t, wins[teamID] + remaining[teamID] - wins[teamX]));
        }
        
        FordFulkerson maxflow = new FordFulkerson(network, s, t);
        // StdOut.println(network.toString());
        if (maxflow.value() == targetMaxFlow) {
            return false;
        }
        cert = new Bag<String>();
        for (int i = 0; i < n; i++) {
            int vertex = i + offset;
            int teamX = vertexToTeam(vertex, teamID, offset);
            if (maxflow.inCut(vertex)) cert.add(teamsMapInv[teamX]);
        }
        return true;
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        validateTeam(team);
        int teamID = teamsMap.get(team);
        // trivial elimination
        for (int i = 0; i < numTeams; i++) {
            if (i == teamID) continue;
            if (wins[teamID] + remaining[teamID] < wins[i]) {
                cert = new Bag<String>();
                cert.add(teamsMapInv[i]);
                return true;
            }
        }
        return computeEliminated(teamID);
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        validateTeam(team);
        if (isEliminated(team)) return cert;
        return null;
    }

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        StdOut.println("number of teams: " + division.numberOfTeams());
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
