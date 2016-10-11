package projetBank;

import java.util.Arrays;

public class Client {

	protected static int compteur = 0;
	
	protected String nom, prenom;
	protected int age, numero;
	protected Compte[] tabCompte = new Compte[5];
	
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
		this.tabCompte = new Compte[5];
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
	
	public Compte[] getComptes() {
		return this.tabCompte;
	}

	
	@Override
	public String toString() {
		StringBuilder client = new StringBuilder();
		
		client
			.append("Client :\n\t nom ").append(nom)
		    .append("\n\t prenom ").append(prenom)
		    .append("\n\t age ").append(age)
		    .append("\n\t numero ").append(numero)
		    .append("\n\t comptes ").append(Arrays.toString(tabCompte))
		    .append("");
		
		return client.toString();
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
		if (!Arrays.equals(tabCompte, other.tabCompte))
			return false;
		return true;
	}

	
	
	
}
