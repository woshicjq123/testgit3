import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.get(1);
        Iterator iter = list.iterator();
        String str = "Hello";
        str.toLowerCase();
    }

    void Merge(int r[],int r1[],int s,int m,int t)
    {
        int i=s;
        int j=m+1;
        int k=s;
        while(i<=m&&j<=t)
        {
            if(r[i]<=r[j])
                r1[k++]=r[i++];
            else
                r1[k++]=r[j++];
        }
        while(i<=m)
            r1[k++]=r[i++];
        while(j<=t)
            r1[k++]=r[j++];
        for(int l=0; l<8; l++)
            r[l]=r1[l];
    }

    void MergeSort(int r[],int r1[],int s,int t)
    {
        if(s==t)
            return;
        else
        {
            int m=(s+t)/2;
            MergeSort(r,r1,s,m);
            MergeSort(r,r1,m+1,t);
            Merge(r,r1,s,m,t);
        }
    }

}