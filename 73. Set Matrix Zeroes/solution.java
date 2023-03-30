import java.util.*;

class solution {

    public static void main (String args[]){
        int arr[][] = {{1,1,1},{1,0,1},{1,1,1}} ;
        // int arr[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}} ;

        int n = arr.length ;

        printMatrix(arr,n);

        //setZeroesBetter(arr);
        setZeroesOptimal(arr);

        printMatrix(arr,n);


    }

    public static void setZeroesBetter(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;

        boolean markRow[] = new boolean[m];
        boolean markCol[] = new boolean [n];

        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(arr[i][j]==0){
                    markRow[i] = true;
                    markCol[j] = true;
                }
            }
            
        }

        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(markRow[i] || markCol[j]){
                    arr[i][j]=0 ;
                }
            }
            
        }
    }

    public static void setZeroesOptimal(int arr[][]){
        boolean firstRow = false ;
        boolean firstCol = false ;


// Set markers in first row and first column
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(arr[i][j]==0){
                    if(i==0)firstRow = true; // Check if zeroes in first row and first column 
                    if(j==0)firstCol = true;

                    arr[0][j] = 0 ;
                    arr[i][0] = 0 ;
                }
            }
            
        }
//  Replace inner matrix
        for(int i=1 ; i<arr.length ; i++){
            for(int j=1 ; j<arr[0].length ; j++){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0 ;
                }
            }
            
        }
// Check if zeroes in first row and first column 
        if(firstRow){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[0][j] = 0 ;
            }
        }
        if(firstCol){
            for(int i=0 ; i<arr.length ; i++){
                arr[i][0] = 0 ;
            }
        }
    }

    static void printMatrix(int arr[][],int n){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}