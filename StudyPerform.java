import java.util.ArrayList;

public class StudyPerform {
    private static ArrayList<StudyPerform> list_Score = new ArrayList<StudyPerform>();
	private static int numberOfStudyPer  = 0;
    private PNV_Student student;
    private Subject subject;
    private float score;

    public StudyPerform(PNV_Student student, Subject subject, float score){
        this.student = student;
        this.subject = subject;
        this.score = score;
        list_Score.add(this);
        numberOfStudyPer = numberOfStudyPer + 1;
    }
    public StudyPerform(PNV_Student student, Subject subject){ // this constructor use in subcribe method
        this.student = student;
        this.subject = subject;
        this.score = 0;
    }

    public static int getNumberOfStudent(){
        return numberOfStudyPer;
    }
    public static void addStudyPerformList(PNV_Student student, Subject subject){
        list_Score.add(new StudyPerform(student, subject));
        numberOfStudyPer = numberOfStudyPer + 1;
    }
    public static ArrayList<StudyPerform> getList_Score() {
        return list_Score;
    }
    public static void setList_Score(ArrayList<StudyPerform> list_Score) {
        StudyPerform.list_Score = list_Score;
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
        for(int i = 0; i < numberOfStudyPer; i++ ) {
            if (list_Score.get(i).getStudent() == student){
                System.out.println(student.getName()+"   "+ list_Score.get(i).getSubject().getSubject_name() +"  "+list_Score.get(i).getScore() );
            }
        }   
    }

    public static ArrayList<StudyPerform> showStudyPerTeachBy(PNV_Teacher teacher){
        ArrayList<StudyPerform> listStudentTeachByTeacher = new ArrayList<StudyPerform>();
        for(int i = 0; i < numberOfStudyPer; i++ ) {
            if (list_Score.get(i).getSubject().getTeacher() == teacher){
                listStudentTeachByTeacher.add(list_Score.get(i));
            }
        }
        return   listStudentTeachByTeacher;
    }

}