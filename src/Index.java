import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Index {
	PrintWriter pw;
	HashMap<String, Blob> files = new HashMap<String, Blob>();
	File index;
	public Index() throws FileNotFoundException {
		
	}
	public void init() {
		File theindex = new File(System.getProperty("user.dir"), "index");
		index = theindex;
		File theDir = new File(System.getProperty("user.dir"), "objects");
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
	}
	public void editIndex() throws FileNotFoundException {
		pw = new PrintWriter(index);
		for(String s : files.keySet()) {
			pw.println(s + " : " + files.get(s).getSHA1());
		}
		pw.close();
	}
	public void add(String FileName) throws IOException {
		Blob blob = new Blob(FileName);
		files.put(FileName, blob);
		editIndex();
	}
	public void remove(String FileName) throws FileNotFoundException {
		File removee = files.get(FileName).getFile();
		files.remove(FileName);
		removee.delete();
		editIndex();
	}
}
