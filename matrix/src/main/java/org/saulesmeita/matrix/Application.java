package org.saulesmeita.matrix;

import org.saulesmeita.menu.MenuBuilder;

public record Application(ProcessorFacade processor) implements Runnable {

    @Override
    public void run() {
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
    }
}
