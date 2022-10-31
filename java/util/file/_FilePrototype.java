package util.file;

/**
 * 다른 util.file의 class들이 공통적으로 상속받게 될 _FilePrototype 클래스.
 * @author 환류상
 */
public class _FilePrototype {
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
	protected _FilePrototype() { };
}