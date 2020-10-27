package ������Ϸ;

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
		//���Գ�ʼ������
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
		//����ĳ��ϸ����Χ��3��ϸ�������
		cell.initMatrix();
		assertEquals(0,cell.matrix[20][20]);
		cell.matrix[19][19]=1;
		cell.matrix[19][20]=1;
		cell.matrix[19][21]=1;
		cell.change();
		assertEquals(1,cell.matrix[20][20]);
		
		//����ĳ��ϸ����Χ��2��ϸ�������
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
		
		//����ĳ��ϸ����Χ��1��ϸ�������
		cell.initMatrix();
		cell.matrix[0][0]=1;
		assertEquals(1,cell.matrix[0][0]);
		cell.matrix[1][0]=1;
		cell.change();
		assertEquals(0,cell.matrix[0][0]);
		
		//����ĳ��ϸ����Χ��4��ϸ�������
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
