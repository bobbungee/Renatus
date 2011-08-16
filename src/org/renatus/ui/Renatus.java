package org.renatus.ui;

import org.renatus.Application;
import org.renatus.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The main UI for the application.
 *
 * @author Timer
 */
public class Renatus extends JFrame implements ActionListener {
	private final Application application;

	public Renatus(final Application application) {
		this.application = application;
		init();
		pack();
		setTitle(Configuration.NAME);
		setLocationRelativeTo(getOwner());
		setMinimumSize(getSize());
		setResizable(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JPopupMenu.setDefaultLightWeightPopupEnabled(false);
				ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
			}
		});
	}

	public void actionPerformed(final ActionEvent event) {
	}

	private void init() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		setIconImage(Configuration.getImage(Configuration.Paths.Resources.Images.ICON));
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception ignored) {
		}
	}
}
