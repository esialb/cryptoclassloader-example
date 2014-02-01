package org.cryptoclassloader.example.use;

import java.io.File;
import java.io.IOException;
import java.util.ServiceLoader;

import org.cryptoclassloader.CryptoClassLoader;
import org.cryptoclassloader.example.api.Widget;

public class WidgetMain {
	
	private static Widget loadImpl() {
		try {
			ClassLoader ccl = new CryptoClassLoader(
					"foobar",
					new File("target/dependency/example-cryptoclassloader-impl.jar").toURI().toURL());
			
			for(Widget w : ServiceLoader.load(Widget.class, ccl))
				return w;
		} catch (IOException e) {
		}
		return null;
	}

	public static void main(String[] args) {
		loadImpl().doSomething();
	}

}
