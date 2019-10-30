def avg(list):
    int_list = map(float, list)
    return sum(int_list)/len(int_list)


def print_avg(student_marks, query_name):
    print "{:.2f}".format(
        round(next(
            avg(marks)
            for name, marks in student_marks.iteritems()
            if name == query_name), 2))


def main():
    student_marks = {
        'Krishna': [67.0, 68.0, 69.0],
        'Malika': [52.0, 56.0, 60.0],
        'Arjun': [70.0, 98.0, 63.0]
    }
    query_name = 'Malika'
    print_avg(student_marks, query_name)


if __name__ == '__main__':
    main()
