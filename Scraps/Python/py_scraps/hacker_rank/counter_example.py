from collections import Counter

X = int(raw_input())
shoes = Counter(map(int, raw_input().strip().split()))
N = int(raw_input())
total = 0
for i in range(N):
    shoe_size, price = map(int, raw_input().strip().split())
    if shoes[shoe_size]:
        shoes[shoe_size] -= 1
        total += price
print total
