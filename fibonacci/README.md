# Fibonacci Sequence

Introduces smoothly recursion with TDD.

The Fibonacci sequence is a well known mathematical sequence leading to astounding properties, in various domains like number theory, geometry, crystallography and even graphical arts and architecture.

Its formula is
```
u[n] = u[n-1] + u[n-2]
```
starting with
```
u[0] = 0
u[1] = 1
```
Let's compute the first few of them:
```
u[2] = u[1] + u[0] = 1 + 0 = 1
u[3] = u[2] + u[1] = 1 + 1 = 2
u[4] = u[3] + u[2] = 2 + 1 = 3
...
```

In this kata, we propose to implement this sequence. We shall create a `Fibonacci` class, having a single public static method
```
public int of(int number);
```
taking an `int` as parameter (the number of which we wish to know its Fibonacci number) and returning an `int` (the Fibonacci number itself). 

Reference: [Codemanship's Test-driven Development in Java](https://www.youtube.com/watch?v=nt2KKUSSJsY)