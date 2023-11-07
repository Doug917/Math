class Polynomial:

    def __init__(self, coeffs):

        self.coeffs = coeffs
        self.degree = len(coeffs) - 1
    
    def power_coeff(self, exponent):

        try:
            return self.coeffs[exponent]
        except IndexError:
            print(f"Polynomial degree {self.degree} is less than requested exponent coefficient.")

    def eval(self, n):

        result = 0
        for i in range(self.degree+1):
            result += self.coeffs[i] * n ** i

        return result

    def display(self):

        poly_str = ''
        for i in range(self.degree+1):
            poly_str += f"{self.coeffs[i]}*x^{i} + "


        return poly_str[:-2]

    def __mul__(self, p):

        product_polynomial = [0] * (self.degree + p.degree + 1)

        for i in range(self.degree + 1):
            for j in range(p.degree + 1):
                product_polynomial[i + j] += self.coeffs[i] * p.coeffs[j]

        return Polynomial(product_polynomial)
    
    def __add__(self, p):

        sum_polynomial = [0] * (self.degree + 1)
        for i in range(self.degree+1):
            sum_polynomial[i] = self.coeffs[i] + p.coeffs[i]

        return Polynomial(sum_polynomial)
    
    def derivative(self):

        d_poly = [0] * (self.degree)
        for i in range(self.degree):
            d_poly[i] = (i+1) * self.coeffs[i+1]

        return Polynomial(d_poly)
