// MatrixOps.java
import java.util.Scanner;

public class MatrixOps {
    static int[][] readMatrix(Scanner sc, int r, int c) {
        int[][] m = new int[r][c];
        System.out.println("Enter " + (r*c) + " elements:");
        for (int i=0;i<r;i++)
            for (int j=0;j<c;j++)
                m[i][j] = sc.nextInt();
        return m;
    }
    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
    static int[][] add(int[][] a, int[][] b) {
        int r=a.length, c=a[0].length;
        int[][] res = new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=a[i][j]+b[i][j];
        return res;
    }
    static int[][] subtract(int[][] a, int[][] b) {
        int r=a.length, c=a[0].length;
        int[][] res = new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=a[i][j]-b[i][j];
        return res;
    }
    static int[][] multiply(int[][] a, int[][] b) {
        int r=a.length, c=b[0].length, n=a[0].length;
        int[][] res = new int[r][c];
        for(int i=0;i<r;i++)
          for(int j=0;j<c;j++)
            for(int k=0;k<n;k++)
              res[i][j]+=a[i][k]*b[k][j];
        return res;
    }
    static int[][] transpose(int[][] a) {
        int r=a.length, c=a[0].length;
        int[][] t = new int[c][r];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) t[j][i]=a[i][j];
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows cols for matrix A: ");
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] A = readMatrix(sc, r, c);
        System.out.print("Rows cols for matrix B: ");
        int r2 = sc.nextInt(), c2 = sc.nextInt();
        int[][] B = readMatrix(sc, r2, c2);

        System.out.println("A + B (if same size):");
        if (r==r2 && c==c2) printMatrix(add(A,B)); else System.out.println("Not possible");

        System.out.println("A - B (if same size):");
        if (r==r2 && c==c2) printMatrix(subtract(A,B)); else System.out.println("Not possible");

        System.out.println("A * B (if A.cols == B.rows):");
        if (c==r2) printMatrix(multiply(A,B)); else System.out.println("Not possible");

        System.out.println("Transpose of A:");
        printMatrix(transpose(A));
        sc.close();
    }
}
