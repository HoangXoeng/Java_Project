
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static ArrayList<String> listAccStudent = new ArrayList<String>();
    public static ArrayList<String> listAccStaff = new ArrayList<String>();
    public static ArrayList<String> listAcc = new ArrayList<String>();
    public static Scanner input = new Scanner(System.in);
    public final static File MYFILESTUDENT = new File(
            "C:\\Users\\Admin\\Documents\\GitHub\\Java_Project\\AccountStudent.txt");
    public final static File MYFILETEACHER = new File(
            "C:\\Users\\Admin\\Documents\\GitHub\\Java_Project\\AccountStaff.txt");
    // you can change your path of file.

    public static int checkAcc(String userName, int role) { // check username already exits ?

        if (role == 1) {
            listAcc = listAccStudent;
        } else {
            listAcc = listAccStaff;
        }
        for (int i = 0; i < listAcc.size(); i += 2) {
            if (userName.equalsIgnoreCase(listAcc.get(i)))
                return i;
        }
        return -1;
    }

    public static void accessFile(int role) {
        File myFile; // create myFile, it will access the file base on role
        if (role == 1) {
            myFile = MYFILESTUDENT;
            listAcc = listAccStudent;
        } else {
            myFile = MYFILETEACHER;
            listAcc = listAccStaff;
        }
        // create 2 list acc, base on role, the arrayList will store data ex. role
        // 1(Student) => arrayList store data account of student
        try {
            // create file if file not exits
            myFile.createNewFile();
            FileInputStream in = new FileInputStream(myFile); // read data file (byte)
            InputStreamReader in1 = new InputStreamReader(in, "UTF-8"); // convert data from byte to utf-8
            BufferedReader file = new BufferedReader(in1); // add data to file
            String x;
            while ((x = file.readLine()) != null) {
                listAcc.add(x);// read file and add data(user name , pass) to ArrayList
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logIn(int role) {
        input.nextLine();
        int count = 0;
        System.out.println("------------LOG IN------------");
        System.out.print("\nUser name: ");
        String userName = input.nextLine();
        while (checkAcc(userName, role) == -1) {
            count++;
            if (count == 3) {
                System.out.println("Enter wrong 3 times, switch to sing up case");
                System.out.println("Press enter to continue");
                signUp(role);
                break;
            }
            System.out.println("Account does not exist! Try again");
            System.out.print("User name: ");
            userName = input.nextLine();
        }
        if (count == 3)
            return;
        int indexPassword = checkAcc(userName, role) + 1;
        count = 0;
        System.out.print("Password: ");
        String password = input.nextLine();
        while (password.equals(listAcc.get(indexPassword)) == false) {
            count++;
            if (count == 3) {
                System.out.println("Enter wrong 3 times, switch to sing up case");
                System.out.println("Enter to continue");
                signUp(role);
                break;
            }
            System.out.println("Wrong password! Re-enter!");
            System.out.print("Password: ");
            password = input.nextLine();
        }
    }

    public static void clrscr() { // make blank console
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void signUp(int role) {
        input.nextLine();
        clrscr();
        File myFile;
        if (role == 1) {
            myFile = MYFILESTUDENT;
        } else {
            myFile = MYFILETEACHER;
        }
        System.out.println("------------SIGN UP------------");
        try {
            FileWriter writer = new FileWriter(myFile, true); // access file and allow write new linne
            BufferedWriter filein = new BufferedWriter(writer);

            System.out.print("\nUser name: ");
            String userName = input.nextLine();
            while (checkAcc(userName, role) != -1) { // check user name already exits ???
                System.out.println("This account name has already existed! Try again");
                System.out.print("User name: ");
                userName = input.nextLine();
            }
            System.out.print("Password: ");
            String password = input.nextLine();
            filein.write(userName + "\n"); // add user name to file
            filein.write(password + "\n"); // add password to file
            filein.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifiInformation(Person person, int choseModifi) {
        switch (choseModifi) {
            case 1:
                input.nextLine();
                System.out.print("Enter new name: ");
                String name = input.nextLine();
                person.setName(name);
                break;
            case 2:
                input.nextLine();
                System.out.print("Enter new phone number: ");
                String phoneNum = input.nextLine();
                person.setPhoneNumber(phoneNum);
                break;
            case 3:
                input.nextLine();
                System.out.print("Enter new age: ");
                int age = input.nextInt();
                person.setAge(age);
                break;
            case 4:
                input.nextLine();
                System.out.print("Enter new gender (1 letter): ");
                char gender = input.nextLine().charAt(0); // if user enter mone than 1 letter, App will recive firs
                                                          // letter
                person.setAge(gender);
                break;
            case 5:
                input.nextLine();
                System.out.print("Enter name of street: ");
                String street = input.nextLine();
                System.out.print("Enter house number (int)");
                int houseNumber = input.nextInt();
                person.setAddress(new Address(street, houseNumber));
                break;
            default:
                break;
        }
    }

    public static void pressEnter() {
        boolean condition;
        do {
            condition = true;
            System.out.println("Press any key to continue");
            String out = input.nextLine();
            if (out != null) {
                input.nextLine();
                condition = false;
            }

        } while (condition);
    }

    public static void studentMenthod(PNV_Student student) {
        int chose;
        System.out.println("Welcome back");
        System.out.println("List of student: ");
        PNV_Student.showStudentList();
        System.out.print("Chose your id student:\n-->");
        int id = input.nextInt();
        do {

            clrscr();
            System.out.println("Hello " + PNV_Student.getList_Student().get(id).getName());
            System.out.println("---------------------Menu---------------------");
            System.out.println("----------------------------------------------");
            System.out.println("-   1: Modifi infomation                     -");
            System.out.println("-   2: View infomation                       -");
            System.out.println("-   3: View list of subject in PNV           -");
            System.out.println("-   4: Check score                           -");
            System.out.println("-   5: Subcribe subject                      -");
            System.out.println("-   6: Exit                                  -");
            System.out.println("----------------------------------------------");
            System.out.print("Chose funtion:\n-->");
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    clrscr();
                    int choseModifi;
                    do {
                        System.out.println("---------------------Menu---------------------");
                        System.out.println("----------------------------------------------");
                        System.out.println("-       Choose your infor you want modifi:    -");
                        System.out.println("-       1. Modifi name                        -");
                        System.out.println("-       2. Modifi phone number                -");
                        System.out.println("-       3. Modifi age                         -");
                        System.out.println("-       4. Modifi gender                      -");
                        System.out.println("-       5. Modifi address                     -");
                        System.out.println("-       6. Exit                               -");
                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter your chose\n-->");
                        choseModifi = input.nextInt();
                        modifiInformation(PNV_Student.getList_Student().get(id), choseModifi);
                    } while (choseModifi != 6);
                    break;
                case 2:
                    clrscr();
                    PNV_Student.getList_Student().get(id).showInfor();
                    pressEnter();
                    break;
                case 3:
                    clrscr();
                    Subject.showSubjectList();
                    pressEnter();
                    break;
                case 4:
                    clrscr();
                    StudyPerform.showScoreOfStudent(PNV_Student.getList_Student().get(id));
                    pressEnter();
                    break;
                case 5:
                    clrscr();
                    Subject.showSubjectList();
                    System.out.print("Chose subject you want to subcribe\n-->");
                    int choseSubject = input.nextInt();
                    StudyPerform.addStudyPerformList(PNV_Student.getList_Student().get(id),
                            Subject.getListSubject().get(choseSubject));
                    break;
                default:
                    break;
            }
        } while (chose != 6);
    }

    public static void teacherMethod(PNV_Teacher teacher) {
        int chose;
        System.out.println("Welcome back");
        System.out.println("List of teacher: ");
        PNV_Teacher.showTeacherList();
        System.out.println("Chose your id teacher:");
        int id = input.nextInt();
        do {
            System.out.println("Chose funtion");
            System.out.println("1: View information of teacher");
            System.out.println("2: Modifi information");
            System.out.println("3: View list of student");
            System.out.println("4: Modifi score");
            System.out.println("5: View Student score");
            System.out.println("6: Exit ");
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("--------------Infor--------------");
                    PNV_Teacher.getList_Teacher().get(id).showInfor();
                    break;
                case 2:
                    int choseModifi;
                    do {
                        System.out.println("Choose your infor you want modifi: ");
                        System.out.println("1. Modifi name");
                        System.out.println("2. Modifi phone number");
                        System.out.println("3. Modifi age");
                        System.out.println("4. Modifi gender");
                        System.out.println("5. Modifi address");
                        System.out.println("6. Exit");
                        choseModifi = input.nextInt();
                        modifiInformation(PNV_Teacher.getList_Teacher().get(id), choseModifi);
                    } while (choseModifi != 6);
                    break;
                case 3:
                    System.out.println("List of student: ");
                    PNV_Student.showStudentList();
                    break;
                case 4:
                    ArrayList<StudyPerform> listStudentTeachByTeacher = new ArrayList<StudyPerform>();
                    listStudentTeachByTeacher = StudyPerform.showStudyPerTeachBy(PNV_Teacher.getList_Teacher().get(id));
                    int choseStudentModifiScore;
                    System.out.println("_______________LIST SCORE______________");
                    for (int i = 0; i < listStudentTeachByTeacher.size(); i++) {
                        System.out.println(i + " " + listStudentTeachByTeacher.get(i).getStudent().getName());
                    }
                    System.out.println("Enter id student you want to modifi score");
                    choseStudentModifiScore = input.nextInt();
                    System.out.println("The student have soce is: "
                            + listStudentTeachByTeacher.get(choseStudentModifiScore).getScore());
                    System.out.print("enter new score: ");
                    int score = input.nextInt();
                    listStudentTeachByTeacher.get(choseStudentModifiScore).setScore(score);
                    System.out.println("Update successful");
                    break;
                case 5:
                    listStudentTeachByTeacher = StudyPerform.showStudyPerTeachBy(PNV_Teacher.getList_Teacher().get(id));
                    for (int i = 0; i < listStudentTeachByTeacher.size(); i++) {
                        System.out.println(i + " " + listStudentTeachByTeacher.get(i).getStudent().getName() + "  "
                                + listStudentTeachByTeacher.get(i).getScore());
                    }

                    break;
                default:
                    break;
            }
        } while (chose != 6);
    }

    public static void main(String[] args) {
        runData();// run data for program, you can understand this funtion will create object for
                  // this program
        PNV_Student pnv_Student = new PNV_Student();
        PNV_Teacher pnv_Teacher = new PNV_Teacher();
        System.out.println("====================================");
        System.out.println("=       Welcome to application     =");
        System.out.println("=         Choose your role         =");
        System.out.println("= 1. Student                       =");
        System.out.println("= 2. Teacher                       =");
        System.out.println("= 3. Exit                          =");
        System.out.println("====================================");
        System.out.print("Enter your chose\n-->");
        int choose = input.nextInt();

        do {
            clrscr();
            switch (choose) {
                case 1: 
                    
                    int choseTypeLogin;
                    do {
                        accessFile(1);// prepare list of account
                        clrscr();
                        System.out.println("Are you already have a accout");
                        System.out.println("1 Yes (Log in)");
                        System.out.println("2. No (Sign up)");
                        System.out.println("3. Exit");
                        System.out.print("-->");
                        choseTypeLogin = input.nextInt();
                        switch (choseTypeLogin) {
                            case 1:
                                clrscr();
                                logIn(1);
                                clrscr();
                                studentMenthod(pnv_Student);
                                break;
                            case 2:
                                clrscr();
                                signUp(1);
                                break;
                            default:
                                break;
                        }
                    } while (choseTypeLogin != 3);
                    break;    
                case 2: {
                    accessFile(2);// prepare list of account
                    choseTypeLogin = 0;
                    do {
                        accessFile(1);// prepare list of account
                        clrscr();
                        System.out.println("Are you already have a accout");
                        System.out.println("1 Yes (Log in)");
                        System.out.println("2. No (Sign up)");
                        System.out.println("3. Exit");
                        System.out.print("-->");
                        choseTypeLogin = input.nextInt();
                        switch (choseTypeLogin) {
                            case 1:
                                clrscr();
                                logIn(2);
                                clrscr();
                                teacherMethod(pnv_Teacher);
                            case 2:
                                clrscr();
                                signUp(2);
                                break;
                            default:
                                break;
                        }
                    } while (choseTypeLogin != 3);
                    break;    
                }
            }
        } while (choose != 3);
        input.close();
    }

    public static void runData() {
        Address ad0 = new Address("To Hien Thanh", 13);
        Address ad1 = new Address("Phan Boi Chau", 13);
        Address ad2 = new Address("Ho Chi Minh", 13);
        Address ad3 = new Address("To Hien Thanh", 13);
        Address ad4 = new Address("To Hien Thanh", 13);
        Address ad5 = new Address("To Hien Thanh", 13);

        PNV_Student st1 = new PNV_Student("Ky Ba", "012312412", 18, 'f', ad0, "PNV26A");
        PNV_Student st2 = new PNV_Student("Thanh Binh", "012312412", 18, 'f', ad1, "PNV26A");
        PNV_Student st3 = new PNV_Student("Minh Hoang", "012312412", 18, 'f', ad2, "PNV26A");
        PNV_Student st4 = new PNV_Student("Thai Duong", "012312412", 18, 'f', ad3, "PNV26B");
        PNV_Student st5 = new PNV_Student("Xuan Nguyen", "012312412", 18, 'f', ad4, "PNV26B");
        PNV_Student st6 = new PNV_Student("Duyen Ha", "012312412", 18, 'f', ad5, "PNV26B");

        PNV_Teacher tc1 = new PNV_Teacher("Le Thi Hong Thuy", "012312412", 20, 'f', ad0, 19000000);
        PNV_Teacher tc2 = new PNV_Teacher("Le Nguyen Phuc Nhan", "012312412", 20, 'f', ad0, 20000000);
        PNV_Teacher tc3 = new PNV_Teacher("Ho Thi Ngoc Nhai", "012312412", 20, 'f', ad0, 18500000);

        Subject sb1 = new Subject("Python", 90, tc1);
        Subject sb2 = new Subject("Java OOP", 90, tc1);
        Subject sb3 = new Subject("GE1", 120, tc2);
        Subject sb4 = new Subject("GE2", 120, tc2);
        Subject sb5 = new Subject("PLT1", 90, tc3);
        Subject sb6 = new Subject("PLT2", 45, tc3);

        StudyPerform stpm1 = new StudyPerform(st1, sb1, 8);
        StudyPerform stpm2 = new StudyPerform(st2, sb1, 8);
        StudyPerform stpm3 = new StudyPerform(st3, sb1, 8);
        StudyPerform stpm4 = new StudyPerform(st4, sb1, 8);
        StudyPerform stpm5 = new StudyPerform(st5, sb1, 8);
        StudyPerform stpm6 = new StudyPerform(st6, sb1, 8);
        StudyPerform stpm7 = new StudyPerform(st1, sb4, 8);
        StudyPerform stpm8 = new StudyPerform(st2, sb4, 8);
        StudyPerform stpm9 = new StudyPerform(st3, sb4, 8);
        StudyPerform stpm10 = new StudyPerform(st4, sb4, 8);
        StudyPerform stpm11 = new StudyPerform(st5, sb4, 8);
        StudyPerform stpm12 = new StudyPerform(st6, sb4, 8);
    }
}
