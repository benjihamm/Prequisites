import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Index {
	PrintWriter pw;
	HashMap<String, String> files = new HashMap<String, String>();
	public Index() throws FileNotFoundException {
		File index = new File(System.getProperty("user.dir"), "index");
		pw = new PrintWriter(index);
		File theDir = new File(System.getProperty("user.dir"), "objects");
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
	}
	public void editIndex() {
		for(String s : files.keySet()) {
			pw.println(s + " : " + files.get(s));
			pw.close();
		}
	}
	public void add(String FileName) throws IOException {
		Blob blob = new Blob(FileName);
		files.put(FileName, blob.getSHA1());
		editIndex();
	}
	public void remove(String FileName) {
		File removee = new File(System.getProperty("user.dir") + "/objects", FileName);
		files.remove(FileName);
		editIndex();
	}
}
