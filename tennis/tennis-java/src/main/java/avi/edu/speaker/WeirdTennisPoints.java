package avi.edu.speaker;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class WeirdTennisPoints {
    private static List<Integer> points = ImmutableList.of(
            0, 15, 30, 40
    );

    public static int get(int i) {
        return  i <= 3 ? points.get(i) : 40 + i;
    }
}
