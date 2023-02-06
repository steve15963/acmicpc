package p17478;

import java.util.Scanner;

public class p17478 {
	
	public static StringBuilder underBar(int time) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < time;i++) {
			sb.append("____");
		}
		return sb;
	}
	
	public static void recall(StringBuilder sb, int time, int round) {
		StringBuilder under = underBar(time);
		sb.append(under).append("\"����Լ��� ������?\"\n");
		if(time == round)
			sb.append(under).append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
		else {
			sb.append(under).append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
			sb.append(under).append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
			sb.append(under).append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
			recall(sb, time+1, round);
		}
		sb.append(under).append("��� �亯�Ͽ���.\n");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder().append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		recall(sb, 0, sc.nextInt());
		System.out.println(sb.toString());
		sc.close();
	}
}
