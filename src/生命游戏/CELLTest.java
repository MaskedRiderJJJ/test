package 生命游戏;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CELLTest {
	
	private static CELL cell = new CELL();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitMatrix() {
		//测试初始化函数
		cell.initMatrix();
		for(int i=0;i<cell.length;i++)
		{
			for(int j=0;j<cell.length;j++)
			{
				assertEquals(0,cell.matrix[i][j]);
			}
		}
	}


	@Test
	public void testChange() {
		//测试某个细胞周围有3个细胞的情况
		cell.initMatrix();
		assertEquals(0,cell.matrix[20][20]);
		cell.matrix[19][19]=1;
		cell.matrix[19][20]=1;
		cell.matrix[19][21]=1;
		cell.change();
		assertEquals(1,cell.matrix[20][20]);
		
		//测试某个细胞周围有2个细胞的情况
		cell.initMatrix();
		assertEquals(0,cell.matrix[0][0]);
		cell.matrix[0][1]=1;
		cell.matrix[1][0]=1;
		cell.change();
		assertEquals(0,cell.matrix[0][0]);
		
		cell.initMatrix();
		cell.matrix[0][0]=1;
		assertEquals(1,cell.matrix[0][0]);
		cell.matrix[1][0]=1;
		cell.matrix[0][1]=1;
		cell.change();
		assertEquals(1,cell.matrix[0][0]);
		
		//测试某个细胞周围有1个细胞的情况
		cell.initMatrix();
		cell.matrix[0][0]=1;
		assertEquals(1,cell.matrix[0][0]);
		cell.matrix[1][0]=1;
		cell.change();
		assertEquals(0,cell.matrix[0][0]);
		
		//测试某个细胞周围有4个细胞的情况
		cell.initMatrix();
		cell.matrix[1][0]=1;
		cell.matrix[1][1]=1;
		cell.matrix[2][1]=1;
		cell.matrix[3][1]=1;
		cell.matrix[2][0]=1;
		cell.change();
		assertEquals(0,cell.matrix[2][0]);
	}

}
