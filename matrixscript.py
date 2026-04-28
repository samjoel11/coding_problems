import re

# Read dimensions
n, m = map(int, input().split())

# Read the matrix rows
matrix = [input() for _ in range(n)]

# Decode by reading columns (transposing the matrix)
decoded_string = "".join([matrix[row][col] for col in range(m) for row in range(n)])

# Regex explanation:
# (?<=\w) - Positive lookbehind: preceded by an alphanumeric character
# [^\w]+  - One or more non-alphanumeric characters
# (?=\w)  - Positive lookahead: followed by an alphanumeric character
result = re.sub(r'(?<=\w)([^\w]+)(?=\w)', ' ', decoded_string)

print(result)
