import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Okno extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L; //nastavimo ID, da pri shranjevanju nimamo problemov
	
	private StiriVVrsto Stiri_v_vrsto;
	
	protected static final Color BACKGROUND_COLOR = new Color(160, 160, 160); // barvi ozadij
	protected static final Color GRID_COLOR = new Color(0, 0, 180);
	 
	JMenuItem menuNew67;
	JMenuItem menuNew810;
	JMenuItem menuNew1620;
	
	Platno platno;
	
	public Okno(StiriVVrsto Stiri_v_vrsto) {
	    super();
	    
	    this.Stiri_v_vrsto = Stiri_v_vrsto;
	    
	    setTitle("Stiri_v_vrsto");
	    getRootPane().putClientProperty("apple.awt.brushMetalLook", true);
	    setLayout(new BorderLayout());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Igra igra = new Igra (6,7); //naredimo igro, ki po defaultu zaène z dimenzijami 6 × 7
	    platno = new Platno(igra);
	    add(platno, BorderLayout.CENTER);
		
	    JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu menu = new JMenu("Igra");
	    bar.add(menu);
	    //trije meniji, ki nam omogoèajo, da spreminjamo velikost polja
	    menuNew67 = new JMenuItem("6 × 7");
	    menuNew67.addActionListener(this);
	    menu.add(menuNew67);
	      
	    menuNew810 = new JMenuItem("8 × 10");
	    menuNew810.addActionListener(this);
	    menu.add(menuNew810);
	      
	    menuNew1620 = new JMenuItem("16 × 20");
	    menuNew1620.addActionListener(this);
	    menu.add(menuNew1620);
	}
	
	public StiriVVrsto getStiri_v_vrsto() {
		return Stiri_v_vrsto;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) { //kaj se mora zgoditi, èe se igralec odloèi, da bo spremenil velikost
		Object source = event.getSource();
		if (source == menuNew67) {
			platno.igra = new Igra(6,7);
			platno.repaint();
		}
		if (source == menuNew810) {
			platno.igra = new Igra(8,10);
			platno.repaint();
		}
		if (source == menuNew1620) {
			platno.igra = new Igra(16,20);
			platno.repaint();
		}
	}
}