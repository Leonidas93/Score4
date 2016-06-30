package score4;


public class Min //eisagwgikos kombos. einai h riza tou dentrou pou dhmiourghte
{
    KombosMin children[]=new KombosMin[7];
    int array[][]=new int[6][7];
    int position=-1;
    
    public Min(int[][] a,int pointer)
    {
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                array[i][j]=a[i][j];
            }
        }
        
        
        setChildren(pointer);
        
        
        find_best_move();
            
    }
    
    public void find_best_move()
    {
        int i;
        int min=0;
        for(i=0;i<7;i++)
        {
            if(children[i]!=null)
            {
                
                min=children[i].points;
                position=i;
                break;
            }
        }
        for(int j=i;j<7;j++)
        {
            if(children[j]!=null)
            {
                if(children[j].points<min)
                {
                    
                    min=children[j].points;
                    position=j;
                }
            }
        }
        
    }

    public void setChildren(int x)
    {
       
        for(int i=0;i<7;i++)
        {
            if(!isfull(i))
            {
                children[i]=new KombosMin(array,i,x-1);
            }
            
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
}


