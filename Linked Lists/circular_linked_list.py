# -*- coding: utf-8 -*-
"""
Created on Wed Mar 17 14:38:42 2021

@author: Ariel
"""

class node:
    
    def __init__(self, value, next = None, last = None):
        self.value = value
        self.next = next
        self.last = last #not sure if this is necessary
        
    def __repr__(self):
        return str(self.value)

class circular_linked_list:
    
    def __init__(self, head : node, tail : node):
        self.head = head
        self.tail = tail
        
        self.head.next = tail
        self.tail.next = head
        self.tail.last = self.head
        self.head.last = self.tail
    
    def add_node(self, node : node):
        """if self.head.next == self.tail:
            self.head.next = node
            node.next = self.tail
        else:
            node.next"""
            
        old_tail = self.tail
        self.tail = node
        old_tail.next = self.tail
        self.tail.last = old_tail
        self.tail.next = self.head
        
    def print_list(self, count = 20):
        node_to_print = self.head
        while count != 0:
            print(node_to_print)
            node_to_print = node_to_print.next
            
            count -= 1

if __name__ == "__main__": #Driver code, if will only trigger if code is run from this file.
    node1 = node(1)
    node_last = node(123)
    circle_list = circular_linked_list(node1, node_last)
    
    node2 = node(2)
    node3 = node(3)
    
    circle_list.add_node(node2)
    circle_list.add_node(node3)
    
    circle_list.add_node(node(17))
    circle_list.add_node(node(21))
    
    