#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu May  7 10:38:15 2020

@author: arielavshalom

Goals: 
    to define a class called pokemon
        Pokemon will include stuff like name, level, health, attacks. 
        While there should be a general class that is modified with each instance of a pokemon, we won't do something that complicated here. Just assume that there is one of a type of pokemon for this game.
        
    to define a class called trainer
        This class will have things like the trainer's money, their pokemon. Maybe a function to add money or pokemon.
        For simplicity, each trainer will only have one pokemon in their bag.
        
        What will a trainer have?
        
            One pokemon
            A bag with items
            A name.
            A nature. Is he mean or is he nice. 
            Badges
        
        
        
    To create a maingame with a battle between trainers and a simple movement game. 
        So how do we create a battle system?
        We need to do show attacks to the player. Once the player has that option, they can choose an attack. we will then attack by the amount and damage the health of pokemon.

"""

import random
import numpy as np

#We want pokemon.

class Pokemon:
    
    def __init__(self, pokename, pokelevel, poketype, pokehealth, pokeattacks):
        self.pokename = pokename
        self.pokelevel = pokelevel
        self.poketype = poketype
        self.pokehealth = pokehealth
        self.pokeattacks = pokeattacks
        
        
    def show(self):
        print("Pokemon Name is : ", self.pokename, "\n Pokemon Level is : ", self.pokelevel, "\n Pokemon type is ", self.poketype, "\n Pokemon's health is : ", self.pokehealth)
        
    def attacks(self):
        print(self.pokename, " Has these attacks \n", )
        for x,y in self.pokeattacks.items():
            print(x,y)
            
    #def attacked(self):
        
        

class trainer:
    
    def __init__(self, name, pokemon1, bag, nature, badges):
        """

        Parameters
        ----------
        name : str
            Its the name of the character..
        pokemon1 : Pokemon
            The 1 pokemon of a trainer. We aren't getting fancier than that.
        bag : list
            pokeballs, potion, repel, food.
        nature : str
            the disposition of the trainer. ie naughty or nice.
        badges : int
            0-8 depending on how far the trainer got.

        Returns
        -------
        None.

        """
        
        self.name = name
        self.pokemon1 = pokemon1
        self.bag = bag
        self.nature = nature
        self.badges = badges
        
    def showbag(self):
        for value in self.bag:
            print(value)
    



pikachu = Pokemon("Pikachu", 100, "Electric", 325, {"thunder": 50, "Lightning": 75, "Surf": 60})
rayray = Pokemon("Rayquaza", 70, "Flying-Dragon", 300, {"fly": 70, "Hyperbeam": 140, "Surf": 60})

ashbag = ["pokeball", "potion", "repel", "pizza"]

ash = trainer("Ash", pikachu, ashbag, "kind", 8)
ariel = trainer("Ariel", rayray, ashbag, "Crazy", 64)


#pikachu.show()
#pikachu.attacks()
#rayray.attacks()
#attacks = {"thunder": 50, "Lightning": 75, "Surf": 100}



#Two trainers meet each other.
#Print that trainers have encountered each other.
#keeping track of turns.
#Giving them an option to use moves.
#Keep track of pokemonhealth.


def battle(player1, bot):
    

    print(player1.name, "Has met", bot.name)

    initialresponse = """what would you like to do?
    battle
    run
    """

    testresponse = 0
    while testresponse == 0:
        plyresponse = input(initialresponse)
        
        if plyresponse == "run":
            testresponse = -1
            return print("Ran the heck away")
        
        if plyresponse == "battle":
        #ToDo battle.
            testresponse = 1
    
    if testresponse == 1:
    
        print(player1.name, "Has chosen to use", player1.pokemon1.pokename, "\n", bot.name, "has chosen to use", bot.pokemon1.pokename)
        
        playerhealth = player1.pokemon1.pokehealth
        bothealth = bot.pokemon1.pokehealth
        
        while playerhealth > 0 and bothealth > 0:
        
            response = 0
            while response == 0:
                
                player1.pokemon1.attacks()
                plyatk = input("Which move would you like to use?\n")
                if plyatk in player1.pokemon1.pokeattacks:
                    response = 1
                else:
                    print("$$$$$$$$$$$$\nHey there pick a move your pokemon can use!\n$$$$$$$$")
            
            bothealth -= player1.pokemon1.pokeattacks[plyatk]
            print("\n%%%%%%%%%%%%%%%%%%", bot.pokemon1.pokename, " lost ", player1.pokemon1.pokeattacks[plyatk], "\nhealth is now", bothealth, "\n%%%%%%%%%%%%%%%%%%")
            
            botattack = random.choice(list(bot.pokemon1.pokeattacks.keys()))
            
            playerhealth -= bot.pokemon1.pokeattacks[botattack]
            
            print("\n%%%%%%%%%%%%%%%%%%", player1.pokemon1.pokename, " lost ", bot.pokemon1.pokeattacks[botattack], "\nhealth is now", playerhealth, "\n%%%%%%%%%%%%%%%%%%")
            
            if playerhealth <= 0:
                return print("you lost game over!")
            if bothealth <= 0:
                return print("You won! Yay. Steal some money from the loser...")
            
            


ourarray = np.zeros([10,10])

ourarray[0,0] = 1

playerposition = [0,0]

playmovement = "yes"
while playmovement != 'q':
    
    ourarray[playerposition[0],playerposition[1]] = 0
    move = input("which way would you like to go?")
    
    if move == 'd':
        playerposition[1] += 1
    
    if move == 'a':
        playerposition[1] -= 1
        
    if move == 's':
        playerposition[0] -= 1
    
    if move == 'w':
        playerposition[0] += 1
    
    ourarray[playerposition[0],playerposition[1]] = 1
    
    print(ourarray)
    
    playmovement = input("would you like to keep moving?")



            