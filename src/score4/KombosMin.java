package score4;


public class KombosMin {
    int array[][]=new int[6][7];
    KombosMax children[]=new KombosMax[7];
    int player=-1;
    int final_State=2;
    int points=0;
    
    public KombosMin(int[][] a,int x,int pointer)
    {   
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                array[i][j]=a[i][j];
            }
        }
        setPosition(x);
        if(final_State!=-1)
        {
            setChildren(pointer);
        }
        if(final_State==0)
        {
            Heuristic h=new Heuristic();
            h.evaluate(array);
            points=h.maxps-h.minps;
            
        }
        else if(final_State==2)
        {
            points=find_best_move();
        }
        else if(final_State==-1)
        {
            points=-100000;
        }
    }
    
    public int find_best_move()
    {
        int i;
        int max=0;
        for(i=0;i<7;i++)
        {
            if(children[i]!=null)
            {
                max=children[i].points;
                break;
            }
        }
        for(int j=0;j<7;j++)
        {
            if(children[j]!=null)
            {
                if(children[j].points>max)
                {
                    max=children[j].points;
                }
            }
        }
        
        return max;
    }
    
    public void setChildren(int x)
    {
        if(x==0)
        {
            final_State=0;
            return;
        }
        
        int counter=0;
        for(int i=0;i<7;i++)
        {
            if(!isfull(i))
            {
            	children[i]=new KombosMax(array,i,x-1);
            }    
            else counter++;
        }
        
        if(counter==7)
        {
            final_State=0;
        }
    }
    
    public boolean isfull(int i)
    {
        if(array[5][i]!=0)
        {
            return true;
        }
        else return false;
    }
    
    private void setPosition(int pointer)
    {
        for(int i=0;i<6;i++)
        {
            if(array[i][pointer]==0)
            {
                array[i][pointer]=player;
                result(i,pointer);
                break;
            }
        }
        
    }
    
    private void result(int x,int y)
    {
        int counter=0;
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
        
        
        
        up_right=checkURDiag(x,y,array);
        up_left=checkULDiag(x,y,array);
        down_right=checkDRDiag(x,y,array);
        down_left=checkDLDiag(x,y,array);
        
        
        checkpoints(right,left);
        checkpoints(down,0);
        checkpoints(up_right,down_left);
        checkpoints(down_right,up_left);
        
    }
   
    private int checkURDiag(int x,int y,int[][] array)
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
    
    private int checkDRDiag(int x,int y,int[][] array)
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

    private int checkULDiag(int x,int y,int[][] array)
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
    
    private int checkDLDiag(int x,int y,int[][] array)
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
    
    public void checkpoints(int x,int y)
    {
        if(x+y>=3)
        {
            final_State=-1;
            
        }
    }

}