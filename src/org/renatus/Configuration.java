package org.renatus;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Pertains data for the application to use.
 *
 * @author Timer
 */
public class Configuration {
	public static final String NAME = "Renatus";
	private static OperatingSystem operatingSystem;
	public static boolean RUNNING_FROM_JAR = false;

	public static class Paths {
		public interface Resources {
			public static final String ROOT = "resources";
			public static final String ROOT_IMG = ROOT + "/images";

			public static final String VERSION = Resources.ROOT + "/version.txt";

			public interface Images {
				public static final String ICON = ROOT_IMG + "/icon.png";
			}
		}
	}

	public static void setup() {
		if (operatingSystem == null) {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				operatingSystem = OperatingSystem.WINDOWS;
			} else if (os.contains("Mac")) {
				operatingSystem = OperatingSystem.MAC;
			} else if (os.contains("Linux")) {
				operatingSystem = OperatingSystem.LINUX;
			} else {
				operatingSystem = OperatingSystem.OTHER;
			}
		}
		final URL resource = Configuration.class.getClassLoader().getResource(Paths.Resources.VERSION);
		if (resource != null) {
			Configuration.RUNNING_FROM_JAR = true;
		}
	}

	public static OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public static URL getResourceURL(final String path) throws MalformedURLException {
		return RUNNING_FROM_JAR ? Configuration.class.getResource("/" + path) : new File(path).toURI().toURL();
	}

	public static Image getImage(final String resource) {
		try {
			return Toolkit.getDefaultToolkit().getImage(getResourceURL(resource));
		} catch (final Exception ignored) {
		}
		return null;
	}

	public enum OperatingSystem {
		MAC, WINDOWS, LINUX, OTHER
	}
}