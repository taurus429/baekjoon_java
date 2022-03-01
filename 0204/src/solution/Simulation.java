package solution;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Simulation extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int N;
	Color bgcolor, color1, color2;
	boolean b2 = false;
	boolean b3 = false;
	double[] m;
	double[] posx;
	double[] posy;
	double[][] rx;
	double[][] ry;

	double G = 50;
	double mu = 0.005;
	double[] R;
	double[] vx;
	double[] vy;
	Color[] color;
	boolean[] bool;
	boolean[][] BG;
	static double width = Test.width * 4;
	static double height = Test.height * 4;
	Thread t;
	boolean wawawa = true;
	int cnt = 0;
	int first = 0;

	static double transX(double x) {
		return x * 4;
	}

	static double transY(double y) {
		return height - y * 4;
	}

	static double[][] getPos(double[] posx, double[] posy) {
		double[][] res = new double[posx.length][2];
		for (int i = 0; i < posx.length; i++) {
			res[i][0] = posx[i] / 4;
			res[i][1] = (height - posy[i]) / 4;
		}
		return res;
	}

	public void init() {
		bgcolor = new Color(1, 50, 1);
		setSize((int) width, (int) height);
		// Start thread
		t = new Thread(this);
		t.start();
		// Scanner kb = new Scanner(System.in);
		N = 6;// kb.nextInt();
		m = new double[N];
		posx = new double[N];
		posy = new double[N];
		rx = new double[N][N];
		ry = new double[N][N];
		R = new double[N];
		vx = new double[N];
		vy = new double[N];
		color = new Color[N];
		bool = new boolean[N];
		BG = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			m[i] = 1;
			R[i] = 3.75 * 4;
			vx[i] = 0;
			vy[i] = 0;
			bool[i] = true;
		}

		color[0] = Color.yellow;
		color[1] = Color.black;
		color[2] = Color.PINK;
		color[3] = Color.pink;
		color[4] = Color.blue;
		color[5] = Color.blue;
		posx[0] = transX(65);
		posy[0] = transY(65);

		posx[1] = transX(195);
		posy[1] = transY(68);

		posx[2] = transX(185);
		posy[2] = transY(67);

		posx[3] = transX(205);
		posy[3] = transY(65);

		posx[4] = transX(196);
		posy[4] = transY(75);
		posx[5] = transX(194);
		posy[5] = transY(55);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Test t = new Test();
				double[][] balls = getPos(posx, posy);
				double[] ans = Test.getBest(balls, new int[] { 2, 3 });
				double angle = ans[0];

				double rad = Math.toRadians(90 - angle);
				if (first++ != -1) {
					vx[0] = 5 * Math.cos(rad);
					vy[0] = -5 * Math.sin(rad);
				} else {
					vx[0] = 9.77123953;
					vy[0] = 0;
				}
				System.out.println(posy[0]);
				wawawa = false;
				run();
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("fslfjsld");
			}
		});
	}

	public void run() {
		try {
			while (!wawawa) {
				// Request a repaint
				paint(this.getGraphics());
				// Sleep before update
				Thread.sleep(10);
			}
			paint(this.getGraphics());
		} catch (Exception e) {
		}
	}

	public void paint(Graphics g) {
		// Draw filled circle
		Dimension d = getSize();
		// 배경색
		g.setColor(bgcolor);
		//g.fillRect(0, 0, (int) width, (int) height);
		// 각각의 값 초기화
		for (int i = 0; i < N; i++) {
			if (!bool[i]) {
				bool[i] = true;
				continue;
			}
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				rx[i][j] = posx[i] - posx[j];
				ry[i][j] = posy[i] - posy[j];
				double r = Math.sqrt(rx[i][j] * rx[i][j] + ry[i][j] * ry[i][j]);
				if ((R[i] + R[j]) * (R[i] + R[j]) < (posx[i] - posx[j]) * (posx[i] - posx[j])
						+ (posy[i] - posy[j]) * (posy[i] - posy[j])) {
					BG[i][j] = true;
					BG[j][i] = true;
				} else {

					if (BG[i][j] && BG[j][i] == true) {
						double[] vecPerp = { rx[i][j] / r, ry[i][j] / r };
						double[] vecPar = { -ry[i][j] / r, rx[i][j] / r };
						double[] compPerp = new double[2];
						double[] compPar = new double[2];
						compPerp[0] = (vx[i] * vecPar[1] - vy[i] * vecPar[0])
								/ (vecPerp[0] * vecPar[1] - vecPerp[1] * vecPar[0]);
						compPerp[1] = (vx[j] * vecPar[1] - vy[j] * vecPar[0])
								/ (vecPerp[0] * vecPar[1] - vecPerp[1] * vecPar[0]);
						compPar[0] = (vx[i] * vecPerp[1] - vy[i] * vecPerp[0])
								/ (vecPar[0] * vecPerp[1] - vecPar[1] * vecPerp[0]);
						compPar[1] = (vx[j] * vecPerp[1] - vy[j] * vecPerp[0])
								/ (vecPar[0] * vecPerp[1] - vecPar[1] * vecPerp[0]);
						double v1 = ((m[i] - m[j]) / (m[i] + m[j])) * compPerp[0]
								+ ((2 * m[j]) / (m[i] + m[j])) * compPerp[1];
						double v2 = (-(m[i] - m[j]) / (m[i] + m[j])) * compPerp[1]
								+ ((2 * m[i]) / (m[i] + m[j])) * compPerp[0];
						vx[i] = v1 * vecPerp[0] + compPar[0] * vecPar[0];
						vy[i] = v1 * vecPerp[1] + compPar[0] * vecPar[1];
						vx[j] = v2 * vecPerp[0] + compPar[1] * vecPar[0];
						vy[j] = v2 * vecPerp[1] + compPar[1] * vecPar[1];
						bool[j] = false;
						BG[i][j] = false;
					}
				}
			}
			if (mu * mu < vx[i] * vx[i] + vy[i] * vy[i]) {
				vx[i] = vx[i] * (1 - mu / Math.sqrt(vx[i] * vx[i] + vy[i] * vy[i]));
				vy[i] = vy[i] * (1 - mu / Math.sqrt(vx[i] * vx[i] + vy[i] * vy[i]));
			} else {
				vx[i] = 0;
				vy[i] = 0;
			}
		}
		wawawa = true;
		for (int h = 0; h < N; h++) {
			wawawa = wawawa && (vx[h] == 0 && vy[h] == 0);
		}

		for (int i = 0; i < N; i++) {
			if (R[i] > posx[i]) {
				vx[i] = 0.8 * Math.abs(vx[i]);
				vy[i] *= 0.8;
			} else if (posx[i] > width - R[i]) {
				vx[i] = -0.8 * Math.abs(vx[i]);
				vy[i] *= 0.8;
			}
			if (R[i] > posy[i]) {
				vy[i] = 0.8 * Math.abs(vy[i]);
				vx[i] *= 0.8;
			} else if (posy[i] > height - R[i]) {
				vy[i] = -0.8 * Math.abs(vy[i]);
				vx[i] *= 0.8;
			}
			posx[i] += vx[i];
			posy[i] += vy[i];
			g.setColor(color[i]);
			g.fillOval((int) (posx[i] - R[i]), (int) (posy[i] - R[i]), 2 * (int) R[i], 2 * (int) R[i]);
		}
		g.setColor(Color.red);
		g.fillRect(125 * 4, 130 * 4 - 2 * 4, 10 * 4, 2 * 4);
		g.fillRect(125 * 4, 0, 10 * 4, 2 * 4);

	}
}
