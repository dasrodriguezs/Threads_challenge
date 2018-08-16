package com.company;

/**
 * This is the abstraction of a bank cashier and extends the {@link Agent} class
 * @author Daniel Rodriguez
 */
public class Cashier extends Agent {
    /**
     * Constructor of the Cashier class
     * @param name Cashier's name
     * @param available Cashier's status
     * @param assignedClient Cashier's assigned client
     */
    public Cashier(String name, boolean available, Client assignedClient) {
        super(name, available, assignedClient);
    }
}
