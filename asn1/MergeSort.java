public class MergeSort
{

    public static void mergeSort(int[] A, int p, int r)
    {
        int q;
        if (p < r)
        {
            q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];
        int i, j, k;

        for (i = 0; i < n1; i++)
        {
            L[i] = A[p + i];
        }
        for (j = 0; j < n2; j++)
        {
            R[j] = A[q + j + 1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        i = 0;
        j = 0;
        for (k = p; k <= r; k++)
        {

            if (L[i] <= R[j])
            {
                A[k] = L[i];
                i = i + 1;
            }
            else
            {
                A[k] = R[j];
                j = j + 1;

            }
        }
    }


    public static void main(String[] args)
    {

        int n = Integer.parseInt(args[0]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = n - i;

        System.out.printf("Merge Sort on %d elements. \n", n);

        System.out.print("First 20 elements before sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");

        mergeSort(arr, 0, n-1);

        System.out.print("\nFirst 20 elements after sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
        System.out.print("\n");

    }
}

