package math.computation.algebra;

import java.util.*;

public class Polynomial{

    ArrayList<Double> coefficients = new ArrayList<Double>();
    int degree = 0;

    //Constructor.
    public Polynomial(double ...c){

        for (double x:c){
            coefficients.add(x);
        }

        this.Reduce();

    }

    //Eliminate spurious zero-terms if needed and re-calculate degree.
    public void Reduce(){

        //Allow for a zero polynomial by checking for size.
        if (coefficients.size() == 1){
            return;
        }

        if (coefficients.get(coefficients.size()-1) == 0){ //if highest-order tem is zero, take it out.
            coefficients.remove(coefficients.size()-1);
        }

        degree = coefficients.size()-1;

    }

    //Print polynomial to console.
    public void Display(){

        StringBuilder s = new StringBuilder();
        String sp;
        int i = 0;
        for (double a:coefficients){
            s.append(a+"x^"+i+" ");
            i+=1;
        }
        sp = s.toString();
        System.out.println(sp.substring(0,sp.length()-1));
    }

    //Create additional term.
    public void addTerm(double coeff, int exponent){

        while (exponent > degree){
            //add element to end of current coefficients list.
            coefficients.add(0.0);
            degree = coefficients.size()-1;
        }
        
        coefficients.set(exponent, coefficients.get(exponent)+coeff);
        //Because of how polynomials are added and multiplied,
        //we don't want to reduce after adding a term.

    }

    //Add p to this polynomial.
    public void Add(Polynomial p){

        while (this.degree < p.degree){
            this.addTerm(0.0, this.degree+1);
        }

        for(int i=0;i<=p.degree;i++){
            this.addTerm(p.coefficients.get(i), i);
        }

        //Reduce is only performed after addition of terms is done.
        this.Reduce();

    }

    //Differentiate this polynomial.
    public void Derivative(){

        // update coefficients.
        coefficients.set(0, 0.0);
        for (int i=1;i<coefficients.size();i++){
            coefficients.set(i-1, coefficients.get(i) * (i));
        }

        coefficients.remove(coefficients.size()-1);
        this.Reduce();

    }

    //Return the product of polynomials p and q.
    public static Polynomial Multiply(Polynomial p, Polynomial q){

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

        p.Reduce();
        q.Reduce();
        prod.Reduce();

        return prod;
    }

    
}