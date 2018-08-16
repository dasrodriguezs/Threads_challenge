package com.company;

import java.util.function.Supplier;

/**
 * This class implements {@link Supplier} to perform completable futures with the client's bank operations
 * @author Daniel Rodriguez
 */
public class Agent implements Supplier<String> {
    /**Name of the agent
     */
    private String name;
    /**Status of the agent
     */
    private boolean available;
    /**Client to be attended by the agent
     */
    private Client client;
    /**Time of the thread delay
     */
    private int time;

    /**
     * Constructor for the Agent class
     *
     * @param name      agent's name
     * @param available bool condition to check if the agent is available
     * @param client    client given to the agent to perform an operation
     */
    public Agent(String name, boolean available, Client client) {
        this.name = name;
        this.available = available;
        this.client = client;
        time = 0;
    }

    /**
     * Override of the get function of the {@link Supplier} to return an String process answer
     *
     * @return The process final response
     */
    @Override
    public String get() {
        return attend();
    }

    /**
     * Obtain the agent's name
     *
     * @return The agent's name
     */
    public String getName() {
        return name;
    }

    /**
     * Modify the agent's name
     *
     * @param name the agent's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtain the agent's status
     *
     * @return The agent's status
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Modify the agent's availability
     *
     * @param available The agent's status
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Obtain the current client
     *
     * @return The client that is being attended
     */
    public Client getClient() {
        return client;
    }

    /**
     * Modify the current agent's client
     *
     * @param client Client to be modified
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Simulates a random attend time between 10 and 15 seconds and sleeps the thread this time
     * after that time returns the response of the process
     *
     * @return Response of the finished process
     */
    private String attend() {
        time = (int) (Math.random() * 15) + 10;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + " finished attending the " + client.getName() + " after " + time + " seconds";
    }
}
