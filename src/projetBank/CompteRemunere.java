package projetBank;

public class CompteRemunere extends Compte implements ICompteRemunere{
	protected static double taux;

	public CompteRemunere(){
		this(-1,0,0);
	}

	public CompteRemunere(int unNum,double unSoldeInit,double unTaux){
		super(unNum,unSoldeInit);
		this.numero = unNum;
		this.taux = unTaux;
	}

	public double getTaux(){
		return this.taux;
	}

	public void setTaux(double taux){
		if((taux < 0) || (taux >1)){
			throw new IllegalArgumentException("Le taux doit etre entre 0 et 1");
		}
		this.taux = taux;
	}

	public double calculerInterets(){
		return super.getSolde() * this.getTaux();
	}

	public void verserInterets(){
		super.ajouter(this.calculerInterets());
	}

	public String toString(){
		return super.toString() + "taux = " + this.getTaux();
	}

}
