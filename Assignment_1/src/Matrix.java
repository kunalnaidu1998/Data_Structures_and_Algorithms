import java.util.Scanner;

/**
 * Creates a 2 dimensional matrix
 *
 * Used https://docs.oracle.com/javase/tutorial/java/generics/methods.html
 * to help create generic class
 *
 * @param <T> - Generic type for matrix values
 */
public class Matrix<T> {
    private int rows;
    private int columns;

    private T[][] matrix;

    /**
     * creates empty matrix with specified size for specified object values.
     *
     * Used https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
     * to help create multidimensional matrix
     *
     * @param rows number of rows for the matrix
     * @param columns number of columns for the matrix
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = (T[][]) new Object[rows][columns];
    }

    /**
     * reading from the standard input and creating a matrix
     */
    public void read(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i< rows; i++){
            for (int j = 0; j < columns; j++){
                T value = (T) scanner.next();
                matrix[i][j] = value;
            }
        }
    }

    /**
     * writing to the standard output
     */
    public void write() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * adds input matrix to current matrix.
     *
     * @param secondMatrix matrix to be added
     * @throws IllegalArgumentException throws when matrices aren't the same size
     */
    public void add(Matrix<T> secondMatrix) throws IllegalArgumentException{
        if (this.rows != secondMatrix.rows || this.columns != secondMatrix.columns){
            throw new IllegalArgumentException("Matrix are different sizes");
        }
        for (int i = 0; i< this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                T value = (T) (secondMatrix.matrix[i][j] + this.matrix[i][j]);
            }

        }
    }

    /**
     * takes the summation of all elements of the matrix
     * @return the summation of all elements of the matrix
     */
    public T sum(){
        T totalSum;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < rows; j++){
                totalSum += this.matrix[i][j];
            }
        }
        return totalSum;
    }

}
