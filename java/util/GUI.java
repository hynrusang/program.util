package util;
import util.file.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ChangePanel implements ActionListener {
	int panelnum;
	@Override
	public void actionPerformed(ActionEvent e) {
		Database panel = _Panel.getPanelBox(panelnum);
		GUI.mainpanel.removeAll();
		GUI.mainpanel.add(panel.get(0, JPanel.class), BorderLayout.WEST);
		GUI.mainpanel.add(panel.get(1, JPanel.class), BorderLayout.CENTER);
		GUI.main.revalidate();
	}
	public ChangePanel(int panelnum) { this.panelnum = panelnum; }
}
class _MenuBar extends JMenuBar {
	public static JMenuBar get() {
		JMenuBar menubar = new JMenuBar(); 
		JMenu menu = new JMenu("util 핸들러");
		menubar.add(menu);
		JMenuItem item1 = new JMenuItem("U.Database");
		item1.addActionListener(new ChangePanel(0));
		menu.add(item1);
		menu.addSeparator();
		JMenuItem item2 = new JMenuItem("U.file.Filepath");
		item2.addActionListener(new ChangePanel(1));
		menu.add(item2);
		JMenuItem item3 = new JMenuItem("U.file.Json");
		menu.add(item3);
		return menubar;
	}
	private _MenuBar() { }
}
class _Panel {
	public static Database getPanelBox(int num) { 
		Database panel = new Database(false);
		JPanel side = new JPanel();
		panel.add(side);
		JButton createbutton;
		JButton removebutton;
		side.setLayout(new GridLayout(10, 1, 1, 20));
		JPanel main = new JPanel();
		JLabel mainexplain;
		panel.add(main);
		switch (num) {
		case 0:
			createbutton = new JButton("create new Database");
			side.add(createbutton);
			removebutton = new JButton("remove targer Database");
			side.add(removebutton);
			mainexplain = new JLabel("<html>현재 저장된 Database:<br></html>");
			main.add(mainexplain);
			break;
		case 1:
			main.setLayout(new GridLayout(9, 1, 1, 10));
			mainexplain = new JLabel("Filepath에 저장된 경로명:");
			mainexplain.setHorizontalAlignment(JLabel.CENTER);
			main.add(mainexplain);
			JLabel local = new JLabel("Local: "+ Filepath.Local);
			local.setHorizontalAlignment(JLabel.CENTER);
			main.add(local);
			JLabel appdata = new JLabel("Appdata: "+ Filepath.Appdata);
			appdata.setHorizontalAlignment(JLabel.CENTER);
			main.add(appdata);
			JLabel onedrive = new JLabel("Onedrive: "+ Filepath.Onedrive);
			onedrive.setHorizontalAlignment(JLabel.CENTER);
			main.add(onedrive);
			JLabel programfile = new JLabel("Programfiles: "+ Filepath.Programfiles);
			programfile.setHorizontalAlignment(JLabel.CENTER);
			main.add(programfile);
			JLabel programfile86 = new JLabel("Programfiles86: "+ Filepath.Programfiles86);
			programfile86.setHorizontalAlignment(JLabel.CENTER);
			main.add(programfile86);
			JLabel user = new JLabel("User: "+ Filepath.User);
			user.setHorizontalAlignment(JLabel.CENTER);
			main.add(user);
			JLabel downloads = new JLabel("Downloads: "+ Filepath.Downloads);
			downloads.setHorizontalAlignment(JLabel.CENTER);
			main.add(downloads);
		}
		return panel; 
	}
	private _Panel() {} ;
}
final public class GUI extends JFrame {
	public static GUI main = new GUI();
	public static JPanel mainpanel = new JPanel();
	public static void main(String args[]) {
		main.setTitle("util GUI(그래픽 유저 인터페이스) 커멘더");
		main.setJMenuBar(_MenuBar.get());;
		main.setSize(1040, 720);
		mainpanel.setLayout(new BorderLayout());
		main.add(mainpanel);
		main.setVisible(true);
	}
	private GUI() { }
}