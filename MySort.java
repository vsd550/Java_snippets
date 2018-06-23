import java.util.*;
import java.io.*;
///remember Search resultis an abstract class so no need to make a class for it....haha
public class MySort {
    ArrayList<SearchResult> sortThisList(LinkedList <SearchResult> listOfSortableEntries){
        ArrayList<SearchResult> arr = new ArrayList();
       // listOfSortableEntries.sort(Collections.sort(this));
       // listOfSortableEntries.s
        // Collections.sort(list,new MySalaryComp());
                //class MySalaryComp implements Comparator<Empl>
          // Collections.sort(listOfSortableEntries,new SearchResult()); 
          Collections.sort(listOfSortableEntries);
         // Collections.so
          ////////check whether its correct or not...
          for(int i=0; i<listOfSortableEntries.size();i--){
              arr.add(listOfSortableEntries.get(i));
          }
        return arr;
    }
        
    
}
