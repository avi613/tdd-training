package avi.edu.dla.boundary;

import avi.edu.dla.particle.Particle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Boundary {
    private int eastBoundary;
    private int northBoundary;
    private int westBoundary;
    private int southBoundary;

    public boolean hasOutPassedEASTBoundary(Particle particle) {
        return particle.getX() > eastBoundary;
    }

    public boolean hasOutPassedNORTHBoundary(Particle particle) {
        return particle.getY() > northBoundary;
    }

    public boolean hasOutPassedWESTBoundary(Particle particle) {
        return particle.getX() < westBoundary;
    }

    public boolean hasOutPassedSOUTHBoundary(Particle particle) {
        return particle.getY() < southBoundary;
    }
}
