from SumUp import SumUp

import time

t1= time.time()

hand = ["0","0","1","3","3","5","6","8","8","9"]
sums = SumUp(hand)

sums.max_sum_fast()
t2 = time.time()
total_time = t2 - t1
print(f"Elapsed Time: {total_time}")