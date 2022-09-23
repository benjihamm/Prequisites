package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Commit;

class realCommitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws FileNotFoundException {
		Commit test1 = new Commit(null, null, "objects/9d973c6780cdc990b1bb7f60bbd108a72a7f8570", "Asher", "first commit");
		Commit test2 = new Commit("objects/9d973c6780cdc990b1bb7f60bbd108a72a7f8570", null, "objects/ffed3881547b10233038aa5f925c5177e89f7e72", "AsherB", "second commit");
		test1.writeFile();
		test1.getDate();
		test2.writeFile();
	}

}
