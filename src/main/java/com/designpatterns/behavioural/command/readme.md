The pattern intends to encapsulate in an object all the data required for performing a given action (command), including what method to call, the method's arguments, and the object to which the method belongs.

This model allows us to decouple objects that produce the commands from their consumers, so that's why the pattern is commonly known as the producer-consumer pattern.

References:
https://www.baeldung.com/java-command-pattern
https://betterprogramming.pub/utilizing-the-command-pattern-to-support-undo-redo-and-history-of-operations-b28fa9d58910