# -*- coding: utf-8 -*-
"""
Created on Thu Apr 29 10:26:19 2021

@author: Ariel
"""
import random as r
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        
    #Our insert follows the rule that the left is strictly less than the parent
    #The right is greater than or equal to the parent
    
    def insert(self, value):
        
        #easy part, left side
        
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:#recursively find the location to add the value to
                self.left.insert(value)
                
        #a little harder but not so bad
        if value >= self.value:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)
        
        return self
    
    def contains(self, value):
        #left side
        if value < self.value:
            if self.left is None:
                return False
        
            return self.left.contains(value)
        if value > self.value: #right side
            if self.right is None:
                return False
            return self.right.contains(value)
        
        #If equal to
        return True
    
    #this is the real hard part
    
    def remove(self, value, parent = None):
        #When we remove something there are a few options.
        #If we remove a leaf, that's fine, we're done
        #If we remove something with children, we need to keep the children connected to the tree.
        
        #This is the easy part, keep going left while you don't find the value to remove if the value is less than your current value.
        if value < self.value:
            if self.left is not None:
                self.left.remove(value, self)
        
        #Pretty easy as well, recursively move right.
        elif value > self.value:
            if self.right is not None:
                self.right.remove(value, self)

        else:
            #this is the hard logic part. This is the code where we remove a parent.
            if self.left is not None and self.right is not None:
                self.value = self.right.get_min_value()
                self.right.remove(self.value, self)
            elif parent is None: 
                #in case of deletion and left is full, move left to current node and save its left to our left and its right to our right.
                if self.left is not None:
                    self.value = self.left.value
                    self.right = self.left.right
                    self.left = self.left.left
                elif self.right is not None:
                    self.value = self.right.value
                    self.left = self.right.left
                    self.right = self.right.right
                    
                else:
                    pass
                
            elif parent.left == self:#We have only one child
                parent.left = self.let if self.left is not None else self.right
            elif parent.right == self:
                parent.right = self.left if self.left is not None else self.right
                
        return self
                
    def get_min_value(self):
        current_node = self
        while current_node.left is not None:
            current_node = current_node.left
        return current_node.value
    
    
if __name__ == "__main__":
    bt = BST(0)
    bt1 = BST(15)
    for num in range(26):
        bt.insert(r.randint(0, 26))
        bt1.insert(r.randint(0,26))