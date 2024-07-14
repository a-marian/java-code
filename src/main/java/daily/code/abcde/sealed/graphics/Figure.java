package abcde.sealed.graphics;

// the permit clause has been omitted as its permitted classes have been defined
//in the same file
public sealed class Figure {
}


non-sealed class Polygon extends Figure{
    Polygon(){
        System.out.println("""
                These two are other classifications of a polygon wherein regular polygons both have sides of equal lengths \n
                and interior angles of equal measurement. The most common examples of a regular polygon include an equilateral \n
                triangle, a square, a pentagon, and hexagons, and octagons. Irregular polygons, on the other hand, are figures
                which do not satisfy both conditions to be considered as a regular polygon.
                """);
    }

}

sealed class Triangle extends Figure {}

final class Isosceles extends  Triangle{
    public Isosceles(){
        System.out.println("It is kind of triangle that exactly has two sides of equal length");
    }
}

final class Scalene extends Triangle{
    private Scalene(){
        System.out.println("It is a kind of triagle that has no sides of equal length");
    }
}

final class Right extends Triangle {
    private void initRightTriangle(){
        System.out.println(""" 
                A triangle that has 90-degree interior angle. The side directly opposite of this angle is \n
                called the hypotenuse, which i also the longest side of a right triangle.
                """);
    }
}



