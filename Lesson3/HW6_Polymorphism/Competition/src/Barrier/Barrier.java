package Barrier;

import Participant.Participant;

public interface Barrier {
    boolean isPossibleToOvercome(Participant participant);

    void overcome(Participant participant);
}
