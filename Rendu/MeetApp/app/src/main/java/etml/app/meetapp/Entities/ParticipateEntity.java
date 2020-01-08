/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Participation object
 */

package etml.app.meetapp.Entities;

/**
 * Entity for the Participation object
 */
public class ParticipateEntity {

    int fkUser;         // User participating id
    int fkEvent;        // Event in which the user is participating id
    String partChance;  // Participation chance

    /**
     * Gets the participating user's id
     * @return
     */
    public int getFkUser() {
        return fkUser;
    }

    /**
     * Sets the participating user's id
     * @param fkUser
     */
    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    /**
     * Gets the event's id
     * @return
     */
    public int getFkEvent() {
        return fkEvent;
    }

    /**
     * Sets the event's id
     * @param fkEvent
     */
    public void setFkEvent(int fkEvent) {
        this.fkEvent = fkEvent;
    }

    /**
     * Gets the part chance
     * @return
     */
    public String getPartChance() {
        return partChance;
    }

    /**
     * Sets the part chance
     * @param partChance
     */
    public void setPartChance(String partChance) {
        this.partChance = partChance;
    }
}
