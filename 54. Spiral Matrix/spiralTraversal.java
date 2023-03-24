import java.util.*;

class solution {

    public static void main (String args[]){
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}} ;
        // int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);
        // System.out.println(arr[0].length-1);
        // System.out.println(arr.length-1);
        
    }
    public static List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int maxRow = arr.length-1;
        int maxCol = arr[0].length-1 ;
        int minRow = 0;
        int minCol = 0;

        int totalElem = (maxRow+1)*(maxCol+1) ;
        int cnt = 0 ;

        while(cnt<totalElem){

          

            for(int i=minRow,j=minCol ; j<=maxCol && cnt<totalElem ; j++){
                
                list.add(arr[i][j]);
                cnt++;
                
            }
            minRow++;

            for(int i=minRow,j=maxCol ; i<=maxRow && cnt<totalElem; i++){
                list.add(arr[i][j]);
                cnt++;
            }
            maxCol--;

            for(int i=maxRow,j=maxCol ; j>=minCol && cnt<totalElem; j--){
                list.add(arr[i][j]);
                cnt++;
            }
            maxRow--;

            for(int i=maxRow,j=minCol ; i>=minRow && cnt<totalElem; i--){
                list.add(arr[i][j]);
                cnt++;
            }
            minCol++;

        }
        return list;
    }
    

}