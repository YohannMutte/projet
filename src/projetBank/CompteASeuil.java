package projetBank;

public class CompteASeuil extends Compte{
	protected double seuil;
	
	public CompteASeuil(){
		this(-1,0,0);
	}
	
	public CompteASeuil(int unNum, double unSoldeInit, double unSeuil){
		super(unNum,unSoldeInit);
		this.seuil = unSeuil;
	}
	
	public double getSeuil(){
		return this.seuil;
	}
	
	public void setSeuil(double unSeuil){
		this.seuil = unSeuil;
	}
	
	public String toString(){
		return String.format("%s Seuil=%f", super.toString(), this.getSeuil());
	}
	
}
