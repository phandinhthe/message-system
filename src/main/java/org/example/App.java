package org.example;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		final String ORANGE = "\u001B[38;5;208m";
		final String RESET = "\u001B[0m";
		System.out.println(ORANGE +
				"================== Message System - Java Multithreading using wait(), notify() ==============="
				+ RESET
		);

		MessageSystem messageSystem = MessageSystem.instance();
		Thread publisher = new Thread(() -> {
			try {
				messageSystem.publish();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

        Thread consumer = new Thread(() -> {
			try {
				messageSystem.subscribe();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		publisher.start();
		consumer.start();
	}


}