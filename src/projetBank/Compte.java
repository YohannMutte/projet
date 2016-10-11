package projetBank;

public class Compte {
	protected int numero;
	protected double solde;

	public Compte(){
		this(-1,0d);

	}
	
	public double getSolde(){
		return this.solde;
	}

	public void setSolde(double solde){
		this.solde = solde;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void setNumero(int numero){
		this.solde = numero;
	}
	
	public Compte(int unNum, double unSoldeInit){
		super();
		this.numero = unNum;;
		this.solde = unSoldeInit;
	}
	
	public void ajouter(double valeur){
		this.solde += valeur;

	}

	public void retirer(double valeur) throws BanqueException{

		this.solde -= valeur;
	}
	
	@Override
	public String toString() {
		StringBuilder compte = new StringBuilder();

		compte
			.append("Compte:\n\t numero = ").append(numero)
			.append(" \n\t solde = ").append(solde)
			.append("");

		return compte.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj instanceof Compte) {
			Compte c = (Compte) obj;
			return this.getNumero() == c.getNumero();
		}
		return false;
	}
	
}
