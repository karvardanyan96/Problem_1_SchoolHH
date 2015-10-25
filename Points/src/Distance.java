
public class Distance {
	public static double fun(int x1, int y1, int x2, int y2)
    {
        double distance;
        distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return distance;
    }
}
