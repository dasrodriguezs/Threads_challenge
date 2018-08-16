package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class receives the incoming clients and pass it to an available agent to perform an operation
 */
public class Dispatcher {
    /**List of bank agents
     */
    private List<Agent> agents = new ArrayList<>();
    /**thread pool administrator
     */
    ExecutorService dispatcher;
    /**Number of agents
     */
    int numberAgents = 10;

    /**
     * Constructor for the dispatcher class
     */
    public Dispatcher() {
        createAgents(numberAgents);
        dispatcher = Executors.newFixedThreadPool(numberAgents);
    }

    /**
     * Function in charge to take an incoming client, assign it to an available agent an attend it.
     *
     * @param client incoming client to be attended
     */
    public void attend(Client client) {
        Agent agentAvailable = obtainAgentAvailable();
        if (agentAvailable != null) {
            System.out.println("The " + client.getName() + " is going to be attended by " + agentAvailable.getName());
            agentAvailable.setClient(client);
            agentAvailable.setAvailable(false);
            CompletableFuture
                    .supplyAsync(agentAvailable, dispatcher)
                    .thenAccept(response -> {
                        System.out.println(response);
                        agentAvailable.setAvailable(true);
                        agentAvailable.setClient(null);
                    });
        } else {
            putOnWait(client);
        }
    }

    /**
     * If all the agents are already busy, the incoming client is put on wait using this function
     *
     * @param client the incoming client
     */

    public void putOnWait(Client client) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attend(client);
    }

    /**
     * This function is used when there are no more clients to the dispatcher
     */
    public void finishAssignerJob() {
        dispatcher.shutdown();
    }

    /**
     * Obtain the next avaliable {@link Cashier},{@link Supervisor} or {@link Director}
     *
     * @return The next avaliable {@link Agent}
     */
    private Agent obtainAgentAvailable() {
        return agents.stream().filter(Agent::isAvailable).findFirst().orElse(null);
    }

    /**
     * Check the number of agents and adds the agents to the list
     *
     * @param numberAgents the number of agents to work
     */
    private void createAgents(int numberAgents) {
        if (numberAgents > 1) {
            for (int i = 1; i <= numberAgents - 2; i++) {
                agents.add(new Cashier("Cashier #" + i, true, null));
            }
            agents.add(new Supervisor("Supervisor", true, null));
            agents.add(new Director("Director", true, null));
        } else if (numberAgents == 1) {
            agents.add(new Director("Director", true, null));
        } else {
            System.out.println("There are no enough agents to attend people");
            this.numberAgents = 1;
        }

    }
}