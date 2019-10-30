if __name__ == '__main__':
    n = int(raw_input())
    marksheet = [[raw_input(), float(raw_input())] for _ in range(n)]

    second_lowest = sorted(set([marks for name, marks in marksheet]))[1]

    print '\n'.join(
        sorted([name for name, marks in marksheet if marks == second_lowest]))
