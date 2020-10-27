package 生命游戏;

import java.util.Random;

public class CELL {
	public int length = 59;
	public int cellSize = 15;
	public int[][] matrix=new int[length][length];
	private int[] search = { 0,1,2,3,5,6,7,8 };
	
	//初始化
	public void initMatrix()
	{
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				matrix[i][j] = 0;
			}
		}
	}
	
	//放置细胞
	public void setCell()
	{
		int key;
		Random r = new Random(1);
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				key = r.nextInt(2);
				if (key==1)
				{
					matrix[i][j] = 1;
				}
			}
		}
	}
	
	//演变
	public void change()
	{
		int[][] tempMatrix = new int[length][length];
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				tempMatrix[i][j] = matrix[i][j];
			}
		}
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				int count = 0;
				for (int k = 0; k < 8; k++)
				{
					if ((i - 1 + search[k] / 3) >= 0 && (i - 1 + search[k] / 3) < length && (j - 1 + search[k] % 3) >= 0 && (j - 1 + search[k] % 3) < length)
					{
						count += tempMatrix[i - 1 + search[k] / 3][j - 1 + search[k] % 3] == 1 ? 1 : 0;
					}
				}
				if (tempMatrix[i][j] == 1)
				{
					if (count < 2 || count>3)
					{
						matrix[i][j] = 0;
					}
				}
				else
				{
					if (count == 3)
					{
						matrix[i][j] = 1;
					}
				}
			}
		}
	}
	
}
