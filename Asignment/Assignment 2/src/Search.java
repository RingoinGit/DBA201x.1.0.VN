import java.util.ArrayList;
import java.util.List;

public class Search {
    //Tìm kiếm tuyến tính vị trí các phần tử lớn hơn value
    public static List<Integer> lagerValueLinear(double[] array, double value) {
        List<Integer> indices = new ArrayList<>();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] > value) {
                indices.add(i);
            }
        }
        return indices;
    }
    // Tìm kiếm nhị phân phần tử đầu tiên trên mảng đã sắp xếp
    public static int firstValueBinary(double[] array, double value) {
        int left = 0, right = array.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == value) {
                result = mid;
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
