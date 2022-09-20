import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class commitTester {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// TODO Auto-generated method stub
		Commit test1 = new Commit(null, null, "objects/9d973c6780cdc990b1bb7f60bbd108a72a7f8570", "Asher", "first commit");
		Commit test2 = new Commit("objects/9d973c6780cdc990b1bb7f60bbd108a72a7f8570", null, "objects/ffed3881547b10233038aa5f925c5177e89f7e72", "AsherB", "second commit");
		test1.writeFile();
		test2.writeFile();
	}

}
