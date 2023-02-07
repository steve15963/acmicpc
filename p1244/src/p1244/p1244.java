package p1244;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1244{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Integer.parseInt(br.readLine());
		//입력받아 char 배열에 넣기.
		char SWMap[] = br.readLine().replaceAll(" ", "").toCharArray();
		int MAPLength = SWMap.length;
		int round = Integer.parseInt(br.readLine());
		//학생 수 만큼
		while(round-- > 0) {
			//좌변 우변을 " "공백 문자로 나눠서 Array String으로 저장
			String data[] = br.readLine().split(" ");
			//배수 값인 우항이 String이므로 int값으로 변환
			int num = Integer.parseInt(data[1]);
			// 남자면
			if(data[0].equals("1")) {
				for(int i=num-1; i < MAPLength; i = i + num) {
					// 1이면  0으로 0이면 1으로
					SWMap[i] = SWMap[i] == '1' ? '0' : '1';
				}
			}
			//여자면
			else {
				int i = 0;
				//index는 0부터 이므로.
				num--;
				//좌우 항이 같은동안 반전하겠다.
				while(num - i >= 0 && num + i < MAPLength && SWMap[num - i] == SWMap[num + i]) {
					//반전
					SWMap[num - i] = SWMap[num - i] == '1'? '0':'1';
					SWMap[num + i] = SWMap[num - i];
					//검색 범위 증가
					i++;
				}
			}
		}
		for(int i= 1; i<=MAPLength;i++)
			sb.append(SWMap[i-1]).append(i%20 == 0 ? "\n":" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}