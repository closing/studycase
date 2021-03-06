package com.zyx.rs.boot;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import com.zyx.rs.subscriber.SampleSubscriber;

import reactor.core.publisher.Flux;

public class ReactorBoot {
	public static void main(String[] args) throws IOException {
		Flux.range(1, 3).subscribe();

		Flux.range(1, 3).subscribe(i -> System.out.println(i));

		Flux.range(1, 4).map((i) -> {
			if (i <= 3) {
				return i;
			} else {
				throw new RuntimeException("Got to 4");
			}

		}).subscribe(i -> System.out.println(i),
				error -> System.out.println("Error: " + error));

		Flux.range(1, 4)
				.subscribe(i -> System.out.println(i),
						error -> System.out.println("Error: " + error),
						() -> {
							System.out.println("Down");
						});

		SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();

		Flux.range(1, 4).subscribe(i -> System.out.println(i),
				error -> System.out.println("Error: " + error),
				() -> {
					System.out.println("Down");
				}, s -> ss.request(10));
		Flux.range(1, 4).subscribe(ss);

		Flux.generate(() -> 0, (state, sink) -> {
			sink.next("3 x" + state + " = " + 3 * state);
			if (state == 10)
				sink.complete();
			return state + 1;
		}).subscribe(i -> System.out.println(i));

		Flux.generate(AtomicLong::new, (state, sink) -> {
			long i = state.getAndIncrement();
			sink.next("3 x " + i + " = " + 3 * i);
			if (i == 10)
				sink.complete();
			return state;
		}).subscribe(i -> System.out.println(i));

		System.out.println("================");
		Flux.generate(
				AtomicLong::new, (state, sink) -> {
					long i = state.getAndIncrement();
					sink.next("3 x " + i + " = " + 3 * i);
					if (i == 10)
						sink.complete();
					return state;
				}, (s) -> {
					System.out.println(s);
				});

		System.out.println("================");

		Flux.just(-1, 30, 13, 9, 20).handle((e, s) -> {
			String result = alphabet(e);
			if (result != null) {
				s.next(result);
			}
		}).subscribe(System.out::println);

		System.out.println("================");
//		Flux.range(1, 10000).publishOn(Schedulers.parallel())
//				.subscribe(i -> System.out.println(i));

		System.out.println("================");
		Flux.interval(Duration.ofMillis(250)).map(input -> {
			if (input < 3)
				return "ticket" + input;
			throw new RuntimeException("boom");
		}).onErrorReturn("Uh oh").subscribe(System.out::println);

		System.out.println("================");
//		Flux.interval(Duration.ofMillis(250)).map(input -> {
//			if (input < 3)
//				return "ticket" + input;
//			throw new RuntimeException("boom");
//		}).elapsed().retry(1).subscribe(System.out::println);

		System.out.println("================");
//		Flux.<String> error(new IllegalArgumentException()).doOnError(System.out::println)
//				.retryWhen(companion -> companion.take(3));

		System.out.println("================");
		Flux.just("foo").map(input -> {
			throw new IllegalArgumentException(input);
		}).subscribe(v -> System.out.println("GOT VALUE"),
				e -> System.out.println("ERROR: " + e));

		System.in.read();

	}

	public static String alphabet(int letterNumber) {
		if (letterNumber < 1 || letterNumber > 26) {
			return null;
		}
		int letterIndexAscii = 'A' + letterNumber - 1;
		return "" + (char) letterIndexAscii;
	}

}
