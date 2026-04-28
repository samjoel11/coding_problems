def is_leap(year):
    # Returns True if conditions are met, otherwise False
    return (year % 4 == 0) and (year % 100 != 0 or year % 400 == 0)

year = int(input())
print(is_leap(year))
