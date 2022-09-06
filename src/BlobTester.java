import java.io.File;
import java.io.IOException;

public class BlobTester {
	public static void main (String [] args) throws IOException {
//		File testFile = new File("tester.txt");
		Blob test = new Blob("/test.txt");
//		System.out.println(test.method(testFile));
		System.out.println(System.getProperty("user.dir"));
	}
}

