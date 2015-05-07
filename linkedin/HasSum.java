public class HasSum{
  public boolean hasSum(int input, Map<Integer, Integer> m) {
		for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			int curr = entry.getKey();
			if (curr == input - curr && m.get(input - curr) > 1
					|| curr != input - curr && m.containsKey(input - curr)) {
				if (m.containsKey(input)) {
					m.put(input, m.get(input) + 1);
				} else {
					m.put(input, 1);
				}
				return true;
			}
		}
		if (m.containsKey(input)) {
			m.put(input, m.get(input) + 1);
		} else {
			m.put(input, 1);
		}
		return false;
	}
}
