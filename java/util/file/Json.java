package util.file;
import util.Database;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 동적으로 Json 파일을 다룰 수 있게 해 주는 Json 클래스.
 * @author 환류상
 *
 */
final public class Json extends _FilePrototype {
	private File file;
	private Database keys;
	private Database values;
	private void _parsing() {
		values = new Database(false);
		String parse[] = this.data.replaceAll("\\{", "")
				.replaceAll("\\}", "")
				.replaceAll(" ", "")
				.replaceAll("\n", "")
				.replaceAll("\t", "")
				.replaceAll("\"", "")
				.replaceAll("\\[","")
				.replaceAll("\\]", "")
				.split(":");
		if (parse.length != 1) {
			keys.add(parse[0]);
			for (int i = 1; i < parse.length; i++) {
				Database value = new Database(false);
				String reParse[] = parse[i].split(",");
				if (i == (parse.length - 1)) {
					for (int j = 0; j < reParse.length; j++) value.add(reParse[j]);
				} else {
					keys.add(reParse[reParse.length - 1]);
					for (int j = 0; j < reParse.length - 1; j++) value.add(reParse[j]);
				}
				values.add(value);
			}
		}
	}
	/**
	 * 현 Json 파일의 <span style="font-weight: bold;">key</span>값에 <span style="font-weight: bold;">values</span>의 요소들을 추가.
	 * @param key : <span style="color:blue; font-weight: bold;">String</span>
	 * @param type : <span style="color:blue; font-weight: bold;">Class</span><span style="color:purple; font-weight: bold;">&lt;T&gt;</span>
	 * @param values : ...<span style="color:purple; font-weight: bold;">T</span>
	 */
	public<T> void add(String key, Class<T> type, T ...values) {
		for (T value : values) {
			int index = keys.getIndex(key);
			try (FileWriter writer = new FileWriter(file); ) {
				if (index == -1) {
					if (keys.length() == 0) {
						if (value.getClass() == String.class) this.data = this.data.replaceAll("}", "\t\"" + key + "\": \"" + value + "\"\n}");
						else this.data = this.data.replaceAll("}", "\t\"" + key + "\": " + value + "\n}");
					} else {
						if (value.getClass() == String.class) this.data = this.data.replaceAll("\n}", ",\n\t\"" + key + "\": \"" + value + "\"\n}");
						else this.data = this.data.replaceAll("\n}", ",\n\t\"" + key + "\": " + value + "\n}");
					}
				} else {
					String parse = "[ ";
					if (value.getClass() == String.class) {
						for (int i = 0; this.values.get(index, Database.class).isExist(i); i++) parse += "\"" + this.values.get(index, Database.class).get(i, String.class) + "\", ";
						parse += "\"" + value + "\"";
						parse += " ]";
					} else {
						for (int i = 0; this.values.get(index, Database.class).isExist(i); i++) parse += this.values.get(index, Database.class).get(i, String.class) + ", ";
						parse += value;
						parse += " ]";
					}
					if (this.values.get(index, Database.class).length() == 1) {
						if (value.getClass() == String.class) this.data = this.data.replaceAll("\t\"" + key + "\": \"(.*)\"", "\t\"" + key + "\": " + parse);
						else this.data = this.data.replaceAll("\t\"" + key + "\": (.*)", "\t\"" + key + "\": " + parse);
					}
					else this.data = this.data.replaceAll("\t\"" + key + "\": \\[(.*)\\]", "\t\"" + key + "\": " + parse);
				}
				writer.write(this.data);
				writer.flush();
			} catch (IOException e) { e.printStackTrace(); }
			_parsing();
		}
	}
	/**
	 * 현 Json 파일의 <span style="font-weight: bold;">key</span>값을 <span style="font-weight: bold;">values</span>의 요소들로 대체.
	 * @param key : <span style="color:blue; font-weight: bold;">String</span>
	 * @param type : <span style="color:blue; font-weight: bold;">Class</span><span style="color:purple; font-weight: bold;">&lt;T&gt;</span>
	 * @param values : ...<span style="color:purple; font-weight: bold;">T</span>
	 */
	public<T> void replace(String key, Class<T> type, T ...values) {
		delete(key);
		add(key, type, values);
	}
	/**
	 * 현 Json 파일의 <span style="font-weight: bold;">key</span>를 삭제.
	 * @param key : <span style="color:blue; font-weight: bold;">String</span>
	 */
	public void delete(String key) {
		int index = keys.getIndex(key);
		if (index != keys.length() - 1) this.data = this.data.replaceAll("\n\t\"" + key + "\": (.*)", "");
		else this.data = this.data.replaceAll(",\n\t\"" + key + "\": (.*)", "");
		keys.remove(index);
		try (FileWriter writer = new FileWriter(file); ) {
			if (keys.length() == 0 && index != -1) this.data = "{\n}";
			writer.write(this.data);
			writer.flush();
		} catch (IOException e) { e.printStackTrace(); }
	}
	/**
	 * 현 Json의 keys를 모두 출력.
	 * @return 현 Json의 keys.
	 */
	public Database keys() { return keys; }
	/**
	 * 현 Json의 values를 모두 출력.
	 * @return 현 Json의 values.
	 */
	public Database values() { return values; }
	public Json(String filename) { this(null, filename); }
	public Json(String filepath, String filename) {
		file = new File(filepath, filename + ".json");
		this.filepath = filepath;
		this.data = "";
		keys = new Database(true);
		if (!file.exists()) try (FileWriter writer = new FileWriter(file);) { 
			file.createNewFile();
			writer.write("{\n}");
			writer.flush();
		} catch (IOException e) { e.printStackTrace(); }
		int temp;
		try (FileReader reader = new FileReader(file);) {
			do {
				temp = reader.read();
				if (temp != -1) this.data += (char)temp;
			} while (temp != -1);
		} catch (IOException e) { e.printStackTrace(); }
		_parsing();
	}
}