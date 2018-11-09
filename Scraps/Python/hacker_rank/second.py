if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 7, 3, 4, 5, 3]

    print sorted(set(arr))[-2]

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
