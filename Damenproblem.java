/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damenproblem;


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
                        Schachbrett[x][y] = '$';
			if (Damenmenge < 8) {				
				y = y + 1;
				x = 0;
				control(x,y);				
			}else{
                          anzeigen();   
                        }
		}else {
			x = x + 1;
			if (x < Schachbrett[0].length) {
				control(x,y);
			}else {
				clearall();
				x=0;
				y=0;
				control(x,y);
			}
		}								
	}
	
	public boolean Spalte(int x,int y) {
		boolean Dame = false;
		
                 if (alteposition(x,y)){
                    return true;
                }
                
		for(int i=0;i<Schachbrett.length;i++) {
			if(Schachbrett[i][y] == '$') {
				Dame = true;
			}
		}
				
		return Dame;
	}
	
	public boolean Zeile(int x,int y) {
		boolean Dame = false;
		
                if (alteposition(x,y)){
                    return true;
                }
                
                for(int j=0;j<Schachbrett[0].length;j++) {
			if(Schachbrett[x][j]=='$'){
				Dame = true;
			}
		}
		
		return Dame;
	}
	
	public boolean Diagonal(int x,int y) {
		boolean Dame = false;
		int tempx = x;
                int tempy = y;
                
                if (alteposition(x,y)){
                    return true;
                }
                
                
                
                //                      ^
                //-                     '
                // -                    '
                //  -                   '
                //   -                  '
                while(tempx >= 0 && tempy >= 0){
                    
                    if(Schachbrett[tempx][tempy] == '$' ){
                        Dame = true;
                    }
                    tempx = tempx - 1;
                    tempy = tempy - 1;
                    
                }
                
                //                     '
                //-                    '
                // -                   '
                //  -                  '
                //   -                `´
                tempx = x;
                tempy = y;
                while(tempx < Schachbrett.length && tempy < Schachbrett.length){
                    
                    if (Schachbrett[tempx][tempy] == '$' ){
                        Dame = true;
                    }
                    tempx = tempx + 1;
                    tempy = tempy + 1;
                                
                }
                
                
                //                     ^
                //      -              '
                //    -                '
                //  -                  '
                //-                    '                
                
                tempx = x;
                tempy = y;
                while(tempx >= 0 && tempy < Schachbrett.length){
                    
                    if (Schachbrett[tempx][tempy] == '$'){
                        Dame = true;
                    }
                    tempx = tempx - 1 ;
                    tempy = tempy + 1;
                }
                
                //                     '
                //      -              '
                //    -                '
                //  -                  '
                //-                    `´
                
                tempx = x;
                tempy = y;
                while(tempy >= 0 && tempx < Schachbrett.length){
                    
                    if (Schachbrett[tempx][tempy] == '$'){
                        Dame = true;
                    }
                    tempx = tempx + 1;
                    tempy = tempy - 1;
                }
                                
                return Dame;
	}
	
	public void clearall() {
		for(int i=0;i<Schachbrett.length;i++) {
			for(int j=0;j<Schachbrett[0].length;j++) {
				if(Schachbrett[i][j]=='$') {
					Schachbrett[i][j]  ='N';
				}
			}
		}
		Damenmenge = 0;
	}
        
        public boolean alteposition(int x,int y){
        
            if(Schachbrett[x][y] == 'N'){
                return true;
            }
            return false;
        }
        
        
	
	public void anzeigen() {
		for(int i=0;i<Schachbrett.length;i++) {
			for(int j=0;j<Schachbrett[0].length;j++) {
				if(Schachbrett[i][j] != '$'){
					Schachbrett[i][j] = '-';
				}
                                
                                System.out.print(Schachbrett[i][j]);
                                System.out.print(" | ");
			}
			System.out.println();			
		}
		
	}
	
}

