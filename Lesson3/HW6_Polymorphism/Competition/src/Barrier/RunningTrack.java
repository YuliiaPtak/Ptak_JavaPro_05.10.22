package Barrier;

import Participant.Participant;

public class RunningTrack implements Barrier {
    private double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    public boolean isPossibleToOvercome(Participant participant) {
        return length <= participant.getRunLimit();
    }

    public void overcome(Participant participant) {
        participant.run(this);
    }
}
