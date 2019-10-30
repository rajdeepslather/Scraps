import math
from sklearn.metrics.pairwise import cosine_similarity

# 1
math.sqrt(1 + 2 ** 2 + 10 ** 2 + 5 ** 2 + 3 ** 2)

d1 = [[10, 0, 0, 5, 0]]
d2 = [[1, 4, 0, 5, 3]]
d3 = [[0, 2, 10, 5, 3]]

baby = [[1, 0, 0, 0, 0]]

# 2
x0c1 = 15 + 25 + 10 + 20
x0c2 = 0 + 10 + 5 + 25

x1c1 = 15 + 0 + 0 + 15
x1c2 = 0 + 25 + 35 + 0

total = x0c1 + x0c2 + x1c1 + x1c2

