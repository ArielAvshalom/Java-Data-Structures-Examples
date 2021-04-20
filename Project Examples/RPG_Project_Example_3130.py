# -*- coding: utf-8 -*-
"""
Created on Tue Apr 20 09:30:54 2021

@author: Ariel
"""
class player:
    def __init__(self, name : str, nature : str, bag : bag, health : bar, experience: bar, level : int) -> None:
        self.name = name
        self.nature = nature
        self.bag = bag
        self.health = health
        self.experience = experience
        self.level = level
    
    def __repr__(self):
        return f"The player's name is {self.name}.\nThe player's nature is {self.nature}.\nhis current health is {self.health.current} out of {self.health.limit}.\nThe player's level is over 9000!@O!@!@ (JK, it's {self.level}"
    
    def level_up(self):
        #after each time the player gets experience, calculate the experience and if the experience is over 100%, then reduce it to itself - 100 and then level up the character
        if self.experience.current >  self.experience.limit:
            print("level up! You are now level ", self.level + 1)    
            self.level += 1
    
    def use_item(self):
        pass

class monster:
    pass
    
    
class item:
    pass

class attack:
    pass
    
class environment:
    pass
    
class bag:
    def __init__(self, item_list):
        self.item_list = item_list
class bar:
    def __init__(self, current, limit):
        self.current = current
        self.limit = limit
    #This means that you have an amount of something and a limit for how much you can have of it.
    #you have x/100 experience
    #you have 75 out 387 health