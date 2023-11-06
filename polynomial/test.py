from polynomial import Polynomial

p1 = Polynomial([1, 2, 3])    #1+2x+x^2
p2 = Polynomial([1, 0, 2])    #1+2x^2

p3 = p1 + p2
p4 = p1 * p2
print(p3.coeffs, p4.coeffs)