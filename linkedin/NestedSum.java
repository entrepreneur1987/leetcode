public class NestedSum{
  public int nestedSum(List intList) {
		return nestedSum(intList, 1);
	}

	private int nestedSum(List intList, int depth) {
		int sum = 0;
		for (Object obj : intList) {
			if (obj instanceof Integer) {
				sum += ((int) obj) * depth;
			} else {
				sum += nestedSum((List) obj, depth + 1);
			}
		}
		return sum;
	}
}
