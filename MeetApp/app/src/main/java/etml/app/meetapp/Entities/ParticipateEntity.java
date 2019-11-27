package etml.app.meetapp.Entities;

public class ParticipateEntity {

    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    int fkUser;

    public int getFkEvent() {
        return fkEvent;
    }

    public void setFkEvent(int fkEvent) {
        this.fkEvent = fkEvent;
    }

    int fkEvent;

    public String getPartChance() {
        return partChance;
    }

    public void setPartChance(String partChance) {
        this.partChance = partChance;
    }

    String partChance;



}
