import itertools


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


print list(itertools.islice(itertools.count(1), 100))
print map(factors, itertools.islice(itertools.count(1), 100))
print filter(is_prime, itertools.islice(itertools.count(1), 100))
print filter(is_prime, itertools.count(1))

print list(xfilter(is_prime, xrange(10)))
print list(itertools.islice(xfilter(is_prime, itertools.count(1)), 100))
