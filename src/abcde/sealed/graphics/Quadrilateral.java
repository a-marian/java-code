package abcde.sealed.graphics;


public sealed class Quadrilateral extends Shape permits Rectangle, Kite, Square {
    public double length, width;
    Quadrilateral(){
        System.out.println("""
                Quadrilaterals are polygons that have exactly four sides and four corners. \n
                 Quadrilaterals are divided into two major types namely, simple and complex.
                """);
    }

    public void drawTrapezium(){
        System.out.println("""
                A quadrilateral that has no sides that are parallel with each other
                """);
    }
    private static void drawTrapezoid(){
        System.out.println("A quadrilateral that has base angles of equal value");
    }
    public void drawRhombus(){
        drawTrapezoid();
        System.out.println("A quadrilateral with two pairs of parallel sides");
    }
}