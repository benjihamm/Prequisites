import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class BlobTester {
	public static void main (String [] args) throws IOException, NoSuchAlgorithmException {
//		File testFile = new File("tester.txt");
		Blob test = new Blob("tst");
//		System.out.println(test.method(testFile));
		System.out.println(System.getProperty("user.dir"));
	}
}

