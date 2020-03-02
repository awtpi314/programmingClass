package chapter9;

/**
 * <h3>public class Exercise2</h3>
 * <ul style="list-style-type:none;">
 *     <li>Alexander Taylor</li>
 *     <li>Sunday, March 1, 2020</li>
 *     <li>Mr. Yonts</li>
 *     <li>TPS Java 2019-2020</li>
 * </ul>
 * <h3>Details</h3>
 * <p>Exercise2 is a class that, along with {@link chapter9.Stock}, creates a solution to exercise 9.2 in the Pearson AP Java book</p>
 * <p>I went to town with the Javadoc on this project, because I had a little more time this week to work on my homework.</p>
 */
public class Exercise2 {
    public static void main(String[] args) {
        // Make a new Stock object that represents a stock from Oracle Corporation
        Stock oracle = new Stock("ORCL", "Oracle Corporation");

        // Assign the previous closing price
        oracle.setPreviousClosingPrice(34.5);
        // Assign the current price
        oracle.setCurrentPrice(34.35);

        // Use printf to print the percent change between the previous and current prices
        System.out.printf("The price change percentage is %.4f percent.", oracle.getChangePercentage());
    }
}

/**
 * <h2>class Stock</h2>
 * <p>This class represents a stock. It has a symbol, name, previous closing price, and current price.</p>
 * <p>The symbol and name are constants that can only be passed in through the constructor.</p>
 * <p>There are two different constructors, one that takes just a symbol and a name, and the other which takes the previous closing price and the current price also</p>
 */
class Stock {
    /**
     * A string constant that will hold the symbol of the stock
     */
    private final String symbol;

    /**
     * A string constant that will hold the name of the stock
     */
    private final String name;

    /**
     * A double variable that holds the previous closing price of the stock
     */
    private double previousClosingPrice;

    /**
     * A double variable that holds the current price of the stock
     */
    private double currentPrice;

    /**
     * Most basic constructor
     *
     * <p>Used to initialize the stock to a specified symbol and name, but not have any values for previous closing price and current price.</p>
     *
     * @param s the symbol of the stock
     * @param n the name of the stock
     */
    public Stock(String s, String n) {
        this(s, n, 0.0, 0.0);
    }

    /**
     * Complete constructor
     *
     * <p>Used to completely initialize the stock to specified symbol, name, previous closing price, and current price</p>
     *
     * @param s              the symbol of the stock
     * @param n              the name of the stock
     * @param prevClosePrice the previous closing price of the stock
     * @param currPrice      the current price of the stock
     */
    public Stock(String s, String n, double prevClosePrice, double currPrice) {
        this.symbol = s;
        this.name = n;
        this.previousClosingPrice = prevClosePrice;
        this.currentPrice = currPrice;
    }

    /**
     * <h3>getChangePercentage</h3>
     * This method gets the change percentage between the previous closing price and the current price
     *
     * @return the percentage that the stock changed
     */
    public double getChangePercentage() {
        return ((this.currentPrice - this.previousClosingPrice) / this.previousClosingPrice) * 100;
    }

    /**
     * <h3>getCurrentPrice</h3>
     *
     * @return the current price of the stock
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * <h3>setCurrentPrice</h3>
     * Sets the current price of the stock to the passed double
     *
     * @param currentPrice the new current price of the stock
     */
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * <h3>getPreviousClosingPrice</h3>
     *
     * @return the previous closing price of the stock
     */
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    /**
     * <h3>setPreviousClosingPrice</h3>
     * Sets the previous closing price of the stock to the passed double
     *
     * @param previousClosingPrice the previous closing price of the stock
     */
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    /**
     * <h3>getSymbol</h3>
     *
     * @return the symbol of the stock
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * <h3>getName</h3>
     *
     * @return the name of the stock
     */
    public String getName() {
        return name;
    }
}