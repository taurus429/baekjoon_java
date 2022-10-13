package hunt;

import java.io.IOException;
import java.util.*;

interface Opponent {
   int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]);
}

public class Main {
    
    private static int DEER = 0;
    private static int RABBIT = 1;
    private static int SNAKE = 2;

	// ※ 전역변수 및 함수 사용 가능합니다.
	// ※ 단, 팀명을 앞에 prefix로 붙여주세요.
	//     ex) int seoul12_2_sum = 0;
	//     ex) int seoul12_2() { } 
	// ※ 현재 상태에서 빌드 시 사용할 수 있는 API는 사용 가능합니다.
	// ※ 제출방법 : hunt 메소드, 필요한 전역변수, 전역 메소드를 포함하여 txt 파일로 만들어서 제출
    
    static boolean isCooperative(int opp, int opp_last_pattern[]) {
        int dCnt = 0; // 사슴 낸 횟수
        int rCnt = 0; // 토끼 낸 횟수
        for (int pattern : opp_last_pattern) {
            if (pattern == DEER)
                dCnt++;
            else if (pattern == RABBIT)
                rCnt++;
        }

        return dCnt + rCnt > (opp_last_pattern.length / 2) ? true : false;
    }

    static boolean buk04_1_coop = false;
    static int buk04_1_opp_betrayal_cnt = 0;
    static int buk04_1_reprisal_cnt = 0;
    static boolean isInReprisal = false;
    static boolean buk04_1_paneltyCleared = false;
    static Opponent Me = new Opponent() { 
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            if (turn == 0) { // 첫 턴
                //상대방 성향 체크
                // true : 협력적 , false : 비협력적
                buk04_1_coop = isCooperative(opp, opp_last_pattern[opp]);
                //상대방 배신 횟수 초기화
                buk04_1_opp_betrayal_cnt = 0;
                buk04_1_reprisal_cnt = 0;
                //패널티 초기화 체크 변수 초기화
                buk04_1_paneltyCleared = false;

                if (buk04_1_coop) { // 협력적인 사람이면
                    return DEER;
                } else { // 그 외
                    return SNAKE;
                }
            } else if (turn == 9) { // 마지막 턴
                if(buk04_1_reprisal_cnt <=3) // 뱀을내도 점수차가 안좁혀짐
                    return SNAKE;
                else
                    return DEER;
            }
            else {
                if (isInReprisal) { // 보복 하는 중
                    if (buk04_1_opp_betrayal_cnt == buk04_1_reprisal_cnt && opp_prev == DEER) {
                        //보복 끝
                        buk04_1_reprisal_cnt = 0;
                        isInReprisal = false;
                        return DEER;
                    } else if (opp_prev != DEER) {
                        buk04_1_opp_betrayal_cnt++;
                    }

                    if (buk04_1_reprisal_cnt < 6) {
                        buk04_1_reprisal_cnt++;
                        return SNAKE;
                    } else {
                        if (!buk04_1_paneltyCleared) {//패널티 초기화
                            buk04_1_paneltyCleared = true;
                            return DEER;
                        }
                        return SNAKE;
                    }
                } else {
                    if (opp_prev != DEER) { // 상대방 배신
                        buk04_1_opp_betrayal_cnt++;
                        buk04_1_reprisal_cnt++;
                        isInReprisal = true;
                        return SNAKE;
                    } else {
                        return DEER;
                    }
                }
            }
        }
    };
    

	// 아래 Opponent1~3은 테스트용 상대 사냥꾼입니다.
	// 기본 제공 코드는 임의 수정해도 관계 없습니다.
    // 상대방 추가 시, Register 함수를 통해 상대방을 등록합니다. ex) Register("Opp1", Opponent1); 
    /////////////////////////////////////////////////////////////////////////////////////////////찬호
    static int buulgyeong4_1_game = 0;
    static int[] buulgyeong4_1_myRecord; // 이번턴 내기록
    static int[] buulgyeong4_1_oppTotal; // 상대방 전체 기록
    static int[] buulgyeong4_1_firstDecision;
    static int[][][] buulgyeong4_1_reaction = new int[150][3][3]; // 리액션 기록
    static boolean buulgyeong4_1_firstMeet;

    static Opponent Opponent1 = new Opponent() { 
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            /////////////////////////////////////////////////////////////////////////////////////////////
            if (turn == 0) { // 첫 턴인 경우 상대 분석 & 상대 첫 턴 전적 분석
               buulgyeong4_1_game++;
               buulgyeong4_1_myRecord = new int[10];
               buulgyeong4_1_oppTotal = new int[3];
               int[] oppFirst = new int[3];
   
               if (buulgyeong4_1_game > 1) {
                  for (int i = 0; i < buulgyeong4_1_game - 1; i++) {
                     for (int j = 0; j < 10; j++) {
                        if (0 <= opp_last_pattern[i][j] && opp_last_pattern[i][j] < 3)
                           buulgyeong4_1_oppTotal[opp_last_pattern[i][j]]++;
                     }
                  }
                  for (int i = 0; i < buulgyeong4_1_game - 1; i++) {
                     if (0 <= opp_last_pattern[i][0] && opp_last_pattern[i][0] < 3)
                        oppFirst[opp_last_pattern[i][0]]++;
                  }
                  if (buulgyeong4_1_reaction[opp][0][0] == 0 && buulgyeong4_1_reaction[opp][0][1] == 0
                        && buulgyeong4_1_reaction[opp][0][2] == 0 && buulgyeong4_1_reaction[opp][1][0] == 0
                        && buulgyeong4_1_reaction[opp][1][1] == 0 && buulgyeong4_1_reaction[opp][1][2] == 0
                        && buulgyeong4_1_reaction[opp][2][0] == 0 && buulgyeong4_1_reaction[opp][2][1] == 0
                        && buulgyeong4_1_reaction[opp][2][2] == 0) {
                     buulgyeong4_1_firstMeet = true;
                  }
                  if (oppFirst[0] >= oppFirst[1] && oppFirst[0] >= oppFirst[2]) {
                     buulgyeong4_1_firstDecision = new int[] { 0, 1, 2 };
                  } else if (oppFirst[1] >= oppFirst[0] && oppFirst[1] >= oppFirst[2]) {
                     buulgyeong4_1_firstDecision = new int[] { 2, 1, 0 };
                  } else {
                     buulgyeong4_1_firstDecision = new int[] { 2, 1, 0 };
                  }
               } else {
                  buulgyeong4_1_firstDecision = new int[] { 2, 1, 0 };// 아무 기록이 없을 시
                  buulgyeong4_1_firstMeet = true;
               }
               System.out.println(
                     "------------------------" + buulgyeong4_1_game + "번째 경기 분 석 ------------------------");
               System.out.println("상대방 첫 턴 기록" + Arrays.toString(oppFirst));
               System.out.println("상대방 토탈 기록" + Arrays.toString(buulgyeong4_1_oppTotal));
               System.out.println("------------------------------------------------------------");
               buulgyeong4_1_myRecord[turn] = buulgyeong4_1_firstDecision[0];
               return buulgyeong4_1_firstDecision[0]; // 반드시 0 또는 1 또는 2로 리턴해야합니다.
            } else {
               // 기록
               int myPrev = buulgyeong4_1_myRecord[turn - 1];
               buulgyeong4_1_reaction[opp][myPrev][opp_prev]++;
               buulgyeong4_1_oppTotal[opp_prev]++;
   
               if (buulgyeong4_1_firstMeet) {// 첫만남일시
                  if (turn <= 2) {
                     buulgyeong4_1_myRecord[turn] = buulgyeong4_1_firstDecision[turn];
                     return buulgyeong4_1_firstDecision[turn];
                  } else {
                     buulgyeong4_1_firstMeet = false; // 반응 데이터 생성 끝
                     if (buulgyeong4_1_reaction[opp][myPrev][0] > buulgyeong4_1_reaction[opp][myPrev][1]
                           && buulgyeong4_1_reaction[opp][myPrev][0] > buulgyeong4_1_reaction[opp][myPrev][2]) {
                        // 사슴 나올 확률이 높음
                        buulgyeong4_1_myRecord[turn] = 0;
                        return 0;
                     } else if (buulgyeong4_1_reaction[opp][myPrev][1] > buulgyeong4_1_reaction[opp][myPrev][2]
                           && buulgyeong4_1_reaction[opp][myPrev][1] > buulgyeong4_1_reaction[opp][myPrev][0]) {
                        // 토끼 나올 확률이 높음
                        buulgyeong4_1_myRecord[turn] = 2;
                        return 2;
                     } else {
                        // 뱀 나올 확률이 높음, 4번 연속 뱀 냈을 때 사슴으로 바꿔주기
                        if (turn >= 4 && buulgyeong4_1_myRecord[turn - 1] == 2
                              && buulgyeong4_1_myRecord[turn - 2] == 2 && buulgyeong4_1_myRecord[turn - 3] == 2) {
                           buulgyeong4_1_myRecord[turn] = 0;
                           return 0;
                        } else {
                           buulgyeong4_1_myRecord[turn] = 2;
                           return 2;
                        }
                     }
                  }
               } else {
                  buulgyeong4_1_firstMeet = false; // 반응 데이터 생성 끝
                  if (buulgyeong4_1_reaction[opp][myPrev][0] > buulgyeong4_1_reaction[opp][myPrev][1]
                        && buulgyeong4_1_reaction[opp][myPrev][0] > buulgyeong4_1_reaction[opp][myPrev][2]) {
                     // 사슴 나올 확률이 높음
                     buulgyeong4_1_myRecord[turn] = 0;
                     return 0;
                  } else if (buulgyeong4_1_reaction[opp][myPrev][1] > buulgyeong4_1_reaction[opp][myPrev][2]
                        && buulgyeong4_1_reaction[opp][myPrev][1] > buulgyeong4_1_reaction[opp][myPrev][0]) {
                     // 토끼 나올 확률이 높음
                     buulgyeong4_1_myRecord[turn] = 2;
                     return 2;
                  } else {
                     // 뱀 나올 확률이 높음, 4번 연속 뱀 냈을 때 사슴으로 바꿔주기
                     if (turn >= 4 && buulgyeong4_1_myRecord[turn - 1] == 2
                           && buulgyeong4_1_myRecord[turn - 2] == 2 && buulgyeong4_1_myRecord[turn - 3] == 2) {
                        buulgyeong4_1_myRecord[turn] = 0;
                        return 0;
                     } else {
                        buulgyeong4_1_myRecord[turn] = 2;
                        return 2;
                     }
                  }
               }
            }
   
         }
    };
    /////////////////////////////////////////////////////////////////////////////////////////////지훈
   static int[] buulgyeong4_3_MySequence = new int[2];
   static int[] buulgyeong4_3_pattern = new int[10];

    static Opponent Opponent2 = new Opponent() { 
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            if (turn == 0) {
                buulgyeong4_3_MySequence[0] = SNAKE;
                buulgyeong4_3_MySequence[1] = 1;
                return SNAKE;
             }
             // 두 번째 턴부터 상대의 이전 수를 체크
             if (turn > 0)
                buulgyeong4_3_pattern[turn - 1] = opp_prev;
    
             // 이전 패턴 중 현재와 일치하는 것이 있는지 확인
             if (opp_last_pattern.length > 1) {
                boolean flag = true;
                for (int i = 0; i < opp_last_pattern.length; i++) {
                   for (int j = 0; j < turn; j++) {
                      if (buulgyeong4_3_pattern[j] == -1 || opp_last_pattern[i][j] == -1)
                         continue;
                      if (buulgyeong4_3_pattern[j] != opp_last_pattern[i][j]) {
                         flag = false;
                         break;
                      }
                   }
                   // 패턴 일치 경우가 있는 경우
                   if (flag) {
                      // 모를 경우 사슴
                      if (opp_last_pattern[i][turn] == -1) {
                         if (buulgyeong4_3_MySequence[0] == DEER)
                            buulgyeong4_3_MySequence[1]++;
                         else {
                            buulgyeong4_3_MySequence[0] = DEER;
                            buulgyeong4_3_MySequence[1] = 1;
                         }
                         return DEER;
                      }
                      // 상대가 사슴일 경우 사슴리턴
                      else if (opp_last_pattern[i][turn] == 0) {
                         if (buulgyeong4_3_MySequence[0] == DEER)
                            buulgyeong4_3_MySequence[1]++;
                         else {
                            buulgyeong4_3_MySequence[0] = DEER;
                            buulgyeong4_3_MySequence[1] = 1;
                         }
                         return DEER;
                      }
                      // 상대가 토끼
                      else if (opp_last_pattern[i][turn] == 1) {
                         // 현재 뱀을 내도 패널티를 받지 않으면 뱀 리턴
                         if (buulgyeong4_3_MySequence[0] != SNAKE)
                            return SNAKE;
                         else {
                            // 패널티를 적용하여도 뱀을 내는 것이 이득인 경우 뱀
                            if (30 - buulgyeong4_3_MySequence[1] * -3 > 20) {
                               buulgyeong4_3_MySequence[1]++;
                               return SNAKE;
                            }
                            // 패널티를 고려하려 뱀을 내는 것이 손해인 경우 토끼
                            else {
                               buulgyeong4_3_MySequence[0] = RABBIT;
                               buulgyeong4_3_MySequence[1] = 1;
                               return RABBIT;
                            }
                         }
                      }
                      // 상대가 뱀
                      else {
                         // 현재 뱀을 내도 패널티를 받지 않으면 뱀 리턴
                         if (buulgyeong4_3_MySequence[0] != SNAKE)
                            return SNAKE;
                         else {
                            // 패널티를 적용하여도 뱀을 내는 것이 이득인 경우 뱀
                            if (10 - buulgyeong4_3_MySequence[1] * -3 > 0) {
                               buulgyeong4_3_MySequence[1]++;
                               return SNAKE;
                            }
                            // 패널티를 고려하려 뱀을 내는 것이 손해인 경우 토끼
                            else {
                               buulgyeong4_3_MySequence[0] = RABBIT;
                               buulgyeong4_3_MySequence[1] = 1;
                               return DEER;
                            }
                         }
                      }
                   }
                }
             }
             // 상대의 첫상대가 나인 경우 or 패턴 일치 X
             if (buulgyeong4_3_MySequence[0] == SNAKE) {
                if (10 - buulgyeong4_3_MySequence[1] * -3 > 0) {
                   buulgyeong4_3_MySequence[1]++;
                   return SNAKE;
                }
             }
             return DEER;
    
        }
    };
    /////////////////////////////////////////////////////////////////////////////////////////////예림
   static int[] buk4_4_max_a = new int[150];
    static Opponent Opponent3 = new Opponent() { 
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
			// opp_last_pattern 활용 -> [150][10]
            if (turn == 0) {
                // System.out.println(Arrays.toString(opp_last_pattern[opp]));
                int dcnt = 0;
                int rcnt = 0;
                int scnt = 0;
    
                for (int i = 0; i < 10; i++) {
                   if (opp_last_pattern[opp][i] == -1)
                      break;
                   else if (opp_last_pattern[opp][i] == 0)
                      dcnt++;
                   else if (opp_last_pattern[opp][i] == 1)
                      rcnt++;
                   else if (opp_last_pattern[opp][i] == 2)
                      scnt++;
                }
    
                int max = Math.max(dcnt, Math.max(rcnt, scnt));
                int max_a = 0;
                if (max == rcnt)
                   max_a = 1;
                else if (max == scnt)
                   max_a = 2;
                buk4_4_max_a[opp] = max_a;
             }
    
             // 상대방이 이전 게임에서 무슨 동물을 가장 많이 냈는지에 따라
             if (buk4_4_max_a[opp] == 0) { // 상대방이 사슴을 가장 많이 냄
                if (turn == 3 || turn == 6)
                   return RABBIT;
                return DEER;
             } else if (buk4_4_max_a[opp] == 1) { // 상대방이 토끼를 가장 많이 냄
                if (turn == 3 || turn == 6)
                   return RABBIT;
                return SNAKE;
             } else { // 상대방이 뱀을 가장 많이 냄
                if (turn == 3 || turn == 6)
                   return DEER;
                return SNAKE;
             }
    
        }
    };    
    
    private static Opponent[] f = new Opponent[100];
    private static String[] names = new String[100];
    private static int f_inx = 0;
    
    static void Register (String name, Opponent func)
    {
        names[f_inx] = name;
        f[f_inx++] = func;
    }
    
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        
        int[] total_score = new int[150];
        int[][][] last_pattern = new int[150][150][10]; // [팀][대전][패턴]
        int[] pattern_count = new int[150];
        
		Register("Me", Opponent1);
		Register("Opp1", Opponent3);
		Register("Opp2", Opponent2);
		Register("Opp3", Me);
        
        for(int i=0; i<140; i++)
            for(int j=0; j<140; j++)
                for(int k=0; k<10; k++)
                    last_pattern[i][j][k] = -1;
                    
        for(int i=1; i<f_inx; i++) {
            for(int j=0; j<f_inx; j++){
                
                int team_a = j % f_inx;
                int team_b = (j + i) % f_inx;
                
                System.out.println(String.format("[%s] vs [%s]", names[team_a], names[team_b])); 
                
                int a_game_score = 0;
                int b_game_score = 0;
                
                int prev_a = -1;
                int prev_b = -1;
                
                int team_a_count = 0;
                int team_b_count = 0;
                
                int[] a_pattern = new int[10];
                int[] b_pattern = new int[10]; 
                
                for(int k=0; k<10; k++){
                
                    int a = f[team_a].hunt(team_b, k, prev_b, last_pattern[team_b]);
                    int b = f[team_b].hunt(team_a, k, prev_a, last_pattern[team_a]);
                    
                    a_pattern[k] = a;
                    b_pattern[k] = b;
                    
                    if(a == prev_a) team_a_count += a+1; else team_a_count = 0;
                    if(b == prev_b) team_b_count += b+1; else team_b_count = 0;
                
                    if(a != 0 && a != 1 && a != 2) team_a_count = 100;
                    if(b != 0 && b != 1 && b != 2) team_b_count = 100;
                    
                    prev_a = a;
                    prev_b = b;
                    
                    int a_score = 0;
                    int b_score = 0;
                    int a_bonus = 0;
                    int b_bonus = 0;
                    
                    if(a == DEER && b == DEER) {a_score = 50; b_score = 50;}
                    else if(a == DEER && b == RABBIT) {a_score = 0; b_score = 20;}
                    else if(a == DEER && b == SNAKE) {a_score = 0; b_score = 10;}
                    else if(a == RABBIT && b == DEER) {a_score = 20; b_score = 0;}
                    else if(a == RABBIT && b == RABBIT) {a_score = 20; b_score = 20;}
                    else if(a == RABBIT && b == SNAKE) {a_score = 0; b_score = 30;}
                    else if(a == SNAKE && b == DEER) {a_score = 10; b_score = 0;}
                    else if(a == SNAKE && b == RABBIT) {a_score = 30; b_score = 0;}
                    else if(a == SNAKE && b == SNAKE) {a_score = 10; b_score = 10;}
                    
                    a_score -= team_a_count;
                    b_score -= team_b_count;
                    
                    a_bonus = random.nextInt(3);
                    b_bonus = random.nextInt(3);
                    a_score += a_bonus;
                    b_score += b_bonus;
                    
                    a_game_score += a_score;
                    b_game_score += b_score;
                    
                    System.out.println(String.format("Turn [%d] [%s:(%s)] vs [%s:(%s)] ---> score [%d] / [%d] ", 
                        k+1, names[team_a], (a!=0) ? (a==2 ? "SNAKE" : "RABBIT") : "DEER",
					    names[team_b], (b!=0) ? (b == 2 ? "SNAKE" : "RABBIT") : "DEER", a_game_score, b_game_score));
                    
                }

                for (int z = 0; z<10; z++) { 
                    last_pattern[team_a][pattern_count[team_a]][z] = a_pattern[z];
                }
                for (int z = 0; z<10; z++) {
                    last_pattern[team_b][pattern_count[team_b]][z] = b_pattern[z];
                }
            
                pattern_count[team_a]++;
                pattern_count[team_b]++;
                
                
                total_score[team_a] += a_game_score;
                total_score[team_b] += b_game_score;

				System.out.println("<Game Result>");
                if (a_game_score == b_game_score) System.out.println("Draw\n");
                else System.out.println(String.format("Win: [%4s]!\n", a_game_score > b_game_score ? names[team_a] : names[team_b]));

            }
        }
        
        System.out.println("<Final score>");

        int max_inx = 0;
        int max_score = 0;
        
        for(int i=0; i<f_inx; i++) {

			System.out.println(String.format("[%4s] Total Score: %d", names[i], total_score[i]));
            
            if(max_score < total_score[i]) {
                max_inx = i;
                max_score = total_score[i];
            }
        }
        
        System.out.printf(String.format("<Winner: [%4s]!!!!>", names[max_inx]));
    }
}
