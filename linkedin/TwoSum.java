public class MyTwoSum implements TwoSum {
	private List<Integer> list = new ArrayList<Integer>();

	public void store(int input) {
		list.add(input);
	}

	public boolean test(int val) {
		Set<Integer> s = new HashSet<Integer>();
		for (int num : list) {
			if (checkOverflow(val, num))
				continue;
			if (s.contains(val - num))
				return true;
			s.add(num);
		}
		return false;
	}

	boolean checkOverflow(int val, int el) {
		// int ret = val - el;
		// if (val >= 0 && el < 0) {
		// if (ret < val)
		// return true;
		// }
		// if (val < 0 && el > 0) {
		// if (ret > val)
		// return true;
		// }
		// return false;
		long vval = val;
		long vel = el;
		long ret = vval - vel;
		if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
			return true;
		return false;
	}

	public static void main(String[] args) {
		MyTwoSum twoSum = new MyTwoSum();
		twoSum.store(-2);
		twoSum.store(Integer.MAX_VALUE - 1);
		twoSum.store(1);
		System.out.println(twoSum.test(Integer.MAX_VALUE));
	}

}
