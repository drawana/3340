// Daniel Rawana
// 250911447
// Cs3340 Asn1 Question 5.a)
public class InsertionSort
{
    static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args)
    {
        
        int n = Integer.parseInt(args[0]);
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = n - i;
        
        System.out.printf("Insertion Sort on %d elements. \n", n);
        
        System.out.print("First 20 elements before sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
            
        sort(arr);
        
        System.out.print("\nFirst 20 elements after sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
        System.out.print("\n");

    }

}

