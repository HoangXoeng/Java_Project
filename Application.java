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

    static ArrayList<String> listAcc = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);
    final static File myFile = new File("C:\\Users\\Admin\\Documents\\GitHub\\Java_Projects\\Account.txt");

    // check username already exits ?
    static int checkAcc(String userName) {
        for (int i = 0; i < listAcc.size(); i += 2) {
            if (userName.equalsIgnoreCase(listAcc.get(i)))
                return i;
        }
        return -1;
    }

    static void accessFile() {
        // create or access path of file
        // read file and add data(user name , pass) to ArrayList
        try {
            // create file if file not exits
            myFile.createNewFile();

            FileInputStream in = new FileInputStream(myFile); // read data file (byte)
            InputStreamReader in1 = new InputStreamReader(in, "UTF-8"); // convert data from byte to utf-8
            BufferedReader file = new BufferedReader(in1); // add data to file

            String x;
            while ((x = file.readLine()) != null) {
                listAcc.add(x);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void logIn() {

        int count = 0;
        if (input.hasNextLine())
            input.nextLine();
        System.out.println("_______________LOG IN_______________");
        System.out.print("\nUser name: ");
        String userName = input.nextLine();
        while (checkAcc(userName) == -1) {
            count++;
            if (count == 3) {
                System.out.println("Enter incorrectly 3 times, automatically switch to the sign up item");
                System.out.println("Enter to continue");
                signUp();
                break;
            }
            System.out.println("Account does not exist! Re-enter!");
            System.out.print("User name: ");
            userName = input.nextLine();
        }
        if (count == 3)
            return;
        int indexPassword = checkAcc(userName) + 1;
        count = 0;
        System.out.print("Password: ");
        String password = input.nextLine();
        while (password.equals(listAcc.get(indexPassword)) == false) {
            count++;
            if (count == 3) {
                System.out.println("Enter incorrectly 3 times, automatically switch to the sign up item");
                System.out.println("Enter to continue");
                signUp();
                break;
            }
            System.out.println("Wrong password! Re-enter!");
            System.out.print("Password: ");
            password = input.nextLine();
        }
    }

    static void clean() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    static void signUp() {
        if (input.hasNextLine())
            input.nextLine();
        clean();
        System.out.println("_______________SIGN UP_______________");
        try {
            FileWriter writer = new FileWriter(myFile, true);
            BufferedWriter filein = new BufferedWriter(writer);

            System.out.print("\nUser name: ");
            String userName = input.nextLine();
            while (checkAcc(userName) != -1) {
                System.out.println("This name account has already existed! Re-enter!");
                System.out.print("User name: ");
                userName = input.nextLine();
            }
            System.out.print("Password: ");
            String password = input.nextLine();
            filein.write(userName + "\n");
            filein.write(password + "\n");
            filein.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        accessFile();
        logIn();
        // signUp();
    }

}
