package com.company;
/**
 * This is the abstraction of a bank supervisor and extends the {@link Agent} class
 * @author Daniel Rodriguez
 */
public class Supervisor extends Agent {

    /**
     * Constructor of the Supervisor class
     * @param name Supervisor's name
     * @param available Supervisor's status
     * @param assignedClient Supervisor's assigned client
     */
    public Supervisor(String name, boolean available, Client assignedClient) {
        super(name, available, assignedClient);
    }
}
