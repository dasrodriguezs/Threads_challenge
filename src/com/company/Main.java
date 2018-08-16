package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Project's main class
 */
public class Main {
    /**List of clients that are arrive to the bank
     */
    private static List<Client> clients=new ArrayList<>();


    /**
     * The main class creates a number of clients calling the createClients function.
     * Also creates a {@link Dispatcher} instance and deliver the clients one by one.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        createClients(20);
        Dispatcher dispatcher=new Dispatcher();
        for(Client client:clients) {
            client.performOperation(dispatcher);
        }
        dispatcher.finishAssignerJob();
    }

    /**
     * Creates a determinate number of clients
     *
     * @param numberClients the number of clients that will be created
     */
    public static void createClients(int numberClients)
    {
        for(int i=1;i<=numberClients;i++) {
            clients.add(new Client("Client #" + i));
        }
    }
}
