package projetBank;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {

	protected static int compteur = 0;
	
	protected String nom, prenom;
	protected int age, numero;
	protected ArrayList<Compte> tabCompte;
	
	public Client() {
		this("", "", 0, 0);
	}
	
	public Client(String nom, String prenom) {
		this(nom, prenom, 0, 0);
	}
	
	public Client(String nom, String prenom, int age, int numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.numero = numero;
		this.tabCompte = new ArrayList<Compte>();
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int unAge){
		this.age = unAge;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String unNom){
		this.nom = unNom;
	}
	
	public String getprenom(){
		return this.prenom;
	}
	
	public void setPrenom(String unPrenom){
		this.nom = unPrenom;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void setNumero(int unNum){
		this.numero = unNum;
	}
	
	public ArrayList<Compte> getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(ArrayList<Compte> tabCompte) {
		this.tabCompte = tabCompte;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Client [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", age=");
		builder.append(age);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", tabCompte=");
		builder.append(tabCompte);
		builder.append("]");
		
		return builder.toString();
	}
	
	public void ajouterCompte(Compte cpt) throws BanqueException{
		boolean ajoute = false;
		
		for (int i = 0; i < this.tabCompte.length; i++) {
			if(this.tabCompte[i] == null) {
				this.tabCompte[i] = cpt;
				ajoute = true;
				break;
			}
		}
		//si on a parcouru la liste sans y ajouter de compte alors:
		if(!ajoute){
			throw new BanqueException("Plus de place dans le tableau");
		}
	}
	
	public Compte getCompte(int numeroCompte){
		for (int i = 0 ; i < this.tabCompte.length; i++) {
			if( this.tabCompte[i].getNumero() == numeroCompte ) {
				return this.tabCompte[i];
			}
		}
		
		return null;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (tabCompte == null) {
			if (other.tabCompte != null)
				return false;
		} else if (!tabCompte.equals(other.tabCompte))
			return false;
		return true;
	}


	



	

	
	
	
}
