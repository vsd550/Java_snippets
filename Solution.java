import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private final int [] empty ={}; // to return an empty array..in case u need to
    public class Pair{
        int first;
        int second;
       public Pair(int first, int second){
            this.first = first;
            this.second = second;
            
        }
    }
      public static void main(String[] args) {
        Solution sol = new Solution();
        String line1 = "12243660";
        ArrayList <int []> ret = new ArrayList <int []>();
        String str = "vijay is boss";
        String str2 = "vijay";
      //System.out.print(longestoftwo(str,str2));
        String [] split  = str.split(" ");
        int a =9; int b =8;
        sol.swap(a, b);
        System.out.println(a);  // a nice illustration that a will not change 
//        printarraystring(split);
        int[] ns = new int[] {1,2,3,4,5,0};
        
        String reverse = sol.reverse_string(str);
        System.out.println(reverse);
        
 
    }
     // SOME JAVA SNIPPETS
      public String reverse_string(String str){
          return new StringBuilder(str).reverse().toString();
      }
      public int array_sum_withstream(int[] A ){
          return Arrays.stream(A).sum();
      }
      /*Note: Explore the possibilities of Array Stream */
      public int min_in_array(int [] A){
          return Arrays.stream(A).min().getAsInt();
      }
      public void swap(int a, int b){
        int temp = a;
        a = b;
        b= temp;
        }
      public static void printarrayint(int [] A){
          for(int i=0;i< A.length;i++){
              System.out.print(A[i]+" ");
          }
      }
      public static void printarraystring(String [] A){
          for(int i=0;i< A.length;i++){
              System.out.print(A[i]+" ");
          }
      }
    public static String longestoftwo(String A,String B){
        String temp = A;
        String temp2 = B;
        if(A.length() >= B.length())
            {temp = B;
            temp2 = A;
                
            }
        for(int i=temp.length();i>=0;i--){
            if(temp2.startsWith(temp.substring(0,i)) )
                return temp.substring(0,i);
        }
        return "";
            
    }

    
    public void swap_within_array(int [] A,int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b]= temp;
    } 

      public static int arraygcd(int [] a,int n){
          if (n == 0) return 0;
          if(n ==1) return a[0];
          
          int result = a[0];
          for(int i=1;i<n;i++){
              result = gcd(result,a[i]);
          }
          return result;
      }
      public static int gcd(int a, int b){
          if(a ==0 || b == 0)return 0;
          if(a== b) return a;
          
          if(a>b) return gcd(a-b,b);
          else
          return gcd(a,b-a);
      }
    public boolean findpairs(int [] a,int n){
        HashMap <Integer,Pair> hm = new HashMap();
        HashSet<Integer> h = new HashSet<>();
        
        
        for(int i=0;i<n;i++){
            for (int j = i+1;j<n;j++){
                int sum = a[i]+a[j];
                if(!hm.containsKey(sum)){
                    hm.put(sum,new Pair(a[i],a[j]));
                }
                else{
                    Pair p = hm.get(sum);
                    System.out.println(a[i]+"xx"+a[j]);
                    return true;
                }
            }
        }
        return false;
    }
    public static int maxlenzerosum(int [] arr){
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        // a hm that has key as sum and value i where that sum occurs
        // we check that if sum already exists, if it exists there is a zero sum subarray
        // then maxlen = max(maxlen,i-previ)
        int sum = 0;
        int max_len = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0)
                max_len = 1;
            sum = sum+arr[i];
            if(sum == 0){
                max_len = i+1;
            }
            if(hm.containsKey(sum))
            {   Integer prev_i = hm.get(sum);
                    max_len = Math.max(max_len, i - prev_i);
                    }
            else {
                hm.put(sum, i);
            }
            
        }
        return max_len;
    }
    public static int binsearch(int [] a,int low, int high, int val) {
        ArrayList<Integer> arr = new ArrayList();
        //a//rr.g
        if(a.length == 0)
            return -1;
        if(high < low)
            return -1;
        int mid = (low+high)/2;
        arr.add(mid);
        if(a[mid] == val)
            return mid;
        else if(val > a[mid])
            return binsearch(a,mid+1,high,val);
        else
            return binsearch(a,low,mid-1,val);
        
    }
    public static int findpivot(int [] a,int low, int high, int val) {
        if(a.length == 0)   
            return -1;
        if(high < low)
            return -1;
        int mid = (low+high)/2;
        if(a[mid] == val)
            return mid;
        else if(val > a[mid])
            return binsearch(a,mid+1,high,val);
        else
            return binsearch(a,low,mid-1,val);
        }
    public static int minCost(int cost[][], int m, int n)
    { //tc i j represents the min cost path to i, j...so it works accordingly
    int [][] tc = new int[m+1][n+1];
    tc[0][0] = cost[0][0];
    //firs row
    for(int j=1;j<=n;j++){ //cant move up ,have to take a straight path always
        tc[0][j] = cost[0][j] + tc[0][j-1];
    }
    for(int i=1;i<=m;i++){
        tc[i][0] = cost[i][0] + tc[i-1][0];
    }
    
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
        tc[i][j] = cost[i][j] + minofthree(tc[i-1][j-1], tc[i][j-1], tc[i-1][j]);///min tc kalenge...not of the cost okkk
        }
    }
    return tc[m][n];
}
 public static int minofthree(int a,int b,int c){
     return Math.min(a, Math.min(b,c));
 }

     public static int LCsubstr(char X[], char Y[], int m, int n) {
         ///to find the longest common substring
         //uses the longest common suffix property
         //for all i, j between m and n, the max length longest common suffix, is the longest substring
         ///TRY TOVISUALIZE, ITS EASY
         int [][] lcs = new int [m+1][n+1];
         int res = 0;
         
         for(int i=0;i<=m;i++){
             for(int j=0;j<=n;j++){
                 if(i == 0 || j == 0){
                     lcs[i][j] = 0;
                 }
                 if(X[i] == Y[j]){
                     lcs[i][j] = 1+lcs[i-1][j-1];
                     res = Math.max(res, lcs[i][j]);
                 }
                 else
                     lcs[i][j] = 0;
             }
         }
         return res;
     }  
     public static boolean isbalanced_parentheses(String s){
	    Stack <Character> st = new Stack<Character>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                    st.push(s.charAt(i));
                }
                if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']'){
                    //st.push(s.charAt(i));
                    if(st.isEmpty()) return false; ///while popping u have to check this condition, else error
                    else {
                        ///search forismatchingpair
                    }
                }
            }return false;
	}
    public static boolean ispalindrome(String s,int low,int high){
        while(high>=low){
            if(s.charAt(low) == (s.charAt(high))){
                low++;
                high--;
            }
            else return false;
        }
        return true;
    }
    public static String getsumof_twostrings(String s1,String s2){
        int sum = Integer.parseInt(s2)+ Integer.parseInt(s1);
        return (new String(Integer.toString(sum)));
    }    
}

