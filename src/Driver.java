import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

/* Enter your budget
 * Enter the proportion of each expenses item
 * Ignore further item if proportion exceeds 100%
 * Use ArrayList to store expense proportions
 * Find the amount of each item*/
public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your budget: ");
		double budget = scan.nextDouble();
		DecimalFormat df = new DecimalFormat("#.##");
		int i = 0;
		double sum = 0;
		ArrayList<Double> proportion = new ArrayList<Double>();
		System.out.println("Enter your proportion of various expenses.");
		System.out.println("(The system tops if cumulative proportion exceeds 100%.)");
		do {
			System.out.println("The proportion of expense " + (i+1)+ ":");
			proportion.add(scan.nextDouble());
			sum += proportion.get(i);
			i++;
		} while (sum <= 100);
		if (sum > 100) {
			double cumulative = 0;
			for (int j = 0; j < proportion.size() - 1; j++) {
				cumulative += proportion.get(j);
			}
			proportion.set(proportion.size() - 1, 100 - cumulative);
		}
		for (double value : proportion) {
			double expense = value/100 * budget;
			System.out.println("Your " + value + "% equal $" + df.format(expense));
		}
		scan.close();
	}

}
