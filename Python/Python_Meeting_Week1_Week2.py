#!/usr/bin/env python
# coding: utf-8

# #### Basic quiz Python - slicing

# In[127]:


s = "Tanisha Brown"
s[0:4]


# #### Some data types in Python

# In[140]:


i = 3  # weakly typed  Python is very short and terse. ipynb file extension
print(type(i))
interest = 3.44
print(type(interest))
safe = True
print(type(safe))
nums = [1,2,3] # regular list
nums[1] = 45 # can change list because it is mutable
x = 34 + 11j
tuple1 = (23, 3, 4)  # immutable so can't change it
set1 = {3, 4, 5, 6, 77}  # no duplicates
dict1 = {'a':1, 'b':2, 'c':44, 'd':'Joseph'} # dictionary
print(("partial types shown: %s %s %s %s") %(type(nums), type(tuple1), type(set1), type(dict1)))
lst_comp = [a for a in (type("hello"), type(nums), type(tuple1), type(set1), type(dict1), type(None), 
                    type([[1, 2, 3], [3, 5, 7]]), type(x))] # list comprehension
print(lst_comp)
lst2 = [a for a in [123,2,3,4,5]]
print(lst2)


# In[125]:


## What is a dict?
print(dict1['a'])


# In[126]:


def fizz_buzz():
    
    for i in range(1, 31): # Does range include last element? inclusive:exclusive
        if i % 3 == 0 :
            name = 'fizz'
            if i % 5 == 0:
                name = 'fizzbuzz'
        elif i % 5 == 0:
            name = 'buzz'
        else:
            name = ''
        print(i, name, end = '\n')
        
fizz_buzz()      
            
            


# In[133]:


# classes, constructor with __init__, print stmts and formats, var args - *args and **kwargs
class Dog:
    def __init__(self, name, breed, *args): # variable args
        self.name = name
        self.breed = breed
        self.age = args[0]

    def print(self):
        print(self.name, self.breed, self.age, sep = ', ', end = '\n')

brad = Dog('Brad', 'Pit Bull Terrier', 3)
brad.print()

class Dog2:
    def __init__(self, name, breed, age, **kwargs): # variable keyword args
        self.name = name
        self.breed = breed
        self.age = age
        self.color = kwargs['color'] #dict or like associative array

    def print(self):
        print(self.name, self.breed, self.age, self.color, sep = ', ', end = '\n')
        print("%s is a %s of age %d and her color is %s. \n" % (self.name, self.breed, self.age, self.color))
        print("same output diff format: {0} is a {1} of age {2} and her color is {3}. \n".format(self.name, self.breed, self.age, self.color))
amy = Dog2('Amy', 'Poodle', 3, color="black")
amy.print()


# ### Use DataFrame from pandas. Dot product multiplies rows and columns.
# 

# In[134]:


import pandas as pd
df1 = pd.DataFrame([[1,2,3], [4,5,6], [7,8,9]]) # matrix or list of lists
print(type(df1))
df2 = pd.DataFrame([[1,2,3], [14,15,16], [17,8,12]])
print(df1, df2, sep = '\n')
print("length dataframe is", len(df1))
df_result = df1.dot(df2) # "pythonic"
df_result.columns = ["c1", "c2", "c3"]
df_result.index = ["r1", "r2", "r3"]
print(type(df_result))
print("dot product:", df_result, sep = "\n")
print("print rows 2, 3 slice:", df_result[1:], sep = "\n")
print("print row 2 slice:", df_result[1:2], sep = "\n")
#Note: Using default column row, column names can use loc. But with custom names use iloc
print("print 3rd column slice with loc[]:", df_result.iloc[:, 2], sep = "\n") # use iloc to specify columns also


# ### Use array and initialize with list comprehension. This can be messy with all the for loops.

# In[135]:


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


# ### Numpy multiplication with matrices is a little different. The array in Numpy will apply an element by element multiplication and not a dot product as above.

# In[ ]:


import numpy as np  # pip installed modules, packages, etc.
mat1 = np.array([[1,2,3], [4,5,6], [7,8,9]])
print(type(mat1))
mat2 = np.array([[1,2,3], [14,15,16], [17,8,12]])
print(mat1*mat2) # numpy look at array and ndarray  pandas check out DataFrame, Series (slicing)


# In[ ]:


mat1[1][1:3] # for slicing the last position after : is exclusive


# ### Lambdas in python are like "anonymous" functions - functional programming. Note in example below we don't have a function name, function body, parameters enclosed in parentheses. Relate this to streams and lambda in Java 8 and beyond, if you work with Java.

# In[136]:


f = lambda x : x**3  # no function name, no parens with params, no return type
f(3)


# ### A filter takes two parameters, (1) function and (2) iterable or scalar to use for function.

# In[ ]:


odds = list(filter(lambda x : x % 2 == 1, range(1,50)))
print(odds)


# In[142]:


lst = [5, 4, 1, 2, 3]
result = filter(lambda x : x**3 > 10, lst)
for i in result:
    print(i)


# In[143]:


[i**3 for i in [1,2,4]] # list comprehension


# ### Use map to map two arguments (1) functions to (2) each group of iterables.

# In[144]:


odds = enumerate(map(lambda x : x % 2 == 1, range(1, 51)), start = 1) # enumerate useful for numbering
print(odds)
for i in odds:
    print(i)


# ### Now use map with two iterables and a function that takes two parameters. The iterables will be used only based on the shortest iterable.

# In[ ]:


def calc(num, pow):
    return num**pow
# num is base in first iterable, exponent is in second iterable so 1**11, 2**12, 3**13, etc.
powers = map(calc, range(1, 6), range(11, 20)) # 1**11, 2**12, 3**13, etc. range(1, 6) is shortest range here.
# with lambda: powers = map(lambda x, y : x**y , range(1, 6), range(11, 20)) 
p = enumerate(powers, start = 1) # get index position starting at 1
print("(value, value**value )")
for i in p:
    print(i)


# ### Example uses filter with named function (could we use lambda here?). Note the mod does not have to use O(n) but O(n**0.5). Formal proof not necessary but think about it.

# In[145]:


from math import ceil
for n in range(3, 27, 2):# 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71
#73 79 83 89 97 101 103 107 109 113
#127 131 137 139 149 151 157 163 167 173
#179 181 191 193 197 199 211 223 227 229
#233 239 241 251 257 263 269 271 277
    print(n, len([i for i in range(2, ceil(n**0.5) + 1) if n%i == 0]) == 0)
def find_primes(n):
    return len([i for i in range(2, ceil(n**0.5) + 1) if n%i == 0]) == 0
p = filter(find_primes, range(3, 217, 2))
list(p) # please work on lambda, filter, map, reduce. Stream interface in Java 8 will have similar functions.


# ### Use reduce for the first parameter as a type of accumulator and the second parameter as an iterable.

# In[137]:


from Lib.functools import reduce
factorial = reduce(lambda x, y : (x*y), range(1, 6))
print("Value of factorial =", factorial)


# ### A perfect fit for a line showing numpy array 

# In[146]:


import numpy as np
from matplotlib import pyplot as plt  # seaborn is another good plotting library
get_ipython().run_line_magic('matplotlib', 'inline')
x = np.array([1,2,3,4,5])
y = np.array([4, 6, 8, 10, 12])
plt.title("Sample plot")
plt.grid()
plt.xlabel("x axis")
plt.ylabel("y axis")
plt.plot(x, y, label='Model')


# ### Scatter plot with two sets of data, legend, grid

# In[147]:


import numpy as np
from matplotlib import pyplot as plt
get_ipython().run_line_magic('matplotlib', 'inline')
set1 = plt.scatter(np.array([1, 2, 3, 4, 5]), np.array([11, 22, 38, 41, 66]), c="orange", label="data set 1" )
set2 = plt.scatter(np.array([1, 3, 5, 11, 19]), np.array([17, 26, 55, 69, 87]), c="green", label="data set 2" )
plt.title("Sample plot")
plt.legend(loc='best')
plt.grid()
plt.xlabel("x axis")
plt.ylabel("y axis")


# ### Let's use scikit-learn library to make regression (linear regression here) easier

# In[148]:


import numpy as np
from sklearn.linear_model import LinearRegression

x = np.array([5, 18, 28, 38, 55, 65]).reshape((-1, 1)) # Make array one col. and as many rows as necessary with reshape.
y = np.array([5, 28, 23, 39, 31, 45])


# In[149]:


print(x, x.shape)
print(y)


# ###  r squared shows how well data is correlated (fit) to a line.
# * 1.0 shows perfect correlation for data
# * 0 shows no correlation
# * -1.0 shows no correlation
# * relative magnitude of coefficient shows degree of correlation of anti-correlation
# 

# In[150]:


model = LinearRegression().fit(x, y)
r_square = model.score(x, y)
print("corr. coeff. r**2 =" ,r_square)


# ### Compute y intercept (b) and slope (m) of line: y = mx + b. We can then use data for independent variable x to predict dependent variable y.

# In[151]:


print('intercept b: %4.2f' %model.intercept_)
print('slope m: %4.2f' %model.coef_)
print('y = %4.2fx + %4.2f' %(model.coef_, model.intercept_))


# ### Plot points and draw line from regression.

# In[ ]:


plt.scatter(np.array([5, 18, 28, 38, 55, 65]), np.array([5, 28, 23, 39, 31, 45]), c="r")
plt.title("Linear Regression")
plt.grid()
plt.xlabel("x")
plt.ylabel("y")


# In[ ]:


yvals = map(lambda xval : 0.52*xval + 10.3 , np.array([5, 18, 28, 38, 55, 65]))
yvals = list()


# ### Now plot regression line with actual data and view "best fit" line with actual points.

# In[ ]:


# Get y-Values from actual data for line. Cast map to list so plotting y-values is valid.
yvals = list(map(lambda xval : 0.52*xval + 10.3 , np.array([5, 18, 28, 38, 55, 65]))) 
plt.scatter(np.array([5, 18, 28, 38, 55, 65]), np.array([5, 28, 23, 39, 31, 45]), c="r")
plt.title("Linear Regression")
plt.grid()
plt.xlabel("x")
plt.ylabel("y")
plt.plot(np.array([5, 18, 28, 38, 55, 65]), yvals) # can't use map as y-values
plt.show()


# ### Can think of multiple linear regression as using many observations (rows) of data using columns (features) as the independent variables, choosing a column as the dependent variable. Look at numpy for matrix multiplication. We saw something similar for pandas.DataFrame and dot product.

# In[152]:


import urllib.request

urllib.request.urlopen('file:///c:/Users/thomas.aronson/Downloads/country_vaccinations.csv',
                           'vaccinations.txt') # too many columns in some rows
closing_data = np.genfromtxt('vaccinations.txt', delimiter=',', skip_header=1)
closing_data


# ### Try reading csv file with pandas to avoid error of max columns and use multiply function of dataframe.

# In[153]:


import pandas as pd
import numpy as np
df = pd.read_csv("c:/Users/thomas.aronson/Downloads/country_vaccinations.csv")
df.shape
df[['country', 'people_vaccinated', 'people_fully_vaccinated']]
df.isnull().values.any()
df.convert_dtypes()
df.dropna(inplace=True)
print(df.head(5))

weights = np.array([0.3, 0.4, 0.5])
df2 = df[['people_vaccinated', 'people_fully_vaccinated', 'total_vaccinations']]
print(type(df2))
df2
print(df2.shape)
results = df2.multiply(weights) # numpy matmul does not seem to work for DataFrame and array
results2 = df2.dot(weights) # Not same as above multiply function! This does true dot product. Above is element by element.
results2


# ### This is correct for numpy matmul of two numpy arrays so using matmul with arrays works as expected.

# In[154]:


mat1 = np.array([1, 2, 5, 6, 12, 7])
mat2 = np.array([1, 2, 5, 6, 12, 7])
np.matmul(mat1, mat2)


# ### Check regression model with an example.

# In[155]:


"""
Created on Sat Feb 13 14:36:02 2021

@author: Jason Brownlee / TA
"""

from numpy.random import rand
from sklearn.datasets import make_regression
from sklearn.metrics import mean_squared_error

# linear regression
def predict_row2(row, coefficients):
    # add the bias, the last coefficient
    result = coefficients[-1]
    # add the weighted input
    # This is longer way "non-Pythonic" with for loop
    for i in range(len(row)):
        result += coefficients[i] * row[i]
    return result

def predict_row(row, coefficients):
    # add the bias, the last coefficient
    result1 = coefficients[-1]
    # add the weighted input
    # This is more "Pythonic".
    result = [coefficients[i] * row[i] for i in range(len(row))]
    return result[0] + result1

def predict_dataset(X, coefficients):
    yhats = list()
    for row in X:
        # make a prediction
        yhat = predict_row(row, coefficients)
        # store the prediction
        yhats.append(yhat)
    return yhats

# define dataset
X, y = make_regression(n_samples=1000, n_features=10, n_informative=2, noise=0.2, random_state=1)
# summarize the shape of the dataset
print(X.shape, y.shape)

# determine the number of coefficients
n_coeff = X.shape[1] + 1
# generate random coefficients
coefficients = rand(n_coeff)
# generate predictions for dataset
yhat = predict_dataset(X, coefficients)
# calculate model prediction error
score = mean_squared_error(y, yhat)
print('MSE: %f' % score)


# ### We can analyze a box plot and some of the important features.

# In[156]:


from matplotlib import pyplot as plt
values = np.array([1, 10.5, 12.2, 2.2, 3.3, 5.6, 8.1, 33.7, 22.6, 19, 56.9, 14.5, 25.8])
values2 = 2*values
values3 = 3.3*values
data = [values, values2, values3]
fig, ax1 = plt.subplots()
ax1.set_title("Various Box Plots")
plt.boxplot(data)


# ### We see a lot of random numbers generated for various purposes in Python. This is just an example of choosing the order of group presentations using random numbers.

# In[ ]:


# set will not print members in order so use list also
from random import random
groups = set() # won't add duplicates
lst = []
for i in range(1, 150):
    group_num = int(10*random()) + 1
    if(group_num == 10):
        continue
    groups.add(group_num)
    if lst.count(group_num) == 0:
        lst.append(group_num)
    if len(groups) == 9:
        break
print(lst)


# In[ ]:


# set will print members in order so use list also
from random import random
groups = set() # won't add duplicates
lst = []
for i in range(1, 150):
    group_num = int(10*random()) + 1
    if(group_num == 10):
        continue
    groups.add(group_num)
    
    if len(groups) == 9:
        break
print(groups)


# In[ ]:





# ### Stacked bar charts can be hard to read based on actual values in terms of the charts above level one. But the relative sizes of the charts for the given data are the important thing.

# In[157]:


# adapted from https://matplotlib.org/stable/gallery/lines_bars_and_markers/bar_stacked.html#sphx-glr-gallery-lines-bars-and-markers-bar-stacked-py
import matplotlib.pyplot as plt

labels = ['GR1', 'GR2', 'GR3', 'GR4', 'GR5']
# Height of each bar
male_means = [20, 35, 30, 35, 27]
female_means = [25, 32, 34, 20, 25] # female scores are difference in vertical axis between male max and max for each bar
# Length of vertical bars for each group are male/female std. dev.
male_std = [2, 3, 4, 1, 2]  #std. deviations for males, female std. dev. below
female_std = [3, 5, 2, 3, 3]
width = 0.40       # the width of the bars: can also be len(x) sequence

fig, ax = plt.subplots() # ax denotes a single axis in this case based on no params for function; fig is Figure.
print(fig.__getstate__())
ax.bar(labels, male_means, width, yerr=male_std, label='Males', color = 'b')
ax.bar(labels, female_means, width, yerr=female_std, bottom=male_means,
       label='Females', color = 'pink')

ax.set_ylabel('Scores')
ax.set_title('Scores by group and gender')
ax.legend()

plt.show()


# In[158]:


labels = ['GR1', 'GR2', 'GR3', 'GR4', 'GR5']
# Height of each bar
male_means = [20, 35, 30, 35, 27]
female_means = [25, 32, 34, 20, 25] # female scores are difference in vertical axis between male max and max for each bar
# Length of vertical bars for each group are male/female std. dev.
male_std = [2, 3, 4, 1, 2]  #std. deviations for males, female std. dev. below
female_std = [3, 5, 2, 3, 3]
width = 0.40       # the width of the bars: can also be len(x) sequence

fig, ax = plt.subplots() # ax denotes a single axis in this case based on no params for function; fig is Figure.
fig.add_subplot(ax)
print(fig.__getstate__())
ax.bar(labels, male_means, width, yerr=male_std, label='Males', color = 'b')
ax.bar(labels, female_means, width, yerr=female_std, bottom=male_means,
       label='Females', color = 'pink')

ax.set_ylabel('Scores')
ax.set_xlabel('Groups')
ax.set_title('Scores by group and gender')
ax.legend()

plt.show()


# In[ ]:




