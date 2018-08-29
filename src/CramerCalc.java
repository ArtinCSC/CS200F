
public class CramerCalc {

	private String firstEqu, secondEqu;
	private double x1Double, y1Double, c1Double, x2Double, y2Double, c2Double, slope1, slope2, yIntercept1, yIntercept2,
			dDouble, dXDouble, dYDouble, xDouble, yDouble;
	private int xInt, yInt;
	private String myString = "";
	private double[] infinSolu;

	public CramerCalc(String firstEqu, String secondEqu) {

		this.firstEqu = firstEqu;
		this.secondEqu = secondEqu;

		int equalSign = firstEqu.indexOf("=");
		int x = firstEqu.indexOf("x");
		int equalSign2 = secondEqu.indexOf("=");
		int x2Eq = secondEqu.indexOf("x");

		String c1 = firstEqu.substring(++equalSign);
		String y1 = firstEqu.substring(x + 1, equalSign - 2);
		String x1 = firstEqu.substring(0, x);

		String c2 = secondEqu.substring(++equalSign2);
		String y2 = secondEqu.substring(x2Eq + 1, equalSign2 - 2);
		String x2 = secondEqu.substring(0, x2Eq);

		x1Double = Double.parseDouble(x1);
		y1Double = Double.parseDouble(y1);
		c1Double = Double.parseDouble(c1);

		x2Double = Double.parseDouble(x2);
		y2Double = Double.parseDouble(y2);
		c2Double = Double.parseDouble(c2);

		slope1 = (x1Double * -1) / y1Double;
		slope2 = (x2Double * -1) / y2Double;

		yIntercept1 = c1Double / y1Double;
		yIntercept2 = c2Double / y2Double;
	}

	/*
	 * public static double yIntercept1(double c1Double, double y1Double){
	 * double result = c1Double / y1Double; return result; } public static
	 * double yIntercept2(double c2Double, double y2Double){ double result =
	 * c2Double / y2Double; return result; } public static double slope1(double
	 * x1Double, double y1Double){ double result = (x1Double * -1) / y1Double;
	 * return result; } public static double slope2(double x2Double, double
	 * y2Double){ double result = (x2Double * -1) / y2Double;; return result; }
	 */
	public static double calcInfinSolu(int i, double slope1, double yIntercept1) {
		int result1;
		double result = slope1 * i + yIntercept1;
		if (result >= 0) {
			result = ((result + 0.0005) * 1000);
		} else {
			result = ((result - 0.0005) * 1000);
		}
		result1 = (int) result;
		result = ((double) result1 / 1000);
		return result;
	}

	public String toString() {
		infinSolu = new double[50];
		int i;
		if ((slope1 == slope2) && (yIntercept1 == yIntercept2)) {
			for (i = 0; i < 50; i++) {
				infinSolu[i] = calcInfinSolu(i, slope1, yIntercept1);
				myString = myString + "( " + i + " , " + infinSolu[i] + " ),";
			}
		} else if ((slope1 == slope2) && (yIntercept1 != yIntercept2)) {
			myString = "The lines are parallel to each other; therefore, there is no solution";
		} else {
			dDouble = (x1Double * y2Double) - (y1Double * x2Double);
			dXDouble = (c1Double * y2Double) - (y1Double * c2Double);
			dYDouble = (x1Double * c2Double) - (c1Double * x2Double);

			xDouble = dXDouble / dDouble;
			yDouble = dYDouble / dDouble;
			if (xDouble >= 0) {
				xDouble = ((xDouble + 0.0005) * 1000);
			} else {
				xDouble = ((xDouble - 0.0005) * 1000);
			}
			if (yDouble >= 0) {
				yDouble = ((yDouble + 0.0005) * 1000);
			} else {
				yDouble = ((yDouble - 0.0005) * 1000);
			}
			xInt = (int) xDouble;
			xDouble = ((double) xInt / 1000);
			yInt = (int) yDouble;
			yDouble = ((double) yInt / 1000);

			myString = "( " + xDouble + " , " + yDouble + " )";
		}
		return myString;
	}
}
