package Test;

import Utils.DownLoadUtils;
import org.junit.Test;

import java.util.Date;

public class DownLoadTest {

	@Test
	public void testDownAndReadFile() {
        DownLoadUtils.downAndReadFile("http://39.106.194.129:8080/upfiles/block/blocks.xml");
	}
}
