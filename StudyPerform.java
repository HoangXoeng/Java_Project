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
    public StudyPerform(PNV_Student student, Subject subject){ // this constructor use in subcribe method
        this.student = student;
        this.subject = subject;
        this.score = 0;
    }

    public static void addStudyPerformList(PNV_Student student, Subject subject){
        list_Score.add(new StudyPerform(student, subject));
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

    public static void showScoreOfStudent(PNV_Student student){ //! this method help student can watch score
        System.out.println("_______________SCORE LIST______________");
        for(int i = 0; i < score_ID; i++ ) {
            if (list_Score.get(i).getStudent() == student){
                System.out.println(student.getName()+"   "+ list_Score.get(i).getSubject().getSubject_name() +"  "+list_Score.get(i).getScore() );
        }
    
    }

}
}