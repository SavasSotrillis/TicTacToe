public class Players 
{
	String players[];
	int index=0;
	public Players()
	{
		players=new String[2];
		players[0]="O";
		players[1]="X";
		index=1;
	}
	void changePlayers()
	{
		index=(index+1)%2;
	}
	String getPlayers()
	{
		return players[index];
	}
	
}