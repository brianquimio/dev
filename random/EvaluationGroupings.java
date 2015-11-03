package random;

public class EvaluationGroupings {

    public static void main(String[] args) {

        int[] n = {2,3,2,4};

        int[] ans = new int[5];
        ans[0] = ((n[0]+n[1])*n[2])+n[3];
        ans[1] = (n[0]+(n[1]*n[2]))+n[3];
        ans[2] = (n[0]+n[1])*(n[2]+n[3]);
        ans[3] = n[0]+((n[1]*n[2])+n[3]);
        ans[4] = n[0]+(n[1]*(n[2]+n[3]));

        int odd = 0;
        int even = 0;

        for(int i=0;i<ans.length;i++) {
            if(ans[i]%2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even: " + even + "\nOdd: " + odd);


    }

}



