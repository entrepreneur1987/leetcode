public class ArrayProducts{
  public int[] products(int[] a) {
		int[] output = new int[a.length];
		Arrays.fill(output, 1);
		int left = 1, right = 1;
		for (int i = 0; i < a.length; i++) {
			output[i] *= left;
			output[a.length - i - 1] *= right;
			left *= a[i];
			right *= a[a.length - i - 1];
		}
		return output;
	}
}
