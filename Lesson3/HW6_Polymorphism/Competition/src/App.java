import Barrier.Barrier;
import Barrier.RunningTrack;
import Barrier.Wall;
import Participant.Cat;
import Participant.Human;
import Participant.Participant;
import Participant.Robot;

public class App {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{new Cat("Butch", 200, 2),
                new Human("Rick", 100, 0.5),
                new Robot("Connor", 500, 1)};

        Barrier[] barriers = new Barrier[]{new RunningTrack(150), new Wall(0.4),
                new RunningTrack(200), new Wall(1),
                new RunningTrack(300), new Wall(2)};

        for (Participant participant : participants) {
            for (int j = 0; j < barriers.length; j++) {
                Barrier barrier = barriers[j];
                if (barrier.isPossibleToOvercome(participant)) {
                    barrier.overcome(participant);
                } else {
                    System.out.println(participant.getName() + " can't overcome the " + barrier.getClass().getSimpleName().toLowerCase() + ", position is " + (j + 1));
                    break;
                }
            }
        }
    }
}
