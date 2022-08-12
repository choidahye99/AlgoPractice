import java.util.Scanner ;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i =0; i<N; i++){
            arr[i] = sc.nextInt(); 
        }
        sort(arr) ;
        for (int a : arr){
            System.out.println(a+"");
        }
    }
    static void sort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = i ; j > 0 ; j--){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
}
}