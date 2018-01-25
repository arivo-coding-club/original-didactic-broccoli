package mission03.answer;

public class LearningThreadSleep {
	public static void main(String[] args) {
		/*
		 우선 Thread.sleep()을 설명하기 전에,
		 
		 우리가 '프로그램' 이라고 하는, 예를 들어 인터넷 익스플로러나, 지뢰찾기, 이클립스 등 
		 실행하는 것들을 보통은 프로그램이라고 하고, 개발에서는 이걸 '프로세스(Process)' 라는 용어를 써요.
		 사실 신경 쓸 일이 없었지만 프로세스들은 동시에 여러 개가 실행되고 있지요.
		 (사실은 동시에 실행되고 있는 것처럼 보이고, CPU가 열심히 프로세스들의 작업을 아주 짧은 시간 동안에 돌아가면서 해주고 있어서 그렇게 보여요)
		 
		 이런 프로세스는 운영체제 안에서 실행되고 운영체제가 관리하게 돼요.
		 그래서 Ctrl + Alt + Del 키를 누르면 운영체제를 통해 프로그램을 강제로 종료할 수도 있게 되구요.
		 
		 그리고 그 프로세스 안에서 또 잘게 나뉘어져서 동시에 돌아가는(것 처럼 보이는) '스레드(Thread)'가 있어요.
		 사실 모든 자바 프로세스는 1개의 스레드가 있어요
		 프로세스가 실행되고 -> 스레드가 실행되서 -> 메인 메서드를 실행하게 돼요.
		 
		 그 첫 번째 스레드를 보고 메인 스레드(Main Thread)라고 해요. 
		 */
		
		// Thread에 있는 currentThread() 정적 메서드는 현재 스레드 객체를 가져와요. 
		Thread thread = Thread.currentThread();
		// 그 스레드의 이름을 출력해보면
		System.out.println(thread.getName());
		// 사실 이 이름은 말그대로 이름이라 이름을 바꿔줄 수도 있어요.
		thread.setName("메인 스레드");
		System.out.println(thread.getName());
		
		// Thread.sleep() 정적 메서드는 현재 스레드(currentThread)를 잠시 재워놓는,
		// 즉 CPU가 현재 스레드의 작업을 하지 않고 쉬도록 하는 역할을 해요
		try {
			System.out.println("0초");
			Thread.sleep(1000);
			System.out.println("1초");
			Thread.sleep(1000);
			System.out.println("2초");
			Thread.sleep(1000);
			System.out.println("3초");
			Thread.sleep(1000);
			System.out.println("4초");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 저 sleep 메서드에 인자로 전달되는 값은 밀리세컨드 단위로 전달을 해요.
		// 밀리세컨드 = 1000분의 1초.
		// 즉 1000 밀리세컨드는 1초. 그래서 위에 예에서는 1000을 전달했어요.
		
		// 자 여기까지 정리해보면, 자바를 실행하면 메인스레드가 기본적으로 있고,
		// 이 스레드를 쉬게할 수도 있고, 쉬게하는 메서드는 sleep()이다. 가 됩니다.
		
		// 아직 스레드의 개념이 알쏭달쏭할테니,
		// 여러 개의 스레드를 만들어서 동시에 처리(되는 것 같은) 걸 만들어 볼게요.
		
		Runnable 공부하기 = new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < 10 ; i++) {
					System.out.println(Thread.currentThread().getName() + " 공부한다.");
				}
			}
		};
		// 첫 번째 인자는 Runnable, 두 번째 인자는 스레드 이름(아까 thread.getName()의 그 name)
		Thread 공부 = new Thread(공부하기, "공부 스레드");
		
		// Runnable을 익명 객체로 전달
		Thread 게임 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ; i < 10 ; i++) {
					System.out.println(Thread.currentThread().getName() + " 게임한다.");
				}
			}
		}, "게임 스레드");
		
		// 비슷하지만 람다 표현식으로 Runnable 전달
		Thread 잠 = new Thread(() -> { // Java 8 의 lambda 표현, 위 new Runnable()..과 똑같은 역
				for(int i = 0 ; i < 10 ; i++) {
					System.out.println(Thread.currentThread().getName() + " 잔다.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}, "잠 스레드");
		
		// 이렇게 우선 세 개의 새로운 스레드를 만들었어요.
		// 우선은 깊게 이해를 하지 않아도 되고, 뒤에 네트워크와 GUI 프로그래밍을 할 때 스레드를 다시 만나게 될 거예요.
		// 지금은 맛보기라고 생각하고 가볍게!
		
		// 각 스레드가 해야할 일을 Runnable 인터페이스의 run() 메서드를 구현해서 전달해줘요.
		// 위 예시처럼 익명으로 해도 되고,Runnable 인터페이스를 구현하는 클래스를 만들어도 되고, 어쨌든 Runnable 객체를 넘겨주면
		// 스레드를 시작하면 run() 메서드를 실행하게 되어요.
		
		// 위에는 일단 스레드를 만들기만 한 상태고, 스레드를 시작하려면, start() 메서드를 호출해주면 됩니다.
		공부.start();
		게임.start();
		잠.start();
		
		System.out.println("thread 출력 완료");
		
		// 이 클래스를 실행해보면 알겠지만, 코드에 있는 순서인 공부 -> 게임 -> 잠 의 순서가 아니라
		// 동시에 작업을 해요. 이 순서는 운영체제와 CPU가 결정하게 되어있고, 스레드의 우선순위를 조금 조정할 수는 있어요.
		// 어쨌든 어느 스레드가 먼저 시작하고, 먼저 끝날지, 중간에 어떤 작업을 할지 알 순 없지만
		// 동시에 실행(되는 것처럼 보이는)돼요.
		
		// 스레드는 위에서 잠깐 살펴본 것처럼 동시에 여러 작업을 수행할 수 있도록 해줘요.
		// 여기선 다루지 않았지만 스레드를 쓸 때는 조심해야할 내용들이 많아요.
		// 일단은 여기까지 가볍게 스레드 공부 끝!
	}
}
