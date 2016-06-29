package score4;


public class KombosMax {
    int array[][]=new int[6][7];
    KombosMin children[]=new KombosMin[7];
    int player=1;
    int final_State=2;
    int points=0;
    
    public KombosMax(int[][] a,int x,int pointer)
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                array[i][j]=a[i][j];
            }
        }
        setPosition(x);
        if(final_State!=1)
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
        else if(final_State==1)
        {
            points=100000;
        }
    }
    
    public int find_best_move()//tsekarei na brei thn kaluterh lush antoistixa kai ston min
    {
        int i;
        int min=0;
        for(i=0;i<7;i++)
        {
            if(children[i]!=null)
            {
                min=children[i].points;
                break;
            }
        }
        for(int j=0;j<7;j++)
        {
            if(children[j]!=null)
            {
                if(children[j].points<min)
                {
                    min=children[j].points;
                }
            }
        }
        
        return min;
    }
    
    public void setChildren(int x)//dhmiourgei ta paidia. gia na dhmiourgh8ei to epomeno 8a prepei na exei dhmirghsei t proto kai ola ta paidia tou
    {
        if(x==0)
        {
            final_State=0;
            return;
        }
        //boolean firstchild=false;
        
        int counter=0;
        for(int i=0;i<7;i++)
        {
            if(!isfull(i))
            {   
            	children[i]=new KombosMin(array,i,x-1);
            }
            else counter++;
        }
        
        if(counter==7)
        {
            final_State=0;
        }
    }
    
    public boolean isfull(int i)//tsekarei an einai gemath h sthlh antistoixa kai ston min
    {
        if(array[5][i]!=0)
        {
            return true;
        }
        else return false;
    }
    
    private void setPosition(int pointer)//topo8etei thn epilogh sthn katallhlh 8esh
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
    
    private void result(int x,int y)//upologizei an exei ginei score4 kai wste na mhn dhmirroughsei autos o komvos alla paidia
    {//upologizei posa idia exei orizontia ka8eta kai diagwnia
        int right = 0,left=0,down=0,up=0,up_right=0,up_left=0,down_right=0,down_left=0;
        
        for(int i=y+1;i<7;i++)
        {
            if(player==array[x][i])
            { 
                right++;
            }
            else break;
        }
        
        for(int i=y-1;i>0;i--)
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
        checkpoints(down,up);
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
    
    public void checkpoints(int x,int y)//tsekarei an exei niikhsei o paixths
    {
        if(x+y>=3)
        {
            final_State=player;
        }
    }
    
}