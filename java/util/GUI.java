package util;
import util.file.*;
import java.awt.*;
import javax.swing.*;

class _MenuBar extends JMenuBar {
	public static JMenuBar get() {
		JMenuBar menubar = new JMenuBar(); 
		JMenu menu = new JMenu("핸들러");
		menubar.add(menu);
		JMenuItem item1 = new JMenuItem("U.Database");
		menu.add(item1);
		menu.addSeparator();
		JMenuItem item2 = new JMenuItem("U.file.Filepath");
		menu.add(item2);
		JMenuItem item3 = new JMenuItem("U.file.Json");
		menu.add(item3);
		return menubar;
	}
	private _MenuBar() { }
}
class _SidePanel extends JPanel {
	public static JPanel get(JButton ...buttons) {
		JPanel panel = new JPanel();
		for (JButton button : buttons) { panel.add(button); }
		return panel;
	}
	private _SidePanel() { }
}
class _MainPanel extends JPanel {
	public static JPanel get() {
		JPanel panel = new JPanel();
		return panel;
	}
	private _MainPanel() { }
}
final public class GUI extends JFrame {
	public static void main(String args[]) {
		GUI main = new GUI();
		main.setTitle("util 패키지 매니저");
		main.setJMenuBar(_MenuBar.get());;
		main.setSize(1040, 720);
		main.add(_SidePanel.get(), BorderLayout.WEST);
		main.add(_MainPanel.get(), BorderLayout.CENTER);
		main.setVisible(true);
	}
	private GUI() { }
}