/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Solution: (1) merge array. O(m+n)
          (2) find kth element. adjust start of each array. O(log(m+n))
*/

public double findMedianSortedArray_merge(int[] A, int[] B){
        int M = A.length;
        int N = B.length;
        
        int median = (M+N)/2 + 1;
        int pre = 0, cur = 0;
        int in_A = 0, in_B = 0;
        
        for (int k = 1; i<= median; i++){
             int a = in_A==M? Integer.MAX_VALUE: A[in_A];
             int b = in_B == N ? Integer.MAX_VALUE: B[in_B];
             pre = cur;
             cur = Math.min(a, b);
             if (a < b) in_A++;
             else in_B++;
        }
        
        if ( (M+N)%2 == 1){
             return cur;
        }else{
             return (double)(pre + cur)/2.0;
        }
}


public double findMedianSortedArrays_kth(int A[], int B[]) {
    int M = A.length;
    int N = B.length;
    boolean isOdd = ((M+N)%2==1);
    
    if(isOdd) return findKth(A, 0, M-1, B, 0, N-1, (M+N)/2+1);
    return (findKth(A, 0, M-1, B, 0, N-1, (M+N)/2) + findKth(A, 0, M-1, B, 0, N-1, (M+N)/2 + 1))/2.0;
}
private double findKth(int[] A, int Astart, int Aend, int[] B, int Bstart, int Bend, int k){
    int M = Aend - Astart + 1;
    int N = Bend - Bstart + 1;
    if (M > N) return findKth(B, Bstart, Bend, A, Astart, Aend, k);
    if ( M == 0) return B[Bstart + k - 1]; 
    if (k == 1) return Math.min(A[Astart], B[Bstart]);
    
    int pa = Math.min(M, k/2);
    int pb = k - pa;
    
    if (A[Astart + pa-1] < B[Bstart + pb-1]){
        return findKth(A, Astart+pa, Aend, B, Bstart, Bend, k-pa);
    }else if ( A[Astart + pa - 1] > B[Bstart+pb-1]){
        return findKth(A, Astart, Aend, B, Bstart+pb, Bend, k-pb);
    }else{
        return A[Astart + pa - 1];
    }
}
