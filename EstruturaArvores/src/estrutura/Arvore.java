package estrutura;

import javax.swing.*;

public class Arvore extends NoArvore {
	public NoArvore t;
	String vai = "";

	public NoArvore getT() {
		return t;
	}

	public void setT(NoArvore t) {
		this.t = t;
	}

	public String getVai() {
		return vai;
	}

	public void setVai(String vai) {
		this.vai = vai;
	}

	public void inicializaT() {
		this.setT(null);
	}

	public NoArvore insereABB(NoArvore t, int x) {

		if (t == null) {

			t = new NoArvore();
			t.setInfo(x);
			t.setEprox(null);
			t.setDprox(null);
		} else if (t.getInfo() > x) {
			t.setEprox(insereABB(t.getEprox(), x));
		} else if (t.getInfo() < x) {
			t.setDprox(insereABB(t.getDprox(), x));
		} else {
			JOptionPane.showMessageDialog(null, "Elemento j� inserido");
		}

		return t;
	}

	public NoArvore remove(NoArvore t, int x) {
		if (t != null) {
			if (t.getInfo() > x) {
				t = remove(t.getEprox(), x);
			} else if (t.getInfo() < x) {
				t = remove(t.getDprox(), x);
			} else {
				NoArvore p = t;
				if (p.getDprox() == null) {
					t = t.getEprox();

				} else if (t.getEprox() == null) {
					t = t.getDprox();
				} else {
					NoArvore r = p;
				
				p = p.getEprox();
				while (p.getEprox() != null) {
					r = p;
					p = p.getEprox();

				} 
				t.setInfo(p.getInfo());
				if(r.getDprox() == p){
					r.setDprox(p.getDprox());
				} else {
					r.setEprox(p.getDprox());
				}

			}

		}
   	 }
			return t;
	}

	public void pertinencia(NoArvore t, int x) {
		if (t == null) {
			JOptionPane
					.showMessageDialog(null, "O elemento n�o est� na lista ");
		} else if (t.getInfo() > x) {
			pertinencia(t.getEprox(), x);
			System.out.println("entrou a direita");
		} else if (t.getInfo() < x) {

			pertinencia(t.getDprox(), x);
		}
		if (t.getInfo() == x) {
			JOptionPane.showMessageDialog(null, " O valor foi encontrado ");
		}
	}

	public void max(NoArvore t) {

		if (t == null) {
			System.out.println("A arvore n�o possui um valor maior");
		} else {
			NoArvore aux = t;

			while (t.getDprox() != null) {
				aux = t.getDprox();
				t = t.getDprox();

			}
			JOptionPane.showMessageDialog(null,
					" O maior valor �" + " " + aux.getInfo());
		}
	}

	public void min(NoArvore t) {

		if (t == null) {
			System.out.println("A arvore n�o possui um valor maior");
		} else {
			NoArvore aux = t;

			while (t.getEprox() != null) {
				aux = t.getEprox();
				t = t.getEprox();

			}
			JOptionPane.showMessageDialog(null,
					" O menor valor �" + " " + aux.getInfo());
		}
	}

	public void imprime(NoArvore t, int nivel) {

		if (t != null) {

			imprime(t.getDprox(), nivel + 1);// verifica esquerda
			for (int i = 0; i < nivel; i++)
				setVai(getVai() + "     "); // espa�o entre os n�s
			setVai(getVai() + Integer.toString(t.getInfo()) + "\n"); // conte�do									// que
																		// ser�
			// impresso e uma
			// qubra de linha
			imprime(t.getEprox(), nivel + 1);// verifica direita
		}

	}
}
