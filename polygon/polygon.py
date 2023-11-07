class Polygon:

    def __init__(self, v):

        self.vertices = v
        self.num_vertices = len(v)

        
    def area(self):

        #Compute area with shoelace formula.
        x = [v[0] for v in self.vertices]
        y = [v[1] for v in self.vertices]
        area = 0

        for i in range(self.num_vertices-1):
            area += (x[i]*y[i+1] - x[i+1]*y[i])

        area += (x[self.num_vertices-1]*y[0] - x[0]*y[self.num_vertices-1])
                     
        return 0.5 * area
    
    def perimeter(self):

        x = [v[0] for v in self.vertices]
        y = [v[1] for v in self.vertices]
        perimeter = 0

        for i in range(self.num_vertices-1):
            perimeter += ((x[i+1]-x[i])**2 + (y[i+1]-y[i])**2)**0.5

        perimeter += ((x[self.num_vertices-1]-x[0])**2 + (y[self.num_vertices-1]-y[0])**2)**0.5

        return perimeter