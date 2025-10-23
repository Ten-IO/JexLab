package lombokPlay;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Subject {
    private String subjectName = "Introduction to Software Engineering"; // e.g. Intro to SE
    private int subjectCode = 015; // e.g. 1
    private int numberOfCredits = 100;
    private final String season = "S2";

    //Constructor
    public Subject() {
        super();
    }
    public Subject(String subjectName, int subjectCode, int numberOfCredits) {
        super();
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.numberOfCredits = numberOfCredits;
    }
    // Method
    public void setSubjectName(String subjectName) throws IllegalArgumentException {    
        if (subjectName == null || subjectName.trim().isEmpty()) {                      // .trim(), for thorough check white space 
            throw new IllegalArgumentException("Subject name was not assigned!");
        }
        this.subjectName = subjectName;
    }   
}
