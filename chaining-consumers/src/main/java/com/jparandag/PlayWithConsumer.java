package com.jparandag;

public class PlayWithConsumer {

    public static void main(String...args) {
        //PlayWithConsumer.withoutChainingConsumers();
        PlayWithConsumer.withChainingConsumers();
    }

    static void withoutChainingConsumers() {
        Consumer<String> c1 = s -> System.out.println("C1 = " + s);
        Consumer<String> c2 = s -> System.out.println("C2 = " + s);

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Chaining Juan");
    }

    static void withChainingConsumers() {
        Consumer<String> c1 = s -> System.out.println("C1 = " + s);
        Consumer<String> c2 = s -> System.out.println("C2 = " + s);

        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("Chaining Juan");
        System.out.println("Exiting main");
    }
}
