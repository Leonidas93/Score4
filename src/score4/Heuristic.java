package score4;


public class Heuristic {
    int maxps=0;
    int minps=0;
    
    public void evaluate(int[][] a)//elegxei tis grammes , tis sthles kai tis diagwnies
    {
        lines(a);
        columns(a);
        diag(a);
    }
    
    public void diag(int[][] a)
    {
        int[] diag1={a[0][3],a[1][2],a[2][1],a[3][0]};
        int[] diag2={a[0][4],a[1][3],a[2][2],a[3][1],a[4][0]};
        int[] diag3={a[0][5],a[1][4],a[2][3],a[3][2],a[4][1],a[5][0]};
        int[] diag4={a[0][6],a[1][5],a[2][4],a[3][3],a[4][2],a[5][1]};
        int[] diag5={a[1][6],a[2][5],a[3][4],a[4][3],a[5][2]};
        int[] diag6={a[2][6],a[3][5],a[4][4],a[5][3]};
        
        int[] diag7={a[2][0],a[3][1],a[4][2],a[5][3]};
        int[] diag8={a[1][0],a[2][1],a[3][2],a[4][3],a[5][4]};
        int[] diag9={a[0][0],a[1][1],a[2][2],a[3][3],a[4][4],a[5][5]};
        int[] diag10={a[0][1],a[1][2],a[2][3],a[3][4],a[4][5],a[5][6]};
        int[] diag11={a[0][2],a[1][3],a[2][4],a[3][5],a[4][6]};
        int[] diag12={a[0][3],a[1][4],a[2][5],a[3][6]};
        
        
        check_diag(diag1);
        check_diag(diag2);
        check_diag(diag3);
        check_diag(diag4);
        check_diag(diag5);
        check_diag(diag6);
        check_diag(diag7);
        check_diag(diag8);
        check_diag(diag9);
        check_diag(diag10);
        check_diag(diag11);
        check_diag(diag12);
        
    }
    
    public void check_diag(int[] a)
    {
        int sum1=0;  //max 
        int sum=0;
        
        for(int j=0;j<a.length-3;j++)
            {
                sum1=0;
                sum=0;
                for(int k=j;k<j+4;k++)
                {
                    if(a[k]==1)
                    {
                        sum1++;
                    }
                    else if(a[k]==-1)
                    {
                        sum++;
                    }
                    
                }
                check_result(sum1,sum);
            }
    }
    
    public void columns(int[][] a)
    {
        int sum1=0;  //max 
        int sum=0;
        
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<3;j++)
            {
                sum1=0;
                sum=0;
                for(int k=j;k<j+4;k++)
                {
                    if(a[k][i]==1)
                    {
                        sum1++;
                    }
                    else if(a[k][i]==-1)
                    {
                        sum++;
                    }
                    
                }
                check_result(sum1,sum);
            }
        }
    }
    
    public void lines(int[][] a)
    {
        int sum1=0;  //max 
        int sum=0;   //min
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<4;j++)
            {
                sum1=0;
                sum=0;
                for(int k=j;k<j+4;k++)
                {
                    if(a[i][k]==1)
                    {
                        sum1++;
                    }
                    else if(a[i][k]==-1)
                    {
                        sum++;
                    }
                    
                }
                check_result(sum1,sum);
            }
        }
    }
    
    public void check_result(int sum1,int sum)
    {
        if(sum1==0)
        {
            if(sum==1)
            {
                minps+=100;
            }
            else if(sum==2)
            {
                minps+=1000;
            }
            else if(sum==3)
            {
                minps+=15000;
            }
        }
        else if(sum==0)
        {
            if(sum1==1)
            {
                maxps+=100;
            }
            else if(sum1==2)
            {
                maxps+=1000;
            }
            else if(sum1==3)
            {
                maxps+=15000;
            }
        }
    }

}

