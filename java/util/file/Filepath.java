package util.file;

class FileDependency {
	protected String filepath;
	protected String data;
	/**
	 * 현재 파일이 저장될 디렉터리를 반환.
	 * @return 현재 파일이 저장될 디렉터리.
	 */
	public String getPath() { return filepath; };
	/**
	 * 현 파일의 소스 코드를 반환.
	 * @return 현 파일의 소스 코드.
	 */
	@Override
	public String toString() { return data; };
	/**
	 * 현 파일의 소스 코드를 출력.
	 */
	public void print() { System.out.print(toString()); };
}
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