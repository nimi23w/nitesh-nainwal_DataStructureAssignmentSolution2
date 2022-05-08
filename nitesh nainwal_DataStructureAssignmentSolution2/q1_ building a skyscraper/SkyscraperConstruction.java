import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;


public class SkyscraperConstruction {

	public Integer totalNumOfFloors;
	public Integer[] currentFloor;
	
	public void getUserInput() {
		System.out.println("enter the total no of floors in the building");
		Scanner sc = new Scanner(System.in);
		totalNumOfFloors = sc.nextInt();
		currentFloor = new Integer[totalNumOfFloors];
		
		for(int x=0;x<totalNumOfFloors;x++) {
			System.out.println("enter the floor size given on day :" + (x+1));
			currentFloor[x] = sc.nextInt();
		}
		
		Construct(currentFloor);
	}
	
	public void Construct(Integer currentFloor[]) {
		System.out.println("The order of construction is as follows");
		
		int a=0;
		
		//Store all the floor sizes in descending order
		Integer[] DescendingFloorSize = new Integer[currentFloor.length];
		for(int i=0;i<currentFloor.length;i++)
			DescendingFloorSize[i] = currentFloor[i];
		Arrays.sort(DescendingFloorSize,Collections.reverseOrder());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<currentFloor.length;i++) 
		{
			if(currentFloor[i] == DescendingFloorSize[a])
			{
				if( i == currentFloor.length-1) //reached at the end
					a = i;
				else
					a = i+1;
				
				//Pop the stack till its empty
				System.out.println("Day: " + (i+1));
				if(stack != null)
				{
					System.out.print(currentFloor[i]+" ");
					while(!stack.empty())
					{
						int result = stack.pop();
						if( result >= DescendingFloorSize[a])
						{
							System.out.print(result+" ");
						}							
						else 
						{
							stack.push(result);
							a -= stack.size();
							break;
						}
					}
					System.out.println(" ");
				}
				else
				{
					System.out.println(currentFloor[i]);
				}
			}
			else
			{
					System.out.println("Day: " + (i+1));
					stack.push(currentFloor[i]);
			}			
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkyscraperConstruction obj = new SkyscraperConstruction();
		obj.getUserInput();
			
	}

}

