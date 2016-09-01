package avi.edu.dla.movement;

public class Trampoline<T> {
    public T getCurrent() {
        return null;
    }

    public Trampoline<T> bounce() {
        return null;
    }

    public T run() {
        Trampoline<T> trampoline = this;

        while (trampoline.getCurrent() == null) {
            trampoline = trampoline.bounce();
        }

        return trampoline.getCurrent();
    }
}
