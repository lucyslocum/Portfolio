public class Textbook extends Book {
    private int gradeLevel;

    public Textbook(int gradeLevel, int pages, String title) {
        super(pages, title);
        this.gradeLevel = gradeLevel;
    }
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    public int getGradeLevel() {
        return gradeLevel;
    }
}    

