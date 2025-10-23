package lombokPlay;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Prachna
 * @version 1.0
 * @creation 12-01-2025
 * @modified 14-01-2025
 * Description: A class that practice Code Standard and Best Practice 
 * based session time control
 * @function getSessionStart : Session
 * @method setDuration : Session
 */

@Getter @Setter
public class Session {
    private int sessionStart = 13;
    private int sessionEnd = 15;
    private String sessionTitle = "Study session";

    // Constructor
    public Session() {
        super();
    }
    public Session (String sessionTitle, int sessionStart, int sessionEnd) {
        this.sessionTitle = sessionTitle;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
    }

    // Method
     void setDuration(int sessionStart, int sessionEnd) throws IllegalArgumentException {
        if (sessionStart >= sessionEnd ) {
            throw new IllegalArgumentException("Start time must be less than end time !");
        }
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
    }
}
