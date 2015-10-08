package ch6;
/*
Problem: Ants on a Triangle. find the probability of collision with n ants on an 
n-vertex polygon.

Solution: 
Only if all ants go in the same direction, they will not collide.

P(clockwise) = (1 / 2) ^ n
P(counter clockwise) = (1 / 2）^ n
P(same direction) = 2 * (1 / 2) ^ n = (1 / 2) ^ (n - 1)
P(collision) = 1 - P(same direction) = 1 - (1 / 2) ^ (n - 1)







*/