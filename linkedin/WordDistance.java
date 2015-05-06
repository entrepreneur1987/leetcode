public class WordDistance{
  public int minDistance(String[] dict, String word1, String word2) {
		Map<String, List<Integer>> track = new HashMap<String, List<Integer>>();
		for (int i = 0; i < dict.length; i++) {
			String w = dict[i];
			if (track.containsKey(w)) {
				track.get(w).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				track.put(w, list);
			}
		}

		List<Integer> list1 = track.get(word1);
		List<Integer> list2 = track.get(word2);
		return minDist(list1, list2);
	}

	private int minDist(List<Integer> list1, List<Integer> list2) {
		int i1 = 0, i2 = 0, min = Integer.MAX_VALUE;
		while (i1 < list1.size() && i2 < list2.size()) {
			if (list1.get(i1) > list2.get(i2)) {
				min = Math.min(min, list1.get(i1) - list2.get(i2));
				i2++;
			} else if (list1.get(i1) < list2.get(i2)) {
				min = Math.min(min, list2.get(i2) - list1.get(i1));
				i1++;
			} else {
				return 0;
			}
		}
		return min;
	}
}
