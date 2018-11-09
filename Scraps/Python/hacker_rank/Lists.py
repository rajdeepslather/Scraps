from __future__ import print_function


def print_test(ls):
    return lambda: print(ls)


choices = {'insert': lambda ls: ls.insert,
           'print': print_test,
           'remove': lambda ls: ls.remove,
           'append': lambda ls: ls.append,
           'sort': lambda ls: ls.sort,
           'pop': lambda ls: ls.pop,
           'reverse': lambda ls: ls.reverse
           }

if __name__ == '__main__':
    ls = []
    N = int(raw_input())
    for i in range(N):
        inputs = raw_input().strip().split(" ")

        if len(inputs) == 1:
            choices[inputs[0]](ls)()
        elif len(inputs) == 2:
            choices[inputs[0]](ls)(int(inputs[1]))
        elif len(inputs) == 3:
            choices[inputs[0]](ls)(int(inputs[1]), int(inputs[2]))
