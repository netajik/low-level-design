1. The Liskov Substitution Principle states that subclasses should be substitutable for their base classes. 
2. The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of its subclasses without breaking the application

This means that, given that class B is a subclass of class A, we should be able to pass an object of class B to any method that expects an object of class A and the method should not give any weird output in that case.

This is the expected behavior, because when we use inheritance we assume that the child class inherits everything that the superclass has. The child class extends the behavior but never narrows it down.

Therefore, when a class does not obey this principle, it leads to some nasty bugs that are hard to detect.