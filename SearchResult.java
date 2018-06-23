
public abstract class SearchResult implements Comparable {
 PageEntry pagekanam;
 float relevance;
    public SearchResult(PageEntry p, float r){
        pagekanam = p;
        relevance = r;
    }
    public PageEntry getPageEntry(){
        return pagekanam;
    }
    public float getRelevance(){
        return relevance;
    }
     ///@Override
  /*  public int compareTo(SearchResult otherObject) {
        return (this.relevance > otherObject.relevance ? 1:-1);  
        //used for ordering...
    }*/

    //@Override
    public int compareTo(SearchResult otherObject) {
 
        int compare = (int)(((SearchResult)otherObject).getRelevance());
       // return (this.relevance > otherObject.relevance ? 1:-1); 
  // return this.relevance.compareTo/
  return compare-(int)this.getRelevance();
    
    }
   /* public int compareTo(Student comparestu) {
        int compareage=((Student)comparestu).getStudentage();
        /* For Ascending order*/
//        return this.studentage-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
}
