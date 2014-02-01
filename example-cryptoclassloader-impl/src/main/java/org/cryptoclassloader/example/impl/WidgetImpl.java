package org.cryptoclassloader.example.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.cryptoclassloader.example.api.Widget;

public class WidgetImpl implements Widget {

	public void doSomething() {
		InputStream in = WidgetImpl.class.getResourceAsStream("widget.txt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			byte[] buf = new byte[1024];
			for(int r = in.read(buf); r != -1; r = in.read(buf))
				out.write(buf, 0, r);
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}
		System.out.println(new String(out.toByteArray()));
	}

}
