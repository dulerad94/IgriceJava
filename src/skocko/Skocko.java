package skocko;
import gui.GUIKontoler;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
* Predstavlja celu igricu skocko
* 
* @author Aleksandar Randjelovic
* @version 1.0
*/
public class Skocko extends JFrame {
	/**
	 * Panel na kome se sve nalazi
	 */
	private JPanel contentPane;
	/**
	 * Dugme koje se pritiska za unosenje znaka skocka
	 */
	private JButton btnSkocko;
	/**
	 * Dugme koje se pritiska za unosenje znaka zvezde
	 */
	private JButton btnZvezda;
	/**
	 * Dugme koje se pritiska za unosenje znka pika
	 */
	private JButton btnPik;
	/**
	 * Dugme koje se pritiska za unosenje znaka srca
	 */
	private JButton btnSrce;
	/**
	 * Dugme koje se pritiska za unosenje znaka trefa
	 */
	private JButton btnTref;
	/**
	 * Dugme koje se pritiska za unosenje znaka karo
	 */
	private JButton btnKaro;
	/**
	 * Polja prvog reda
	 */
	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	/**
	 * Polja drugog reda
	 */
	private JLabel b1;
	private JLabel b2;
	private JLabel b3;
	private JLabel b4;
	/**
	 * Polja treceg reda
	 */
	private JLabel c1;
	private JLabel c2;
	private JLabel c3;
	private JLabel c4;
	/**
	 * Polja cetvrtog reda
	 */
	private JLabel d1;
	private JLabel d2;
	private JLabel d3;
	private JLabel d4;
	/**
	 * Polja petog reda
	 */
	private JLabel e1;
	private JLabel e2;
	private JLabel e3;
	private JLabel e4;
	/**
	 * Polja sestog reda
	 */
	private JLabel f1;
	private JLabel f2;
	private JLabel f3;
	private JLabel f4;
	
	/**
	 * Borojac koliko je puta korisnik puta kliknuo da unese neki znak
	 */
	private int brojacKlikova = 1;
	
	/**
	 * Polja prvog reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel aa;
	private JLabel ab;
	private JLabel ac;
	private JLabel ad;
	/**
	 * Polja drugog reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel ba;
	private JLabel bb;
	private JLabel bc;
	private JLabel bd;
	/**
	 * Polja treceg reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel ca;
	private JLabel cb;
	private JLabel cc;
	private JLabel cd;
	/**
	 * Polja cetvrtog reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel da;
	private JLabel db;
	private JLabel dc;
	private JLabel dd;
	/**
	 * Polja petog reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel ea;
	private JLabel eb;
	private JLabel ec;
	private JLabel ed;
	/**
	 * Polja sestog reda koja pokazuju koliko je znakova na pravom, a koliko na pogresnom mestu.
	 */
	private JLabel fa;
	private JLabel fb;
	private JLabel fc;
	private JLabel fd;
	/**
	 * Vizuelni prikazivac vremena koje je ostalo do kraja
	 */
	private JProgressBar progressBar;
	/**
	 * Natpis vreme
	 */
	private JLabel lblVreme;
	/**
	 * Dugme za pokretanje igrice
	 */
	private JButton btnStart;
	/**
	 * Tekstualni prikazivac vremena koje je ostalo do kraja
	 */
	private JTextField textField;
	/**
	 * Polja u koja se unosi random kombinacija i sa kojima se vrsi poredjenje kada korisnik pogadja kombinaciju
	 */
	private JLabel r1;
	private JLabel r2;
	private JLabel r3;
	private JLabel r4;
	/**
	 * Pomocne vrednosti koje sluze za ogranicenje da korisnik ne moze da klikne u bilo kom trenutku na bilo koje polje
	 * i tako krene da unosi znakove od tog mesta gde je kliknuo
	 */
	boolean a1enabled = false;
	boolean a2enabled = false;
	boolean a3enabled = false;
	boolean b1enabled = false;
	boolean b2enabled = false;
	boolean b3enabled = false;
	boolean c1enabled = false;
	boolean c2enabled = false;
	boolean c3enabled = false;
	boolean d1enabled = false;
	boolean d2enabled = false;
	boolean d3enabled = false;
	boolean e1enabled = false;
	boolean e2enabled = false;
	boolean e3enabled = false;
	boolean f1enabled = false;
	boolean f2enabled = false;
	boolean f3enabled = false;
	/**
	 * Natpis resenje
	 */
	private JLabel lblReenje;
//	/**
//	 * Pomocna promenjliva koja signalizira da ne postoji fajl u koji se unosi rezultat
//	 */
//	boolean prviPut = false;
//	

	/**
	 * Kreira se prozor.
	 */
	public Skocko() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Skocko.class.getResource("/skocko/slike/skockoicon.png")));
		setTitle("Sko\u010Dko");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSkocko());
		contentPane.add(getBtnZvezda());
		contentPane.add(getBtnPik());
		contentPane.add(getBtnSrce());
		contentPane.add(getBtnTref());
		contentPane.add(getBtnKaro());
		contentPane.add(getA1());
		contentPane.add(getA2());
		contentPane.add(getA3());
		contentPane.add(getA4());
		contentPane.add(getB1());
		contentPane.add(getB2());
		contentPane.add(getB3());
		contentPane.add(getB4());
		contentPane.add(getC1());
		contentPane.add(getC2());
		contentPane.add(getC3());
		contentPane.add(getC4());
		contentPane.add(getD1());
		contentPane.add(getD2());
		contentPane.add(getD3());
		contentPane.add(getD4());
		contentPane.add(getE1());
		contentPane.add(getE2());
		contentPane.add(getE3());
		contentPane.add(getE4());
		contentPane.add(getF1());
		contentPane.add(getF2());
		contentPane.add(getF3());
		contentPane.add(getF4());	
		contentPane.add(getAa());
		contentPane.add(getAb());
		contentPane.add(getAc());
		contentPane.add(getAd());
		contentPane.add(getBa());
		contentPane.add(getBb());
		contentPane.add(getBc());
		contentPane.add(getBd());
		contentPane.add(getCa());
		contentPane.add(getCb());
		contentPane.add(getCc());
		contentPane.add(getCd());
		contentPane.add(getDa());
		contentPane.add(getDb());
		contentPane.add(getDc());
		contentPane.add(getDd());
		contentPane.add(getEa());
		contentPane.add(getEb());
		contentPane.add(getEc());
		contentPane.add(getEd());
		contentPane.add(getFa());
		contentPane.add(getFb());
		contentPane.add(getFc());
		contentPane.add(getFd());
		contentPane.add(getProgressBar());
		contentPane.add(getLblVreme());
		contentPane.add(getBtnStart());
		contentPane.add(getTextField());
		contentPane.add(getR1());
		contentPane.add(getR2());
		contentPane.add(getR3());
		contentPane.add(getR4());
		contentPane.add(getLblReenje());
		contentPane.add(getLblNajbolji());
		contentPane.add(getLblRezultatnatpis());
		contentPane.add(getLblRezultat());
		
		setLocationRelativeTo(null);
	}
	/**
	 * Metoda vraca dugme skocko ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return znak skocko kao Button
	 */
	private JButton getBtnSkocko() {
		if (btnSkocko == null) {
			btnSkocko = new JButton("");
			btnSkocko.setEnabled(false);
			btnSkocko.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnSkocko);
					brojacKlikova++;
				}
			});
			btnSkocko.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/skocko.png")));
			btnSkocko.setBounds(10, 10, 50, 50);
		}
		return btnSkocko;
	}
	/**
	 * Metoda vraca dugme zvezda ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return znak zvezda kao Button
	 */
	private JButton getBtnZvezda() {
		if (btnZvezda == null) {
			btnZvezda = new JButton("");
			btnZvezda.setEnabled(false);
			btnZvezda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnZvezda);
					brojacKlikova++;
				}
			});
			btnZvezda.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/zvezda.png")));
			btnZvezda.setBounds(10, 70, 50, 50);
		}
		return btnZvezda;
	}
	/**
	 * Metoda vraca dugme pik ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return pik skocko kao Button
	 */
	private JButton getBtnPik() {
		if (btnPik == null) {
			btnPik = new JButton("");
			btnPik.setEnabled(false);
			btnPik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnPik);
					brojacKlikova++;
				}
			});
			btnPik.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/tref.png")));
			btnPik.setBounds(10, 130, 50, 50);
		}
		return btnPik;
	}
	/**
	 * Metoda vraca dugme srce ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return znak srce kao Button
	 */
	private JButton getBtnSrce() {
		if (btnSrce == null) {
			btnSrce = new JButton("");
			btnSrce.setEnabled(false);
			btnSrce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnSrce);
					brojacKlikova++;
				}
			});
			btnSrce.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/srce.png")));
			btnSrce.setBounds(10, 190, 50, 50);
		}
		return btnSrce;
	}
	/**
	 * Metoda vraca dugme tref ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return znak tref kao Button
	 */
	private JButton getBtnTref() {
		if (btnTref == null) {
			btnTref = new JButton("");
			btnTref.setEnabled(false);
			btnTref.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnTref);
					brojacKlikova++;
				}
			});
			btnTref.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/pik.png")));
			btnTref.setBounds(10, 250, 50, 50);
		}
		return btnTref;
	}
	/**
	 * Metoda vraca dugme karo ina klik na ovo dugme poziva se metoda klik koja je definisana u daljem kodu i
	 * registruje da je izvrsen jedan unos znaka
	 * @return znak karo kao Button
	 */
	private JButton getBtnKaro() {
		if (btnKaro == null) {
			btnKaro = new JButton("");
			btnKaro.setEnabled(false);
			btnKaro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnKaro);
					brojacKlikova++;
				}
			});
			btnKaro.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/karo.png")));
			btnKaro.setBounds(10, 310, 50, 50);
		}
		return btnKaro;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getA1() {
		if (a1 == null) {
			a1 = new JLabel("");
			a1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(a1.getIcon()!=null && a1enabled) {
						a1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 1;
					}
				}
			});
			a1.setOpaque(true);
			a1.setBackground(SystemColor.inactiveCaption);
			a1.setBounds(100, 10, 50, 50);
		}
		return a1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getA2() {
		if (a2 == null) {
			a2 = new JLabel("");
			a2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(a2.getIcon()!=null && a2enabled) {
						a2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 2;
					}
				}
			});
			a2.setOpaque(true);
			a2.setBackground(SystemColor.inactiveCaption);
			a2.setBounds(160, 10, 50, 50);
		}
		return a2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getA3() {
		if (a3 == null) {
			a3 = new JLabel("");
			a3.setOpaque(true);
			a3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(a3.getIcon()!=null && a3enabled) {
						a3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 3;
					}
				}
			});
			a3.setBackground(SystemColor.inactiveCaption);
			a3.setBounds(220, 10, 50, 50);
		}
		return a3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getA4() {
		if (a4 == null) {
			a4 = new JLabel("");
			a4.setOpaque(true);
			a4.setBackground(SystemColor.inactiveCaption);
			a4.setBounds(280, 10, 50, 50);
		}
		return a4;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getB1() {
		if (b1 == null) {
			b1 = new JLabel("");
			b1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(b1.getIcon()!=null && b1enabled) {
						b1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 5;
					}
				}
			});
			b1.setOpaque(true);
			b1.setBackground(SystemColor.inactiveCaption);
			b1.setBounds(100, 70, 50, 50);
		}
		return b1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getB2() {
		if (b2 == null) {
			b2 = new JLabel("");
			b2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(b2.getIcon()!=null && b2enabled) {
						b2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 6;
					}
				}
			});
			b2.setOpaque(true);
			b2.setBackground(SystemColor.inactiveCaption);
			b2.setBounds(160, 70, 50, 50);
		}
		return b2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getB3() {
		if (b3 == null) {
			b3 = new JLabel("");
			b3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(b3.getIcon()!=null && b3enabled) {
						b3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 7;
					}
				}
			});
			b3.setOpaque(true);
			b3.setBackground(SystemColor.inactiveCaption);
			b3.setBounds(220, 70, 50, 50);
		}
		return b3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getB4() {
		if (b4 == null) {
			b4 = new JLabel("");
			b4.setOpaque(true);
			b4.setBackground(SystemColor.inactiveCaption);
			b4.setBounds(280, 70, 50, 50);
		}
		return b4;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getC1() {
		if (c1 == null) {
			c1 = new JLabel("");
			c1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(c1.getIcon()!=null && c1enabled) {
						c1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 9;
					}
				}
			});
			c1.setOpaque(true);
			c1.setBackground(SystemColor.inactiveCaption);
			c1.setBounds(100, 130, 50, 50);
		}
		return c1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getC2() {
		if (c2 == null) {
			c2 = new JLabel("");
			c2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(c2.getIcon()!=null && c2enabled) {
						c2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 10;
					}
				}
			});
			c2.setOpaque(true);
			c2.setBackground(SystemColor.inactiveCaption);
			c2.setBounds(160, 130, 50, 50);
		}
		return c2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getC3() {
		if (c3 == null) {
			c3 = new JLabel("");
			c3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(c3.getIcon()!=null && c3enabled) {	
						c3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 11;
					}
				}	
			});
			c3.setOpaque(true);
			c3.setBackground(SystemColor.inactiveCaption);
			c3.setBounds(220, 130, 50, 50);
		}
		return c3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getC4() {
		if (c4 == null) {
			c4 = new JLabel("");
			c4.setOpaque(true);
			c4.setBackground(SystemColor.inactiveCaption);
			c4.setBounds(280, 130, 50, 50);
		}
		return c4;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getD1() {
		if (d1 == null) {
			d1 = new JLabel("");
			d1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(d1.getIcon()!=null && d1enabled) {
						d1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 13;
					}
				}
			});
			d1.setOpaque(true);
			d1.setBackground(SystemColor.inactiveCaption);
			d1.setBounds(100, 190, 50, 50);
		}
		return d1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getD2() {
		if (d2 == null) {
			d2 = new JLabel("");
			d2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(d2.getIcon()!=null && d2enabled) {	
						d2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 14;
					}
				}
			});
			d2.setOpaque(true);
			d2.setBackground(SystemColor.inactiveCaption);
			d2.setBounds(160, 190, 50, 50);
		}
		return d2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getD3() {
		if (d3 == null) {
			d3 = new JLabel("");
			d3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(d3.getIcon()!=null && d3enabled) {
						d3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 15;
					}
				}
			});
			d3.setOpaque(true);
			d3.setBackground(SystemColor.inactiveCaption);
			d3.setBounds(220, 190, 50, 50);
		}
		return d3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getD4() {
		if (d4 == null) {
			d4 = new JLabel("");
			d4.setOpaque(true);
			d4.setBackground(SystemColor.inactiveCaption);
			d4.setBounds(280, 190, 50, 50);
		}
		return d4;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getE1() {
		if (e1 == null) {
			e1 = new JLabel("");
			e1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(e1.getIcon()!=null && e1enabled) {
						e1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 17;
					}
				}
			});
			e1.setOpaque(true);
			e1.setBackground(SystemColor.inactiveCaption);
			e1.setBounds(100, 250, 50, 50);
		}
		return e1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getE2() {
		if (e2 == null) {
			e2 = new JLabel("");
			e2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(e2.getIcon()!=null && e2enabled) {
						e2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 18;
					}
				}
			});
			e2.setOpaque(true);
			e2.setBackground(SystemColor.inactiveCaption);
			e2.setBounds(160, 250, 50, 50);
		}
		return e2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getE3() {
		if (e3 == null) {
			e3 = new JLabel("");
			e3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(e3.getIcon()!=null && e3enabled) {
						e3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 19;
					}
				}
			});
			e3.setOpaque(true);
			e3.setBackground(SystemColor.inactiveCaption);
			e3.setBounds(220, 250, 50, 50);
		}
		return e3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getE4() {
		if (e4 == null) {
			e4 = new JLabel("");
			e4.setOpaque(true);
			e4.setBackground(SystemColor.inactiveCaption);
			e4.setBounds(280, 250, 50, 50);
		}
		return e4;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getF1() {
		if (f1 == null) {
			f1 = new JLabel("");
			f1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(f1.getIcon()!=null && f1enabled) {
						f1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 21;
					}
				}
			});
			f1.setOpaque(true);
			f1.setBackground(SystemColor.inactiveCaption);
			f1.setBounds(100, 310, 50, 50);
		}
		return f1;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getF2() {
		if (f2 == null) {
			f2 = new JLabel("");
			f2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(f2.getIcon()!=null && f2enabled) {
						f2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 22;
					}
				}
			});
			f2.setOpaque(true);
			f2.setBackground(SystemColor.inactiveCaption);
			f2.setBounds(160, 310, 50, 50);
		}
		return f2;
	}
	/**
	 * Metoda vraca polje i na klik na ovo polje u slucaju da postoji neki znak unet u ovo polje brise taj znak
	 * tj. stavlja novu sliku preko
	 * @return polje kao JLabel
	 */
	private JLabel getF3() {
		if (f3 == null) {
			f3 = new JLabel("");
			f3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(f3.getIcon()!=null && f3enabled) {
						f3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
						brojacKlikova = 23;
					}
				}
			});
			f3.setOpaque(true);
			f3.setBackground(SystemColor.inactiveCaption);
			f3.setBounds(220, 310, 50, 50);
		}
		return f3;
	}
	/**
	 * Metoda vraca dato polje 
	 * @return polje kao JLabel
	 */
	private JLabel getF4() {
		if (f4 == null) {
			f4 = new JLabel("");
			f4.setOpaque(true);
			f4.setBackground(SystemColor.inactiveCaption);
			f4.setBounds(280, 310, 50, 50);
		}
		return f4;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za prvi red
	 * @return polje kao JLabel
	 */
	private JLabel getAa() {
		if (aa == null) {
			aa = new JLabel("");
			aa.setBackground(SystemColor.inactiveCaptionBorder);
			aa.setOpaque(true);
			aa.setBounds(340, 10, 22, 22);
		}
		return aa;
	}
	private JLabel getAb() {
		if (ab == null) {
			ab = new JLabel("");
			ab.setBackground(SystemColor.inactiveCaptionBorder);
			ab.setOpaque(true);
			ab.setBounds(368, 10, 22, 22);
		}
		return ab;
	}
	private JLabel getAc() {
		if (ac == null) {
			ac = new JLabel("");
			ac.setBackground(SystemColor.inactiveCaptionBorder);
			ac.setOpaque(true);
			ac.setBounds(340, 38, 22, 22);
		}
		return ac;
	}
	private JLabel getAd() {
		if (ad == null) {
			ad = new JLabel("");
			ad.setBackground(SystemColor.inactiveCaptionBorder);
			ad.setOpaque(true);
			ad.setBounds(368, 38, 22, 22);
		}
		return ad;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za drugi red
	 * @return polje kao JLabel
	 */
	private JLabel getBa() {
		if (ba == null) {
			ba = new JLabel("");
			ba.setBackground(SystemColor.inactiveCaptionBorder);
			ba.setOpaque(true);
			ba.setBounds(340, 70, 22, 22);
		}
		return ba;
	}
	private JLabel getBb() {
		if (bb == null) {
			bb = new JLabel("");
			bb.setBackground(SystemColor.inactiveCaptionBorder);
			bb.setOpaque(true);
			bb.setBounds(368, 70, 22, 22);
		}
		return bb;
	}
	private JLabel getBc() {
		if (bc == null) {
			bc = new JLabel("");
			bc.setBackground(SystemColor.inactiveCaptionBorder);
			bc.setOpaque(true);
			bc.setBounds(340, 98, 22, 22);
		}
		return bc;
	}
	private JLabel getBd() {
		if (bd == null) {
			bd = new JLabel("");
			bd.setBackground(SystemColor.inactiveCaptionBorder);
			bd.setOpaque(true);
			bd.setBounds(368, 98, 22, 22);
		}
		return bd;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za treci red
	 * @return polje kao JLabel
	 */
	private JLabel getCa() {
		if (ca == null) {
			ca = new JLabel("");
			ca.setBackground(SystemColor.inactiveCaptionBorder);
			ca.setOpaque(true);
			ca.setBounds(340, 130, 22, 22);
		}
		return ca;
	}
	private JLabel getCb() {
		if (cb == null) {
			cb = new JLabel("");
			cb.setBackground(SystemColor.inactiveCaptionBorder);
			cb.setOpaque(true);
			cb.setBounds(368, 130, 22, 22);
		}
		return cb;
	}
	private JLabel getCc() {
		if (cc == null) {
			cc = new JLabel("");
			cc.setBackground(SystemColor.inactiveCaptionBorder);
			cc.setOpaque(true);
			cc.setBounds(340, 158, 22, 22);
		}
		return cc;
	}
	private JLabel getCd() {
		if (cd == null) {
			cd = new JLabel("");
			cd.setBackground(SystemColor.inactiveCaptionBorder);
			cd.setOpaque(true);
			cd.setBounds(368, 158, 22, 22);
		}
		return cd;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za cetvrti red
	 * @return polje kao JLabel
	 */
	private JLabel getDa() {
		if (da == null) {
			da = new JLabel("");
			da.setBackground(SystemColor.inactiveCaptionBorder);
			da.setOpaque(true);
			da.setBounds(340, 190, 22, 22);
		}
		return da;
	}
	private JLabel getDb() {
		if (db == null) {
			db = new JLabel("");
			db.setBackground(SystemColor.inactiveCaptionBorder);
			db.setOpaque(true);
			db.setBounds(368, 190, 22, 22);
		}
		return db;
	}
	private JLabel getDc() {
		if (dc == null) {
			dc = new JLabel("");
			dc.setBackground(SystemColor.inactiveCaptionBorder);
			dc.setOpaque(true);
			dc.setBounds(340, 218, 22, 22);
		}
		return dc;
	}
	private JLabel getDd() {
		if (dd == null) {
			dd = new JLabel("");
			dd.setBackground(SystemColor.inactiveCaptionBorder);
			dd.setOpaque(true);
			dd.setBounds(368, 218, 22, 22);
		}
		return dd;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za peti red
	 * @return polje kao JLabel
	 */
	private JLabel getEa() {
		if (ea == null) {
			ea = new JLabel("");
			ea.setBackground(SystemColor.inactiveCaptionBorder);
			ea.setOpaque(true);
			ea.setBounds(340, 250, 22, 22);
		}
		return ea;
	}
	private JLabel getEb() {
		if (eb == null) {
			eb = new JLabel("");
			eb.setBackground(SystemColor.inactiveCaptionBorder);
			eb.setOpaque(true);
			eb.setBounds(368, 250, 22, 22);
		}
		return eb;
	}
	private JLabel getEc() {
		if (ec == null) {
			ec = new JLabel("");
			ec.setBackground(SystemColor.inactiveCaptionBorder);
			ec.setOpaque(true);
			ec.setBounds(340, 278, 22, 22);
		}
		return ec;
	}
	private JLabel getEd() {
		if (ed == null) {
			ed = new JLabel("");
			ed.setBackground(SystemColor.inactiveCaptionBorder);
			ed.setOpaque(true);
			ed.setBounds(368, 278, 22, 22);
		}
		return ed;
	}
	/**
	 * Metoda vraca dato polje koje se boju u slucaju pogodjenog ili znaka koji nije na mestu za sesti red
	 * @return polje kao JLabel
	 */
	private JLabel getFa() {
		if (fa == null) {
			fa = new JLabel("");
			fa.setBackground(SystemColor.inactiveCaptionBorder);
			fa.setOpaque(true);
			fa.setBounds(340, 310, 22, 22);
		}
		return fa;
	}
	private JLabel getFb() {
		if (fb == null) {
			fb = new JLabel("");
			fb.setBackground(SystemColor.inactiveCaptionBorder);
			fb.setOpaque(true);
			fb.setBounds(368, 310, 22, 22);
		}
		return fb;
	}
	private JLabel getFc() {
		if (fc == null) {
			fc = new JLabel("");
			fc.setBackground(SystemColor.inactiveCaptionBorder);
			fc.setOpaque(true);
			fc.setBounds(340, 338, 22, 22);
		}
		return fc;
	}
	private JLabel getFd() {
		if (fd == null) {
			fd = new JLabel("");
			fd.setBackground(SystemColor.inactiveCaptionBorder);
			fd.setOpaque(true);
			fd.setBounds(368, 338, 22, 22);
		}
		return fd;
	}
	/**
	 * Metoda vraca progressBar koji sluzi za prikazivanje vremena
	 * @return progressBar
	 */
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setForeground(Color.GREEN);
			progressBar.setValue(100);
			progressBar.setOrientation(SwingConstants.VERTICAL);
			progressBar.setBounds(415, 38, 41, 270);
		}
		return progressBar;
	}
	/**
	 * Metoda vraca label koj je natpis vreme
	 * @return lblVreme kao Jlabel
	 */
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("VREME");
			lblVreme.setFont(new Font("Eras Bold ITC", Font.PLAIN, 13));
			lblVreme.setBounds(412, 10, 56, 22);
		}
		return lblVreme;
	}
	/**
	 * Metoda vraca polje u koje se brojcano upisuje vreme
	 * @return textField kao JtextField
	 */
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Eras Bold ITC", Font.PLAIN, 13));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBackground(SystemColor.controlHighlight);
			textField.setEditable(false);
			textField.setBounds(415, 319, 41, 41);
			textField.setColumns(10);
		}
		return textField;
	}
	/**
	 * Metoda vraca polje u koje se random upisuje neki znak 
	 * @return polje za rezultat kao JLabel
	 */
	private JLabel getR1() {
		if (r1 == null) {
			r1 = new JLabel("");
			r1.setBounds(100, 370, 50, 50);
		}
		return r1;
	}
	/**
	 * Metoda vraca polje u koje se random upisuje neki znak 
	 * @return polje za rezultat kao JLabel
	 */
	private JLabel getR2() {
		if (r2 == null) {
			r2 = new JLabel("");
			r2.setBounds(160, 370, 50, 50);
		}
		return r2;
	}
	/**
	 * Metoda vraca polje u koje se random upisuje neki znak 
	 * @return polje za rezultat kao JLabel
	 */
	private JLabel getR3() {
		if (r3 == null) {
			r3 = new JLabel("");
			r3.setBounds(220, 370, 50, 50);
		}
		return r3;
	}
	/**
	 * Metoda vraca polje u koje se random upisuje neki znak 
	 * @return polje za rezultat kao JLabel
	 */
	private JLabel getR4() {
		if (r4 == null) {
			r4 = new JLabel("");
			r4.setBounds(280, 370, 50, 50);
		}
		return r4;
	}
	/**
	 * Metoda vraca label koj je natpis najbolji
	 * @return lblNajbolji kao Jlabel
	 */
	private JLabel getLblNajbolji() {
		if (lblNajbolji == null) {
			lblNajbolji = new JLabel("NAJBOLJI ");
			lblNajbolji.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
			lblNajbolji.setBounds(356, 396, 100, 14);
		}
		return lblNajbolji;
	}
	/**
	 * Metoda vraca label koj je natpis rezultat
	 * @return lblRezultatNatpis kao Jlabel
	 */
	private JLabel getLblRezultatnatpis() {
		if (lblRezultatnatpis == null) {
			lblRezultatnatpis = new JLabel("REZULTAT:");
			lblRezultatnatpis.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
			lblRezultatnatpis.setBounds(353, 409, 103, 29);
		}
		return lblRezultatnatpis;
	}
	/**
	 * Metoda vraca label koj je najbolji postavljen rezultat i ona svaki put ucitava iz fajla najbolji rezultat osim prvog puta
	 * kada jos ni jednom nije pogodjena kombinacija
	 * @return lblRezultat kao Jlabel
	 */
	private JLabel getLblRezultat() {
		if (lblRezultat == null) {
			lblRezultat = new JLabel("");
			lblRezultat.setHorizontalAlignment(SwingConstants.CENTER);		
			int rez=GUIKontoler.ucitajRez("highscoreSkocko.out");
			lblRezultat.setText(String.valueOf(rez) + " sec");
			lblRezultat.setFont(new Font("Eras Bold ITC", Font.PLAIN, 17));
			lblRezultat.setBounds(340, 444, 116, 14);
		}
		return lblRezultat;
	}
	/**
	 * Metoda vraca btnStart i na klik na ovo dugme poziva metodu random i na osnovu nje izbacuje neku kombinaciju brojeva,
	 * postavlja da su dugmici za unos znakova vidljivi, stavlja da su poslednja 4 polja za  resenja nevidljiva za korisnika,
	 * postavlja da su za klik dostupna samo prva 3 polja prvog reda, brise sve do tada unete znakove iz prethodne partije,
	 * postavlja pocetni brojac klikova i poziva metodu Timer
	 * @return btnStart kao JButton
	 */
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("START");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch(random()) {
					  	case 1: r1.setIcon(btnSkocko.getIcon()); break;
					  	case 2: r1.setIcon(btnZvezda.getIcon()); break;
					  	case 3: r1.setIcon(btnKaro.getIcon()); break;
					  	case 4: r1.setIcon(btnPik.getIcon()); break;
					  	case 5: r1.setIcon(btnSrce.getIcon()); break;
					  	case 6: r1.setIcon(btnTref.getIcon()); break;
					}
					switch(random()) {
				  		case 1: r2.setIcon(btnSkocko.getIcon()); break;
				  		case 2: r2.setIcon(btnZvezda.getIcon()); break;
				  		case 3: r2.setIcon(btnKaro.getIcon()); break;
				  		case 4: r2.setIcon(btnPik.getIcon()); break;
				  		case 5: r2.setIcon(btnSrce.getIcon()); break;
				  		case 6: r2.setIcon(btnTref.getIcon()); break;
					}
					switch(random()) {
						case 1: r3.setIcon(btnSkocko.getIcon()); break;
						case 2: r3.setIcon(btnZvezda.getIcon()); break;
				  		case 3: r3.setIcon(btnKaro.getIcon()); break;
				  		case 4: r3.setIcon(btnPik.getIcon()); break;
				  		case 5: r3.setIcon(btnSrce.getIcon()); break;
				  		case 6: r3.setIcon(btnTref.getIcon()); break;
					}
					switch(random()) {
				  		case 1: r4.setIcon(btnSkocko.getIcon()); break;
				  		case 2: r4.setIcon(btnZvezda.getIcon()); break;
				  		case 3: r4.setIcon(btnKaro.getIcon()); break;
				  		case 4: r4.setIcon(btnPik.getIcon()); break;
				  		case 5: r4.setIcon(btnSrce.getIcon()); break;
				  		case 6: r4.setIcon(btnTref.getIcon()); break;
					}
					
					r1.setVisible(false);
					r2.setVisible(false);
					r3.setVisible(false);
					r4.setVisible(false);
					
					btnKaro.setEnabled(true);
					btnZvezda.setEnabled(true);
					btnPik.setEnabled(true);
					btnTref.setEnabled(true);
					btnSrce.setEnabled(true);
					btnSkocko.setEnabled(true);
					
					a1enabled = true;
					a2enabled = true;
					a3enabled = true;
					
					isprazniSvaPolja();
					brojacKlikova = 1;
					lblReenje.setVisible(false);
					
					Timer();
				}
			});
			btnStart.setFont(new Font("Eras Bold ITC", Font.PLAIN, 28));
			btnStart.setBounds(100, 427, 230, 42);
		}
		return btnStart;
	}
	/**
	 * @param JButton
	 * Ova metoda u zavisnosti od broja unetih znakova i kliknutog znaka koji je dat kao ulazni parametar postavlja
	 * taj znak na polje koje je sledece u nizu, sagledavajuci slucaj za 4. polje svakog reda kada poziva metodu krajReda
	 * koja predstavlja drugi slucaj od prva tri polja
	 */
	public void klik(JButton button) {
		switch(brojacKlikova) {
			case 1:a1.setIcon(button.getIcon()); break;
			case 2:a2.setIcon(button.getIcon()); break;
			case 3:a3.setIcon(button.getIcon()); break;
			case 4:krajReda(button, a4, aa, ab, ac, ad, a1, a2, a3, a4); break; 
			case 5:b1.setIcon(button.getIcon()); break;
			case 6:b2.setIcon(button.getIcon()); break;
			case 7:b3.setIcon(button.getIcon()); break;
			case 8:krajReda(button, b4, ba, bb, bc, bd, b1, b2, b3, b4); break;
			case 9:c1.setIcon(button.getIcon()); break;
			case 10:c2.setIcon(button.getIcon()); break;
			case 11:c3.setIcon(button.getIcon()); break;
			case 12:krajReda(button, c4, ca, cb, cc, cd, c1, c2, c3, c4); break;
			case 13:d1.setIcon(button.getIcon()); break;
			case 14:d2.setIcon(button.getIcon()); break;
			case 15:d3.setIcon(button.getIcon()); break;
			case 16:krajReda(button, d4, da, db, dc, dd, d1, d2, d3, d4); break;
			case 17:e1.setIcon(button.getIcon()); break;
			case 18:e2.setIcon(button.getIcon()); break;
			case 19:e3.setIcon(button.getIcon()); break;
			case 20:krajReda(button, e4, ea, eb, ec, ed, e1, e2, e3, e4); break;
			case 21:f1.setIcon(button.getIcon()); break;
			case 22:f2.setIcon(button.getIcon()); break;
			case 23:f3.setIcon(button.getIcon()); break;
			case 24:krajReda(button, f4, fa, fb, fc, fd, f1, f2, f3, f4); break;
		}
	}
	/**
	 * Metoda vraca broj na osnovu koga se odredjuje random kombinacija koju korisnik treba da pogodi
	 * Brojevi su u rasponu od 1 do 6 jer postoji 6 mogucih znakova
	 * @return randomBroj kao int
	 */
	public static int random() {
	    Random random = new Random();
	    int randomNum = random.nextInt(6) + 1;
	    return randomNum;
	}
	/**
	 * Metoda vraca niz od broja pogodjenih i broja onih znakova koji nisu na svom mestu, ona poredi svako polje 
	 * iz jednog reda sa poljima u kojima je upisana zadata kombinacija i na osnovu toga vraca ova dva podatka
	 * @param 4 polja kao JLabel-i
	 * @return niz od dva broja kao int[]
	 */
	public int[] brojPogodjenihIbrojOnihKojiNisuNaSvomMestu(JLabel a, JLabel b, JLabel c, JLabel d) {
		int[] niz = new int[2];
		int brojPogodjenih = 0;
		int brojOnihKojiNisuNaSvomMestu = 0;
		boolean prviPogodjen = false;
		boolean drugiPogodjen = false;
		boolean treciPogodjen = false;
		boolean cetvrtiPogodjen = false;
		if(a.getIcon().toString().equals(r1.getIcon().toString())) prviPogodjen = true;
		if(b.getIcon().toString().equals(r2.getIcon().toString())) drugiPogodjen = true;
		if(c.getIcon().toString().equals(r3.getIcon().toString())) treciPogodjen = true;
		if(d.getIcon().toString().equals(r4.getIcon().toString())) cetvrtiPogodjen = true;
		
		if(a.getIcon().toString().equals(r1.getIcon().toString())) {
			brojPogodjenih++;
		} else {
			if(a.getIcon().toString().equals(r2.getIcon().toString()) && !drugiPogodjen) {
				brojOnihKojiNisuNaSvomMestu++;
				drugiPogodjen = true;
			} else
				if(a.getIcon().toString().equals(r3.getIcon().toString()) && !treciPogodjen) {
					brojOnihKojiNisuNaSvomMestu++;
					treciPogodjen = true;
				} else
					if(a.getIcon().toString().equals(r4.getIcon().toString()) && !cetvrtiPogodjen) {
						brojOnihKojiNisuNaSvomMestu++;
						cetvrtiPogodjen = true;
					}
		}
		if(b.getIcon().toString().equals(r2.getIcon().toString())) {
			brojPogodjenih++;
		} else {
			if(b.getIcon().toString().equals(r1.getIcon().toString()) && !prviPogodjen) {
				brojOnihKojiNisuNaSvomMestu++;
				prviPogodjen = true;
			} else
				if(b.getIcon().toString().equals(r3.getIcon().toString()) && !treciPogodjen) {
					brojOnihKojiNisuNaSvomMestu++;
					treciPogodjen = true;
				} else
					if(b.getIcon().toString().equals(r4.getIcon().toString()) && !cetvrtiPogodjen) {
						brojOnihKojiNisuNaSvomMestu++;
						cetvrtiPogodjen = true;
					}
		}
		if(c.getIcon().toString().equals(r3.getIcon().toString())) {
			brojPogodjenih++;
		} else {
			if(c.getIcon().toString().equals(r1.getIcon().toString())  && !prviPogodjen) {
				brojOnihKojiNisuNaSvomMestu++;
				prviPogodjen = true;
			} else
				if(c.getIcon().toString().equals(r2.getIcon().toString())  && !drugiPogodjen) {
					brojOnihKojiNisuNaSvomMestu++;
					drugiPogodjen = true;
				} else
					if(c.getIcon().toString().equals(r4.getIcon().toString()) && !cetvrtiPogodjen) {
						brojOnihKojiNisuNaSvomMestu++;
						cetvrtiPogodjen = true;
					}
		}
		if(d.getIcon().toString().equals(r4.getIcon().toString())) {
			brojPogodjenih++;
		} else {
			if(d.getIcon().toString().equals(r1.getIcon().toString()) && !prviPogodjen) {
				brojOnihKojiNisuNaSvomMestu++;
				prviPogodjen = true;
			} else
				if(d.getIcon().toString().equals(r2.getIcon().toString()) && !drugiPogodjen) {
					brojOnihKojiNisuNaSvomMestu++;
					drugiPogodjen = true;
				} else
					if(d.getIcon().toString().equals(r3.getIcon().toString()) && !treciPogodjen) {
						brojOnihKojiNisuNaSvomMestu++;
						treciPogodjen = true;
					}
		}
		niz[0] = brojPogodjenih;
		niz[1] = brojOnihKojiNisuNaSvomMestu;
		return niz;
	}
	int rezultat = 0;
	/**
	 * Ova metoda se svodi na specijalan slucaj kada korisnik unese 4. znak u nekom redu, ona tada sagledava 14 mogucih 
	 * kombinacija broja pogodjenih i broja onih koji nisu na svom mestu i upisuje to u odgovarajuca polja. U slucaju 
	 * da je broj pogodjenih 4, to znaci da je korisnik pogodio kombinaciju i iskace prozor koji ga obavestava o vremenu
	 * koje mu je bilo potrebno da pogodi. Istovremeno upisuje ovaj rezultat u fajl i ispisuje ga u polje za prikaz
	 * najboljeg rezultata. Onemogucava dalje unosenje znakova. Registruje da je kombinacija pogodjena. Poseban slucaj je
	 * kada kombinacija nije pogodjena,a predvidjeno vreme je isteklo, onda iskace prozor koji obavestava o isteku vremena
	 * i onemogucava dalje unosenje znakova.
	 * 
	 * @param dugme koje je kliknuto, poslednje polje u datom redu, 4 polja koja sluze za prokaz pogodjenih  znakova i 
	 * onih koji nisu na svom mestu, 4 polja datog reda u koje se unose znakovi
	 */
	public void krajReda(JButton button, JLabel poslednji, JLabel a, JLabel b, JLabel c, JLabel d,
			JLabel x, JLabel y, JLabel z, JLabel w) {
		poslednji.setIcon(button.getIcon());
		int brojPogodjenih = brojPogodjenihIbrojOnihKojiNisuNaSvomMestu(x, y, z, w)[0];
		int brojOnihKojiNisuNaSvomMestu = brojPogodjenihIbrojOnihKojiNisuNaSvomMestu(x, y, z, w)[1];
		boolean pogodjeno = false;
		if(x.equals(a1)) {
			b1enabled = true;
			b2enabled = true;
			b3enabled = true;
		}
		if(x.equals(b1)) {
			c1enabled = true;
			c2enabled = true;
			c3enabled = true;
		}
		if(x.equals(c1)) {
			d1enabled = true;
			d2enabled = true;
			d3enabled = true;
		}
		if(x.equals(d1)) {
			e1enabled = true;
			e2enabled = true;
			e3enabled = true;
		}
		if(x.equals(e1)) {
			f1enabled = true;
			f2enabled = true;
			f3enabled = true;
		}
		
		if(brojPogodjenih == 1 && brojOnihKojiNisuNaSvomMestu == 0) {
			a.setOpaque(true);
			a.setBackground(Color.red);
		}
		if(brojPogodjenih == 2 && brojOnihKojiNisuNaSvomMestu == 0) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.red);
		}
		if(brojPogodjenih == 3 && brojOnihKojiNisuNaSvomMestu == 0) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.red);
			c.setOpaque(true);
			c.setBackground(Color.red);
		}
		if(brojPogodjenih == 4 && brojOnihKojiNisuNaSvomMestu == 0) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.red);
			c.setOpaque(true);
			c.setBackground(Color.red);
			d.setOpaque(true);
			d.setBackground(Color.red);
		
			btnSkocko.setEnabled(false);
			btnTref.setEnabled(false);
			btnKaro.setEnabled(false);
			btnPik.setEnabled(false);
			btnZvezda.setEnabled(false);
			btnSrce.setEnabled(false);
			
			r1.setVisible(true);
			r2.setVisible(true);
			r3.setVisible(true);
			r4.setVisible(true);
			lblReenje.setVisible(true);
			
			timer.stop();
			JOptionPane.showMessageDialog(null, "Čestitamo!!! Pogodili ste traženu kombinaciju." + "\n" + 
			"Vaše vreme je: " +(100 - progressBar.getValue())+ " sec", "Skočko" , JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon(this.getClass().getResource("/skocko/slike/devedzic1.jpg")));
			pogodjeno = true;	 
			int rez=GUIKontoler.ucitajRez("highscoreSkocko.out");
			if ((100 - progressBar.getValue()) < rez || rez==0) {
				GUIKontoler.sacuvajRez("highscoreSkocko.out", 100 - progressBar.getValue());
				lblRezultat.setText(String.valueOf(100 - progressBar.getValue()) + " sec");
			}
				
			
		}
		if(brojPogodjenih == 1 && brojOnihKojiNisuNaSvomMestu == 1) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 1 && brojOnihKojiNisuNaSvomMestu == 2) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 1 && brojOnihKojiNisuNaSvomMestu == 3) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
			d.setOpaque(true);
			d.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 2 && brojOnihKojiNisuNaSvomMestu == 1) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.red);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 2 && brojOnihKojiNisuNaSvomMestu == 2) {
			a.setOpaque(true);
			a.setBackground(Color.red);
			b.setOpaque(true);
			b.setBackground(Color.red);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
			d.setOpaque(true);
			d.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 0 && brojOnihKojiNisuNaSvomMestu == 1) {
			a.setOpaque(true);
			a.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 0 && brojOnihKojiNisuNaSvomMestu == 2) {
			a.setOpaque(true);
			a.setBackground(Color.yellow);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 0 && brojOnihKojiNisuNaSvomMestu == 3) {
			a.setOpaque(true);
			a.setBackground(Color.yellow);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
		}
		if(brojPogodjenih == 0 && brojOnihKojiNisuNaSvomMestu == 4) {
			a.setOpaque(true);
			a.setBackground(Color.yellow);
			b.setOpaque(true);
			b.setBackground(Color.yellow);
			c.setOpaque(true);
			c.setBackground(Color.yellow);
			d.setOpaque(true);
			d.setBackground(Color.yellow);
		}
		
		if(x.equals(a1)) {
			a1enabled = false;
			a2enabled = false;
			a3enabled = false;
		}
		if(x.equals(b1)) {
			b1enabled = false;
			b2enabled = false;
			b3enabled = false;
		}
		if(x.equals(c1)) {
			c1enabled = false;
			c2enabled = false;
			c3enabled = false;
		}
		if(x.equals(d1)) {
			d1enabled = false;
			d2enabled = false;
			d3enabled = false;
		}
		if(x.equals(e1)) {
			e1enabled = false;
			e2enabled = false;
			e3enabled = false;
		}
		if(x.equals(f1)) {
			f1enabled = false;
			f2enabled = false;
			f3enabled = false;
			if(!pogodjeno) {
				timer.stop();
				JOptionPane.showMessageDialog(null, "Više sreće drugi put! :( ", "Skočko" ,
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/skocko/slike/devedzic2.jpg")));
				r1.setVisible(true);
				r2.setVisible(true);
				r3.setVisible(true);
				r4.setVisible(true);
				lblReenje.setVisible(true);
			}
		}
		
	}
	/**
	 * Metoda na poziv dugmeta start prazni sva polja tj postavlja slike sive boje
	 */	
	public void isprazniSvaPolja() {
		a1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		a2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		a3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		a4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		b1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		b2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		b3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		b4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		c1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		c2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		c3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		c4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		d1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		d2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		d3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		d4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		e1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		e2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		e3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		e4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		f1.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		f2.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		f3.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		f4.setIcon(new ImageIcon(this.getClass().getResource("/skocko/slike/prazno.png")));
		aa.setBackground(SystemColor.inactiveCaptionBorder);
		ab.setBackground(SystemColor.inactiveCaptionBorder);
		ac.setBackground(SystemColor.inactiveCaptionBorder);
		ad.setBackground(SystemColor.inactiveCaptionBorder);
		ba.setBackground(SystemColor.inactiveCaptionBorder);
		bb.setBackground(SystemColor.inactiveCaptionBorder);
		bc.setBackground(SystemColor.inactiveCaptionBorder);
		bd.setBackground(SystemColor.inactiveCaptionBorder);
		ca.setBackground(SystemColor.inactiveCaptionBorder);
		cb.setBackground(SystemColor.inactiveCaptionBorder);
		cc.setBackground(SystemColor.inactiveCaptionBorder);
		cd.setBackground(SystemColor.inactiveCaptionBorder);
		da.setBackground(SystemColor.inactiveCaptionBorder);
		db.setBackground(SystemColor.inactiveCaptionBorder);
		dc.setBackground(SystemColor.inactiveCaptionBorder);
		dd.setBackground(SystemColor.inactiveCaptionBorder);
		ea.setBackground(SystemColor.inactiveCaptionBorder);
		eb.setBackground(SystemColor.inactiveCaptionBorder);
		ec.setBackground(SystemColor.inactiveCaptionBorder);
		ed.setBackground(SystemColor.inactiveCaptionBorder);
		fa.setBackground(SystemColor.inactiveCaptionBorder);
		fb.setBackground(SystemColor.inactiveCaptionBorder);
		fc.setBackground(SystemColor.inactiveCaptionBorder);
		fd.setBackground(SystemColor.inactiveCaptionBorder);
	}
	/**
	 * metoda vraca natpis resenje
	 * @return resenje kao lblReenje
	 */
	private JLabel getLblReenje() {
		if (lblReenje == null) {
			lblReenje = new JLabel("REŠENJE");
			lblReenje.setVisible(false);
			lblReenje.setFont(new Font("Eras Bold ITC", Font.PLAIN, 13));
			lblReenje.setBounds(10, 384, 61, 16);
		}
		return lblReenje;
	}
	/**
	 * predstavlja broj milisekundi na koje se tajmer menja
	 */
	private int sekunda = 1000;
	/**
	 * predstavlja pocetak za odbrojavanje od 100 sec
	 */
	private int brojac = 100;
	/**
	 * predstavlja instancu klase timer
	 */
	private Timer timer;
	/**
	 * predstavlja natpis najbolji
	 */
	private JLabel lblNajbolji;
	/**
	 * predstavlja natpis rezultat
	 */
	private JLabel lblRezultatnatpis;
	/**
	 * predstavlja polje za ispis najboljeg rezultata
	 */
	private JLabel lblRezultat;
	
	/**
	 * metoda tajmer koja se poziva na dugme start, na pocetku svake igre tajmer se setuje na 100 i krece da odbrojava do nule
	 * i na osnovu njega se menjaju vrednosti progressBara
	 */
	public void Timer() {
		timer = new Timer(sekunda, null);
        timer.setRepeats(false);
		timer.stop();
        brojac = 100;
        textField.setText("100");
        progressBar.setValue(100);
        timer.start();
        ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.start();
				brojac--;
            	textField.setText(String.valueOf(brojac));
            	progressBar.setValue(brojac);
            	if(brojac <= 10) progressBar.setForeground(Color.red);
            	else progressBar.setForeground(Color.green);
            	if(brojac == 0) {
            		JOptionPane.showMessageDialog(null, "Vreme je isteklo. ", "Skočko" ,
        					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/brojevi/devedzic2.jpg")));
        			timer.stop();
        			r1.setVisible(true);
                	r2.setVisible(true);
                	r3.setVisible(true);
                	r4.setVisible(true);
            	}
            	
			}
		};
		timer.addActionListener(actionListener);
	}
}
