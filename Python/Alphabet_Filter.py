# -*- coding: utf-8 -*-
"""
Created on Fri Mar 26 14:42:18 2021

@author: thomas.aronson
"""

class LetterFilter:
    def __init__(self, s):
       self.s = s
	
    def filter_vowels(self):
        # Enter your code here
        # Return a string
        str = "aeiou"
        return "".join(list(filter(lambda x : x not in str, s)))
        
    
    def filter_consonants(self):
        # Enter your code here
        # Return a string
        #lst = ["a", "e", "i", "o", "u"]
        str = "aeiou"
        #return list(filter(lambda x : (x == s[i] for i in range(len(s)))))
        return "".join(list(filter(lambda x : x in str, s)))

s = input("enter stuff: ")
f = LetterFilter(s)
print(f.filter_vowels())
print(f.filter_consonants())