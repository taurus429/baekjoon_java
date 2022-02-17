package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // turn
        int[][] turn;
        int turn_count = 0;
        int x;
        int y;

        //group
        int now;
        int pre;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (R > 0) {
            int func = Integer.parseInt(st.nextToken());
            N = arr.length;
            M = arr[0].length;
            int temp;
            switch (func) {
                case 1:
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < N / 2; j++) {
                            int tmp = arr[j][i];
                            arr[j][i] = arr[N - 1 - j][i];
                            arr[N - 1 - j][i] = tmp;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            int tmp = arr[i][j];
                            arr[i][j] = arr[i][M - 1 - j];
                            arr[i][M - 1 - j] = tmp;
                        }
                    }
                    break;
                case 3:
                    turn = new int[M][N];

                    y = N - 1;
                    for (int i = 0; i < N; i++) {
                        x = 0;
                        for (int j = 0; j < M; j++) {
                            turn[x][y] = arr[i][j];
                            x++;
                        }
                        y--;
                    }
                    temp = N;
                    N = M;
                    M = temp;
                    turn_count++;
                    arr = turn;
                    break;
                case 4:
                    turn = new int[M][N];

                    y = 0;
                    for (int i = 0; i < N; i++) {
                        x = M - 1;
                        for (int j = 0; j < M; j++) {
                            turn[x][y] = arr[i][j];
                            x--;
                        }
                        y++;
                    }
                    temp = N;
                    N = M;
                    M = temp;

                    turn_count++;
                    arr = turn;
                    break;
                case 5:
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            pre = arr[i][j];

                            now = arr[i][j + (M / 2)];
                            arr[i][j + (M / 2)] = pre;
                            pre = now;

                            now = arr[i + (N / 2)][j + (M / 2)];
                            arr[i + (N / 2)][j + (M / 2)] = pre;
                            pre = now;

                            now = arr[i + (N / 2)][j];
                            arr[i + (N / 2)][j] = pre;
                            pre = now;

                            arr[i][j] = pre;
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            pre = arr[i][j];

                            now = arr[i + (N / 2)][j];
                            arr[i + (N / 2)][j] = pre;
                            pre = now;

                            now = arr[i + (N / 2)][j + (M / 2)];
                            arr[i + (N / 2)][j + (M / 2)] = pre;
                            pre = now;

                            now = arr[i][j + (M / 2)];
                            arr[i][j + (M / 2)] = pre;
                            pre = now;

                            arr[i][j] = pre;
                        }
                    }
                    break;

            }
            R--;
        }

        if (turn_count % 2 != 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
