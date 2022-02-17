package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9490_2 {
	static int N, K, kIdx;
	static int[] A, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			// 두 값의 입력이 0이라면 테스트를 종료한다.
			if (N == 0 && K == 0)
				break;
			A = new int[N + 1];
			parent = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				if (A[i] == K)
					kIdx = i;
			}
			solution();
		}
	}

	static void solution() {
		int answer = 0;
		parent[0] = -1; // 루트 바로 아래자식에서 찾을 경우 카운트 방지
		parent[1] = 0; // 루트 노드의 부모는 없다.

		int idx = 1; // 부모 노드 인덱스
		for (int i = 2; i <= N; i++) {
			parent[i] = idx;
			// 연속된 수열이 아니라면 부모 노드 인덱스를 증가시킨다.
			if (i < N && A[i] + 1 != A[i + 1])
				idx++;
		}
		for (int i = 1; i <= N; i++) {
			// 두 노드의 부모는 다르지만, 두 부모가 형제일 때
			// => 부모의 부모는 같으나 부모는 다를경우
			if (parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
