package Participant;

import Barrier.Barrier;

public abstract class Participant {
    private String name;
    private double runLimit;
    private double jumpLimit;

    public Participant(String name, double runLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public abstract void run(Barrier barrier);

    public abstract void jump(Barrier barrier);

    public String getName() {
        return name;
    }

    public double getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }
}
