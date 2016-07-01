package score4;

import java.util.Scanner;


public class Score4 {

    public static void main(String[] args) {
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("**********");
        System.out.println("* Score4 *");
        System.out.println("**********");
        System.out.println();
        System.out.println("Human plays first!");
        
        Board board=new Board();
        boolean b=true;
        int depth=5;
        
        board.print_array();
        
        for(int i=0;i<21;i++)
        {
            b=true;
            while(b)
            {
                System.out.println("choose one number between 1-7");
                choice=sc.nextInt();
                   
                if((choice<=7)&&(choice>=1))
                {
                    if(!board.isfull(choice-1))
                    {
                        b=false;
                        board.play(choice-1,1);
                    }
                }
            }
                
            board.print_array();
                
            if(board.final_State==1)
            {
                break;//telos paixnidiou, kerdizei o human
            }
                
                
            Min min=new Min(board.array,depth);
            board.play(min.position,-1);
            board.print_array();
                
            if(board.final_State==-1)
            {
                break;//telos paixnidiou, kerdizei h cpu
            }
        }
    }
    
}
