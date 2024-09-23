import java.util.*;

class Solution {
    static Queue<int[]>[] memo; // 경로 기록용 
    static int size; // 경로의 수
    static int answer; // 충돌 횟수

    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        memo = new LinkedList[size];
        
        // 각 로봇의 경로를 저장할 큐 초기화
        for (int i = 0; i < size; i++) {
            memo[i] = new LinkedList<>();
        }
        
        calculatePaths(points, routes); // 로봇의 경로 계산 
        countCollisions(); // 충돌 계산 
        
        return answer;      
    }

    // 충돌 계산 메소드
    private void countCollisions() {
        while (true) {
            int[][] map = new int[101][101]; // 101x101 맵 초기화
            int emptyCount = 0; // 비어있는 큐의 수 카운트

            // 각 로봇의 현재 위치를 맵에 기록
            for (int i = 0; i < size; i++) {
                if (memo[i].isEmpty()) {
                    emptyCount++;
                    continue; // 큐가 비어있으면 건너뜀
                }
                int[] currentPosition = memo[i].poll(); // 현재 위치 가져오기
                map[currentPosition[0]][currentPosition[1]]++; // 맵에 위치 기록
            }

            if (emptyCount == size) break; // 모든 로봇이 도착한 경우 종료

            // 맵을 순회하며 충돌 카운트
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) answer++; // 충돌 발견
                }
            }
        }
    }

    // 로봇의 경로를 계산하는 메소드
    private void calculatePaths(int[][] points, int[][] routes) {
        for (int i = 0; i < size; i++) {
            int[] startPoint = points[routes[i][0] - 1]; // 출발점
            int x = startPoint[0]; // x좌표
            int y = startPoint[1]; // y좌표
            memo[i].add(new int[]{x, y}); // 출발점 기록

            // 각 경로에 대해 다음 포인트로 이동
            for (int j = 1; j < routes[i].length; j++) {
                int[] nextPoint = points[routes[i][j] - 1]; // 다음 포인트
                int nx = nextPoint[0]; // 다음 x좌표
                int ny = nextPoint[1]; // 다음 y좌표

                // x축 이동
                while (x != nx) {
                    x += (nx > x) ? 1 : -1; // x좌표 조정
                    memo[i].add(new int[]{x, y}); // 이동 기록
                }

                // y축 이동
                while (y != ny) {
                    y += (ny > y) ? 1 : -1; // y좌표 조정
                    memo[i].add(new int[]{x, y}); // 이동 기록
                }
            }
        }
    }
}
