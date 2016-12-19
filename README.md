# TDD training
Welcome to my TDD training sessions in Java. This content is regularly augmented from new material and teaching feedback. Its goal is to provide you with

 - good ready to go testing techniques staged in moderately complex yet realistic situations,
 - step stone to recursion programming, refactoring functional code, REST services and Web architectures
 - an introduction to most popular testing frameworks: Junit, AssertJ, Mockito, Cucumber, JUnitParams, SpringTest

What this repo is not going to do for you is

 - teach you how to test first!
 - leverage TDD as design assistant tool. See [Does TDD Really Lead To Good Design](https://codurance.com/2015/05/12/does-tdd-lead-to-good-design/) for a discussion on this topic.

These topics have to be discussed, transmitted. If you have no prior experience in TDD, just seeing the code as it is now won't help you understand how it has been constructed, step by step, using tests.

## Introduction
Here is the recommended learning path.

You may start with the Fibonacci Kata. We give there a reference to a video featuring **test first and recursion**.
The Simple Calculator kata is dedicated to **refactoring a piece of software before introducing a new functionality** (please note that this kata dramatically needs to be renamed as it has nothing to do with simple calculator kata any more!)
The Tennis kata takes you to **Behaviour Drive Development and parametrized tests**.

## Why TDD
Test Driven Development is a fantastic method that helps you to build clean, dependable and robust software. It's a must do!

### Good test coverage
By going from requirement to requirement, that is by adding complexity to your apps, you'll find blessed to have a full test coverage. In ideal TDD, when something goes wrong in your app, then you can be sure that the root cause lies in something you wrote not too long ago, because what was written before has been thoroughly tested.

Of course, this is ideal. Reality can be much more complex. However, testing DOES help troubleshoot bugs.

### Living documentation
Apart from that, well written tests are also use cases that help you understand how an application works. As such, tests stand for a living documentation.