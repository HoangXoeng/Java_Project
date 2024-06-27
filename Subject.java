import java.util.ArrayList;
public class Subject {
	private static int numberOfSubject  = 0;
	private static ArrayList<Subject> listSubject = new ArrayList<Subject>();
	private String subject_name;
	private int number_of_lesson;
	private PNV_Teacher teacher;

	public Subject(String name_of_subject,int number_of_lesson, PNV_Teacher teacher) {
		this.subject_name = name_of_subject;
		this.number_of_lesson = number_of_lesson;
		this.teacher = teacher;
		listSubject.add(this);
		numberOfSubject = numberOfSubject + 1;
	}
	
	@Override
	public String toString() {
		return "subject_name=" + subject_name + "";
	}
	public static int getSubject_ID() {
		return numberOfSubject;
	}
	public static void setSubject_ID(int numberOfSubject) {
		Subject.numberOfSubject = numberOfSubject;
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
        System.out.println("____________________SUBJECT LIST___________________");
        for(int i = 0; i < numberOfSubject; i++ ) {
            System.out.printf(i +". %-20s %.0f lesson %20s\n",listSubject.get(i).getSubject_name(), listSubject.get(i).getNumber_of_lesson(),listSubject.get(i).getTeacher().getName());
        }
		System.out.println("----------------------------------------------------");
    }
	
}
