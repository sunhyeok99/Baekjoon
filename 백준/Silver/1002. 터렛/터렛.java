import java.util.Scanner;

/**
 * 백준 전체 1002 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/05/21/a1002">1002 풀이</a>
 * @since 2021.04.21 Wed 21:56:10
 */
public class Main
{
	/**
	 * 메인 함수
	 *
	 * @param args: [String[]] 매개변수
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int length = scanner.nextInt();
		
		for (int i = 0; i < length; i++)
		{
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int r1 = scanner.nextInt();
			
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int r2 = scanner.nextInt();
			
			System.out.println(calcPoints(x1, y1, r1, x2, y2, r2));
		}
	}
	
	/**
	 * 접점 갯수 반환 함수
	 *
	 * case 1 - 두 원이 정확히 겹칠 경우 (-1)
	 * case 2 - 두 원이 서로 겹치면서 인접하지 않는 경우 (0)
	 * case 3 - 두 원이 서로 겹치지 않으면서 인접하지 않는 경우 (0)
	 * case 4 - 두 원이 서로 겹치면서 인접하는 경우 (1)
	 * case 5 - 두 원이 서로 겹치지 않으면서 인접하는 경우 (1)
	 * case 6 - 두 원이 서로 겹치면서 인접하지 않는 경우 (2)
	 *
	 * @param x1: [int] A의 x좌표
	 * @param y1: [int] A의 y좌표
	 * @param r1: [int] A와 C 사이의 거리
	 * @param x2: [int] B의 x좌표
	 * @param y2: [int] B의 y좌표
	 * @param r2: [int] B와 C 사이의 거리
	 *
	 * @return [int] 접점 갯수
	 */
	private static int calcPoints(int x1, int y1, int r1, int x2, int y2, int r2)
	{
		// 두 점 사이의 거리 계산식
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		
		int sum = r1 + r2;
		int sub = Math.abs(r1 - r2);
		
		// case 1 - 두 원이 정확히 겹칠 경우
		if (distance == 0 && r1 == r2)
		{
			return -1;
		}
		
		// case 2 - 두 원이 서로 겹치면서 인접하지 않는 경우
		else if (distance < sub)
		{
			return 0;
		}
		
		// case 3 - 두 원이 서로 겹치지 않으면서 인접하지 않는 경우
		else if (distance > sum)
		{
			return 0;
		}
		
		// case 4 - 두 원이 서로 겹치면서 인접하는 경우
		else if (distance == sub)
		{
			return 1;
		}
		
		// case 5 - 두 원이 서로 겹치지 않으면서 인접하는 경우
		else if (distance == sum)
		{
			return 1;
		}
		
		// case 6 - 두 원이 서로 겹치면서 인접하지 않는 경우
		else
		{
			return 2;
		}
	}
}