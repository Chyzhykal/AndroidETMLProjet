/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Participation object
 */

package etml.app.meetapp.Entities;

public class ParticipateEntity {

    int fkUser;
    int fkEvent;
    String partChance;

    public int getFkUser() {
        return fkUser;
    }
    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public int getFkEvent() {
        return fkEvent;
    }
    public void setFkEvent(int fkEvent) {
        this.fkEvent = fkEvent;
    }

    public String getPartChance() {
        return partChance;
    }
    public void setPartChance(String partChance) {
        this.partChance = partChance;
    }





}
