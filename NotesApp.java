package Task_4;
import java.io.*;
import java.util.*;

public class NotesApp {
    private static final String File_Name = "notes.txt";
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Notes Application ====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch(choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting the notes application.");
                    break;
                default:
                    System.out.println("Invaild choice. Please try again.");
                    break;
            }
        } while(choice != 3);
        scanner.close();
    }

    private static void addNote(Scanner scanner){
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(File_Name, true)){
            writer.write(note + System.lineSeparator());
            System.out.println("Note added successfully.");
        }
        catch(IOException e){
            System.out.println("Error saving note: " + e.getMessage());
        }
    }

    private static void viewNotes(){
        File file = new File(File_Name);

        if(!file.exists()) {
            System.out.println("No notes found.");
            return;
        }

       System.out.println("\n--- Your Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(File_Name))){
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        }

        catch(IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }

    }

    
}

