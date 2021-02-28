import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		int p = 8;
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		
		for (int n=0; n < p;n++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int k=0; k < p; k++) {
				row.add(factorial(n)/(factorial(k) * factorial(n-k)));
			}
			triangle.add(row);
		}
		for (ArrayList<Integer> innerList : triangle) {
			for (int n : innerList) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	public static int factorial(int n, HashMap<Integer, Integer> cache) {
		if (n <= 0) return 1;
		if (cache.get(n)) 
			return cache.get(n);
		int factorial = n*factorial(n-1);
		cache.put(n,factorial);
		return factorial;
	}
}
