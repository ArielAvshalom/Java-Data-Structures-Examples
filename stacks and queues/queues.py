# -*- coding: utf-8 -*-
"""
Created on Thu Mar  4 09:21:19 2021

@author: Ariel
"""
class node():
    def __init__(self, value = None): #variable with a hash defaulting to {value:None}
        self.value = value #remember this from java
        self.next = None
        self.previous = None
        
class queue():
    def __init__(self):
        self.length = 0
        self.head = None
        self.tail = None
        
    def enqueue(self, x):
        new_node = node(x) #There is no need for something called new in python. That's javaish
        
        if self.head == None:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node #allow the tail's next value to be a new_node.
            new_node.previous = self.tail #Add another lane going the other direction.
            self.tail = new_node
        self.length += 1
        
    def dequeue(self):
        front_line_wannabe = self.head.value
        self.head = self.head.next
        self.length -= 1
        
        if self.length == 0:
            self.tail = None
        return front_line_wannabe