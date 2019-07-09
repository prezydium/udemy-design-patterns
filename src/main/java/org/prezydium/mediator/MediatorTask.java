package org.prezydium.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorTask {
}


class Participant {

    private int value = 0;
    private Mediator mediator;

    public Participant(Mediator mediator) {
        this.mediator = mediator;
        mediator.addParticipant(this);
    }

    public void say(int n) {
        mediator.broadcast(this, n);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Mediator {
    List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void broadcast(Participant participant, int value) {
        participants.stream()
                .filter(x -> x != participant)
                .forEach(x -> x.setValue(x.getValue() + value));
    }
}
