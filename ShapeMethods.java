
abstract class Shape{

    int numVertices;
    int numEdges;
    abstract double area();
    abstract double perimeter();

}

class Circle extends Shape{

    final int numVertices = 0;
    final int numEdges = 1;
    private double radius;

    public Circle(double r){
        radius = r;
    }
    double area(){
        return Math.PI * radius * radius;
    }

    double perimeter(){
        return 2 * Math.PI * radius;
    }

    //Setter for radius.
    void setRadius(double r){
        radius = r;
    }

    //Getter for radius
    double getRadius(){
        return radius;
    }

}

class Triangle extends Shape{

    final int numVertices = 3;
    final int numEdges = 3;
    private double[] sideLengths = {0,0,0};

    public Triangle(double s1, double s2, double s3) throws Exception{

        if (s1+s2<s3 || s1+s3<s2 || s2+s3<s1){
            throw new Exception("Invalid side lengths: instance not created");
        }
        sideLengths[0] = s1;
        sideLengths[1] = s2;
        sideLengths[2] = s3;
    }

    double area(){
        double s = 0.5 * (sideLengths[0]+sideLengths[1]+sideLengths[2]);
        return Math.sqrt(s*(s-sideLengths[0])*(s-sideLengths[1])*(s-sideLengths[2]));
    }

    double perimeter(){
        return sideLengths[0]+sideLengths[1]+sideLengths[2];
    }

    //Setter for sidelengths.
    void setSides(double s1, double s2, double s3) throws Exception{
        if (s1+s2<s3 || s1+s3<s2 || s2+s3<s1){
            throw new Exception("Invalid side lengths: instance not created");
        }
        sideLengths[0] = s1;
        sideLengths[1] = s2;
        sideLengths[2] = s3;
    }

    //Getter for sidelengths.
    void getSides(){
        for (double s:sideLengths){
            System.out.println(s);
        }
    }
}

class ShapeMethods{

    public static void main(String[] args) throws Exception{
        Circle myCircle = new Circle(2.5);

        double myarea = myCircle.area();
        double myperimeter = myCircle.perimeter();

        System.out.println("Area: "+ myarea);
        System.out.println("Perimeter: "+ myperimeter);
        System.out.println("Number of vertices: "+ myCircle.numVertices);
        System.out.println("Number of Edges: "+ myCircle.numEdges);

        myCircle.setRadius(1.0);

        System.out.println("New Area: "+ myCircle.area());
        System.out.println("New perimeter: "+ myCircle.perimeter());

        Triangle myTriangle = new Triangle(3,5,7);
        System.out.println("Area: "+ myTriangle.area());
        System.out.println("Perimeter: "+ myTriangle.perimeter());
        System.out.println("Sides Lengths:");
        myTriangle.getSides();

        myTriangle.setSides(1,2,5);
        System.out.println("New Area: "+ myTriangle.area());
        System.out.println("New perimeter: "+ myTriangle.perimeter());
        
        
    }
}
