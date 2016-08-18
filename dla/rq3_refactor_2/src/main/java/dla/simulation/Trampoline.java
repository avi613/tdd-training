package dla.simulation;

public class Trampoline<T> {
    public T getCurrent() {
        return null;
    }

    public Trampoline<T> jump() {
        return null;
    }

    public T run() {
        Trampoline<T> trampoline = this;

        while (trampoline.getCurrent() == null) {
            trampoline = trampoline.jump();
        }

        return trampoline.getCurrent();
    }
}
