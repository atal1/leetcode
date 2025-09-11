package com.home.dailypractise;

import java.util.concurrent.CompletableFuture;

public class Concurrency {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(ExampleMethods::greetings)
                .thenApply(ExampleMethods::decorate)
                .thenAccept(ExampleMethods::print)
                .join();
    }


}

interface ExampleMethods {
    static String greetings(){
        return "Hello World!!";
    }

    static String decorate(String msg){
        return "+"+msg+"+";
    }
    static void print(String msg){
        System.out.println(msg);
    }
}
