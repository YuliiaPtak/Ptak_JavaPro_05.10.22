package Participant;

import Barrier.Barrier;

public class Human extends Participant {
    public Human(String name, double runLimit, double jumpLimit) {
        super(name, runLimit, jumpLimit);
    }

    public void run(Barrier barrier) {
        System.out.println(getName() + " ran the treadmill.");
    }

    public void jump(Barrier barrier) {
        System.out.println(getName() + " jumped over the wall.");
    }
}
