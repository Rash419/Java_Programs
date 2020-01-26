package learn;
import java.util.*;
public class Tic_Tac_Toe {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		 char board[][] = new char[4][4];
		 
		 board = intialize(board);
		 String Winner = null;
		 int count = 1;
		 show_board(board);
		 while(Winner == null && count <= 9)
		 {
			 System.out.println("Player1 enter : ");
			 int player1 = scan.nextInt();
			 Insert(board,player1,'X');
			 if(count == 9 && Winner == null)
				 break;
			 
			 if(count % 2 != 0)
				 if(check(board) == true)
				 {
					 Winner = "Player1";
					 break;
				 }
			 System.out.println("Player2 enter : ");
			 int player2 = scan.nextInt();
			 Insert(board,player2,'0');
			 if(count % 2 == 0)
				 if(check(board) == true)
				 {
					 Winner = "Player2";
					 break;
				 }
			 show_board(board);
			 System.out.println("\t #############");
			 count+=2;
		 }
		 if(Winner == null)
		 {
			 System.out.println("Game Over : It is draw");
		 }
		 else
		 {
			 System.out.println("Winner is " + Winner); 
		 }
		 System.out.println("\n\nFinal Result : ");
		 show_board(board);
		 
	}
	public static char[][] intialize(char board[][])
	{	
		char x='1';
		for(int i=1;i<=3;i++)
			for(int j=1;j<=3;j++)
			{
				board[i][j] = x;
				x++;
			}
		return board;
	}
	public static void show_board(char board[][])
	{
		for(int i=1;i<=3;i++)
		{
			System.out.println("\t -------------");
			System.out.println("\t" + " | " + board[i][1] + " | " + board[i][2] + " | " + board[i][3] + " | " );
		}
		System.out.println("\t -------------");
	}
	public static char[][] Insert(char board[][],int pos,char ch)
	{	
		Scanner scan = new Scanner(System.in);
		boolean in = true;
		while(in)
		{
			if(pos < 1 || pos > 9)
			{
				System.out.println("Enter correct number");
				System.out.println("Enter number again: ");
				pos = scan.nextInt();
			}
			else
			{
				int arr[] = posi(pos);
				if(board[arr[0]][arr[1]] == 'X' || board[arr[0]][arr[1]] == '0')
				{
					System.out.println("It is already filled enter a different number");
					System.out.println("Enter number again: ");
					pos = scan.nextInt();
				}
				else
				{
					board[arr[0]][arr[1]] = ch;
					in = false;
					return board;
				}
			}
		}
		return board;
	}
	public static int[] posi(int pos)
	{
		int arr[] = new int[2];
		switch(pos)
		{
		case 1: arr[0] = 1;
				arr[1] = 1;
				return arr;
		case 2:	arr[0] = 1;
				arr[1] = 2;
				return arr;	
		case 3: arr[0] = 1;
				arr[1] = 3;
				return arr;
		case 4:	arr[0] = 2;
				arr[1] = 1;
				return arr;
		case 5: arr[0] = 2;
				arr[1] = 2;
				return arr;
		case 6:	arr[0] = 2;
				arr[1] = 3;
				return arr;
		case 7:	arr[0] = 3;
				arr[1] = 1;
				return arr;
		case 8:	arr[0] = 3;
				arr[1] = 2;
				return arr;
		case 9:	arr[0] = 3;
				arr[1] = 3;
				return arr;
		}
		return arr;
	}
	public static boolean check(char board[][])
	{
		if(check_row(board) || check_column(board) || check_diag(board))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean check_row(char board[][])
	{
		for(int i=1;i<=3;i++)
		{
			
			if((board[i][1] == 'X' && board[i][2] == 'X' && board[i][3] == 'X') ||  (board[i][1] == '0' && board[i][2] == '0' && board[i][3] == '0') )
			{
				return true;
			}
		}
		return false;
	}
	public static boolean check_column(char board[][])
	{
		for(int i=1;i<=3;i++)
		{
			if((board[1][i] == 'X' && board[2][i] == 'X' && board[3][i] == 'X') ||  (board[1][i] == '0' && board[2][i] == '0' && board[3][i] == '0'))
			{
				return true;
			}
		}
		return false;
	}
	public static boolean check_diag(char board[][])
	{
			if((board[1][1] == 'X' && board[2][2] == 'X' && board[3][3] == 'X') ||  (board[1][1] == '0' && board[2][2] == '0' && board[3][3] == '0'))
			{
				return true;
			}
			else if((board[1][3] == 'X' && board[2][2] == 'X' && board[3][1] == 'X') ||  (board[1][3] == '0' && board[2][2] == '0' && board[3][1] == '0'))
			{
				return true;
			}
		return false;
	}
	
}
