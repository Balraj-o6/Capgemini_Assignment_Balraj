package practice;



interface lambda{
	public int calc(int a, int b);
}
public class Que1 {
	public static void main(String[] args) {
		lambda l=(x,y)->{
			return (int) Math.pow(x, y);
		};

        System.out.println(l.calc(2, 3));
		
	}

}
