package org.saulesmeita.matrix;

public class Main {
    public static void main(String[] args) {
        new Application(
                new ProcessorImplementation()
        ).run();
    }
}
