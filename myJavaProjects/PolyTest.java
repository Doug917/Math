import math.computation.algebra.*;

class PolyTest{


    public static void main(String[] args){

        Polynomial p1 = new Polynomial(1.0,2.0);
        Polynomial p2 = new Polynomial(0.0,1.0);

        Polynomial p = Polynomial.Multiply(p1, p2);

        p1.Display();
        p2.Display();
        p.Display();

        p1.addTerm(2.0,5);
        p1.Add(p2);

        p1.Display();

        p1.Derivative();

        p1.Display();

        
    }
}