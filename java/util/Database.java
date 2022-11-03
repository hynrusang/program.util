package util;

/**
 * 타입에 관계 없이, 다양한 타입의 객체를 저장할 수 있게 해주는 Database 클래스.
 * @author 환류상
 */
final public class Database {
	private Object[] database;
	private boolean checkEquals;
	/**
	 * <span style="font-weight: bold;">index</span>가 유효한 인덱스인지 체크 후,<br />
	 * <span style="font-weight: bold;">T</span> 타입으로 업캐스팅 된 <span style="font-weight: bold;">index</span>번째 요소를 반환.<br />
	 * <span style="font-weight: bold; color:blue;">예시: database.get(0, Integer.class);</span>
	 * @param <T> : <span style="color:purple; font-weight: bold;">generic</span>
	 * @param index : <span style="color:blue; font-weight: bold;">int</span>
	 * @param type : <span style="color:blue; font-weight: bold;">Class</span><span style="color:purple; font-weight: bold;">&lt;T&gt;</span>
	 * @return <span style="font-weight: bold;">T</span> 타입으로 업캐스팅 된 <span style="font-weight: bold;">index</span> 번째 요소 ? <span style="color: purple; font-weight: bold;">Error</span>
	 * @throws IndexOutOfBoundsException <span style="font-weight: bold;">index</span>가 음수거나, 허용가능한 범위를 벗어났을 때 발생.
	 * @throws ClassCastException <span style="font-weight: bold;">type</span>가 <span style="color: purple; font-weight: bold;">null</span>이거나, <span style="font-weight: bold;">index</span>번째 객체가 <span style="font-weight: bold;">type</span> 객체로 다운캐스팅 될 수 없을 때 발생.
	 */
	public<T> T get(int index, Class<T> type) throws IndexOutOfBoundsException, ClassCastException {
		if (!isExist(index)) throw new IndexOutOfBoundsException("잘못된 index에 접근중입니다. (접근하려는 index:" + index + " 최대 접근가능한 index:" + (database.length - 1)+ ")");
		else if (type == null) throw new ClassCastException("type는 null일 수 없습니다."); 
		else if (!type.isInstance(database[index])) throw new ClassCastException(index+ "번째 " + database[index].getClass() + " 객체는 " + type + " 객체로 다운캐스팅 될 수 없습니다.");
		return type.cast(database[index]); 
	}
	/**
	 * 현재 저장되어 있는 객체의 수를 반환.
	 * @return 현재 저장되어 있는 객체의 수.
	 */
	public int length() { return database.length; }
	/**
	 * <span style="font-weight: bold;">index</span>번째 요소 접근이 가능한지의 여부를 반환.
	 * @param index : <span style="color:blue; font-weight: bold;">int</span>
	 * @return <span style="font-weight: bold;">index</span>번째 요소 접근이 가능한지의 여부.
	 */
	public boolean isExist(int index) { return (0 <= index && index < database.length); }
	/**
	 * <span style="font-weight: bold;">object</span>가 위치해 있는 index를 반환.
	 * @param object : {<span style="color:blue; font-weight: bold;">Object: </span><span style="color:purple; font-weight: bold;">super</span>}
	 * @return <span style="font-weight: bold;">object</span>가 위치해 있는 index ? -1
	 */
	public int getIndex(Object object) {
		for (int i = 0; i < database.length; i++) if (object.equals(database[i])) return i;
		return -1;
	}
	/**
	 * <span style="font-weight: bold;">object</span>의 요소들을 모두 저장.
	 * @param object : ...{<span style="color:blue; font-weight: bold;">Object: </span><span style="color:purple; font-weight: bold;">super</span>}
	 */
	public void add(Object ...object) {
		for (Object data : object) {
			if (data == null) continue;
			else if (checkEquals && getIndex(data) != -1) continue;
			else {
				Object[] temp = new Object[length() + 1];
				int i = 0;
				for (; i < length(); i++) temp[i] = database[i];
				temp[i] = data;
				database = temp;
			}
		}
	}
	/**
	 * <span style="font-weight: bold;">index</span> 번째 요소를 삭제.
	 * @param index : <span style="color:blue; font-weight: bold;">int</span>
	 */
	public void remove(int index) {
		if (isExist(index)) {
			Object[] temp = new Object[length() - 1];
			int correctIndex = 0;
			for (int i = 0; i < length(); i++) {
				if (i == index) continue;
				else {
					temp[correctIndex] = database[i];
					correctIndex++;
				}
			}
			database = temp;
		} else System.out.println("잘못된 index에 접근중입니다. (접근하려는 index:" + index + " 최대 접근가능한 index:" + (database.length - 1)+ ")");
	}
	/**
	 * 현재 데이터들을 모두 \n 형식으로 연결한 문자열을 반환.
	 * @return 현재 데이터들을 모두 \n 형식으로 연결한 문자열.
	 */
	@Override
	public String toString() { 
		String temp = "";
		for (Object data : database) temp += (data.toString() + "\n");
		return temp;
	}
	/**
	 * 현 객체와 <span style="color:blue; font-weight: bold;">Object</span>의 타입과 가지고 있는 데이터가 모두 동일한지의 여부를 반환.
	 * @param object : {<span style="color:blue; font-weight: bold;">Object: </span><span style="color:purple; font-weight: bold;">super</span>}
	 * @return 현 객체와 <span style="color:blue; font-weight: bold;">Object</span>의 타입과 가지고 있는 데이터가 모두 동일한지의 여부.
	 */
	@Override
	public boolean equals(Object object) { return (object.getClass() == Database.class && object.toString().equals(toString())); }
	public Database(boolean checkEquals) { 
		this.checkEquals = checkEquals;
		database = new Object[0]; 
	}
	public Database(boolean checkEquals, Object ...object) {
		this(checkEquals);
		add(object);
	}
}
