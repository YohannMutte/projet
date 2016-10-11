package projetBank;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil{
	protected double seuil;

	public CompteASeuilRemunere(){
		this(-1,0,0,0);
	}

	public CompteASeuilRemunere(int unNumero, double unSoldeInitial, double unTaux, double unSeuil) {
		super(unNumero, unSoldeInitial, unTaux);
		this.setSeuil(unSeuil);
	}

	@Override//recupere la seuil
	public double getSeuil() {
		return this.seuil;
	}

	@Override//modifie la valeur du seuil
	public void setSeuil(double unSeuil) {
		this.seuil = unSeuil;

	}

	public String toString(){
		return super.toString() + "seuil = " + this.getSeuil();
	}

	@Override
	public void retirer(double unMontant) throws BanqueException {
		double simu = this.getSolde() - unMontant;
		if (simu <= this.getSeuil()) {
			throw new BanqueException("Votre seuil de " + this.getSeuil() + " ne vous permet pas de retirer "
					+ unMontant + " de votre compte " + this.getNumero());
		} else {
			super.retirer(unMontant);
		}
	}
}
