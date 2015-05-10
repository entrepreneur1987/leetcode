public class TriangleSides{
  public static int[] getTriangleSides(int[] segments) {

		Arrays.sort(segments);
		for (int i = 0; i < segments.length - 2; i++) {
			if (segments[i] + segments[i + 1] > segments[i + 2]) {
				return new int[] { segments[i], segments[i + 1],
						segments[i + 2] };
			}

		}
		return new int[0];
	}
}
