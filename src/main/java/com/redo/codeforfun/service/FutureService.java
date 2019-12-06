package com.redo.codeforfun.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FutureService {

    public static void futureTest() {
        long startTime = System.currentTimeMillis();
        List<String> phones = Arrays.asList("APPLE", "HUAWEI", "VIVO", "OPPO", "HUAWEI", "VIVO", "OPPO");
        methodSync(phones);
        long endTime1 = System.currentTimeMillis();
        log.info("test1 cost times in mill : {}", endTime1 - startTime);
        methodFuture(phones);
        long endTime2 = System.currentTimeMillis();
        log.info("test2 cost times in mill : {}", endTime2 - endTime1);
        methodCompleteFuture(phones);
        long endTime3 = System.currentTimeMillis();
        log.info("test3 cost times in mill : {}", endTime3 - endTime2);
        methodParallelStream(phones);
        long endTime4 = System.currentTimeMillis();
        log.info("test3 cost times in mill : {}", endTime4 - endTime3);
    }

    private static Integer getPrice(String phone) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("sleep error, e:{}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        return new Random().nextInt(10000) + phone.charAt(1);
    }

    private static void methodSync(List<String> phones) {
        phones.stream().map(FutureService::getPrice).forEach(x -> log.info("item:{}元 ", x));
    }

    private static void methodFuture(List<String> phones) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(() -> getPrice(phones.get(0)));
        getPrice(phones.get(1));

        try {
            result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void methodCompleteFuture(List<String> phones) {
        final Executor executor = Executors.newFixedThreadPool(Math.min(phones.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        List<CompletableFuture<Integer>> futures = phones.stream()
                .map(x -> CompletableFuture.supplyAsync(() -> getPrice(x), executor))
                .collect(Collectors.toList());
        futures.stream().map(CompletableFuture::join).forEach(x -> log.info("item:{}元 ", x));
    }

    private static void methodParallelStream(List<String> phones) {
        phones.parallelStream().map(FutureService::getPrice).forEach(x -> log.info("item:{}元 ", x));
    }

}
