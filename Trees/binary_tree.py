# -*- coding: utf-8 -*-
"""
Created on Thu Apr 22 10:02:22 2021

As of right now, all we need for the Java Solution are traverse and insert

@author: Ariel
"""
import random as r
import time


class node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
class binary_tree:
    def __init__(self, root):
        self.root = root

    def traverse(self):
        list_of_nodes = []#this is not a list of integers, it is a list of nodes
        list_of_nodes.append(self.root)
        #print(self.root.value)
        while list_of_nodes != []:
            node = list_of_nodes.pop(0)
            print("\nPrinting Node value\n", node.value, "\nDONE\n")
            time.sleep(1)
            
            if node.left != None:
                #print(node.left.value)
                list_of_nodes.append(node.left)
            if node.right != None:
                #print(node.right.value)
                list_of_nodes.append(node.right)
                
    #Contains should show you a way without this list thing.
    #Contains is not required for the java solution
    def contains(self, value):
        if self.root.value == value:
            return True
        
        list_of_nodes = []#this is not a list of integers, it is a list of nodes
        list_of_nodes.append(self.root)
        
        while list_of_nodes != []:
            node = list_of_nodes.pop(0)
            
            if node.left != None:
                if node.left.value == value:
                    return True
                
                list_of_nodes.append(node.left)
                
            if node.right != None:
                if node.right.value == value:
                    return True
                
                list_of_nodes.append(node.right)
        
        return False
    
    def insert(self, value, current_node = None):
        #randomly insert a value to one of the empty leaves

        if self.root == None:
            self.root = node(value)
            return None
        
        if current_node == None:
            current_node = self.root
        
        rand_choice_options = ["left", "right"]
        
        choice = r.choice(rand_choice_options)
        print(choice)
        if choice == "left":
            if current_node.left == None:
                current_node.left = node(value)
            else:
                self.insert(value, current_node.left)
        if choice == "right":
            if current_node.right == None:
                current_node.right = node(value)
            else:
                self.insert(value, current_node.right)
            
                
                
"""
                      0
            -21              17
        18      16       78    -47
     {}   {} {} {}     {} {}  {}   {} All of the these are left and right none values
[0]
[]
[-21]
[-21,17]
[-21,17,18,16]
[17,18,16]
[18,16,78,-47]

"""
    
#In java you gotta build your own data structure
#Either override the array to have an append
#ArrayList is a solution
#OR you can use linked lists
#Or you can drop this where code and try something, try doing something with the height of a tree, might be a good idea

    

if __name__ == "__main__":
    

    bt = binary_tree(node(0))
    
    bt.root.value
    
    bt.root.left = node(-21)
    
    bt.root.right = node(17)
    
    bt.root.left.left = node(18)
    bt.root.left.right = node(16)
    bt.root.right.left = node(78)
    bt.root.right.right = node(-47)
    
    #bt.traverse()
    
    bt.contains(0)
    bt.contains(-47)
    
    bt.contains(-21)
    
    bt.contains(15)
    
    bt2 = binary_tree((node(0)))
    bt2.insert(5)
    bt2.insert(7)
    bt2.insert(11)
    bt2.insert(19)
    bt2.insert(23)
    bt2.insert(17)

"""
                            0
                5                       19
           17         7                           23
                        11
    for number in range(25):
        bt2.insert(number)

"""

    



