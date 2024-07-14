package abcde.classes;

public class Classroom {
    private int roomNumber;
    protected static String teacherName;
    static int globalKey = 5432;
    public static int floor = 3;
    Classroom(int r, String t){
        roomNumber = r;
        teacherName = t;
    }

}
