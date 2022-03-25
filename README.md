# EMI-Calculator
### Android application to calculate EMI
### Simple and beautiful app developed with android studio using java.
### Algorithm:
1.start

2.if input fields= empty
   toast: Fields cannot be empty;

3.else accept P,R,T; 
       r=R/12/100;
       t=T*12

4. emi=(a* rat* Math.pow((1+rat),n))/(Math.pow(1+rat,n)-1)

5. total= emi*t

6. payable interest:total-P

7. roundoff the values

8. display

9. stop.
    
