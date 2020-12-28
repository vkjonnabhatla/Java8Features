package org.java8.example;

import java.util.concurrent.PriorityBlockingQueue;

public class StaticVolatileExample {

	private static boolean flag = false;

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
		System.out.println("3" + Thread.currentThread().getName());

		Thread.sleep(5000);
		flag = true;
		Thread.sleep(5000);
		flag = false;
		System.out.println("4");
	}

}
