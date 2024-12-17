import java.util.*;

public class CoveringSegments_12_4 {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments,Comparator.comparingDouble(seg -> seg.end));
        int[] points = new int[segments.length];
        int selectedIndex = 0;
        points[selectedIndex] = segments[0].end;
        for (int i = 0; i < segments.length; i++) {
            if (segments[i].start > points[selectedIndex])
            {
                points[++selectedIndex] = segments[i].end;
            }
        }
        return Arrays.copyOf(points,++selectedIndex);
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
