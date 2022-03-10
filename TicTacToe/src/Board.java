public class Board 
{
	String board[][];
	public Board()
	{
		board=new String[3][3];
	}
	void empty()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				board[i][j]=" ";
			}
		}
	}
	void insertX(int r, int c)
	{
		board[r][c]="X";
	}
	void insertO(int r, int c)
	{
		board[r][c]="O";
	}
	String[][] getBoard()
	{
		return board;
	}
	
}