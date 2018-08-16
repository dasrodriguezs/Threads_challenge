package com.company;

/**
 * This class is the abstraction of a client wanting to perform a bank operation
 */
public class Client {
    /**Name of the client
     */
    private String name;

    /**
     * Constructor for the client class
     *
     * @param name name of the client
     */
    public Client(String name) {
        this.name = name;
    }

    /**
     * Call the attend function on the dispatcher
     *
     * @param dispatcher is the dispatcher instance that is managing the client
     */

    public void performOperation(Dispatcher dispatcher) {
        dispatcher.attend(this);
    }

    /**
     * Returns the client's name
     *
     * @return The client's name
     */

    public String getName() {
        return name;
    }
}
