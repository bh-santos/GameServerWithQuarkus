package com.brendondias.game.server.sockets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void execute(Runnable task) {
        executorService.execute(task);
    }
}
