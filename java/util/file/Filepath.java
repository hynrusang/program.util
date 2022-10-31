package util.file;

/**
 * 주요한 window 환경 변수를 담고 있는 Filepath 인터페이스.
 * @author 환류상
 */
public interface Filepath {
	String Local = System.getenv("LOCALAPPDATA") + "\\";
	String Appdata = System.getenv("APPDATA") + "\\";
	String Onedrive = System.getenv("ONEDRIVE") + "\\";
	String Programfiles = System.getenv("ProgramFiles") + "\\";
	String Programfiles86 = System.getenv("ProgramFiles(x86)") + "\\";
	String User = System.getenv("USERPROFILE") + "\\";
	String Downloads = User + "downloads" + "\\";
}
