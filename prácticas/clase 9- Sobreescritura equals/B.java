public class B extends A{
	
	public B(){
		super(0);
		System.out.println("En constructor de B sin par�metros, x = " + getX());
	}
		
	public B(int x){
		super(x);
		System.out.println("En constructor de B con par�metros, x = " + getX());
	}
}