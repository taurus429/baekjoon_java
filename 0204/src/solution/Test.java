package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
	static double width = 254;
	static double height = 127;
	static int ball = 5;
	static double realdiameter = 5.73;
	static double diameter = 5.73;
	static double[][] holes = new double[][] { { 0 + realdiameter / 2, 0 + realdiameter / 2 }, { width/2, 0 },
			{ width - realdiameter / 2, 0 + realdiameter / 2 }, { 0 + realdiameter / 2, height - realdiameter / 2 }, { width/2, height },
			{ width - realdiameter / 2, height - realdiameter / 2 } };
	static int intercept = 35;
	static double[][] upIntercept = new double[][] { { 0, intercept }, { width/2, height }, { width, intercept } };
	static double[][] downIntercept = new double[][] { { 0, height - intercept }, { width/2, 0 }, { width, height - intercept } };
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
		double res = Math.abs(a * otherball[0] + b * otherball[1] + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		if (res < realdiameter && (end[0] - otherball[0]) * (start[0] - otherball[0]) < 0) {
			System.out.println("충돌");
			System.out.println(Arrays.toString(otherball));
			return true;
		} else {
			double dx = otherball[0] - end[0];
			double dy = otherball[1] - end[1];
			double distance = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
			if(distance<=diameter) {
				System.out.println("둘레에 닿임");
				return true;
			}
			return false;
		}
	}

	static double getDistance(double[] pos1, double[] pos2) {
		return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
	}

	static ArrayList<Double[]> getRad(double[] myPos, double[] ballPos, int ballIdx) {
		ArrayList<Double[]> candidate = new ArrayList<>();
		System.out.println(ballIdx +"번구");
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				System.out.println("좌하단");
				break;
			case 1:
				System.out.println("중하단");
				break;
			case 2:
				System.out.println("우하단");
				break;
			case 3:
				System.out.println("좌상단");
				break;
			case 4:
				System.out.println("중상단");
				break;
			case 5:
				System.out.println("우상단");
				break;

			default:
				break;
			}
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
			if (90 < Math.abs(90 - reflect)) {
				System.out.println("굴절각 불가능");
				possible = false;
			} else {
				System.out.println("굴절 가능");
				for (int j = 1; j < balls.length; j++) {
					if (j == ballIdx)
						continue;
					if (crashCheck(myPos, target, balls[j]) || crashCheck(ballPos, holes[i], balls[j])) {
						crash = true;
					}
				}
			}
			if (!crash && possible) {
				System.out.println(Arrays.toString(myPos));
				System.out.println(Arrays.toString(target));
				double angle = 90 - Math.toDegrees(my2targetRad);
				double refract = Math.abs(90 - reflect);
				double targetDist = getDistance(myPos, target);
				double holeDist = getDistance(ballPos, holes[i]);
				candidate.add(new Double[] { refract, angle, targetDist, holeDist });
			}
		}
		return candidate;
	}
	static double getPower(double ball2hole, double reflect, double my2target) {
		double m = 0.00009;
		double angle = Math.toRadians(reflect);
		double v0 = Math.sqrt(2*m*ball2hole);
		double v1=0;
		if(reflect==0) {
			v1= v0;
		}else {
			v1=v0/Math.cos(angle);
		}
		double power = Math.sqrt(Math.pow(v1, 2)+2*m*my2target);
		return power;
	}
	public static double[] getBest(double[][] inputballs, int[] hitlist) {
		balls = inputballs;
		System.out.println(Arrays.toString(balls[0]));
		double[] ans = new double[] { 90, 100 };
		double[] myPos = balls[0];
		ArrayList<Double[]> candidate = new ArrayList<>();
		
		for (int i : hitlist) {
			ArrayList<Double[]> temp = getRad(myPos, balls[i], i);
			for (Double[] a : temp) {
				candidate.add(a);
			}
		}
		System.out.println(candidate.size());
		Comparator<Double[]> comparator = new Comparator<Double[]>() {

			@Override
			public int compare(Double[] o1, Double[] o2) {
				// TODO Auto-generated method stub
				return (int) (o1[0] - o2[0]);
			}
		};
		Collections.sort(candidate, comparator);
		for (Double[] c : candidate) {
			System.out.println(Arrays.toString(c));
		}
		if (candidate.size() != 0) {
			ans = new double[] { candidate.get(0)[1], getPower(candidate.get(0)[3], candidate.get(0)[0], candidate.get(0)[2]) };
		}else {
			double[] target = new double[] { inputballs[hitlist[0]][0],
					inputballs[hitlist[0]][1]};
			double my2targetRad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);
			double reflect = 90 - Math.toDegrees(my2targetRad);
			ans = new double[] {reflect, 50};
		}
//		double[] target = new double[]  { inputballs[3][0], height*2-diameter-inputballs[3][1]};
//		double[] target = new double[]  { inputballs[4][0], diameter-inputballs[4][1]};
//		double[] target = new double[]  { width/2+width+diameter*5/2, height };
//		double my2targetRad = Math.atan2(target[1] - myPos[1], target[0] - myPos[0]);
//		double reflect = 90 - Math.toDegrees(my2targetRad);
//		ans = new double[] {reflect, 50};
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(crashCheck(new double[] {241.03007318599342, 50.139347733603714}, new double[] {188.94037795435082, 60.548680518971764}, new double[] {194.81705265770634, 54.001697154925}));
		System.out.println(Math.cos(Math.PI));
		// double[] ball1 = new double[] { 71, 120 };
		double[] ball1 = new double[] { 65, 65 };
//		double[] ball2 = new double[] { 125, 120 };
		double[] ball2 = new double[] { 30, 65 };
//		double[] ball3 = new double[] { 240, 124 };
		double[] ball3 = new double[] { 130, 100 };
		double[] ball4 = new double[] { 254, 58 };
//		double[] ball5 = new double[] { 255, 5 };
		double[] ball5 = new double[] { 205, 5 };
		double[] ball6 = new double[] { 15, 10 };
		ball1 = new double[] { 65, 65 };
		System.out.println(Math.sqrt(2));
		ball2 = new double[] { 65*3+7.5/Math.sqrt(2), 65+7.5/Math.sqrt(2) };
		ball2 = new double[] { 260-(65-diameter/2)/Math.sqrt(3), 65+Math.sqrt(3)*diameter/2 };
		System.out.println(ball2[0]);
		System.out.println(ball2[1]);
		balls = new double[][] { ball1, ball2 };
//		balls = new double[][] { ball1, ball2, ball3, ball4, ball5, ball6 };
		double[] ans = getBest(balls, new int[] {1});
	}
}