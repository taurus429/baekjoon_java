package game;

import java.net.*;
import java.io.*;

public class BUK04_KIMJEONGHYEON_SONHYOJAE {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "BUK04_KIMJEONGHYEON_SONHYOJAE";

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
					order = (int) balls[0][1];
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
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수

				float whiteBall_x = -1;
				float whiteBall_y = -1;
				float targetBall_x = -1;
				float targetBall_y = -1;

				if (order == 1) {
					whiteBall_x = balls[0][0];
					whiteBall_y = balls[0][1];
					float dist1 = (whiteBall_x - balls[1][0]) * (whiteBall_x - balls[1][0])
							+ (whiteBall_y - balls[1][1]) * (whiteBall_y - balls[1][1]);
					// 흰 공과 1번 공 간의 거리
					float dist2 = (whiteBall_x - balls[3][0]) * (whiteBall_x - balls[3][0])
							+ (whiteBall_y - balls[3][1]) * (whiteBall_y - balls[3][1]);
					// 흰 공과 3번 공 간의 거리
					if (balls[1][0] == -1 && balls[1][1] == -1 && balls[3][0] == -1 && balls[3][1] == -1) {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					} else {
						if (balls[1][0] == -1 && balls[1][1] == -1) {
							targetBall_x = balls[3][0];
							targetBall_y = balls[3][1];
						} else if (balls[3][0] == -1 && balls[3][1] == -1) {
							targetBall_x = balls[1][0];
							targetBall_y = balls[1][1];
						} else {
							if (dist1 >= dist2) {
								targetBall_x = balls[3][0];
								targetBall_y = balls[3][1];
							} else {
								targetBall_x = balls[1][0];
								targetBall_y = balls[1][1];
							}
						}
					}

				} else if (order == 2) {
					whiteBall_x = balls[0][0];
					whiteBall_y = balls[0][1];
					float dist3 = (whiteBall_x - balls[2][0]) * (whiteBall_x - balls[2][0])
							+ (whiteBall_y - balls[2][1]) * (whiteBall_y - balls[2][1]);
					// 흰 공과 1번 공 간의 거리
					float dist4 = (whiteBall_x - balls[4][0]) * (whiteBall_x - balls[4][0])
							+ (whiteBall_y - balls[4][1]) * (whiteBall_y - balls[4][1]);
					// 흰 공과 3번 공 간의 거리
					if (balls[2][0] == -1 && balls[2][1] == -1 && balls[4][0] == -1 && balls[4][1] == -1) {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					} else {
						if (balls[2][0] == -1 && balls[2][1] == -1) {
							targetBall_x = balls[4][0];
							targetBall_y = balls[4][1];
						} else if (balls[4][0] == -1 && balls[4][1] == -1) {
							targetBall_x = balls[2][0];
							targetBall_y = balls[2][1];
						} else {
							if (dist3 >= dist4) {
								targetBall_x = balls[4][0];
								targetBall_y = balls[4][1];
							} else {
								targetBall_x = balls[2][0];
								targetBall_y = balls[2][1];
							}
						}
					}
				}

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width3 = targetBall_x - whiteBall_x;
				float height3 = targetBall_y - whiteBall_y;
				float width = Math.abs(targetBall_x - whiteBall_x);
				float height = Math.abs(targetBall_y - whiteBall_y);
				if (width3 == 0)
					width3 = 0.000000000000000000000001f;
				if (height3 == 0)
					height3 = 0.000000000000000000000001f;
				float a = Math.signum(width3);
				float b = Math.signum(height3); // x,y 부호 반환

				float LeftUpX = (float) ((Math.abs(targetBall_x - 0)) + 1.2);
				float LeftUpY = (float) ((Math.abs(targetBall_y - 127)) - 1.2); // 왼쪽 위 구멍과 목적구와의 x,y거리

				float LeftDownX = (float) ((Math.abs(targetBall_x - 0)) + 1.2);
				float LeftDownY = (float) ((Math.abs(targetBall_y - 0)) + 1.2); // 왼쪽 아래 구멍과 목적구와의 x,y거리

				float MiddleUpX = (float) (Math.abs(targetBall_x - 127));
				float MiddleUpY = (float) ((Math.abs(targetBall_y - 0)) + 1.2);

				float MiddleDownX = (float) (Math.abs(targetBall_x - 127));
				float MiddleDownY = (float) ((Math.abs(targetBall_y - 0)) - 1.2);

				float RightUpX = (float) ((Math.abs(targetBall_x - 254)) - 1.2);
				float RightUpY = (float) ((Math.abs(targetBall_y - 127)) - 1.2); // 오른쪽 위 구멍과 목적구와의 x,y거리

				float RightDownX = (float) ((Math.abs(targetBall_x - 254)) - 1.2);
				float RightDownY = (float) ((Math.abs(targetBall_y - 0)) + 1.2); // 오른쪽 아래 구멍과 목적구와의 x,y거리

				float goalX = 0;
				float goalY = 0; // 목표지점
				float targetX = 0;
				float targetY = 0;
				float g = 0; // 기울기
				float pi = (float) Math.PI;

				if (targetBall_x < 127) {
					RightUpX = MiddleUpX;
					RightUpY = MiddleUpY;
					RightDownX = MiddleDownX;
					RightDownY = MiddleDownY;
				} else if (targetBall_x >= 127) {
					LeftUpX = MiddleUpX;
					LeftUpY = MiddleUpY;
					LeftDownX = MiddleDownX;
					LeftDownY = MiddleDownY;
				}

				if (a > 0 && b > 0) {
					g = Math.abs(RightUpY / RightUpX);
					targetX = RightUpX;
					targetY = RightUpY;
					goalX = (float) (targetBall_x - 4.1 / Math.sqrt((1 + g) * (1 + g)));
					goalY = (float) (targetBall_y - (4.1 * g) / Math.sqrt((1 + g) * (1 + g)));
					angle = (float) (90 - (float) (180.0 / Math.PI)
							* (float) Math.atan(Math.abs((goalY - whiteBall_y) / (goalX - whiteBall_x))));
				} // 오른쪽 위로 친다.
				else if (a > 0 && b < 0) {
					g = Math.abs(RightDownY / RightDownX);
					targetX = RightDownX;
					targetY = RightDownY;
					goalX = (float) (targetBall_x - 4.1 / Math.sqrt((1 + g) * (1 + g)));
					goalY = (float) (targetBall_y + (4.1 * g) / Math.sqrt((1 + g) * (1 + g)));
					angle = (float) (90 + (float) (180.0 / Math.PI)
							* (float) Math.atan(Math.abs((goalY - whiteBall_y) / (goalX - whiteBall_x))));
				} // 오른쪽 아래로 친다.
				else if (a < 0 && b > 0) {
					g = Math.abs(LeftUpY / LeftUpX);
					targetX = LeftUpX;
					targetY = LeftUpY;
					goalX = (float) (targetBall_x + 4.1 / Math.sqrt((1 + g) * (1 + g)));
					goalY = (float) (targetBall_y - (4.1 * g) / Math.sqrt((1 + g) * (1 + g)));
					angle = (float) (270 + (float) (180.0 / Math.PI)
							* (float) Math.atan(Math.abs((goalY - whiteBall_y) / (goalX - whiteBall_x))));
				} // 왼쪽 위로 친다.
				else if (a < 0 && b < 0) {
					g = Math.abs(LeftDownY / LeftDownX);
					targetX = LeftDownX;
					targetY = LeftDownY;
					goalX = (float) (targetBall_x + 4.1 / Math.sqrt((1 + g) * (1 + g)));
					goalY = (float) (targetBall_y + (4.1 * g) / Math.sqrt((1 + g) * (1 + g)));
					angle = (float) (270 - (float) (180.0 / Math.PI)
							* (float) Math.atan(Math.abs((goalY - whiteBall_y) / (goalX - whiteBall_x))));
				} // 왼쪽 아래로 친다.

				float pre_distance = (goalX - whiteBall_x) * (goalX - whiteBall_x)
						+ (goalY - whiteBall_y) * (goalY - whiteBall_y);
				float pre_distance2 = (goalX - targetX) * (goalX - targetX) + (goalY - targetY) * (goalY - targetY);

				float distance = (float) Math.sqrt(pre_distance + pre_distance2);

				// power: 거리 distance에 따른 힘의 세기를 계산

				power = (float) (distance*0.98);

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
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
}
