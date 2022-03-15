import java.util.Scanner;

public class TicTacToeAI 
{
	static String board[][];
	static String players[];
	static int turn, moves, r, c;
	static int firstMoveR, firstMoveC;
	public static void initialize()
	{
		board=new String[3][3];
		empty();
		players=new String[2];
		players[0]="O";
		players[1]="X";
		turn=1;
		moves=0;
		
	}
	public static void empty()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				board[i][j]=" ";
			}
		}
	}
	public static boolean winner()
	{
		for(int i=0; i<3; i++)
		{
			if( board[i][0]!=" " && board[i][0]==board[i][1] && board[i][0]==board[i][2]) //vertical check
			{
				System.out.println("Winner " +players[turn]);
				return true;
			}
			if( board[0][i]!=" " && board[0][i]==board[1][i] && board[0][i]==board[2][i]) //horizontal check
			{
				System.out.println("Winner " +players[turn]);
				return true;
			}
		}
		if(board[1][1]!=" " && ((board[1][1]==board[0][0] && board[0][0]==board[2][2]) || (board[1][1]==board[0][2] && board[0][0]==board[2][0]))) //diagnols
		{
			System.out.println("Winner " +players[turn]);
			return true;
		}
		return false;
	}
	public static boolean tie()
	{
		if(moves>=9)
		{
			return true;
		}
		return false;
	}
	public static boolean gameover()
	{
		if((winner()||tie()))
		{
			return true;
		}
		return false;
	}
	public static void print()
	{
		for(int i=0; i<3; i++)
		{
			System.out.println("-------");
			System.out.print("|");
			for(int j=0; j<3; j++)
			{
				System.out.print(board[i][j]+ "|");
			}
			System.out.println();
		}
		System.out.println("-------");
	}
	
	public static void cpu()
	{
		int x=(int) (Math.random()*(3));
		if(moves==0)
		{
			
			if(x==1)
			{
				board[0][0]="X";
				return;
			}
			else if(x==2)
			{
				board[0][2]="X";
				return;
			}
			else if(x==3)
			{
				board[2][0]="X";
				return;
			}
			else
			{
				board[2][2]="X";
				return;
			}
		}
		else if(moves==1)
		{
			if(board[1][1]=="O")
			{
				if(x==1)
				{
					board[0][0]="X";
					return;
				}
				else if(x==2)
				{
					board[0][2]="X";
					return;
				}
				else if(x==3)
				{
					board[2][0]="X";
					return;
				}
				else
				{
					board[2][2]="X";
					return;
				}
			}
			else
			{
				board[1][1]="X";
				return;
			}
		}
		else if(moves==3)
		{
			if(board[1][2]=="O")
			{
				
			}
			if(board[2][1]=="O")
			{
				
			}
			if(board[0][1]=="O")
			{
				
			}
			if(board[1][0]=="O")
			{
				
			}
		}
		else
		{
			for(int i=0; i<3; i++)
			{
				if(board[i][i]!=" " && board[i][i]==board[(i+1)%3][(i+1)%3] && board[(i+2)%3][(i+2)%2]==" ") //down diagnoanol
				{
					board[(i+2)%3][(i+2)%2]="X";
					return;
				}
				if(board[i][(2-i)]!= " " && board[i][(2-i)]==board[(i+1)%3][(2-(i+1)%3)] &&board[i+2][2-(i+2)%3]== " ") //up diagongal
				{
					board[i+2][2-(i+2)%3]="X";
					return;
				}
				for(int j=0; j<3; j++)
				{
					if( board[i][j]!=" " && board[i][j]==board[i][(j+1)%3] && board[i][(j+2)%3]==" ") //vertical check
					{
						board[i][(j+2)%3]="X";
						return;
					}
					if( board[j][i]!=" " && board[j][i]==board[(j+1)%3][i] && board[(j+2)%3][i]==" ") //horizontal check
					{
						board[(j+1)%3][i]="X";
						return;
					}
					
				}

			}
		}
		
	}
	public static void main(String args[])
	{
		
		Scanner input=new Scanner(System.in);
		boolean repeat=true;
		while(repeat)
		{
			initialize();
			System.out.println("Who goes first, player 1 (being you) or player 2, being the cpu. Enter Response as 1 or 2");
			turn=input.nextInt();
			while(!gameover())
			{
				turn=(turn+1)%2;
				if(turn%2==0)
				{
					
					print();
					System.out.println("Player " + players[turn] + ", input a legal row and column for your move ");
					r=input.nextInt()-1;
					c=input.nextInt()-1;
					while(!(r< 3 && r>=0 && c<3 && c>=0 && board[r][c]==" "))
					{
						System.out.println("Player " + players[turn] + ", input a legal row and column for your move ");
						r=input.nextInt()-1;
						c=input.nextInt()-1;
					}
					board[r][c]=players[turn];
				}
				else
				{
					cpu();
				}
				moves++;
				
			}
			System.out.println("Play another game? 0 for no, 1 for yes");
			if(input.nextInt()!=1)
			{
				repeat=false;
			}
			
			
		}
		input.close();
	}
}
