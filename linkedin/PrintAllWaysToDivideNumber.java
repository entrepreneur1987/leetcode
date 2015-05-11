public class PrintAllWaysToDivideNumber{
  // no duplicate
  public void printAllMultiples(int num) {
		recSolve(num, num, new Stack<Integer>(), 0);
	}

	private void recSolve(int orig, int num, Stack<Integer> buff, int prev) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0 && i >= prev) {
				buff.push(i);
				buff.push(num / i);
				print(orig, buff);
				int next = buff.pop();
				recSolve(orig, next, buff, i);
				buff.pop();
			}
		}
	}
	
	// duplicate
  public void printAllMultiples(int num) {
		recSolve(num, num, new Stack<Integer>());
	}

	private void recSolve(int orig, int num, Stack<Integer> buff) {
		for (int i = 2; i <num; i++) {
			if (num % i == 0) {
				buff.push(i);
				buff.push(num / i);
				print(orig, buff);
				int next = buff.pop();
				recSolve(orig, next, buff, i);
				buff.pop();
			}
		}
	}
	
	private void print(int num, Stack<Integer> buff) {
		System.out.print(num + "=");
		for (int i = 0; i < buff.size() - 1; i++) {
			System.out.print(buff.get(i) + "*");
		}
		System.out.println(buff.get(buff.size() - 1));
	}
}
