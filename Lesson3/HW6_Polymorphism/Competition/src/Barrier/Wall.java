package Barrier;

import Participant.Participant;

public class Wall implements Barrier {
    double height;

    public Wall(double height) {
        this.height = height;
    }

    public boolean isPossibleToOvercome(Participant participant) {
        return height <= participant.getJumpLimit();
    }

    public void overcome(Participant participant) {
        participant.jump(this);
    }
}
