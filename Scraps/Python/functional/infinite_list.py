import itertools
import datetime
import math


def factors(x):
    factor_list = []
    for i in range(1, x+1):
        if x % i == 0:
            factor_list.append(i)
    return factor_list


def is_prime(x):
    if factors(x) == [1, x]:
        return True
    else:
        return False


def xfilter(predicate, generator):
    return (x for x in generator if predicate(x))


def print_all(generator):
    try:
        while True:
            print generator.next()
    except StopIteration:
        pass


def benchmark(runnable):
    start = datetime.datetime.now()
    runnable()
    diff = datetime.datetime.now() - start
    print 'time taken ' + repr(diff)


benchmark(lambda: print_all(itertools.islice(
    xfilter(is_prime, itertools.count(1)), 500)))

# print list(itertools.islice(itertools.count(1), 100))
# print map(factors, itertools.islice(itertools.count(1), 100))
# print filter(is_prime, itertools.islice(itertools.count(1), 100))
# print filter(is_prime, itertools.count(1))

# print list(xfilter(is_prime, xrange(10)))
# print list(itertools.islice(xfilter(is_prime, itertools.count(1)), 100))
# print_all(xfilter(lambda x:x%2 == 0, xrange(10)))
