package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

	public static class MyApp implements QuarkusApplication {

		@Override
		public int run(final String... args) throws Exception {
			Quarkus.waitForExit();
			return 0;
		}
	}

	public static void main(final String... args) {

		Quarkus.run(MyApp.class, args);
	}
}