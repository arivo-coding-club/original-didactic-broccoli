package application;

public class Model {

	//�߰������� Ŭ���� ��� ������ ���� ���ݿ� ���ο� ���� ������ ��������, �׷��� ���� ��� �ϳ��� ���� ���ݸ� ���˴ϴ�
	public int calculate(String select, int x, int y) {
		if(!select.equals("�߰�����")) {
			return y;
		} else {
			return x+y;
		}
	}
}