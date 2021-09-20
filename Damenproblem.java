
public class Damenproblem {

	
	public char[][] Schachbrett = new char[8][8];
	public int x =0;
	public int y =0;
	public int Damenmenge;
		
	public Damenproblem() {
	    //x=0;
	    //y=0;
	    Damenmenge=0;
		//control(x,y);
	}
	
	public void control(int x,int y) {
	
		if(Spalte(x,y)== false && Zeile(x,y)== false && Diagonal(x,y)== false) {
			Damenmenge = Damenmenge + 1;
			if (Damenmenge < 8) {
				Schachbrett[x][y] = '$';
				y = y + 1;
				x = 0;
				control(x,y);				
			}
		}else {
			x = x + 1;
			if (x <= Schachbrett[0].length) {
				control(x,y);
			}else {
				clearall();
				x=0;
				y=0;
				control(x,y);
			}
		}
		anzeigen();
						
	}
	
	public boolean Spalte(int x,int y) {
		boolean Dame = false;
		
		for(int i=0;i<Schachbrett.length;i++) {
			if(Schachbrett[i][y] == '$' || Schachbrett[i][y] == 'N') {
				Dame = true;
			}
		}
				
		return Dame;
	}
	
	public boolean Zeile(int x,int y) {
		boolean Dame = false;
		
		for(int j=0;j<Schachbrett[0].length;j++) {
			if(Schachbrett[x][j]=='$' || Schachbrett[x][j]=='N'){
				Dame = true;
			}
		}
		
		return Dame;
	}
	
	public boolean Diagonal(int x,int y) {
		boolean Dame = false;
		
		
		return Dame;
	}
	
	public void clearall() {
		for(int i=0;i<Schachbrett[0].length;i++) {
			for(int j=0;j<Schachbrett.length;j++) {
				if(Schachbrett[i][j]=='$') {
					Schachbrett[i][j]  ='N';
				}
			}
		}
		Damenmenge = 0;
	}
	
	public void anzeigen() {
		for(int i=0;i<Schachbrett[0].length;i++) {
			for(int j=0;j<Schachbrett.length;j++) {
				if(Schachbrett[i][j]=='N'){
					Schachbrett[i][j] = ' ';
				}
				System.out.print(Schachbrett[i][j]);
				System.out.print(" ");				
			}
			System.out.println();			
		}
		
	}
	
}
