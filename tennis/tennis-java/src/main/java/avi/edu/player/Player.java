package avi.edu.player;

import avi.edu.player.score.Score;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private Score score;
}
