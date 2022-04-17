# 백준 온라인 저지 사용 팁

## 개요

[백준 온라인 저지](https://www.acmicpc.net)에서 문제를 풀면서 도움이 될만한 내용들에 대한 정리입니다.

## 추천 문제

풀이해보면 괜찮을만한 문제들의 모음입니다.

- [[취업 준비] 신입 개발자 알고리즘 팁 정리 및 문제 추천](https://mangkyu.tistory.com/181)

## 입력을 효율적으로 받기

제공되는 문제들은 대부분 콘솔 입력을 통해 테스트 케이스를 받습니다. 따라서 **테이스 케이스 입력을 얼마나 효율적으로 받느냐에 따라 소요시간이 바뀌게 됩니다.** 본 문서는 이에 대한 참고사항을 다룹니다.

### 상세

자바를 기준으로 설명합니다.
일반적으로 자바에서는 다음 코드를 통해서 입력을 받곤 합니다.

    Scanner sc = new Scanner(System.in);

하지만 Scanner는 내부적으로 nextInt() 등의 함수를 호출시 다음 입력을 찾기 위해 정규식을 사용하므로 속도가 느립니다. 따라서 Scanner를 사용하면 올바른 로직이더라도 시간초과로 인해 오답이 될 수 있습니다. [입력 속도 비교](https://www.acmicpc.net/blog/view/56)를 참고하면 여러 언어들의 입력 방법별 소요 시간을 볼 수 있습니다. 여기서 자바의 경우 BufferedReader를 사용하는 경우 가장 짧은 소요시간을 얻을 수 있으므로, BufferedReader를 사용해야 합니다.

<pre><code>import java.io.BurreredReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exeption {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          // ...
    }

    public static void Main(String[] args) throws Exeption {
      new Main().solution();
    }
}</code></pre>

마찬가지로 String 자료형에 대해 split()을 사용하기 보다는 StringTokenizer를 활용하는게 더 빠릅니다. 따라서 입력받을 때 BufferedReader와 StringTokenizer로 입력받는다면 빠르게 입력받을 수 있습니다.

백준 온라인 저지에서는 다음과 같은 형식의 입력값을 자주 받게 됩니다.

    3
    1 5
    3 10 11 12
    5 1 2 3 4 5

첫번째 줄은 N개의 입력을 의미하고, 두번째 줄 이후부터는 각 입력이 어떤 값들을 가지고 있는지를 나타냅니다. 이것을 Scanner와 split()으로 입력받으면 다음과 같습니다.

<pre><code>import java.util.Scanner;

public class Main {
    public void solution() throws Exeption {
          Scanner sc = new Scanner(System.in);
          int n = Integer.parseInt(sc.nextInt());

          for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] dataArr = str.split(" ");
            int s = Integer.parseInt(dataArr[0]);

            for(int j = 0; j <= s; j++) {
              int data = Integer.parseInt(dataArr[j]);
              System.out.printlb(data);
            }
          }
    }

    public static void Main(String[] args) throws Exeption {
      new Main().solution();
    }
}</code></pre>

반면, BufferedReader와 StringTokenizer로 코드를 작성하면 다음과 같습니다.

<pre><code>import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exeption {
          BufferedReader br = new BufferedReader(new InputStreanReader(System.in));
          int n = Integer.parseInt(br.nextLine());

          for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            for(int j = 0; j < s; j++) {
              int data = Integer.parseInt(st.nextToken());
              System.out.println(data);
            }
          }
    }

    public static void Main(String[] args) throws Exeption {
      new Main().solution();
    }
}</code></pre>

## 참고 자료

- [자바로 백준 풀 때의 팁 및 주의점 (boj java)](https://nahwasa.com/entry자바로-백준-풀-때의-팁-및-주의점-boj-java)
- [백준 문제 자바로 풀 때 유의사항](https://blog.naver.com/chltmddus23/221696297647)
- [[JAVA 자바]입력받기 Scanner vs BufferedReader](https://blog.naver.com/parkhj2416/221843949484)
- [[JAVA] BufferedReader 와 Bufferedwriter 사용법](https://blog.naver.com/ka28/221850826909)
- [[Java , BaekJoon] 자바로 백준 입력 받는 법 정리](https://rhsalska55.tistory.com/6)
