import java.io.FileNotFoundException;
import java.io.IOException;

public class IndexTester {
	public static void main (String [] args) throws IOException {
		Index test = new Index();
		System.out.println(System.getProperty("user.dir"));
		test.init();
		test.add("tst");
		test.add("tsts");
		test.remove("tst");
	}
}
