import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Platno extends JPanel implements MouseListener{
	  
	  private static final long serialVersionUID = 1L; //nastavimo ID, da pri shranjevanju nimamo problemov
	  
	  Igra igra;

	  public Platno(Igra igra) {
	    super();
	    this.igra = igra;
	    setFocusable(true);
	    setBackground(Okno.BACKGROUND_COLOR); //barva ozadja oz. okvirja, ki ostane ko narišemo kvadrat
	    setBorder(BorderFactory.createLineBorder(Color.BLACK)); //dodamo rob
	    setPreferredSize(new Dimension(600, 600)); //nastavimo preferirano velikost panela
	    addMouseListener(this);
	  }
	  
	  @Override
	  public Dimension getPreferredSize() { //s tem nastavimo preferirano velikost 'platna', ki se pojavi v okencu
		  return new Dimension(600, 600);
	  }
	  @Override
	  public void paint(Graphics g) {
	    super.paint(g);
	    
	    Graphics2D graphics = (Graphics2D)g;
	    
	    int width = getWidth();
	    int height = getHeight();
	    int velikostKrogca = Math.min((height-75)/(igra.vrstice * 12/10), (width-75)/(igra.stolpci *12/10));
	    //Velikost krogca nastavimo tako, da od velikosti panela odštejemo malo veè kot širino okvirja, nato preostali del delimo s številom stolpcev oz vrstic,
	    //ki ga pred deljenjem pomnožimo z 1.2, da nam ostane še prostor, ki bo med krogci
	    
	    graphics.setColor(Okno.GRID_COLOR);
	    graphics.fillRect(25, 25, width-50, height-50); //narišemo moder pravokotnik, ki je od robov odmaknjen za širino okvirja (okrog nastane okvir, ki je barve ozadja)
	    //s pomoèjo 2D tabele Board narišemo trenutno stanje igre
	    for (int i = 0; i < igra.vrstice; i++) {
	    	for (int j = 0; j < igra.stolpci; j++) {
	    		if (igra.board[i][j] == Coin.EMPTY) graphics.setColor(Color.WHITE); //kjer še ni 'kovanèkov' narišemo bele kroge 
	    		else if (igra.board[i][j] == Coin.RED) graphics.setColor(Color.RED); //kjer so 'kovanèki' rdeèega igralca, narišemo rdeèe kroge
	    		else graphics.setColor(Color.YELLOW); //èe polje ni prazno in na njem ni 'kovanèek' od rdeèega igralca tam narišemo rumeni krog
	    		graphics.fillOval((width - (igra.stolpci * velikostKrogca *117/100))/ 2 + j * velikostKrogca * 12/10, (height - (igra.vrstice * velikostKrogca *117/100))/ 2 + i * velikostKrogca *12/10, velikostKrogca , velikostKrogca);
	    		//kroge rišemo tako, da pogledamo dimenzijo panela in velikost krogca, nato prilagodimo položaj kjer narišemo prvi (zgornji levi) krog, ostale narišemo s pomoèjo zanke in velikosti krogcev (+ razmik med njimi)
	    	}
	    }
	    
	    if (igra.konec != null) { //èe je igra konèana, poraèunamo koordinate preko katerih bomo narisali èrno èrto, ki pokaže kateri 4 žetoni so zmagovalni
	    	int x1 = (width - (igra.stolpci * velikostKrogca * 117/100)) / 2 + igra.konec[1] * velikostKrogca * 12/10 + velikostKrogca/2;
	    	int x2 = (width - (igra.stolpci * velikostKrogca * 117/100)) / 2 + igra.konec[3] * velikostKrogca * 12/10 + velikostKrogca/2;
	    	int y1 = (height - (igra.vrstice * velikostKrogca * 117/100)) / 2 + igra.konec[0] * velikostKrogca * 12/10 + velikostKrogca/2;
	    	int y2 = (height - (igra.vrstice * velikostKrogca * 117/100)) / 2 + igra.konec[2] * velikostKrogca * 12/10 + velikostKrogca/2;
	    	graphics.setColor(Color.BLACK);
	    	graphics.setStroke(new BasicStroke(4.0f));
	    	graphics.drawLine(x1,y1,x2,y2);
	    }
	  }

	@Override
	public void mouseClicked(MouseEvent event) {
		if (igra.konec != null) return; //èe je igra konèana ignoriramo nadaljne klike miške
		int x = event.getX(); //pogledamo kje se je zgodil klik miške
		int width = getWidth();
	    int height = getHeight();
	    int velikostKrogca = Math.min((height-75)/(igra.vrstice * 12/10), (width-75)/(igra.stolpci *12/10));
		for (int j = 0; j < igra.stolpci +1; j++) { //z zanko gremo èez vsak stolpec in pogledamo èe se je klik zgodil v tistem stolpcu
			if (x <= (width - (igra.stolpci * velikostKrogca *117/100))/ 2 + j * velikostKrogca * 12/10 && x > (width - (igra.stolpci * velikostKrogca *117/100))/ 2) {
				int stolpec = j-1; //zaradi indeksiranja številki stolpca odštejemo ena
			    igra.spusti(stolpec); //v ustrezni stolpec spustimo 'kovanec'
			    repaint(); //narišemo novo stanje igre
				break;
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}