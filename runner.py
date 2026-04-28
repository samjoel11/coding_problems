if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    
    # set(arr) removes duplicates
    # sorted() returns a list in ascending order
    # [-2] accesses the second-to-last element
    print(sorted(set(arr))[-2])
