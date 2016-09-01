package avi.edu.dla.movement;


import avi.edu.dla.boundary.Boundary;
import avi.edu.dla.particle.Particle;
import avi.edu.dla.rand.RandomGenerator;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Movement {
    private final RandomGenerator randomGenerator;
    private final Boundary boundary;
    private final List<Particle> particles;

    public Trampoline<Particle> move(final Particle particle) {
        if (particles.stream().anyMatch(p -> particle.touches(p))) {
            System.out.println("final position reached at: " + particle);
            return new Trampoline<Particle>() {
                @Override
                public Particle getCurrent() {
                    return particle;
                }
            };
        }

        final Particle current = processRebound(particle);

        int[] nextMove = randomGenerator.nextMove();

        return new Trampoline<Particle>() {
            @Override
            public Trampoline<Particle> bounce() {
                return move(new Particle(current.getX() + nextMove[0], current.getY() + nextMove[1]));
            }
        };
    }

    private Particle processRebound(Particle particle) {
        if (boundary.hasOutPassedEASTBoundary(particle))
            return new Particle(boundary.getEastBoundary() - 1, particle.getY());
        if (boundary.hasOutPassedNORTHBoundary(particle))
            return new Particle(particle.getX(), boundary.getNorthBoundary() - 1);
        if (boundary.hasOutPassedWESTBoundary(particle))
            return new Particle(boundary.getWestBoundary() + 1, particle.getY());
        if (boundary.hasOutPassedSOUTHBoundary(particle))
            return new Particle(particle.getX(), boundary.getSouthBoundary() + 1);
        return particle;
    }
}
