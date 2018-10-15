package sort;

public class MergeSort {

    public void merge(int[] data,int lo,int mi,int hi){
      int[] A = new int[data.length];
      int i=0,k=0,j=0;
      for ( i=lo,j=mi+1,k=0;i<=mi&&j<=hi;){
          if(data[i]<data[j])
              A[k++]=data[i++];
          else
              A[k++]=data[j++];
      }
      while(i<mi){
          A[k++]=data[i++];
      }
      while (j<=hi){
          A[k++]=data[j++];
      }
      for(k=0,i=lo;i<=hi;i++,k++)
          data[i]=A[k];
    }
}
