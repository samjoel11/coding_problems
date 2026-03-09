class Solution(object):
    def totalNQueens(self, n):
        board = [[0 for i in range(n)] for j in range(n)]
        def dia(x, y, d):
            tx, ty = x+1, y+1
            while tx<n and ty<n:
                board[tx][ty]+=d
                tx+=1
                ty+=1
            tx, ty = x-1, y-1
            while 0<=tx and 0<= ty:
                board[tx][ty]+=d
                tx-=1
                ty-=1
            tx, ty = x+1, y-1
            while tx<n and 0<= ty:
                board[tx][ty]+=d
                tx+=1
                ty-=1
            tx, ty = x-1, y+1
            while 0<=tx and ty<n:
                board[tx][ty]+=d
                tx-=1
                ty+=1

        def put(row):
            if row==n:
                return 1
            t = 0
            for j in range(n):
                if not board[row][j]:
                    for k in range(n):
                        board[row][k]+=1
                    for l in range(n):
                        board[l][j]+=1
                    dia(row, j, 1)
                    t +=put(row+1)
                    for k in range(n):
                        board[row][k]-=1
                    for l in range(n):
                        board[l][j]-=1
                    dia(row, j, -1)
            return t
        return put(0)