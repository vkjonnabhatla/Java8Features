
public class StaticVolatileExample {

	private static volatile boolean flag = false;

	public static void main(String[] args) throws Exception {

		// IntStream.range(0, 120).forEach(i->{

		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			while (!flag) {
			}
			System.out.println("1 :: " + Thread.currentThread().getName());

			while (flag) {
			}
			System.out.println("2 :: " + Thread.currentThread().getName());
		}).start();

		// });
		System.out.println("3");

		Thread.sleep(1000);
		flag = true;
		Thread.sleep(1000);
		flag = false;
		System.out.println("4");
	}

}
