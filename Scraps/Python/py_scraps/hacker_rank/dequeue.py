from collections import deque

choices = {
    'append': lambda dq: dq.append,
    'pop': lambda dq: dq.pop,
    'appendleft': lambda dq: dq.appendleft,
    'popleft': lambda dq: dq.popleft,
}

if __name__ == '__main__':
    dq = deque()
    N = int(raw_input())
    for i in range(N):
        inputs = raw_input().strip().split(" ")

        if len(inputs) == 1:
            choices[inputs[0]](dq)()
        elif len(inputs) == 2:
            choices[inputs[0]](dq)(int(inputs[1]))
    print ' '.join(map(str, dq))
