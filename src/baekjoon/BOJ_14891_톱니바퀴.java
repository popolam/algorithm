package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14891_톱니바퀴 {
	static ArrayList<Integer>[] gear = new ArrayList[4];
    static int gear_direction[] = new int[4];  
    static int score = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            gear[i] = new ArrayList<>();
            String tmp = sc.next();
            for (int j = 0; j < 8; j++) {
                gear[i].add(tmp.charAt(j) - '0');
            }
        }

        int K = sc.nextInt();             
        for (int i = 0; i < K; i++) {
            Arrays.fill(gear_direction, 0);               
            int gear_num = sc.nextInt() - 1;    
            int direction = sc.nextInt();      

            gear_direction[gear_num] = direction;
            right(gear_num);
            left(gear_num);

            for (int j = 0; j < 4; j++) {
                if (gear_direction[j] == 1) {
                    rightTurn(j);
                } else if (gear_direction[j] == -1) {
                    leftTurn(j);
                } else {
                    continue;
                }
            }

        }
        sumScore();
        System.out.print(score);

    }

    static void left(int gear_num) {
        if (gear_num == 0) return;

        if (gear[gear_num - 1].get(2) != gear[gear_num].get(6)) {
            if (gear_direction[gear_num] == 1) {
                gear_direction[gear_num - 1] = -1;
            } else if(gear_direction[gear_num] == -1) {
                gear_direction[gear_num - 1] = 1;
            }
            left(gear_num - 1);
        }
    }

    static void right(int gear_num) {
        if (gear_num == 3) return;                                 

        if (gear[gear_num].get(2) != gear[gear_num + 1].get(6)) {   
            if (gear_direction[gear_num] == 1) {
                gear_direction[gear_num + 1] = -1;
            } else if(gear_direction[gear_num] == -1) {
                gear_direction[gear_num + 1] = 1;
            }
            right(gear_num + 1);
        }
    }

    static void leftTurn(int i) {
        gear[i].add(gear[i].get(0));
        gear[i].remove(0);
    }

    static void rightTurn(int i) {
        gear[i].add(0, gear[i].get(7));
        gear[i].remove(8);
    }

    static void sumScore() {
        for (int i = 0; i < 4; i++) {
            score += gear[i].get(0) * (1 << i);
        }
    }
}
