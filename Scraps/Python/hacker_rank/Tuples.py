# from __builtins__ import hash

if __name__ == '__main__':
    n = int(raw_input())
    integer_list = map(int, raw_input().split())
    # print integer_list
    # print tuple(integer_list)
    print hash(tuple(integer_list))
