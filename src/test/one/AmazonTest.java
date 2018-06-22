package test.one;
import java.util.ArrayList;
import java.util.List;

public class AmazonTest {

 
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
    
        Cell currentCells = build(states);
        
        Cell cell = currentCells;
        List<Integer> cells = new ArrayList<Integer>();
        
        for(int day = 0; day <=days; day++){
            for(int i = 0; i<states.length; i++){
                if(cell.left!=null && cell.right !=null){
                    
                
                if(cell.left.state==cell.right.state){
                    cells.add(0);
                }else{
                    cells.add(1);
                }
                
                if(cell.right!=null){
                    cell = cell.right;
                    System.out.println("cell is :"+cell.state);
                }
                }
                
            }
        }
        
        
        return cells;
        
    }
    
     Cell build(int[] states){

        Cell c0 = new Cell(states[0], null, null);
        Cell c1 = new Cell(states[1], c0, null);
        Cell c2 = new Cell(states[2], c1, null);
        Cell c3 = new Cell(states[3], c2, null);
        Cell c4 = new Cell(states[4], c3, null);
        Cell c5 = new Cell(states[5], c4, null);
        Cell c6 = new Cell(states[6], c5, null);
        Cell c7 = new Cell(states[7], c6, null);
        
        c0.right = c1;
        c1.right = c2;
        c2.right = c3;
        c3.right = c4;
        c4.right = c5;
        c5.right = c6;
        c6.right = c7;

        //Adding additional cells for end cells
        Cell c_1 = new Cell(0, null, c0);
        c0.left = c_1;
        
        Cell c_8 = new Cell(0, c7, null);
        c7.right = c_8;
        return c0;
    }
    
    class Cell {
        int state;
        Cell left;
        Cell right;
        
        Cell(int state, Cell left, Cell right){
            this.state = state;
            this.left = right;
            this.right = right;
        }
        
    }
  // METHOD SIGNATURE ENDS
    
    public static void main(String[] args) {
        AmazonTest test = new AmazonTest();
        System.out.println("cellCompete:  "+test.cellCompete(new int[] {1,0,0,0,0,1,0,0}, 1));
    }
    
    
}
