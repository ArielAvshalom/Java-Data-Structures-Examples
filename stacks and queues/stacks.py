# -*- coding: utf-8 -*-
"""
Created on Tue Mar  2 09:27:09 2021

@author: Ariel
"""
#I'm going to use a list/array to implement a stack.
#CPython is written in C. So actually creating a new efficient data structure ain't so simple.

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class stackOne:
    #Ze constructor
    def __init__(self):
        self.head = Node("head")
        self.size = 0
        
    #Ze Empty
    def is_empty(self):
        return self.size == 0
    
    
    #Ze Push
    
    def push(self, value):
        node = Node(value)
        node.next = self.head.next #Cut between head and its prior, Save that location onto the next value of what we're pushing
        self.head.next = node #Save this pushed value in the location where head.next used to point
        self.size += 1
    
    #Ze Pop
    
    def pop(self):
        #ToDo put some code in here to check if the stack is empty and return an error if that occurs.
        if self.is_empty():
            raise Exception("You're popping from an empty stack, go get your own stack")
        
        remove = self.head.next
        self.head.next = self.head.next.next
        self.size -= 1
        return remove.value
    
    #Ze Peek
    def peek(self):
        if self.is_empty():
            raise Exception("Peeping Tom, nothing to peek at here!")
        
        return self.head.next.value
    
    
StackA = stackOne()

StackA.push('cake')
StackA.push('candles')
StackA.push('balloons')


from collections import deque

A = deque()

A.append('avc')
A.append(12314)

print(A)

A.append('quora')



class stack2:
    def __init__(self):
        self.list = list()
        
    def push(self, value):
        self.list.append(value)
    
    def pop(self):
        return self.list.pop()
    
    def peek(self):
        return self.list[-1]
    
    def printer(self):
        print(self.list)
        return None

B = stack2()
B.push(3)
B.push(4)
B.push(5)




from queue import Queue

q = Queue(maxsize = 10)

print(q.qsize())

q.put('a')
q.put('b')
q.put('c')

#is the queue full?

print('is the queue full?', q.full())

#remove element:

print(q.get())

print('is the queue empty?', q.empty())


#The best tool for arrays in python is the list.
#It is O(n) to implement.










































