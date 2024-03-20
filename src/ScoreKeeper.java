import java.util.HashMap;
import java.util.Map;

public class ScoreKeeper {
    private Map<Player, Integer> scores;

    public ScoreKeeper() {
        scores = new HashMap<>();
    }

    public void initializeScores(Player[] players) {
        for (Player player : players) {
            scores.put(player, 0);
        }
    }

    public void updateScore(Player player, int penaltyPoints) {
        scores.put(player, scores.getOrDefault(player, 0) + penaltyPoints);
    }

    public int getScore(Player player) {
        return scores.getOrDefault(player, 0);
    }
    
}
