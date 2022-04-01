package Task3;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {
    //To make double value readable
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        //Init our double array
        double[] nums = new double[15];

        //Method to insert random values into array
        insertValues(nums);

        //Print array and avg of positive values
        printArray(nums);
        System.out.println("Average is " + getAverage(nums));

        //Sort and print
        System.out.println("-----------------------------------Start of sorting----------------------------------------");
        sortArray(nums);
    }

    public static void printArray(double[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void insertValues(double[] nums){
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (-10 + random.nextInt(30));
        }
    }

    public static void sortArray(double[] arr){
        int count = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                double temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i = -1;
            }
            System.out.print(count + ". ");
            printArray(arr);
            count++;
        }
    }

    public static String getAverage(double[] nums){
        double sum = 0;
        int count = 0;
        boolean isAllowed = false;

        for (double d : nums) {
            if(d < 0){
                isAllowed = true;
            }

            if(isAllowed && d > 0){
                sum += d;
                count++;
            }
        }

        return df.format(sum/count);
    }
}
