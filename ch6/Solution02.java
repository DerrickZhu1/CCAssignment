package ch6;
/*
Problem: You have a basketball hoop and someone says that you can play one of two games.
Game 1: you get one shot to make the hoop.
Game 2: you get three shots and you have to make two of three shots.
if p is the probability of making a particular shot, for which values of p should you
pick one game or the other?


Solution:
The probability of winning Game 1: P1 = p
The probability of winning Game 2: P2 
Let p(k, n) be the probability of making k shots out of n.
So 
P2 = p(2, 3) + p(3, 3)
   = p(making 1 and 2, missing 3) + p(making 1 and 3, missing 2) + p(making 2 and 3, missing
   1) + p^3
   = 3(1 - p) * p^2 + p^3
   = 3p^2 - 2p^3
   
Let P1 > P2
p > 3p^2 - 2p^3
2p^2 - 3p + 1 > 0
(2p - 1)(p - 1) > 0

so when o < p < 0.5 choose Game 1. When 0.5 < p < 1, choose Game 2.
When p = 0, 0.5 or 1, it doesn't matter which game to choose.



*/