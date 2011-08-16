package org.renatus;

import org.renatus.ui.Renatus;

/**
 * Initializes the application to begin execution.
 *
 * @author Timer
 */
public class Application {
	private final Renatus ui;

	public Application() {
		this.ui = new Renatus(this);
		this.ui.setVisible(true);
	}

	public static void main(final String[] params) {
		Configuration.setup();
		new Application();
	}
}
