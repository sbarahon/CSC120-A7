Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

For the Library class, I decided to overload the containsTitle(int title) method as well as the isAvailable() methods to also take ints as parameters because it could be the case that a book title is comprised of only numbers and while inputting it, someone may forget to input it as a string, so, overloading the method may catch that bug before it happens.

For the House class, since this object has many more parameters than the other classes, I wanted to overload the constructor to take in only a name and address and assume the building only has one floor, no dining room, and no elevator, as well as a constructor that can take in a name, an address, a floor number, and assume false for having a dining room and having an elevator if those values are not provided.

For the Cafe class, since people can order coffee without creams or just simply black coffee, I overloaded the sellCoffee method twice to take in only size and sugar packets as parameters (for a person that does not want cream) or just size as a parameter(for a person that does not want cream or sugar). 

I think the assignment was pretty straight forward but I found myself having very small/specific questions. Upon receving guidance, I realized a lot of these questions were really moreso stylistic choices that we make as coders. Advice I would give someone in the future, is, when in doubt about how to code a program, just style it the way that makes most sense to you and just explain your reasoning behind your choices within the reflection. 