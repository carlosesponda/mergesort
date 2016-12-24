/**
 * Created by CEsponda on 9/3/2016.
 * This is a program to test if the IDEA is working properly
 *
 */
import java.util.*;
public class Example
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Example n = new Example();
        int array[] = new int [100];
        for (int i=0; i<array.length; i++)
        {
            array[i]= rand.nextInt(100)+1;
            System.out.print(""+array[i]+" ");
        }
        n.mergesort(array);
        System.out.println("");
        for(int i=0; i<array.length;i++)
        System.out.print(""+array[i]+" ");

    }
    public  void mergesort(int[] array)
    {
        int[] helper = new int[array.length];
        mergesort(array, helper,0, array.length-1);
    }

    private void mergesort(int[] array, int[] helper, int low, int high)
    {
        if(low<high)
        {
            int middle=(low+high)/2;
            mergesort(array,helper,low,middle);
            mergesort(array,helper,middle+1,high);
            merge(array,helper,low,middle,high);
        }
    }

    private void merge(int[] array, int[] helper, int low, int middle, int high)
    {
        for(int i = low; i <=high; i++)
        {
            helper[i]=array[i];
        }
        int helperLeft = low;
        int helperRight=middle+1;
        int current = low;

        while(helperLeft<= middle && helperRight<= high)
        {
            if(helper[helperLeft]<= helper[helperRight])
            {
                array[current]= helper[helperLeft];
                helperLeft++;
            }
            else
            {
                array[current]=helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = middle-helperLeft;
        for(int i =0; i<= remaining; i++)
        {
            array[current+i]= helper[helperLeft+i];
        }
    }

}
