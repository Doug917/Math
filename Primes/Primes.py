class Primes:
    
    def __init__(self):
        #no arguments required to create instance of Primes object.
        #only methods require input integer.
        pass
    
    #return list of primes less than or equal to (if n is prime) n.
    #uses seive of Eratosthenes.
    def prime_list(self, n):
        start_list = set([i for i in range(1,n+1)])
        U_bound = int(n**0.5)+1
        for i in range(2,U_bound):
            for j in range(2,n//i+1):
                start_list.discard(i*j)
                
        start_list.remove(1)
        
        return list(start_list)
    
    #test if n is prime.
    def isprime(self, n):
        #create list of primes less than sqrt(n).
        truth_val = True
        test_list = self.prime_list(int(n**0.5))
        for num in test_list:
            if n%num == 0:
                truth_val = False
        
        return truth_val
    
