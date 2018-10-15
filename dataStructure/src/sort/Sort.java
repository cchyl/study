package sort;

public class Sort {


    public void selectSort(int[] data){
        int length= data.length;
        int temp;
        for (int j=length;j>1;j--){
            int max =0;//用来标记最值的位置
            for (int i=1;i<j;i++){
                if(data[i]>data[max])
                    max=1;
                if (max!=j-1){
                    temp=data[max];
                    data[max] =data[j-1];
                    data[j-1]=temp;
                }
            }
        }
    }


    void insertionSort(int[] data){

    }
}
