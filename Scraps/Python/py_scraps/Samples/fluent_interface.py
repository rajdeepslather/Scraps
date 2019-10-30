class StringBuilder(object):
    """Fluent Interface in Python"""

    def __init__(self, init_string=""):
        self.string_value = init_string

    def append(self, append_string):
        self.string_value += append_string
        return self

    def __repr__(self):
        return self.string_value

    def __str__(self):
        return self.string_value


def main():
    print StringBuilder("Hello")\
        .append(" ")\
        .append("World")\
        .append("!")

    print StringBuilder()\
        .append("Hello")\
        .append(" ")\
        .append("World")\
        .append("!")


if __name__ == '__main__':
    main()
