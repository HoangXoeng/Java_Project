import java.util.ArrayList;
public class Subject {
	private static int subject_ID  = 0;
	private static ArrayList<Subject> listSubject = new ArrayList<Subject>();
	private String subject_name;
	private int number_of_lesson;
	private PNV_Teacher teacher;
	public Subject() {}
	public Subject(String name_of_subject,int number_of_lesson, PNV_Teacher teacher) {
		this.subject_name = name_of_subject;
		this.number_of_lesson = number_of_lesson;
		this.teacher = teacher;
		listSubject.add(this);
		subject_ID = subject_ID + 1;
	}
	
	@Override
	public String toString() {
		return "subject_name=" + subject_name + "";
	}
	public static int getSubject_ID() {
		return subject_ID;
	}
	public static void setSubject_ID(int subject_ID) {
		Subject.subject_ID = subject_ID;
	}
	public static ArrayList<Subject> getListSubject() {
		return listSubject;
	}
	public static void setListSubject(ArrayList<Subject> listSubject) {
		Subject.listSubject = listSubject;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String name) {
		this.subject_name = name;
	}
	public double getNumber_of_lesson() {
		return number_of_lesson;
	}
	
	public PNV_Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(PNV_Teacher teacher) {
		this.teacher = teacher;
	}
	public static void showSubjectList() {
        System.out.println("_______________SUBJECT LIST______________");
        for(int i = 0; i < subject_ID; i++ ) {
            System.out.printf(i+1 +". %-20s %.0f lesson %20s\n",listSubject.get(i).getSubject_name(), listSubject.get(i).getNumber_of_lesson(),listSubject.get(i).getTeacher().getName());
        }
    }
	
}
