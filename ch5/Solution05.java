package ch5;
/*Explain what the following code does: ((n & (n - 1)) == 0)
Firstly, if A & B == 0, it means A and B have no common 1s in the same place.
Secondly, if subtracting 1 from n, it means n's initial 0s will be 1s in n - 1.
and n's least significant 1 will be 0 in n - 1.
So what ((n & (n - 1)) == 0) does is not check if n is a power of 2.



*/
