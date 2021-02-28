class PSum {
	static double sum1, sum2;
	public static void main(String[] args) {
		seqArraySum(new double[]{1,2,3,4,5,6,7,8,9,4,3,5,6,8,9,6667,645,4234,12321,345,45,345,345,345,34587,87});
	}

	public static double seqArraySum(double[] x) {
		long startTime = System.nanoTime();
		sum1 = 0;
		sum2 = 0;
		for (int i = 0; i < x.length / 2; i++) {
			sum1 += 1 / x[i];
		}
		for (int i = x.length / 2; i < x.length; i++) {
			sum2 += 1 / x[i];
		}
		double sum = sum1 + sum2;
		long timeInNanos = System.nanoTime() - startTime;
		printResults("seqArraySum", timeInNanos, sum);
		return sum;
	}
	public static double parArraySum(double[] x) {
		long startTime = System.nanoTime();
		sum1 = 0;
		sum2 = 0;
		for (int i = 0; i < x.length / 2; i++) {
			sum1 += 1 / x[i];
		}
		for (int i = x.length / 2; i < x.length; i++) {
			sum2 += 1 / x[i];
		}
		double sum = sum1 + sum2;
		long timeInNanos = System.nanoTime() - startTime;
		printResults("seqArraySum", timeInNanos, sum);
		return sum;
	}
	public static void printResults(String name, long timeInNanos, double sum) {
		System.out.printf("   %s completed in %8.3f miliseconds, with sum = %8.5f\n", name, timeInNanos / 1e6, sum);
	}
}
