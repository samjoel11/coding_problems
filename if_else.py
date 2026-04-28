if __name__ == '__main__':
    n = int(input().strip())

    if n % 2 != 0:
        # If n is odd
        print("Weird")
    else:
        # If n is even
        if 2 <= n <= 5:
            print("Not Weird")
        elif 6 <= n <= 20:
            print("Weird")
        elif n > 20:
            print("Not Weird")
