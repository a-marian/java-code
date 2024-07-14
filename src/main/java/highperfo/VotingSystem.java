package highperfo;

import java.util.LinkedHashMap;

public class VotingSystem {

    //
    private LinkedHashMap<String, Integer> votes = new LinkedHashMap<>();

    void vote(String contestant){
        votes.merge(contestant, 1, Integer::sum);
    }

    public LinkedHashMap getVotes(){
        return new LinkedHashMap();
    }
}
