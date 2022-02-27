package org.saulesmeita.matrix;

/**
 * Matrix Processor facade
 */
public interface ProcessorFacade {
    void addMatrices();

    void multiplyByConstant();

    void multiplyMatrices();

    void transpose(TranspositionStrategy mode);

    void calculateDeterminate();

    void inverseMatrix();
}
