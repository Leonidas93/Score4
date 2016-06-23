package score4;


public class Board {
    int array[][]=new int[6][7];
    int final_State=2;
    
    public Board()//arxikpoih to pinaka
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                array[i][j]=0;
                
            }
        }
       
    }
    
    public void print_array()//metatrepei ta 1 -1 se o x kai emfanizei to pinaka
    {
        for(int i=5;i>=0;i--)
            {System.out.println("");
                for(int j=0;j<7;j++)
                {
                    if(array[i][j]==1)
                    {
                        System.out.print("o");
                    }
                    else if(array[i][j]==-1)
                    {
                        System.out.print("x");
                    }
                    else 
                    {
                        System.out.print("-");
                    }
                    System.out.print(" ");
                }
            }
        System.out.println("");
    }
    
    public void play(int choice,int player)//kataxwrei thn epilogh tou paixth sto pinaka
    {
        setPosition(choice,player);
    }
    
    public boolean isfull(int i)
    {
        if(array[5][i]!=0)
        {
            return true;
        }
        else 
            return false;
    }
    
    private void setPosition(int pointer,int player)
    {
        for(int i=0;i<6;i++)
        {
            if(array[i][pointer]==0)
            {
                array[i][pointer]=player;
                result(i,pointer,player);
                break;
            }
        }
        
    }
    
    private void result(int x,int y,int player)
    {
        
        int right = 0,left=0,down=0,up=0,up_right=0,up_left=0,down_right=0,down_left=0;
        
        for(int i=y+1;i<7;i++)
        {
            if(player==array[x][i])
            { 
                right++;
            }
            else break;
        }
        
        for(int i=y-1;i>=0;i--)
        {
            if(player==array[x][i])
            {
                left++;
            }
            else break;
        }
        for(int i=x-1;i>=0;i--)
        {
            if(player==array[i][y])
            {
                down++;
            }
            else break;
        }
        
        
        
        up_right=checkURDiag(x,y,array,player);
        up_left=checkULDiag(x,y,array,player);
        down_right=checkDRDiag(x,y,array,player);
        down_left=checkDLDiag(x,y,array,player);
        
        
        checkpoints(right,left,player);
        checkpoints(down,0,player);
        checkpoints(up_right,down_left,player);
        checkpoints(down_right,up_left,player);
        
        
    }
   
    
    private int checkURDiag(int x,int y,int[][] array,int player)
    {
        int i;
        int j;
        int count=0;
        for(i=x+1,j=y+1;(i<6&&j<7);i++,j++)
        {
            if(player==array[i][j])
            {
                count++;
            }
            else break;
        }
        return count;
    }
    
    private int checkDRDiag(int x,int y,int[][] array,int player)
    {
        int i;
        int j;
        int count=0;
        for(i=x-1,j=y+1;(i>=0&&j<7);i--,j++)
        {
            if(array[i][j]==player)
            {
                count++;
            }
            else break;
        }
        return count;
    }

    private int checkULDiag(int x,int y,int[][] array,int player)
    {
        int i;
        int j;
        int count=0;
        for(i=x+1,j=y-1;(i<6&&j>=0);i++,j--)
        {
            if(player==array[i][j])
            {
                count++;
            }
            else break;
        }
        return count;
    }
    
    private int checkDLDiag(int x,int y,int[][] array,int player)
    {
        int i;
        int j;
        int count=0;
        for(i=x-1,j=y-1;(i>=0&&j>=0);i--,j--)
        {
            if(player==array[i][j])
            {
                count++;
            }
            else break;
        }
        return count;
    }
    
    public void checkpoints(int x,int y,int player)
    {
        
        if(x+y>=3)
        {
            final_State=player;
            if(player==-1){
                System.out.println("x-player wins!");
            }
            else 
                System.out.println("o-player wins!");
        }
    }
}
