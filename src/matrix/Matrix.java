package matrix;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A generic 2D-matrix.
 *
 * @param <E> the cell type.
 */
public class Matrix<E> implements Iterable<E> {
    private ArrayList<ArrayList<E>> matrix;
    private int rows, columns;

    /**
     * Constructs a Matrix.
     *
     * @param rows    - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new ArrayList<ArrayList<E>>();

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<E>());
            for (int j = 0; j < columns; j++) {
                matrix.get(i).add(null);
            }
        }
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row    - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value  - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        matrix.get(row).set(column, value);
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row    - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        E result = matrix.get(row).get(column);
        return result;
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
        int numCells = rows * columns;
        return numCells;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        String string = "";
        // Loop through every row
        for (int i = 0; i < rows; i++) {
            // Loop through every column
            for (int j = 0; j < columns; j++) {
                // Get a single cell value
                string += this.get(i, j);
                // Insert a teb if there is a following value on same row
                if (j != columns - 1) {
                    string += "\t";
                }

            }
            // Insert a new line for next row
            if (i != rows - 1) {
                string += "\n";
            }
        }
        return string;
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int col = 0, row = 0;

            @Override
            public boolean hasNext() {
                return col < columns;
            }
            // Same column next row -> column-major order
            @Override
            public E next() {
                E result = matrix.get(row++).get(col);
                if (row == rows) {
                    row = 0;
                    col++;
                }
                return result;
            }
        };
    }
}