# -*- coding: utf-8 -*-
"""
Created on Thu Jun  3 17:32:40 2021

@author: thomas.aronson
"""

i = 3  # weakly typed  Python is very short and terse.
print(type(i))
interest = 3.44
print(type(interest))
safe = True
print(type(safe))
nums = [1,2,3] # regular list
x = 34 + 11j
tuple1 = (23, 3, 4)  # immutable so can't change it
set1 = {3, 4, 5, 6, 77}  # no duplicates
dict1 = {'a':1, 'b':2, 'c':44} # dictionary
print(("%s %s %s %s") %(type(nums), type(tuple1), type(set1), type(dict1)))
[print(a, end = ' ') for a in (type("hello"), type(nums), type(tuple1), type(set1), type(dict1), type(None), 
                    type([[1, 2, 3], [3, 5, 7]]), type(x))] # list comprehension


def func(*argsSingle, **args):
    
    for element in argsSingle:
        print(element)
        
    for x, y in args.items():
        print("{}:{}".format(x, y))
        
    for x in args.keys():
        print("{}".format(x))
    
    for x in args.values():
        print("{}".format(x))
        
func("Joe", "Sally", a=2, b=3, c=44, d=567)