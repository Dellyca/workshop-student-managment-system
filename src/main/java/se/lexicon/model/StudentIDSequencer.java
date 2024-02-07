package se.lexicon.model;

public class StudentIDSequencer {
    private static int id_counter = 0;

    public static int getStudentId(){
        return ++id_counter;
    }
}
