import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public void terminate() {
        System.out.println("Program Exited Successfully");
    }

    public void createFileOrFolder() {
        System.out.print("Enter File or Folder Name:");
        Scanner sc = new Scanner(System.in);
        File f1 = new File("C:\\Users\\DELL\\Desktop\\main\\" + sc.next());
        try {
            f1.getParentFile().mkdirs();
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileOrFolder() {
        System.out.print("Enter File or Folder Name:");
        Scanner sc = new Scanner(System.in);
        File f2 = new File("C:\\Users\\DELL\\Desktop\\main" + sc.next());
        f2.delete();
    }

    public void listFiles() {
        File[] files = new File("C:\\Users\\DELL\\Desktop\\main\\").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    public void listFilesStartsWith() {
        System.out.print("Enter a Name that a File or Folder starts with:");
        Scanner sc = new Scanner(System.in);
        String givenName = sc.next();
        File[] files = new File("C:\\Users\\DELL\\Desktop\\main\\" ). listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().startsWith(givenName)) {
                System.out.println(file.getName());
            }
        }
    }

    public void secondaryMenu() {
        System.out.print("\n\n\n1. Create a file or folder\n" + "2. Delete a file or folder\n"
                + "3. Search files starts with given name\n"
                + "4. Return to previous menu\n" + "5. Terminate the program\n" + "Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                createFileOrFolder();
                secondaryMenu();
                break;

            case 2:
                deleteFileOrFolder();
                secondaryMenu();
                break;

            case 3:
                listFilesStartsWith();
                secondaryMenu();
                break;

            case 4:
                userMenu();
                break;

            case 5:
                terminate();
                break;

            default:
                System.out.println("\n---Input correct value---");
                secondaryMenu();
                break;
        }
    }

    public void userMenu() {
        System.out.print(
                "\n\n\n1. Show all files in main\n" + "2. Perform File Operations\n" + "3. Terminate the program\n"
                        + "Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                listFiles();
                userMenu();
                break;

            case 2:
                secondaryMenu();
                break;

            case 3:
                terminate();
                break;

            default:
                System.out.println("\n---Input correct value---");
                userMenu();
                break;
        }
       
    }

    public static void main(String args[]) {
        (new File("C:\\Users\\DELL\\Desktop\\main")).mkdir();
        System.out.println("Welcome to file operation");
        Solution solution = new Solution();
        solution.userMenu();

    }
}

	

