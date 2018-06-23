import java.util.*;
import java.io.*;

public class matrix{
    
   static void print(int[][] a , int row, int col){
        int r1 = 0;
        int c1 = 0;
        
        while(r1<row && c1<col){
            for(int i=c1;i<col;i++)
                System.out.print(a[r1][i] +" ");
            
            r1++;
            
            for(int j=r1;j<row;j++)
                System.out.print(a[j][col-1] +" ");
            
            col--;
            
            if(r1<row){
                for(int j=col-1;j>=c1;j--)
                   System.out.print(a[row-1][j] +" ");
                row--;                
            }
            if(c1<col){
                for(int j=row-1;j>=r1;j--)
                   System.out.print(a[j][c1] +" ");
                c1++;                
            }
        }
    }
    
    public static void main(String[] args){
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };
        
        print(a,R,C);
    }
    
}