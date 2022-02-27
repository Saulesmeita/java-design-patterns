package org.saulesmeita.matrix;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class ProcessorImplementation implements ProcessorFacade {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void addMatrices() {
        final var first = readMatrix("first");
        final var second = readMatrix("second");
        print(first.add(second));
    }

    @Override
    public void multiplyByConstant() {
        final var matrix = readMatrix("the");
        System.out.println("Enter constant:");
        final var constant = scanner.nextDouble();
        print(matrix.multiply(constant));
    }

    @Override
    public void multiplyMatrices() {
        final var first = readMatrix("first");
        final var second = readMatrix("second");
        print(first.multiply(second));
    }

    @Override
    public void transpose(final TranspositionStrategy mode) {
        final var matrix = readMatrix("the");
        print(matrix.transpose(mode));
    }

    @Override
    public void calculateDeterminate() {
        final var matrix = readMatrix("the");
        print(matrix.determinant());
    }

    @Override
    public void inverseMatrix() {
        final var matrix = readMatrix("the");
        print(matrix.inverse().orElseThrow());
    }

    private Matrix readMatrix(final String name) {
        System.out.println("Enter size (rows and cols) of " + name + " matrix:");
        final var rows = scanner.nextInt();
        final var cols = scanner.nextInt();
        System.out.println("Enter " + name + " matrix:");
        return Matrix.create(rows, cols, i -> scanner.nextDouble());
    }

    private void print(Object result) {
        System.out.println("The result is:");
        System.out.println(result);
    }
}
