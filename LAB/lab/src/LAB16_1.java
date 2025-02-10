import java.util.LinkedList;
import java.util.Scanner;

public class LAB16_1 {
    public static void main(String[] args) {
        //Bai 1:
        System.out.print("Ready");

        //Bai 2:
        int n2;
        Scanner scanner2 = new Scanner(System.in);
        n2 = scanner2.nextInt(); //Lệnh nhập giá trị của n từ bàn phím.
        int[] arr2 = new int[n2];
        int sum2 = 0;
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner2.nextInt();   // Nhập các phần tử trong dãy.
            sum2 += arr2[i];                //Tính tổng các phần tử
        }
        scanner2.close();
        System.out.print(sum2);

        //Bài 3:
        int n3;
        Scanner scanner3 = new Scanner(System.in);
        n3 = scanner3.nextInt(); //Lệnh nhập giá trị của n từ bàn phím.
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = scanner3.nextInt();   // Nhập các phần tử trong dãy.
        }
        for (int i = 0; i < n3; i++) {
            arr3[i] *= arr3[i];   // Cập nhập giá trị các phần tử trong dãy.
        }
        scanner3.close();
        for (int i = 0; i < n3; i++) {
            System.out.print(arr3[i] + " ");  // In ra màn hình giá trị các phần tử trong dãy.
        }

        //Bài 4:
        int n4;
        Scanner scanner4 = new Scanner(System.in);
        n4 = scanner4.nextInt(); //Lệnh nhập giá trị của n từ bàn phím.
        LinkedList<Integer> arr4 = new LinkedList<>();
        for (int i = 0; i < n4; i++) {
            arr4.add(scanner4.nextInt());   // Cập nhập giá trị các phần tử trong dãy.
        }
        int k, x;
        k = scanner4.nextInt();
        x = scanner4.nextInt();
        arr4.add(k, x);
        scanner4.close();
        for (int i = 0; i <= n4; i++) {
            System.out.print(arr4.get(i) + " ");  // In ra màn hình giá trị các phần tử trong dãy.
        }

        //Bài 5:
        /*
        * Bài tập.
Nhập vào một số nguyên dương n, và n số nguyên lần lượt là các phần tử trong dãy a. Tiếp theo nhập vào số nguyên là k (0 ≤ k < n).

Hãy xóa phần tử có chỉ số k ở trong dãy đó. In mảng kết quả ra màn hình, sau mỗi phần tử có đúng một khoảng trắng.

Ví dụ:

Test mẫu 1:

Input	Output
4
1 2 3 4
1

1 3 4

Với n = 4, a = [1, 2, 3, 4], k = 1, thì kết quả mong muốn là: "1 3 4 ".

Test mẫu 2:

Input	Output
3
1 2 3
2

1 2

Với n = 3, a = [1, 2, 3], k = 2, thì kết quả mong muốn là: "1 2 ".


Hướng dẫn bài tập.
Ý tưởng:
Ta thấy rằng khi xóa một phần tử trong mảng thì số phần tử trong mảng bị giảm đi 1 đơn vị, tất cả những phần tử từ chỉ số 0 đến k-1 đều giữ nguyên, các phần tử từ chỉ số k đến n-1 sẽ giảm chỉ số đi 1 đơn vị (a[i] = a[i+1]).

Chú ý: nhớ dùng vào lặp hợp lý, để không bị mất giá trị các phần tử trong mảng.



Code mẫu:

Ngôn ngữ C++:

#include<iostream>

using namespace std;

int main(){
	int a[100];
	int n, k;
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> a[i];
	}
	cin >> k;
	for (int i = k; i < n; i++){
		a[i] = a[i+1];
	}
	n--;
	for (int i = 0; i < n; i++){
		cout << a[i] << " ";
	}

	return 0;
}
*
*
* Bài tập 6:
Nhập vào một số nguyên dương n, và n số nguyên lần lượt là các phần tử trong dãy a. Hãy in lần lượt các số nguyên tố có trong dãy a ra màn hình, sau mỗi phần tử có đúng một khoảng trắng.
(Số nguyên tố là số nguyên dương có đúng 2 ước là 1 và chính nó. Số a được gọi là ước của b nếu b chia hết cho a). Biết rằng dãy sẽ có ít nhất một số nguyên tố.

Ví dụ:

Test mẫu 1:

Input	Output
4
1 2 3 4

2 3

Với n = 4, a = [1, 2, 3, 4] thì kết quả mong muốn là: "2 3 ".

Test mẫu 2:

Input	Output
3
7 2 3

7 2 3

Với n = 3, a = [7, 2, 3] thì kết quả mong muốn là: "7 2 3 ".


Hướng dẫn bài tập.
Một trong nhữngcách kiểm tra số nguyên tố tốt nhất đó là:
Để kiểm tra một số n có phải là số nguyên tố hay không ta làm như sau:

Nếu n < 2 thì n không là số nguyên tố.
Nếu n = 2 hoặc n = 3 thì n là số nguyên tố.
Nếu n ≥ 2:
Nếu n không có ước trong khoảng 2 đến phần nguyên căn bậc 2 của n thì n là số nguyên tố, ngược lại n không là số nguyên tố.
Code mẫu:

Ngôn ngữ C++:

#include<iostream>
#include<math.h>

using namespace std;

bool isPrime(int n){
	if (n < 2) return false;
	for (int i = 2; i <= sqrt(n); i++){
		if (n%i == 0){
			return false;
		}
	}
	return true;
}
int main(){
	int a[100];
	int n;
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> a[i];
	}
	for (int i = 0; i < n; i++){
		if (isPrime(a[i])){
			cout << a[i] << " ";
		}
	}

	return 0;
}
        *
        *
        * Bài Tập 7
        * Bài tập.
Nhập và một số nguyên dương n, tiếp theo là n số nguyên dương lần lượt là các phần tử của một dãy số, hãy đếm tần số (số lần xuất hiện) của các số trong dãy và in nó ra màn hình dưới dạng sau: "a1 - t1; a2 - t2; ... an - tn; ", trong đó t1 là số lần xuất hiện của số a1, t2 là số lần xuất hiện của a2, ... a1, a2, .. an không trùng nhau và được sắp xếp tăng dần (xem ví dụ để rõ hơn).

Ví dụ:

Test mẫu 1:

Input	Output
6
4 2 2 5 6 5

2 - 2; 4 - 1; 5 - 2; 6 - 1;

Với a = [4, 2, 2, 5, 6, 5] thì kết quả mong muốn là: "2 - 2; 4 - 1; 5 - 2; 6 - 1; ".

Test mẫu 2:

Input	Output
5
2 2 2 1 2

1 - 1; 2 - 4;

Với a = [2, 2, 2, 1, 2] thì kết quả mong muốn là: "1 - 1; 2 - 4; ".
Hướng dẫn bài tập.
Với bài này ta sẽ sử dụng kỹ thuật đánh dấu:

Tạo dãy b với mục đích: b[i] sẽ lưu số lần xuất hiện của số có giá trị là i.

Khởi tạo các phần tử của dãy b bằng 0, nếu trong dãy có số a[i] thì ta tằng b[a[i]] lên 1 đơn vị, giá trị của a[i] sẽ được xem là một chỉ số trong dãy b).

Lưu ý: Với các đánh dấu này chỉ áp dụng được khi a[i] có thể là chỉ số của dãy b.

Code mẫu:

Ngôn ngữ C++:

#include<iostream>

using namespace std;

int a[100001], b[100001];
int main(){
    int n;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    int Max = a[0];
    for (int i = 0; i < n; i++){
        if (a[i] > Max){
            Max = a[i];
        }
    }
    for (int i = 0; i <= Max; i++){
        b[i] = 0;
    }
    for (int i = 0; i < n; i++){
        b[a[i]] += 1;
    }
    for (int i = 0; i <= Max; i++){
        if (b[i] > 0){
            cout << i << " - " << b[i] << "; ";
        }
    }
    return 0;
}
*
* Bài Tập 8
* Nhập và một số nguyên dương n, tiếp theo là n số nguyên dương lần lượt là các phần tử của một dãy số a. Hãy kiểm tra xem dãy a có phải là dãy đơn điệu hay không, trả về "YES" nếu có, "NO" nếu không.

Một dãy đơn điệu khi nó là dãy số tăng (a[i] > a[i-1]), hoặc dãy số giảm (a[i] < a[i-1]).

Ví dụ:

Test mẫu 1:

Input	Output
5
1 2 3 4 5

YES

Với a = [1, 2, 3, 4, 5] thì kết quả mong muốn là "YES".

Test mẫu 2:

Input	Output
4
5 3 1 -4

YES

Với a = [5, 3, 1, -4] thì kết quả mong muốn là "YES".

Test mẫu 3:

Input	Output
5
1 2 4 3 -2

NO

Với a = [1, 2, 4, 3, -2] thì kết quả mong muốn là "NO".
Hướng dẫn bài tập.
Để kiểm tra tính tăng giảm của dãy số, ta lần lượt kiểm tra hiệu số giữa hai phần tử kề nhau ở trong dãy.

Lưu ý: dãy có 1 phần tử cũng là dãy đơn điệu.

Code mẫu:

Ngôn ngữ C++:

Cách 1:

#include<iostream>

using namespace std;

int a[100001];
int main(){
    int n;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    bool kt1 = true; // kiểm tra dãy tăng.
    bool kt2 = true; // kiểm tra dãy giảm.
    for (int i = 1; i < n; i++){
        if (a[i] <= a[i-1]) kt1 = false;
        if (a[i] >= a[i-1]) kt2 = false;
    }
    if (kt1 || kt2) cout << "YES";
    else cout << "NO";
    return 0;
}
Cách 2:

#include<iostream>

using namespace std;

int a[100001];
int main(){
    int n;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    bool kt = true;
    if (n > 2){
        for (int i = 2; i < n; i++){
            if ((a[i] - a[i-1]) * (a[i-1] - a[i-2]) <= 0){
                kt = false;
            }
        }
    }
    if (kt) cout <<"YES";
    else cout <<"NO";
    return 0;
}
*
* Bài Tập 9:
* Cho dãy a gồm n số nguyên, và dãy b gồm m số nguyên, cả hai dãy đều được sắp xếp không giảm.
Hãy gộp hai dãy thành một dãy c, sao cho dãy c cũng là dãy không giảm. In dãy c ra màn hình, sau mỗi phần tử có đúng một dấy cách.

Ví dụ:

Test mẫu 1:

Input	Output
3
1 3 4
4
1 2 3 5

1 1 2 3 3 4 5

Với a = [1, 3, 4] và b = [1, 2, 4, 5] thì kết quả mong muốn là: "1 1 2 3 4 4 5 ".

Test mẫu 2:

Input	Output
3
1 2 3
3
2 3 4

1 2 2 3 3 4

Với a = [1, 2, 3] và b = [2, 3, 4] thì kết quả mong muốn là: "1 2 2 3 3 4 ".
Hướng dẫn bài tập.
Tạo dãy c rỗng, lần lượt thêm các phần tử vào dãy c theo thứ tự từ bé đến lớn, do dãy a và b đã được sắp xếp, nên ta chỉ cần so sánh 2 giá trị là 2 giá trị nhỏ nhất của mỗi dãy.

Ví dụ với bài trên.
Lúc đầu ta sẽ xét hai số là a[0] và b[0] thêm số nhỏ hơn và dãy c. ta thấy a[0] >= b[0] nên ta lấy giá trị nhỏ hơn là b[0] thêm vào dãy c.



Xét hai số là a[0] và b[1] để thêm số nhỏ hơn và dãy c. Ta thấy a[0] < b[1] nên ta thêm a[0] và dãy c.



Tiếp tục tương tự như vậy đến khi 1 trong 2 dãy hết phần tử để duyệt.



Lúc này 1 trong 2 dãy đã hết phần tử, ta thêm tất cả phần tử của dãy còn lại vào dãy c.



Code mẫu:

Ngôn ngữ C++:

#include<iostream>

using namespace std;

int a[100001], b[100001], c[100001];
int main(){
    int n, m;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> a[i];
    }
    cin >> m;
    for (int i = 0; i < m; i++){
        cin >> b[i];
    }
    int size = 0; // lưu số lượng phần tử của dãy c
    int i = 0, j = 0;
    while (i < n && j < m){
        if (a[i] < b[j]){
            c[size] = a[i];
            size = size + 1;
            i = i + 1;
        } else {
            c[size] = b[j];
            size = size + 1;
            j = j + 1;
        }
    }
    while (i < n){
        c[size] = a[i];
        size = size + 1;
        i = i + 1;
    }
    while (j < m){
        c[size] = b[j];
        size = size + 1;
        j = j + 1;
    }
    for (int i = 0; i < size; i++){
        cout << c[i] << " ";
    }
    return 0;
}
*
* Bài TẬP 10:
* Nhập và hai số nguyên dương m và n lần lượt là số hàng và số cột của mảng hai chiều a, tiếp theo là nhập các phần tử của mảng đó.
Hãy tính và đưa ra tổng của tất cả các phần tử trong mảng a.

Ví dụ:

Test mẫu 1:

Input	Output
2 3
1 2 3
4 5 6

21

Với a = [[1, 2, 3], [4, 5, 6]] thì kết quả mong muốn là 21.
Giới thiệu mảng hai chiều.
Mảng hai chiều kích thước (m,n) gồm m hàng và n cột, thực chất có thể xem như là m mảng một chiều kích thước n.

Khai báo mảng hai chiều:

Kiểu_phần_tử tên_mảng[Số_hàng_tối_da][Số_cột_tối_da];
//Ví dụ int a[100][200];
Các chỉ số trong mảng hai chiều được đánh số như sau:



Với a[i][j] là phần tử hàng thứ i và cột thứ j trong mảng hai chiều a.
(Hàng và cột được đánh số từ 0).



Hướng dẫn bài tập.
Code mẫu:

Ngôn ngữ C++:

#include<iostream>

using namespace std;

int main(){
	int a[100][100];
	int m, n;
	cin >> m >> n;
	for (int i = 0; i < m; i++){
		for (int j = 0; j < n; j++){
			cin >> a[i][j];
		}
	}
	int sum = 0;
	for (int i = 0; i < m; i++){
		for (int j = 0; j < n; j++){
			sum += a[i][j];
		}
	}
	cout << sum;

	return 0;
}
*
*
*
* BÀi TẬP 12:
* Câu hỏi ôn tập.
Biến "k" trong chương trình sau dùng để làm gì:

#include<iostream>

using namespace std;

int main(){
	int a[100];
	int n;
	cin >> n;

	for (int i = 0; i < n; i++){
		cin >> a[i];
	}
	int k = 0;
	for (int i = 1; i < n; i++){
		if (a[i] > a[k]){
			k = i;
		}
	}
	cout << k;

	return 0;
}
Hãy chọn phát biểu đúng nhất.


Lưu giá trị lớn nhất trong dãy a.


Lưu chỉ số của phần tử lớn nhất trong mảng a.


CHỌN: Lưu chỉ số của phần tử lớn nhất đầu tiên trong mảng a.
        * */


    }
}
