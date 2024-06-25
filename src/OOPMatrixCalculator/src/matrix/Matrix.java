/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import validate.Validator;

/**
 *
 * @author win
 */
public class Matrix {

    private int rows; // Number of rows in the matrix
    private int cols; // Number of columns in the matrix
    private int[][] data; // The data representing the matrix

    /**
     * Constructs a Matrix object with the specified number of rows and columns.
     *
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    /**
     * Default constructor for Matrix class.
     */
    public Matrix() {
    }

    /**
     * Sets the data for the matrix.
     *
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     * @param data The data to be set for the matrix.
     */
    public void setData(int rows, int cols, int[][] data) {
        this.cols=cols;
        this.rows=rows;
        this.data = new int[rows][cols];
        this.data = data;
    }

    /**
     * Gets the value at the specified row and column in the matrix.
     *
     * @param row The row index.
     * @param col The column index.
     * @return The value at the specified row and column in the matrix.
     */
    public int get(int row, int col) {
        return data[row][col];
    }

    /**
     * Adds the given matrix to this matrix.
     *
     * @param other The matrix to be added to this matrix.
     */
    public void add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same"
                    + " dimensions.");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
    }

    /**
     * Subtracts the given matrix from this matrix.
     *
     * @param other The matrix to be subtracted from this matrix.
     */
    public void subtract(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have "
                    + "the same dimensions.");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
    }

    /**
     * Multiplies this matrix with the given matrix.
     *
     * @param other The matrix to be multiplied with this matrix.
     */
    public void multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Number of columns in the "
                    + "first matrix must be equal to the"
                    + " number of rows in the second matrix.");
        }
        Matrix result = new Matrix(rows, other.cols); 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        setData(result.rows, result.cols, result.data);
    }

    /**
     * Prompts the user to input values for the matrix.
     *
     * @param messInputRow  The message for inputting the number of rows.
     * @param messInputCol  The message for inputting the number of columns.
     * @param messInputData The message for inputting the matrix data.
     */
    public void inputMatrix(String messInputRow, String messInputCol,
            String messInputData) {
        rows = Validator.getInt(messInputRow, "row matrix must be >0",
                "Please enter integer number", 1, Integer.MAX_VALUE);
        cols = Validator.getInt(messInputCol, "column matrix must be >0",
                "Please enter integer number", 1, Integer.MAX_VALUE);
        data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Validator.getInt(
                        String.format(messInputData + " [%d][%d]:", i, j),
                        "Error range", "Values of matrix is digit",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    /**
     * Displays the matrix on the console.
     */
    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println();
        }
    }
}
