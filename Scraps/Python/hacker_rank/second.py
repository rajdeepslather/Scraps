if __name__ == '__main__':
    n = int(raw_input())
    arr = map(int, raw_input().split())
    first = None
    second = None
    for i in arr:
        if first is None:
            first = i
        elif i < first:
            if (second is None) or (i > second):
                second = i
        elif i > first:
            second = first
            first = i

    print second
