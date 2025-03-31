public class KakaoMain {

    //카카오 모빌리티 3문제 130분
    public static void main(String[] args) {

        KakaoSolution solution = new KakaoSolution();

        // solution1
        String S = "Jonn Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        System.out.println("solution1:" + solution.solution1(S , C));
        System.out.println("#######################");


        // solution2
        int[] T0 = {0,0,1};
        int[] B0 = {2}; // 3반환
        System.out.println("solution2:" + solution.solution2(T0, B0));

        int[] T1 = {0,0,0,0,2,3,3};
        int[] B1 = {2,5,6}; // 5반환
        System.out.println("solution2:" + solution.solution2(T1, B1));

        int[] T2 = {0,0,1,2};
        int[] B3 = {1,2}; // 3반환
        System.out.println("solution2:" + solution.solution2(T2, B3));

        int[] T3 = {0,3,0,0,5,0,5};
        int[] B4 = {4,2,6,1,0}; // 7반환
        System.out.println("solution2:" + solution.solution2(T3, B4));
        System.out.println("#######################");


        // solution3
        int[] A0 = {3,2,3,2,3};//5  => all
        System.out.println("solution3:" + solution.solution3(A0));

        int[] A1 = {7,4,-2,4,-2,-9};//4  => [4,-2,4,-2]
        System.out.println("solution3:" + solution.solution3(A1));

        int[] A2 = {7,-5,-5,-5,7,-1,7};//3  => [-5,-5,-5] and [7,-1,7]
        System.out.println("solution3:" + solution.solution3(A2));

        int[] A3 = {4};//1
        System.out.println("solution3:" + solution.solution3(A3));


    }



}