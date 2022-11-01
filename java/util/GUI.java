package util;
import util.file.*;
import java.awt.*;
import javax.swing.*;

class _MenuBar extends JMenuBar {
	public static JMenuBar get() {
		JMenuBar mb = new JMenuBar(); 
		JMenu screenMenu = new JMenu("핸들러");
		screenMenu.add(new JMenuItem("U.Database"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("U.file.Filepath"));
		screenMenu.add(new JMenuItem("U.file.Json"));
		mb.add(screenMenu);
		return mb;
	}
	private _MenuBar() { }
}
class _SidePanel extends JPanel {
	public static JPanel get() {
		JPanel panel = new JPanel();
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