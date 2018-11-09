from __future__ import print_function
import sys
import threading


def safe_print(msg):
    return sys.stdout.write("%s\n" % msg)


def worker(num):
    # print 'Worker: %s \n' % num
    msg = 'Worker: ' + repr(num)
    safe_print(msg)


def main():
    threads = []
    for i in range(10):
        thread = threading.Thread(target=worker, args=(i,))
        threads.append(thread)
        thread.start()
        # worker(i)

    for thread in threads:
        thread.join()


if __name__ == '__main__':
    main()
