import java.util.Scanner;
public class ninePuzzle {

	public static void main(String[] args) {
		int[][] puzzle = {{3, 8, 2}, {0, 6, 5}, {4, 1, 7}};
		Scanner move = new Scanner(System.in);
		
		do {
		displayPuzzle(puzzle);
		System.out.println("Next Move:");
		int puzzleinput = move.nextInt();
		if (puzzleinput < 0 || puzzleinput > 9)
		{
			System.out.println("Invalid entry");
		}
		else
		{
			puzzle = enterPuzzle(puzzle, puzzleinput);
		}	
		}
		while (puzzle[0][0] != 1 && puzzle[0][1] != 2 && puzzle[0][2] !=3 && puzzle[1][0] !=4 && puzzle[1][1] !=5 && puzzle[1][2] !=6 && puzzle[2][0] != 7 && puzzle[2][1] !=8 && puzzle[2][2] !=0);
		displayPuzzle(puzzle);
		move.close();
		System.out.println("You win!");
	}
	
	static void displayPuzzle(int[][] array)
	{
		for (int j = 0; j < 3; j++)
		{	
		for (int i = 0; i < 3; i++)
			{
				if (array[j][i] == 0)
				{
				System.out.print("  ");
				}
				else
				{
				System.out.print(array[j][i] + " ");
				}
				
			}
		System.out.println("");		
		}
	}


static int[][] enterPuzzle(int[][] array, int puzzleinput)
{	int swapi = 0;
	int swapj = 0;
	int tmpi = 0;
	int tmpj = 0;
	for (int j = 0; j < 3; j++)
	{	
	for (int i = 0; i < 3; i++)
		{
			if (array[j][i] == 0)
			{
				
				if (i > 0 )
				{
					if (array[j][i-1] == puzzleinput)
					{
						swapi = i-1;
						swapj = j;
						tmpi = i;
						tmpj = j;
						
					}
				}	
				if ( i < 2)	
					{
					if (array[j][i+1] == puzzleinput)
					{
						swapi = i+1;
						swapj = j;
						tmpi = i;
						tmpj = j;
						
					}
					
				}	
				if (j < 2)
				{
					if (array[j+1][i] == puzzleinput)
					{
						swapi = i;
						swapj = j + 1;
						tmpi = i;
						tmpj = j;
								
					}
				}	
				if (j > 0) 
				{
				if (array[j-1][i] == puzzleinput)
					{
					swapi = i;
					swapj = j - 1;
					tmpi = i;
					tmpj = j;
					}
				}
				
			
			}

		}
	
	}
	array[tmpi][tmpj] = puzzleinput;
	array[swapj][swapj] = 0;

return array;
}
}

