package ssafy.com;

import java.net.*;
import java.io.*;

public class BUK04_CHOIJIWON {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "BUK04_CHOIJIWON";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				double whiteBall_x = balls[0][0];
				double whiteBall_y = balls[0][1];
				
				// 판 위에 존재 여부
				boolean[] isValid = new boolean[6];
				for (int i = 1; i <= 5; i++) {
					if (balls[i][0] < 0 || balls[i][1] < 0) isValid[i] = false;
					else isValid[i] = true;
				}
				
				// 선공 / 후공 (a, b 목적구 / c, d 피해야할 공)
				// 수정 필요 ==========================================================
				// 타겟이 아닌 공과 부딪히지 않도록 타겟을 계속 바꿔야 함
				int a = 0, b = 0, c = 0, d = 0, now = 0;
				if (order == 1) {
					a = 3; b = 1; c = 2; d = 4;
				} else {
					a = 2; b = 4; c = 1; d = 3;
				}
				
				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				double targetBall_x = 0;
				double targetBall_y = 0;
				if (isValid[a]) {
					now = a;
					targetBall_x = balls[a][0];
					targetBall_y = balls[a][1];
				} else if (isValid[b]) {
					now = b;
					targetBall_x = balls[b][0];
					targetBall_y = balls[b][1];
				} else if (isValid[5]) {
					now = 5;
					targetBall_x = balls[5][0];
					targetBall_y = balls[5][1];
				}
				
				// 수정 필요 ==========================================================
				// 1, 4번 홀 조건 주의
				// 목적구가 갈 홀 위치
				int[] hole = new int[2];
				if ((127 <= targetBall_x && targetBall_x <= whiteBall_x)
                        || (whiteBall_x <= targetBall_x && targetBall_x <= 127) && Math.abs(whiteBall_x - 127) <= 40) {
                    if (targetBall_y > whiteBall_y) {
                        hole[0] = HOLES[4][0];
                        hole[1] = HOLES[4][1] - 2;
                    } else {
                        hole[0] = HOLES[1][0];
                        hole[1] = HOLES[1][1] + 2;
                    }
                } else {
                    if (targetBall_x > whiteBall_x) {
                        if (targetBall_y > whiteBall_y) {
                            hole[0] = HOLES[5][0] - 2;
                            hole[1] = HOLES[5][1] - 2;
                        } else {
                            hole[0] = HOLES[2][0] - 2;
                            hole[1] = HOLES[2][1] + 2;
                        }
                    } else {
                        if (targetBall_y > whiteBall_y) {
                            hole[0] = HOLES[3][0] + 2;
                            hole[1] = HOLES[3][1] - 2;
                        } else {
                            hole[0] = HOLES[0][0] + 2;
                            hole[1] = HOLES[0][1] + 2;
                        }
                    }
                }
				
				// 흰 공이 가야할 위치
				double[] target = findTarget(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y, hole);
				// 
				double distance = findAngle(whiteBall_x, whiteBall_y, target[0], target[1])[2];
				// 흰 공이 목적구를 맞추기 위한 각도
				angle = (float) findAngle(whiteBall_x, whiteBall_y, target[0], target[1])[0];
				// 목적구와 포켓의 각도
				double angle2 = findAngle(target[0], target[1], hole[0], hole[1])[0];
				// 맞추면 안 되는 구가 맞는 각도
				double[] cAngles = findAngle(whiteBall_x, whiteBall_y, balls[c][0], balls[c][1]);
				double[] dAngles = findAngle(whiteBall_x, whiteBall_y, balls[d][0], balls[d][1]);
				// 해당 각도 배제 코드
				if ((Math.abs(cAngles[0] - angle) <= cAngles[1] && target[2] > cAngles[2]) || (Math.abs(dAngles[0] - angle) <= dAngles[1] && target[2] > dAngles[2])) {
					if (now == a && isValid[b]) target = findTarget(whiteBall_x, whiteBall_y, balls[b][0], balls[b][1], hole);
					else if (now == b && isValid[a]) target = findTarget(whiteBall_x, whiteBall_y, balls[a][0], balls[a][1], hole);
					angle = (float) findAngle(whiteBall_x, whiteBall_y, target[0], target[1])[0];
					if ((Math.abs(cAngles[0] - angle) <= cAngles[1] && target[2] > cAngles[2]) || (Math.abs(dAngles[0] - angle) <= dAngles[1] && target[2] > cAngles[2])) {
						if (isValid[a]) {
                            now = a;
                            targetBall_x = balls[a][0];
                            targetBall_y = balls[a][1];
                        } else if (isValid[b]) {
                            now = b;
                            targetBall_x = balls[b][0];
                            targetBall_y = balls[b][1];
                        } else if (isValid[5]) {
                            now = 5;
                            targetBall_x = balls[5][0];
                            targetBall_y = balls[5][1];
                        }

                        if (targetBall_x < 128) {
                            if (targetBall_y < 64) {
                                targetBall_x = -(targetBall_x + 5.73f); 
                                targetBall_y = -(targetBall_y + 5.73f); 
                            }
                            else {
                                targetBall_x = -(targetBall_x + 5.73f); 
                                targetBall_y = 128 + (128 - targetBall_y) + 5.73f;
                            }
                        } else {
                            if (targetBall_y < 64) {
                                targetBall_x = 256 + (256 - targetBall_x) + 5.73f;
                                targetBall_y = -(targetBall_y + 5.73f); 
                            }else {
                                targetBall_x = 256 + (256 - targetBall_x) + 5.73f;
                                targetBall_y = 128 + (128 - targetBall_y) + 5.73f;
                            }
                        }
					}
				}

				power = 60;


				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// x1, y1 : white ball
	public static double[] findAngle(double x1, double y1, double x2, double y2) {
		double width = Math.abs(x1 - x2);
		double height = Math.abs(y1 - y2);
		double radian = height > 0? Math.atan(width / height): 0;
		double angle = (180.0 / Math.PI) * radian;
		double alpha = 180.0 * Math.atan(Math.sqrt(width * width + height * height) / 5.73) / Math.PI;
		// 각각 2 / 3 / 4 사분면
		if (y1 > y2 && x1 < x2) angle = 180 - angle;
		else if (y1 > y2 && x1 > x2) angle += 180;
		else if (y1 < y2 && x1 > x2) angle = 360 - angle;
		return new double[] {angle, alpha, Math.sqrt(width * width + height * height)};
	}
	
	public static double[] findTarget(double x1, double y1, double x2, double y2, int[] hole) {
		double[] target = new double[3];
		double thWidth = Math.abs(x2 - hole[0]);
		double thHeight = Math.abs(y2 - hole[1]);
		double thDiag = Math.sqrt(thWidth * thWidth + thHeight * thHeight);
		double aimWidth = thWidth * (thDiag + 5.5) / thDiag;
		double aimHeight = thHeight * (thDiag + 5.5) / thDiag;
		if (x2 > x1) {
			if (y2 > y1) target = new double[] {hole[0] - aimWidth, hole[1] - aimHeight, thDiag};
			else target = new double[] {hole[0] - aimWidth, hole[1] + aimHeight, thDiag};
		} else {
			if (y2 > y1) target = new double[] {hole[0] + aimWidth, hole[1] - aimHeight, thDiag};
			else target = new double[] {hole[0] + aimWidth, hole[1] + aimHeight, thDiag};
		}
		return target;
	}
}
