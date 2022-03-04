import java.util.*;

class Game
{	
	public static void main(String[] abc) 
	{
		String choice;
		//char choice;
		int life,as,b,i,l,m,n,j,k,middle,ball,x,y,c,d;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Array size:");
		as=scanner.nextInt();
		char a[][]=new char[as][as];
		middle=as/2;
		for(i=0;i<as;i++)
		{
			for(j=0;j<as;j++)
			{
				if(i==0 || j==0 || j==as-1)
				{
					a[i][j]='W';
				}
			}
			if(i==as-1)
			{
				for(k=0;k<as;k++)
				{
					if(k!=0 && k!=as-1 && k!=middle)
					{
						a[i][k]='G';
					}
				}
			}
		}
		x=as-1;
		y=as/2;
		c=x;
		d=y;
		a[x][y]='O';
		System.out.println("Number of bricks:");
		b=scanner.nextInt();

		for(i=1;i<=b;i++)
		{
			System.out.println("Enter brick "+i+" position");					

			l=scanner.nextInt();
			m=scanner.nextInt();
			a[l][m]='1';
		}
		System.out.println("Number of balls:");
		ball=scanner.nextInt();
		life=ball;
		ball++;
		for(i=0;i<as;i++)
		{
			for(j=0;j<as;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		while(ball>0 & life>0)
		{
			System.out.println("Enter S for STRAIGHT ");
			System.out.println("Enter L for LEFT ");
			System.out.println("Enter R for RIGHT ");
			choice=scanner.nextLine();
			
			//STRAIGHT
			if(choice.equals("S"))
			{
				c=x;
				d=y;
				while(a[x][y]!='1' )
				{
					x=x-1;
					if(a[x][y]=='W')
					{
						life--;
						x=c;
						y=d;
						break;
					}
				}
				if(a[x][y]=='1')
				{
					a[x][y]='\0';
					ball--;
					x=c;
					y=d;
				}
				else
				{
					if(a[x][y]=='W')
					{
						life--;
						x=c;
						y=d;
					}
				}
				for(i=0;i<as;i++)
				{
					for(j=0;j<as;j++)
					{
						System.out.print(a[i][j]);
					}
					System.out.println();
				}
			}
			
			//LEFT
			if(choice.equals("L"))
			{
				c=x;
				d=y;
				while(a[x][y]!='W')
				{
					if(a[x][y]=='1')
					{
						a[x][y]='\0';
						//count++;
						ball--;
					}
					x--;
					y--;
				}
				if(a[x][y]=='W')
				{
					life--;
				}
				while(a[x][y]!='1')
				{
					y++;
					if(a[x][y]=='W')
					{
						a[c][d]='G';
						//x=as-1;
						//y=as/2;
						x=c;
						y=d;
						a[x][y]='O';
						life--;
						break;
					}
				}	
				if(a[x][y]=='1')
				{	
					a[x][y]='\0';
					ball--;
					while(x!=as-1)
					{
						if(a[x][y]=='1')
						{
							a[x][y]='\0';
							ball--;
						}
						x++;
					}
					if(x==as-1)
					{
						a[c][d]='G';
						a[x][y]='O';
						//x=c;
						//y=d;
					}
				}	
				for(i=0;i<as;i++)
				{
					for(j=0;j<as;j++)
					{
						System.out.print(a[i][j]);
					}
					System.out.println();
				}	
			}
			
			//RIGHT
			if(choice.equals("R"))
			{
				c=x;
				d=y;
				while(a[x][y]!='W')
				{
					if(a[x][y]=='1')
					{
						a[x][y]='\0';
						ball--;
					}
					x--;
					y++;
				}
				if(a[x][y]=='W')
				{
					life--;
					while(a[x][y]!='1')
					{
						y--;
						if(a[x][y]=='W')
						{
							a[c][d]='G';
							//x=as-1;
							//y=as/2;
							x=c;
							y=d;
							a[x][y]='O';
							life--;
							break;
						}
					}
					if(a[x][y]=='1')
					{
						a[x][y]='\0';
						ball--;
					}
					while(x!=as-1)
					{
						x++;
						if(a[x][y]=='1')
						{
							a[x][y]='\0';
							ball--;
						}
					}
					if(x==as-1)
					{
						a[c][d]='G';
						a[x][y]='O';
						//x=c;
						//y=d;
					}
				}
				for(i=0;i<as;i++)
				{
					for(j=0;j<as;j++)
					{
						System.out.print(a[i][j]);
					}
					System.out.println();
				}	
			}
		}
		System.out.println();
		
		System.out.println();
		if(ball==0)
		{
			System.out.println("   Congrats You Won the Game!!!!!");
		}
		else
		{
			System.out.println("   LIFE      REMAINING BRICKS");
			System.out.println("     "+life+"              "+ball);
			System.out.println("   Sorry you loose the Game");
		}
	}
}