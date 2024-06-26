import java.util.ArrayList;

public class StudyPerform {
    private static ArrayList<StudyPerform> list_Score = new ArrayList<StudyPerform>();
	private static int score_ID  = 0;
    private PNV_Student student;
    private Subject subject;
    private float score;

    public StudyPerform(PNV_Student student, Subject subject, float score){
        this.student = student;
        this.subject = subject;
        this.score = score;
        list_Score.add(this);
        score_ID = score_ID + 1;
    }

    public PNV_Student getStudent() {
        return student;
    }
    public void setStudent(PNV_Student student) {
        this.student = student;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

    public static void showScore(PNV_Student student){
        System.out.println("_______________SCORE LIST______________");
        for(int i = 0; i < score_ID; i++ ) {
            if (list_Score.get(i).getStudent() == student){
                System.out.println(student.getName()+"   "+ list_Score.get(i).getSubject().getSubject_name() + list_Score.get(i).getScore() );
            }
        
        }
    }
    

}
