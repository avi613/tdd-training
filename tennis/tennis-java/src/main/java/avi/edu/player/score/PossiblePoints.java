package avi.edu.player.score;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class PossiblePoints {
    private static List<Integer> points = ImmutableList.of(
            0, 15, 30, 40
    );

    public static int get(int i) {
        return  i <= 3 ? points.get(i) : -1;
    }
}
