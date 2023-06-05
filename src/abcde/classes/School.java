package abcde.classes;

import abcde.classes.Classroom;

public class School {

    public static void main(String[] args) {
        System.out.println(Classroom.globalKey);
        Classroom room = new Classroom(101, "Mrs. Anderson");
        //System.out.println(room.roomNumber); // DOES NOT COMPILE
        System.out.println(Classroom.floor);
        System.out.println(Classroom.teacherName);

    }
}
