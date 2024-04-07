### Requirements

    The following are the requirements that we have defined for the online stock brokerage system:
    R1: The system should allow the user to easily trade in stocks (buy or sell the stocks).
    R2: Users are allowed to have numerous watchlists consisting of different stock quotes.
    R3: Users may own different lots of the same stock. This implies that the system should be able to distinguish between several lots of the same stock if a user has purchased the same stock more than once.
    R4: Every time a trade order is carried out, the system should be able to notify users.
    R5: The system should allow the user to order the stock trade of the types given below:
    Market order: Buy or sell stocks at the current market price.
    Limit order: Buy or sell stocks at the price set by the user.
    Stop-loss order: Buy or sell stocks when they reach a certain price.
    Stop-limit order: Buy or sell stocks with a restriction on the limit price (maximum price to be paid, minimum price to be received, etc).
    R6: The system should allow the user to make deposits and withdrawals using checks, wire transfers, or electronic bank transfers.

    Design pattern
    In the online stock brokerage system, there is going to be only one instance of the stock exchange, which encloses all the information and relations relating to the stock exchange. Therefore, we use the Singleton design pattern to ensure that only one instance for the class is created and this instance has a global point of access.

    We can also use the Observer design pattern for our online stock brokerage system. Since the user has set buying and selling limits, the system observes stock prices, and when a stock reaches the specified price it buys and sells the stock automatically. Therefore, there is a need for an observer who observes the price of stock all the time.