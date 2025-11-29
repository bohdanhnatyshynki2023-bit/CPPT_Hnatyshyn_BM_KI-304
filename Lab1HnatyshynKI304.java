import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Lab1HnatyshynKI304 class implements a program that creates a square
 * character matrix and outputs it to the console and a file.  
 * The program asks the user for the matrix size and a filler character,
 * then draws a square where the lower half contains a centered
 * isosceles triangle made of the filler character.
 *
 * @author Bogdan Hnatyshyn
 * @version 2.0
 */
public class Lab1HnatyshynKI304 {

    /**
     * Fills a 2D square character array with spaces.
     *
     * @param arr 2D square array to be filled
     * @param size Size of the square matrix
     */
    static void fillArray(char arr[][], int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = ' ';
            }
        }
    }

    /**
     * Initializes a 2D square character array, allocating memory for each row.
     *
     * @param arr 2D array to be initialized
     * @param size Size of the square matrix
     */
    static void MakeArr(char arr[][], int size) {
        for (int i = 0; i < size; i++) {
            arr[i] = new char[size];
        }
    }

    /**
     * Draws a centered isosceles triangle in the lower half of the square.
     *
     * @param arr 2D square array where the triangle is drawn
     * @param size Size of the square matrix
     * @param filler Character used for filling
     */
    static void drawTriangle(char arr[][], int size, char filler) {
        int topRow = size / 2;   // row from which triangle starts
        int center = size / 2;   // center column
        for (int i = topRow; i < size; i++) {
            int dist = i - topRow;
            int left = center - dist;
            int right = center + dist;
            for (int j = left; j <= right && j < size; j++) {
                if (j >= 0) arr[i][j] = filler;
            }
        }
    }

    /**
     * Main program method. Requests the square size and filler character,
     * constructs the matrix with a lower triangle, and outputs it to
     * the console and a file "MyFile.txt".
     *
     * @param args Command line arguments (not used)
     * @throws FileNotFoundException Thrown if the output file cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows = 0;           // Size of square matrix
        char arr[][];            // 2D array for the matrix
        String filler;           // Filler character
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Ask the user for matrix size
        System.out.println("Enter size of square matrix: ");
        nRows = in.nextInt();
        arr = new char[nRows][];

        // Initialize the array
        MakeArr(arr, nRows);
        fillArray(arr, nRows);

        // Ask the user for the filler character
        System.out.println("Enter symbol-filler: ");
        in.nextLine(); // clear buffer
        filler = in.nextLine();

        if (filler.length() == 1) {
            char symbol = filler.charAt(0);
            drawTriangle(arr, nRows, symbol);

            System.out.println("Your matrix with size " + nRows + " and made of character '" + symbol + "'");

            // Print the final square matrix
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nRows; j++) {
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }
                System.out.println();
                fout.print("\n");
            }
        }
        else if (filler.length() == 0) {
            System.out.println("You didn't enter a filler character");
        }
        else {
            System.out.println("Too many characters entered for filler");
        }

        // Close resources
        fout.close();
        in.close();
    }
}
