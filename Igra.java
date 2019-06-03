
public class Igra {
	int vrstice;
	int stolpci;
	Coin[][] board; //2D tabela kamor shranjejuemo stanje igre
	Player naPotezi; //v tej spremenljivki bomo hranili informacijo o tem kateri igralec je na vrsti
	int[] konec; //spremenljivka ki nam pove, �e je igre konec
	public Igra(int m, int n) {
		vrstice = m;
		stolpci = n;
		board = new Coin[vrstice][stolpci]; //naredimo 2D tabelo z ustreznim �tevilom vrstic in stolpcev
		naPotezi = Player.RED; //za�ne rde�i igralec
		konec = null;
		for (int i = 0; i<vrstice; i++) { //v tabeli so na za�etku samo prazna polja
			for (int j = 0; j < stolpci; j++) {
				board[i][j] = Coin.EMPTY;
			}
		}
	}
	public void spusti (int stStolpca) { //v stolpec spustimo 'kovan�ek'
		int i = 0;
		while (i < vrstice - 1 && board[i+1][stStolpca] == Coin.EMPTY) { //v danem stolpcu pogledamo kje je najni�je le�e�e prazno polje in tja poskusimo dati 'kovanec' ustreznega igralca,
			i ++;														 //�e je stolpec poln si zapomnimo najvi�je le�e�e polje v stolpcu
		}
		if (board[i][stStolpca] == Coin.EMPTY) { //�e je polje kamor ho�emo dati 'kovanec' prazno, dodamo kovanec ustreznega igralca, v nasprotnem primeru (�e je stolpec poln) ne naredimo ni�
			board[i][stStolpca] = (naPotezi == Player.RED)? Coin.RED:Coin.YELLOW; //dodamo 'kovanec' ustreznega igralca
			konec = checkWin(); //preverimo �e je igra kon�ana
			naPotezi = nasprotnik(); //zamenjamo igralca, ki je na potezi
		}
	}
	public Player nasprotnik()  {
		return (naPotezi == Player.RED)? Player.YELLOW:Player.RED; //zamenjamo igralca, ki je na potezi
	}
	
	public int[] checkWin() { //s to funkcijo preverimo, 
	    for (int r = 0; r < vrstice; r++) { // iteriramo vrstice od spodaj navzgor
	        for (int c = 0; c < stolpci; c++) { // iteriramo stolpce od leve proti desni
	            Coin player = board[r][c];
	            if (player == Coin.EMPTY)
	                continue; // �e imamo opravka s praznim poljem z njim ne izgubljamo �asa

	            if (c + 3 < stolpci &&
	                player == board[r][c+1] && // pogledamo desno
	                player == board[r][c+2] &&
	                player == board[r][c+3]) {
	            	return new int[] {r,c,r,c+3};
	                   }
	                
	            	
	            if (r + 3 < vrstice) {
	                if (player == board[r+1][c] && // pogledamo navzgor
	                    player == board[r+2][c] &&
	                    player == board[r+3][c]) {
		            	return new int[] {r,c,r+3,c};
		            			            }
	                if (c + 3 < stolpci &&
	                    player == board[r+1][c+1] && // pogledamo navzgor in desno
	                    player == board[r+2][c+2] &&
	                    player == board[r+3][c+3]){
		            	return new int[] {r,c,r+3,c+3};
		            			            }
	                if (c - 3 >= 0 &&
	                    player == board[r+1][c-1] && // pogledamo navzgor in levo
	                    player == board[r+2][c-2] &&
	                    player == board[r+3][c-3]) {
		            	return new int[] {r,c,r+3,c-3};
		           		            }
	            }
	        }
	    }
	    return null; // zmagovalca �e ni
	}
}
