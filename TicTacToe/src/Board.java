public class Board 
{
	String board[][];
	int moves;
	
	public Board()
	{
		board=new String[3][3];
		moves=0;
		empty();
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
		moves++;
	}
	
	void insertO(int r, int c)
	{
		board[r][c]="O";
		moves++;
	}
	
	String[][] getBoard()
	{
		return board;
	}
	
	
	boolean tie()
	{
		if(moves>=9)
		{
			System.out.println("Tie");
			return true;
		}
		return false;
	}
	
	boolean winner()
	{
		for(int i=0; i<3; i++)
		{
			if( board[i][0]!=" " && board[i][0]==board[i][1] && board[i][0]==board[i][2]) //vertical check
			{
				System.out.println("Winner");
				return true;
			}
			if( board[0][i]!=" " && board[0][i]==board[1][i] && board[0][i]==board[2][i]) //horizontal check
			{
				System.out.println("Winner");
				return true;
			}
		}
		if(board[1][1]!=" " && ((board[1][1]==board[0][0] && board[0][0]==board[2][2]) || (board[1][1]==board[0][2] && board[0][0]==board[2][0]))) //diagnols
		{
			System.out.println("Winner");
			return true;
		}
		return false;
	}
	
	void printBoard()
	{
		for(int i=0; i<3; i++)
		{
			System.out.println("------");
			System.out.print("|");
			for(int j=0; j<3; j++)
			{
				System.out.print(board[i][j]+ "|");
			}
			System.out.println();
		}
		System.out.println("------");
		
	}
}