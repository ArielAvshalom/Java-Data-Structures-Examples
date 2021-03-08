# -*- coding: utf-8 -*-
"""
Created on Thu Feb 25 08:57:46 2021

@author: Ariel
"""

class Node:
    def __init__(self, datavalue = None):
        self.datavalue = datavalue
        self.nextvalue = None
    
    def printvalue(self):
        return self.datavalue

class singly_linked_list:
    def __init__(self):
        self.headvalue = None
        
    def traverse(self):
        
        currentvalue = self.headvalue
        while currentvalue is not None:
            print(currentvalue.datavalue)
            currentvalue = currentvalue.nextvalue
            
class double_forward_node_list:
    def __init__(self):
        pass
    
list1 = singly_linked_list()

list1.headvalue = Node('mosquito')
e2 = Node('dragonfly')
e3 = Node('frog')
e4 = Node('snake')
e5 = Node('owl')
e6 = Node('bacteria')
e7 = Node('circle of life') #eventually

list1.headvalue.nextvalue = e2

e2.nextvalue = e3
e3.nextvalue = e4
e4.nextvalue = e5
e5.nextvalue = e6
e6.nextvalue = e7