import java.util.Scanner;

public class BookRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = input.next();
        System.out.print("Enter the number of pages in the book: ");
        int pages = input.nextInt();
        System.out.print("Is this book a textbook? (yes or no): ");
        String textCheck = input.next();
        
        //textbook loop
         if (textCheck.equals("yes")) {
            System.out.print("Enter the grade level of the textbook: ");
            int gradeLevel = input.nextInt();
            if (gradeLevel < 1 || gradeLevel > 12){
                throw new IllegalArgumentException("Grade level must be between 1 and 12.");
            }
            else {
            Textbook textbook = new Textbook(gradeLevel, pages, title);
            System.out.println("Title: " + textbook.getTitle());
            System.out.println("Pages: " + textbook.getPages());
            System.out.println("Grade Level: " + textbook.getGradeLevel());
            }
         }
        //novel loop
         else {
            Novel novel = new Novel(pages, title);
            System.out.println("Title: " + novel.getTitle());
            System.out.println("Pages: " + novel.getPages());
         }
         System.out.println("Enter another book? (yes or no): ");
            String another = input.next();
            if (another.equals("yes")) {
                main(args);
            } 
 }
}