import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int[][] arr;
	static int[][] arr2;
	static int[] pos; // 사격할 위치
	static int[] power; // 총알힘
	static int max; // 최대점
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// N×N 크기의 보드 판 	
		// K개의 총알은 각각 다른 공격력을 가지고 있다. 
		// 수평으로 총알을 쏨 
		//
		//	0 0 0 0 0 		0 0 0 0 0  		0 0 0 0 0		0 0 0 0 0		0 0 0 0 0
		//  0 0 0 0 0  --> 	0 0 0 0 0  -->  0 0 0 0 0  -->  0 0 0 0 0  -->  0 0 0 0 0
		//	0 0 0 0 0  -->  1 0 0 0 0  -->  0 1 0 0 0  -->  0 0 1 0 0  -->  0 0 0 1 0 
		//  0 0 0 0 0  		0 0 0 0 0  		0 0 0 0 0 		0 0 0 0 0		0 0 0 0 0
		// -총알이 보너스(값 10이상)를 맞추면 보너스점수에 해당하는 점수를 획득
		// -만약 총알이 표적에 맞으면 
		// 1. 총알 공격력이 표적보다 높은 경우 -> 표적에 해당하는 점수 획득 
		// -> 표적 점수의 4분에1에 해당하는 점수를 사방으로 퍼트림(사방에 표적이 있을 떄는 표적위치는 제외)
		// 2. 총알 공격력이 표적보다 낮은 경우 -> 표적의 값을 총알 값만큼 뺌
		
		// 총 K번의 총을 쐈을 때 가장 높은 점수를 얻는 경우의 점수를 구하시오.
		// 쏘는 위치는 만약 N이5이고 K가 4인경우는 5x5x5x5가지 경우의 수
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 표적 및 보너스 점수 입력 끝
		power = new int[K];
		for(int i =0;i<K;i++) {	
			power[i] = sc.nextInt();
		}
		// 각각 k개의 총알의 파워 입력
		arr2 = new int[N][N];
		// 어차피 주변으로 파생되는거니깐 
		// 바뀔 필요가 있어 arr2배열 생성
		max = 0;
		pos = new int[K]; // 총알 개수만큼 위치 선정(총알 쏘는 위치의 index가 있음)
		choose(0,0);
		System.out.println(max);
	}
	// 쏠 위치 선정
	// K번의 위치를 모두 선정하면 이제 사격 시작
	public static void choose(int cnt, int idx) {
		if(cnt==K) {
			// k개 만큼 선정하면 총쏘자 
			int score = shoot();
			// 나온 점수가 max보다 높다면 교체
			max = Math.max(score, max);
			return;
		}
		// 실시 할때 마다 arr2 배열을 arr로 부터 복사받음
		for(int c =0;c<N;c++) {
			arr2[c] = Arrays.copyOf(arr[c],arr[c].length);
		}
		
		// cnt번째에 쏠 위치를 i로 입력받고 다음번으로 진행
		for(int i =0;i<N;i++) {
			pos[cnt] = i; // 해당번째 선정
			choose(cnt+1,idx);
			// 한번 실시한 이후로 파생되거나 없는 점수때문에 arr2배열을 복사해줘야함
			for(int c =0;c<N;c++) {
				arr2[c] = Arrays.copyOf(arr[c],arr[c].length);
			}
			
		}
		return;
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static int shoot() {
		// arr2 배열에서 게임을 해보자
		int score = 0; // 해당 게임에서의 점수 
		int[][] middle = new int[N][N]; // 중간점수 기록하기 위한 것
		for(int i =0;i<K;i++) {
			// 0번부터 K번째까지(총알개수) 시작
			int x = pos[i];
			// pos[i],0에서 시작
			for(int j=0;j<N;j++) { // 수평이동 j
				// 오른쪽으로 이동해보자
				//////////////////////////////////////////////////////////
				// 1. 보너스라면
				if(arr2[x][j]>=10) {
					// 점수 추가하고 위치를 0으로 교체
					score += arr2[x][j];
					arr2[x][j] = 0;
					break;
				}
				///////////////////////////////////////////////////////////
				// 2. 표적이라면
				else if(arr2[x][j]!=0) {
					// 총알파워가 더 쎄면 둘다 없어지게 하고 
					// 아니면 arr2배열에서 그만큼 -
					// 총알이 더 쎈 경우
					if(power[i]>=arr2[x][j]) {
						// tmp는 퍼질 값으로 현재 arr2배열의 값과 중간에 떨어진만큼의 값을 더해서 나누기 4
						int tmp = (arr2[x][j]+middle[x][j])/4;
						score += arr2[x][j]+middle[x][j]; // score는 두개의 합만큼 증가
						middle[x][j] = 0; // 두개다 모두 0으로 바꿔줌
						arr2[x][j] =0;
						// 주변 4군데 총알 퍼트리기
						 for(int in=0;in<4;in++) {
							int tmpx = x+dx[in];
							int tmpy = j+dy[in];
							// 배열내인지 확인 + 표적이 있는경우도 불가능
							if(tmpx<0 || tmpx >=N || tmpy<0 || tmpy>=N || arr2[tmpx][tmpy] !=0) {
								continue;
							}
							arr2[tmpx][tmpy] = tmp; // 퍼질 점수 사방에 기록 
						}
					}
					// 총알보다 표적이 더 쎈 경우
					else {
						// middle값에 power만큼의 값을 추가해주고 
						// arr2의 값을 power만큼 --
						middle[x][j] += power[i];
						arr2[x][j] -= power[i];
					}
					break; 
				}
				///////////////////////////////////////////////////////////
				// 3. 표적도 보너스도 아니면 그냥 j 증가		
				
			} // j for
		} // i for
		return score;
		
	}
}