package solution;

import java.util.Arrays;

public class Test {
	static double width = 254;
	static double height = 124;
	static int ball = 5;
	static double diameter = 7.5;
	static double[][] holes = new double[][] { { 0 + diameter / 2, 0 + diameter / 2 }, { 130, 0 },
			{ 260 - diameter / 2, 0 + diameter / 2 }, { 0 + diameter / 2, 130 - diameter / 2 }, { 130, 130 },
			{ 260 - diameter / 2, 130 - diameter / 2 } };
	static double[] myPos = new double[] { 65, 65 };

	static double[][] upIntercept = new double[][] { { 0, 35 }, { 130, 130 }, { 260, 35 } };
	static double[][] downIntercept = new double[][] { { 0, 95 }, { 130, 0 }, { 260, 95 } };
	static double[][] balls;

	static boolean areaCheck(double[][] intercept, double[] ballPos) {
		double a1 = (intercept[0][1] - intercept[1][1]) / (intercept[0][0] - intercept[1][0]);
		double b = -1;
		double c1 = intercept[0][1] - a1 * intercept[0][0];
		double a2 = (intercept[2][1] - intercept[1][1]) / (intercept[2][0] - intercept[1][0]);
		double c2 = intercept[2][1] - a2 * intercept[2][0];
		double res = (a1 * ballPos[0] + b * ballPos[1] + c1) * (a2 * ballPos[0] + b * ballPos[1] + c2);
		if (res >= 0) {
			return true;
		}
		return false;

	}

	static boolean crashCheck(double[] start, double[] end, double[] otherball) {		
		double a = (start[1] - end[1]) / (start[0] - end[0]);
		double b = -1;
		double c = start[1] - a * start[0];
		double res =  Math.abs(a * otherball[0] + b * otherball[1] + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		if (res < diameter && (end[0] - otherball[0]) * (myPos[0] - otherball[0]) < 0) {				
			System.out.println("충돌");
			return true;
		}else {
			return false;
		}
	}

	static void getRad(double[] myPos, double[] ballPos, int ballIdx) {
		for (int i = 0; i < 6; i++) {
			if (i == 1) {
				if (!areaCheck(downIntercept, ballPos)) {
					System.out.println("도달각 없음");
					continue;
				}
			}
			if (i == 4) {
				if (!areaCheck(upIntercept, ballPos)) {
					System.out.println("도달각 없음");
					continue;
				}
			}
			double ball2holeRad = Math.atan2(holes[i][1] - ballPos[1], holes[i][0] - ballPos[0]);
			double[] target = new double[] { ballPos[0] - diameter * Math.cos(ball2holeRad),
					ballPos[1] - diameter * Math.sin(ball2holeRad) };
			double my2targetRad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);
			double reflect = 90 - Math.toDegrees(my2targetRad) + Math.toDegrees(ball2holeRad);
			boolean crash = false;
			boolean possible = true;
			if (80 < Math.abs(90 - reflect)) {
				System.out.println("굴절각 불가능");
				possible = false;
			} else {
				System.out.println("굴절 가능");
				for(int j=1; j<6; j++) {
					if(j==ballIdx)
						continue;
					if(crashCheck(myPos, target, balls[j])||crashCheck(ballPos, holes[i], balls[j])){
						crash = true;
					}
				}
			}
			if(!crash && possible)
				System.out.println("수구 각도:" + (90 - Math.toDegrees(my2targetRad)));
		}
	}

	static double[] getAnswer(double[][] balls, int i) {
		double[] ans = new double[] { 90, 100 };
		double[] myPos = balls[0];
		getRad(myPos, balls[i], i);
		return ans;
	}

	public static void main(String[] args) {
		// double[] ball1 = new double[] { 71, 120 };
		double[] ball1 = new double[] { 65, 65 };
		double[] ball2 = new double[] { 215, 65 };
		double[] ball3 = new double[] { 240, 124 };
//		double[] ball3 = new double[] { 130, 72 };
		double[] ball4 = new double[] { 254, 58 };
		double[] ball5 = new double[] { 255, 5 };
		double[] ball6 = new double[] { 15, 10 };
		balls = new double[][] { ball1, ball2, ball3, ball4, ball5, ball6 };
		getAnswer(balls, 5);

//		double rad = Math.atan2(holes[4][1] - ball[1], holes[4][0] - ball[0]);
//		System.out.println(Math.toDegrees(rad));
//		double[] target = new double[2];
//		target[0] = ball[0] - 6*Math.cos(rad);
//		target[1] = ball[1] - 6*Math.sin(rad);
//		System.out.println(target[0] + " " +target[1]);
//		rad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);
//		System.out.println(Math.toDegrees(rad));
	}
}
