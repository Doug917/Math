import java.util.*;

class Polynomial{

    ArrayList<Double> coefficients = new ArrayList<Double>();
    int degree = 0;

    //Constructor.
    public Polynomial(double ...c){

        for (double x:c){
            this.coefficients.add(x);
        }

        degree = coefficients.size()-1;

    }

    //Create additional term
    void addTerm(double coeff, int exponent){

        while (exponent > degree){
            //add element to end of current coefficients list.
            coefficients.add(0.0);
            degree = coefficients.size()-1;
        }
        
        coefficients.set(exponent, coefficients.get(exponent)+coeff);

    }

    void Add(Polynomial p){

        while (this.degree < p.degree){
            this.addTerm(0.0, this.degree+1);
        }

        for(int i=0;i<=p.degree;i++){
            this.addTerm(p.coefficients.get(i), i);
        }
    }

    static Polynomial Multiply(Polynomial p, Polynomial q){

        int pDegree = p.degree;
        int qDegree = q.degree;
        int totalDegree = pDegree + qDegree;

        Polynomial prod = new Polynomial(0.0);
        while (prod.degree < totalDegree){
            prod.addTerm(0.0, prod.degree+1);
        }

        while (p.degree < totalDegree){
            p.addTerm(0.0, p.degree+1);
        }

        while (q.degree < totalDegree){
            q.addTerm(0.0, q.degree+1);
        }

        for (int i=0;i<=pDegree;i++){
            for (int j=0;j<=qDegree;j++){
                prod.coefficients.set(i+j, prod.coefficients.get(i+j) + (p.coefficients.get(i) * q.coefficients.get(j)));
            }
        }

        return prod;
    }

    
}

class PolynomialExamples{

    public static void main(String[] args){

        //Create a polynomial
        Polynomial p1 = new Polynomial(1.0,2.0,3.0);
        Polynomial p2 = new Polynomial(-2.5,3,7.8,8.6);

        //Print degrees
        System.out.println(p1.degree+" "+p2.degree);

        //add terms
        p1.addTerm(5.0, 7);
        p2.addTerm(1.0, 0);

        System.out.println("----------p1----------");
        for (int i=0;i<=p1.degree;i++){
            System.out.println(p1.coefficients.get(i));
        }

        System.out.println("----------p2---------");
        for (int i=0;i<=p2.degree;i++){
            System.out.println(p2.coefficients.get(i));
        }

        //add two together
        p1.Add(p2); //p1 only is updated.

        System.out.println("----------p1+p2----------");
        for (int i=0;i<=p1.degree;i++){
            System.out.println(p1.coefficients.get(i));
        }

        System.out.println("----------p1----------");
        
        for (int i=0;i<=p1.degree;i++){
            System.out.println(p1.coefficients.get(i));
        }

        System.out.println("----------p2----------");
        for (int i=0;i<=p2.degree;i++){
            System.out.println(p2.coefficients.get(i));
        }

        Polynomial prod = Polynomial.Multiply(p1, p2);    //p1 is updated; p2 is padded with zeros, and then truncated back.

        System.out.println("----------p1*p2----------");
        
        for (int i=0;i<=prod.degree;i++){
            System.out.println(prod.coefficients.get(i));
        }


    }
}
