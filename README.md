# Examples of Design Patterns in Java

This project contains a simple console application: Matrix Processor. 

Design Patterns used in this project:

## Builder Pattern

The class `MenuBuilder` demonstrate Builder pattern. This class used to create a menu:

```java
new MenuBuilder()
        .title("Numeric Matrix Processor")
        .add("Add matrices", processor::addMatrices)
        .add("Multiply matrix to a constant", processor::multiplyByConstant)
        .add("Multiply matrices", processor::multiplyMatrices)
        .add("Transpose matrix", new MenuBuilder()
                .title("Transpose Matrix")
                .add("Main diagonal", () -> processor.transpose(TranspositionStrategy.MAIN_DIAGONAL))
                .add("Side diagonal", () -> processor.transpose(TranspositionStrategy.SIDE_DIAGONAL))
                .add("Vertical line", () -> processor.transpose(TranspositionStrategy.VERTICAL_AXIS))
                .add("Horizontal line", () -> processor.transpose(TranspositionStrategy.HORIZONTAL_AXIS))
                .oneTime()
                .build()
        )
        .add("Calculate a determinant", processor::calculateDeterminate)
        .add("Inverse matrix", processor::inverseMatrix)
        .build()
        .run();
```

### Factory Pattern

The interface Matrix has a fabric to create an object of type Matrix:

```java
static Matrix create(final int rows, final int cols, final double[] elements) {...}
```

### Command Pattern

The class MenuBuilder has a class Command and uses the Command pattern to execute actions.

### Facade Pattern

The project contains an interface `ProcessorFacade` and an implementation `ProcessorImplementation`. 

### Strategy Pattern

To transpose a matrix the project uses different strategies described in the class 'TranspositionStrategy'.

