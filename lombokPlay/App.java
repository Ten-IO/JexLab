package lombokPlay;

/**
 * Describe about Current-Subject-Session in Class.
 * 
 * @version 1.6
 * @modified 14-01-2025
 */
public class App {
    public static void main(String[] args) {
        Subject se = new Subject();
        Session schedule = new Session();
        try {
            // Quick Check
            System.out.println("\rSubject : " + se.getSubjectName());
            System.out.println("Code : " + se.getSubjectCode());
            System.out.println("Initial Credit: " + se.getNumberOfCredits());
            System.out.println("Season: " + se.getSeason() + "\n");
            // Modified
            se.setNumberOfCredits(90);
            se.setSubjectCode(001);
            se.setSubjectName("Malware");
            // Re-check
            System.out.println("Subject : " + se.getSubjectName());
            System.out.println("Code : " + se.getSubjectCode());
            System.out.println("After credit: " + se.getNumberOfCredits());
            System.out.println("Season: " + se.getSeason());
            // null test
            se.setSubjectName("");
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
        // Session implementation
        System.out.println("Class: " + schedule.getSessionTitle());
        System.out.println("Session start: " + schedule.getSessionStart());
        System.out.println("Session end: " + schedule.getSessionEnd());
        // modified
        try {
            schedule.setDuration(1, 2);
            schedule.setSessionTitle("Godly Class");
        } catch (IllegalArgumentException e) {
            System.out.println("Logic error: " + e.getMessage());
        }
    }
}
