static int maxSumArray(int[] arr, int size){
    int max_so_far =0;
    int max_ending_here = 0;
    int start =0, s=0;
    int end =0;
    
    for(int i=0;i<size;i++){
        max_ending_here = max_ending_here + arr[i];
        if(max_ending_here < 0){
            max_ending_here = 0;
            s = i+1;
        }
        if(max_ending_here > max_so_far)
            max_so_far = max_ending_here;
            start = s;
            end = i;
    }
    for(int i=start;i<end;i++){
        System.out.print(arr[i] + "h ");
        
    }
        System.out.println();
    
    return max_so_far;
}

 static boolean matfind(int[][] mat, int row, int col, int k){
        int [] temp;// = new int[col];
        int i = 0;
        while(i<row){
            temp = mat[i];
            if(binsearch(temp,0,col-1,k)){
                             return true;
                //break;
            }
            else i++;
        }
        return false;
    }
    
    static boolean binsearch(int[] a, int low,int high, int k){
        int mid = (low+high)/2;
      if(low <= high){
        if(a[mid] == k)
            return true;
        if(k < a[mid])
           return binsearch(a,low,mid-1,k);
        if(k > a[mid])
           return binsearch(a,mid+1,high,k);
               
      }
      return false;
    }


 static void recreverse(String s){
        int n = s.length();
      if(s == null || n<=1)
          System.out.print(s);
      else{
          System.out.print(s.charAt(n-1));
          recreverse(s.substring(0, n-1));
      }
     
    }

 static void revarray(char[] a,int start, int end){
        while(start<= end){
           char temp = a[start];
           a[start++] = a[end];
           a[end--] = temp;
                   }
    }

 


 static String super_reduced_string(String s){
        // Complete this function
       Stack <Character> stack = new Stack();
       for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop(); // since String has 2 adjacent equal characters
            } else {
                stack.push(ch);
            }
       }
       if(stack.isEmpty()){
           System.out.println("Empty String");
           return "";
       }
       else{
           String t ="";
           for (char ch : stack) {
                t = t+ch;
       }
           return t;
    }
    }

import java.util.Stack;

  HashMap <Integer,Integer> hm = new HashMap <Integer,Integer>();
  
  for(int i=0;i<arr.length;i++){
     // int count = 
      if(hm.containsKey(arr[i])){
          int count = hm.get(arr[i]);
          count++;
          hm.put(arr[i], count);
      }
      else{
          hm.put(arr[i], 1);
      }
  }
  System.out.println(hm);
  System.out.println(hm.keySet());
  // int temp = Integer.MAX_VALUE;
  for(int i=0;i<arr.length;i++){     
      if(hm.get(arr[i])!=null && hm.get(arr[i])%2 == 0 )
      {   //temp = arr[i];  
          System.out.print(arr[i]);
          hm.remove(arr[i]);
      }
  }


 int a1 = 9999999;
   int a2 = 10000;
   int sum = a1+a2;
   //System.out.println(Integer.toBinaryString(a1));
   //System.out.println(Integer.toString(a1));
   
   int n1 = Integer.toString(a1).length();
   int n2 = Integer.toString(a2).length();
   
   int sumn = Integer.toString(sum).length();
   
   if(sumn == n2)
       System.out.println(sum);
   else
       System.out.println(a2);


LinkedList<Integer> [] lis = new LinkedList[arr.length];
   for(int i=0;i<lis.length;i++)
   { lis[i] = new LinkedList();
   }
       lis[0].addFirst(arr[0]);

   for(int i=1;i<arr.length;i++){
       for(int j=0;j<= i-1;j++){
           if(arr[i]>arr[j] && lis[i].size < lis[j].size+1){
                              lis[i] = lis[j];
           }
       }
       lis[i].addFirst(arr[i]);
   }
   
   
   int max = lis[0].size;
   LinkedList<Integer> maxseq = lis[0];
   for(int k=1;k<lis.length;k++)
   {
       if(lis[k].size > max)
           max = lis[k].size;
           maxseq = lis[k];
   }
         System.out.println(max);
      ///can use ITERATOR to print the linked list
        System.out.println(maxseq);

   
  static void removeDup(String str){
        ///What is a HASHSET
        LinkedHashSet<Character> list = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++)
        { list.add(str.charAt(i));
            for(Character c : list)
            System.out.print(c);
            System.out.println();
        }
           String temp = list.toString();
        System.out.println(temp);
        
        for(Character c : list)
            System.out.print(c);
        
        
    }
      

static boolean isTriplet(int ar[], int n)
    {
        for (int i=0; i<n-2; i++)
        {
            for (int j=i+1; j<n-1; j++)
            {    
                for (int k=j+1; k<n; k++)
                {
                    // Calculate square of array elements
                    int x = ar[i]*ar[i], y = ar[j]*ar[j], z = ar[k]*ar[k];
  
                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }
  
        // If we reach here, no triplet found
        return false;
    }
    
    
    static void printalt(String s1, String s2){
        int n= s1.length();
        int m = s2.length();
        int i=0, j=0;
        String s3 = "";
        while(i<n && j<m){
      
            s3 = s3 + s1.charAt(i);
            i++;
            //System.out.println(s3);
            s3 = s3 + s2.charAt(j);
            j++;
                      //  System.out.println(s3);

            
        }
       // if(i == j)
       // System.out.println(s3);
        if(j == m && i == n){
            //s3 = s3 + s1.substring(i);
            System.out.println(s3);
        } 
        
        if(j == m && i<n){
            s3 = s3 + s1.substring(i);
            System.out.println(s3);
        } 
        
        if(i == n && j<m){
            s3 = s3 + s2.substring(j);
            System.out.println(s3);
        }
    }
  
   
    
    static String stringsort(String s){
        char [] temp = s.toCharArray();
        Arrays.sort(temp);      
   String s1  = new String(temp);
   return s1;
   
    }
    

 Node reverse(Node head,int k){
                int count = 0;
                Node curr = head;
                Node prev = null;
                Node next  = null;
                
                while(count<k && curr != null){
                next = curr.next;
                    curr.next = prev;
                prev = curr;
                curr = next;
                count++;
             //   System.out.print(curr.data+" "+next.data);
                }
                if(next!=null){
                    head.next = reverse(next,k);
                }
                return prev;                   
            }

static int num10(int num, int m){
    
      int temp1 =num;
      int temp2 = num;
          int i=0;
          int  j=0;
          if(num%m == 0){
              return num;
                        }
           while(temp1<Integer.MAX_VALUE){
               temp1++;
               i++;
               if(temp1 % m == 0)
               {   //temp1 = num; 
                System.out.println(temp1+"x");
                   break;
               }
               
               }
           
      while(temp2>Integer.MIN_VALUE){
               temp2--;
               j++;
               if(temp2 % m == 0){
                   ///temp2 = num;
                   System.out.println(temp2+"x");
                   break;
               }
           }
      
      System.out.println(i + "x"+ j);
      
      if(i==j)
          return temp1;
      if(i<j)
          return temp1;
      if(i>j)
          return temp2;
            
   return 0;
   
}

static int val(String a, int pos)
{
    if (pos >= a.length())
        return 0;
 
    //  converting character to integer
    return (a.charAt(pos)-'0');  
}
 static int num10(int num, int m){
    
      int temp1 =num/m;
      int temp2 = temp1 * m;
      int temp3 = (temp1+1) * m;
      
     if(Math.abs(temp2-num)<Math.abs(temp3-num))
         return temp2;
     if(Math.abs(temp2-num)>Math.abs(temp3-num))
         return temp3;
     if(Math.abs(temp2-num) == Math.abs(temp3-num))
         return temp3;
          
               
              
   return 0;
   
}

HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i =0;i<n;i++){
            if(hm.containsKey(ar[i])){
                int count = hm.get(ar[i]);
                count++;
                hm.put(ar[i],count);
            }
            else
                hm.put(ar[i],1);
        }
      int pairs = 0;
        for(Integer frequency : hm.values()) {
           System.out.print(frequency+" ");
            pairs += frequency/2;
        }
        System.out.println(pairs);

 static int min(int a,int b,int c){
         if(a<b && a<c)
             return a;
         else if(b<a && b<c)
             return b;
         //if(c<a && c<b)
         else
             return c;
         
     }
     static int editdis(String s1, String s2, int n, int m ){
         if(n == 0)
             return m;
         if(m == 0)
             return n;
         
         if(s1.charAt(n-1) == s2.charAt(m-1))
             return editdis(s1,s2,n-1,m-1);
         else{
             return 1+ min(editdis(s1,s2,n-1,m-1),editdis(s1,s2,n-1,m),editdis(s1,s2,n,m-1));
         }
     }

 static void revstack(Stack<Integer> st){
         if(st.isEmpty()){
             return;
         }else {
             int temp = st.peek();
             st.pop();
             revstack(st);
             insertBottom(st,temp);
         }
     }
     static void insertBottom(Stack<Integer> st,int x){
         if(st.isEmpty())
             st.push(x);
         else{
            
                 int temp = st.peek();
                 st.pop();
                 insertBottom(st,x);
                 st.push(temp);
            // }
         }
     }
 static void med(int [] a1, int [] a2, int n){
         if(n == 0)
            System.out.print("nothing ");
         int count =0;
         int i=0; int j=0;int k =0;
         int [] b = new int[n+1];
         while(i<n && j<n && k<n+1){
             if(a1[i] < a2[j] )
             {  b[k] = a1[i];
                k++; i++;
             }
             if(a1[i] >= a2[j] && k<n+1)
             {    b[k] = a2[j];
                k++; j++;
             }
             
             for(int g : b){
                 System.out.print(g+" ");
             }
             System.out.println();
         }
         
         int med = (b[n-1] + b[n])/2;
         
         System.out.println(med +"  ");
         
     }

static int smallest(int [][] cost, int m, int n){
    if(m == 0 && n == 0)
        return cost[0][0];
    else if(m<0 || n<0)
        return Integer.MAX_VALUE;
    else
            return cost[m][n] + min(smallest(cost,m,n-1), smallest(cost,m-1,n), smallest(cost,m-1,n-1));
} 
    static int min(int a,int b,int c){
         if(a<b && a<c)
             return a;
         else if(b<a && b<c)
             return b;
         //if(c<a && c<b)
         else
             return c;
         
     }
public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        
        return new String(charArray);
       // return String.valueOf(charArray);
    }
public static void permute(String str, int l, int h){
    if(l == h)
        System.out.println(str);
    else {
    for(int i=l;i<=h;i++){
        str = swap(str,l,i);
        permute(str,l+1,h);
        str = swap(str,l,i);
    }
    }
}
static int numpath(int m, int n){
    
    if(m ==0 || n==0)
        return 0;
    if(m ==1 || n==1)
        return 1;
     
        return numpath(m,n-1)+numpath(m-1,n); 
}

static int numpath(int m, int n){
    
    int a = fact(m-1);
    int b = fact(n-1);
    int c = fact(m+n-2);
    
    return (c/(a*b));
}
static boolean binsearch(int[] a, int low,int high, int k){
        int mid = (low+high)/2;
      if(low <= high){
        if(a[mid] == k)
            return true;
        if(k < a[mid])          
 return binsearch(a,low,mid-1,k);
        if(k > a[mid])
           return binsearch(a,mid+1,high,k);
               
      }
      return false;
    }
    static int fact (int n){
        if(n == 0|| n== 1)
            return 1;
        else
            return n*fact(n-1);
    }

/////////////halloween wala
int howManyGames(int p, int d, int m, int s) {
    int games = 0;
    while (s >= p) { // while we can buy the next game

        // buy the next game
        s -= p;
        games++;

        // update the price (using the snippet above)
        p -= d;
        if (p < m) p = m;
    }
    return games;
}

public static int edit_dis(String s1,String s2,int m,int n){
    int [][] dp = new int[m+1][n+1];
    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0)
                dp[i][j] = j;/////DHYAN RHE...USE OF ELSE IF CLEVER
            else if(j==0)
                dp[i][j] = i;
            else if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = 1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
            
        }
    }
    return dp[m][n];
    
}    
///LCS by DP
public static int LCS(String a, String b, int m, int n){
        int [][] x = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                
        if(i == 0 || j == 0){
            x[i][j] = 0;
        }
        else if(a.charAt(i-1) == b.charAt(j-1)){
            x[i][j] = 1+x[i-1][j-1];
        }
        else {
            x[i][j] = Math.max(x[i-1][j],x[i][j-1]);
        }
            }
        }
        
        return x[m][n];
    }

////////////SUM STRING DE SHAW
public static String getsum(String s1,String s2){
        int sum = Integer.parseInt(s2)+ Integer.parseInt(s1);
        return (new String(Integer.toString(sum)));
    }
    
    public static boolean isumstr(String str, int low, int len1, int len2){
        String s1 = str.substring(low,low+len1);
        String s2 = str.substring(low+len1,low+len1+len2);
        String s3 = getsum(s1,s2);
        int len3 = s3.length();
        
        ////now we have to check conditions and return
        if(low+len1+len2+len3 > str.length()) return false;        
        if( str.substring(low+len1+len2,low+len1+len2+len3).equals(s3)){
            if (low+len1+len2+len3 == str.length()) return true;
            
            return isumstr(str,low+len1,len2,len3);
        }
        return false;    
    }
    public static boolean isumst(String str, int n){
        for(int i=1;i<n;i++){
                for(int j=1;i+j<n;j++){
                if(isumstr(str,0,i,j)) return true;
            }
        }
        return false;
    }
public boolean printancestorrs(Node root, int key){
        if(root == null )
            return true;
        if(root.data == key)
                return true;
        if(printancestorrs(root.left,key) || printancestorrs(root.right,key)){
            print(node.data);
            return true;
        }
        return false;
    }