# -*- coding: utf-8 -*-
import pandas as pd

mat1 = [[1,2,3], [4,5,6], [7,8,9]]
mat2 = [[1,2,3], [14,15,16], [17,8,12]]
print(type(mat1))
result = [[0 for i in range(len(mat1))] for j in range(len(mat2))] # list comprehension
# result = [[0]*len(df1)]*len(df2)  another way to initialize array but be careful when printing 2D array!
for mat1_r in range(len(mat1)): # rows of matrix 1
    for mat2_c in range(0, len(mat2)):  # columns of matrix 2
        sum = 0;
        for mat2_r in range(0, len(mat2)): # rows of matrix 2
            sum = sum + mat1[mat1_r][mat2_r]*mat2[mat2_r][mat2_c]  # matrix multiplication
        result[mat1_r][mat2_c] = sum # This is a cell in the final matrix now.
print(result)


print(pd.DataFrame(mat1).dot(pd.DataFrame(mat2)))
