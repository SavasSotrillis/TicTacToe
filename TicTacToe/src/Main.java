import java.util.Scanner;

public class Main 
{
	public static void main(String args[])
	{
		Board board=new Board();
		Players player=new Players();
		
		Scanner input=new Scanner(System.in);
		int r, c;
		while(!(board.winner() ||board.tie()))
		{
			player.changePlayers();
			board.printBoard();

			System.out.println("Players " + player.getPlayers() + ", Enter the row and columns to insert your move");
			r=input.nextInt()-1;
			c=input.nextInt()-1;
			
			while(!(r< 3 && r>=0 && c<3 && c>=0 && board.getBoard()[r][c]==" "))
			{
				System.out.println("Players " + player.getPlayers() + ", Enter the row and columns to insert your move");
				r=input.nextInt()-1;
				c=input.nextInt()-1;
			}

			if(player.getPlayers()=="X")
			{
				board.insertX(r, c);
			}
			else
			{
				board.insertO(r, c);
			}
			
		}
		input.close();
		
		
	}
}