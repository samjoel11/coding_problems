from itertools import product

# Read K and M from the first line
K, M = map(int, input().split())

# Read K lines of lists, ignoring the first integer (size of the list)
# We store the square of each element to optimize the calculation later
lists = []
for _ in range(K):
    # input().split()[1:] skips the first value (number of elements in the list)
    lists.append([int(x)**2 for x in input().split()[1:]])

# Generate all possible cartesian products (one element from each list)
# For each combination, sum the pre-calculated squares and apply modulo M
combinations = product(*lists)
results = [sum(combo) % M for combo in combinations]

# Print the maximum result found
print(max(results))
