package aSap.testy;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class MF1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public MF1() {
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);

	}

}
