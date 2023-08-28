Creational design patterns: Creational design patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.


Singleton:
- The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
- Define a class that has only one instance and provides a global point of access to it. A class must ensure that only a single instance should be created and a single object can be used by all other classes.
- The singleton pattern is one of the simplest design patterns. Sometimes we need to have only one instance of our class for example a single DB connection shared by multiple objects as creating a separate DB connection for every object may be costly. Similarly, there can be a single configuration manager or error manager in an application that handles all problems instead of creating multiple managers.
- https://www.geeksforgeeks.org/singleton-design-pattern/

Factory:
The Factory Design Pattern or Factory Method Design Pattern is one of the most used design patterns in Java.

According to GoF, this pattern “defines an interface for creating an object, but let subclasses decide which class to instantiate. The Factory method lets a class defer instantiation to subclasses”.

This pattern delegates the responsibility of initializing a class from the client to a particular factory class by creating a type of virtual constructor.

To achieve this, we rely on a factory which provides us with the objects, hiding the actual implementation details. The created objects are accessed using a common interface.


References:
https://www.baeldung.com/creational-design-patterns

