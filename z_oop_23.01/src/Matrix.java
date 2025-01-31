public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix add(Matrix other) {
        int rows = this.matrix.length;
        int cols = this.matrix[0].length;
        if (rows != other.matrix.length || cols != other.matrix[0].length) {
            throw new IllegalArgumentException("Выступы должны иметь одинаковые размеры.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        int rows1 = this.matrix.length;
        int cols1 = this.matrix[0].length;
        int rows2 = other.matrix.length;
        int cols2 = other.matrix[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Для умножения количество столбцов в первой матрице должно равняться количеству строк во второй матрице.");
        }

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}