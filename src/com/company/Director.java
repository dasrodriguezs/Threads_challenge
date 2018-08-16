package com.company;
/**
 * This is the abstraction of a bank director and extends the {@link Agent} class
 */
public class Director extends Agent {
    /**
     * Constructor of the Director class
     * @param name Director's name
     * @param available Director's status
     * @param assignedClient Director's assigned client
     */
    public Director(String name, boolean available, Client assignedClient) {
        super(name, available, assignedClient);
    }
}
