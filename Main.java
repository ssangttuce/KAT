package KAT;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        lecture_classification subjectList = new lecture_classification();
        TT_gen tt = new TT_gen();
        ui.menu(subjectList, tt);
    }
}