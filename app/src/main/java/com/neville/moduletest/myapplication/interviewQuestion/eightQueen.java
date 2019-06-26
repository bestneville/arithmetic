package com.neville.moduletest.myapplication.interviewQuestion;

/**
 * Created by niewei on 2019/6/25.
 */

//八皇后，8*8的棋盘，放8个棋子(皇后)，要求每个棋子 行，列，对角线都不能有其他棋子，打印出所有可能的摆法
public class eightQueen {
    private static int[] result = new int[8];//index是row，存column

    public static void main(String[] args) {
        call8queen(0);
    }

    private static void call8queen(int row) {
        if (row == 8) {
            printResult(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                call8queen(row + 1);
            }
        }

    }

    //逐级向上排查
    private static boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {//当前column是否有棋子
                return false;
            }
            if (leftUp >= 0 && result[i] == leftUp) {//左对角线是否有棋子
                return false;
            }
            if (rightUp <= 7 && result[i] == rightUp) {//右对角线是否有棋子
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private static void printResult(int[] result) {

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
