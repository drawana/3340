public class MixedSort
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

    static void InsertionSort(int[] A, int p, int r)
    {
        int i, j, key;

        for (j = p + 1; j <= r; j++)
        {
            key = A[j];
            i = j - 1;
            while (i >= p && A[i] > key)
            {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    static void MixedSort(int A[], int p, int r, int k)
    {
        if (p >= r) return;

        if (r - p < k)
        {
            InsertionSort(A, p, r);
        }
        else
        {
            int q = (p + r) / 2;
            MixedSort(A, p, q, k);
            MixedSort(A, q + 1, r, k);
            merge(A, p, q, r);
        }
    }

    public static void main(String[] args)
    {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = n - i;

        System.out.printf("Mixed Sort on %d elements. \n", n);

        System.out.print("First 20 elements before sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");

        MixedSort(arr, 0, n - 1, k);

        System.out.print("\nFirst 20 elements after sorting: ");
        for (int i = 0; i < 20; i++) System.out.print(arr[i] + " ");
        System.out.print("\n");

    }
}

