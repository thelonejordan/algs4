package wordnet;

public class Outcast {
    private final WordNet wn;
    public Outcast(WordNet wordnet) {         // constructor takes a WordNet object
        wn = wordnet;
    }
    public String outcast(String[] nouns) {  // given an array of WordNet nouns, return an outcast
        int maxDist = -1;
        int idx = 0;
        for (int i = 0; i < nouns.length; i++) {
            int dist = 0;
            for (int j = 0; j < nouns.length; j++) {
                if (i != j) {
                    dist = dist + wn.distance(nouns[i], nouns[j]);
                }
            }
            if (dist > maxDist) {
                maxDist = dist;
                idx = i;
            }
        }
        return nouns[idx];
    }

    public static void main(String[] args) { // see test client below

    }
}
