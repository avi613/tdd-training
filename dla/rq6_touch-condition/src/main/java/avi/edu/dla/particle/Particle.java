package avi.edu.dla.particle;

import lombok.Value;

@Value
public class Particle {
    private int x;
    private int y;

    public boolean touches(Particle particle) {
        if (x - particle.getX() == -1 && y == particle.getY())
            return true;
        if (x == particle.getX() && y - particle.getY() == -1)
            return true;
        if (x - particle.getX() == 1 && y == particle.getY())
            return true;
        if (x == particle.getX() && y - particle.getY() == 1)
            return true;
        return false;
    }
}
