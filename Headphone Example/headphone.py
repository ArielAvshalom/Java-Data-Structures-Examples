# -*- coding: utf-8 -*-
"""
Created on Thu Feb 11 09:52:57 2021

@author: Ariel
"""

class headphone:
    def __init__(self, name, size, cost, color, htype):
        self.name = name
        self.size = size
        self.cost = cost
        self.color = color
        self.htype = htype
        
    def fetch_info(self):
        return f"\n\nThe name of your headphone model is the {self.name}, the size is {self.size}, the cost is ${self.cost}, the color is {self.color} and the type is {self.htype}."

#I really like python's f-strings, they make everything so much neater! Wazoo!   

XM4 = headphone("Sony XM4", "super large", 350, 'space gray', 'over-ear')
print(XM4.fetch_info())