package application;

public class Model {

	//�߰������� Ŭ���� ��� ������ ���� ���ݿ� ���ο� ���� ������ ��������, �׷��� ���� ��� �ϳ��� ���� ���ݸ� ���˴ϴ�
	public int calculate(String push, int x, int y) {
		if(push.equals("5000")) {
			return 5000-(x+y);
		} else {
			return 10000-(x+y); 
		}
	}
}