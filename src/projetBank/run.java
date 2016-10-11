package projetBank;

import projetBank.Client;
import projetBank.Compte;
import projetBank.CompteASeuil;
import projetBank.CompteRemunere;
import projetBank.ICompteASeuil;
import projetBank.ICompteRemunere;
import projetBank.BanqueException;

public class run {

	public static void main(String[] args) throws BanqueException {
		
		Client client = new Client("Albert","Dupontel",28,1);
		
		Compte A1 = new Compte(0,200);
		Compte A2 = new Compte(1,1000);
		CompteASeuil A3 = new CompteASeuil(2,400,100);
		CompteRemunere A4 = new CompteRemunere(3,400,0.10);
		CompteRemunere A5 = new CompteRemunere(4,600,0.50);
		
		try{
		client.ajouterCompte(A1);
		client.ajouterCompte(A2);
		client.ajouterCompte(A3);
		client.ajouterCompte(A4);
		client.ajouterCompte(A5);
		}
		catch(BanqueException e){
			e.printStackTrace();
		}
		System.out.println(client);
		
		try{
		client.getCompte(2).retirer(500);
		System.out.println("On ne verra jamais ce texte");
		}
		catch(BanqueException e){
			e.printStackTrace();
		}
		System.out.println(A3);
		A4.verserInterets();
		System.out.println(A3);
		
		CompteASeuil Ic = new CompteASeuil(50,200,50);
		
		((Compte) Ic).getSolde();
		
		Compte c = new CompteASeuil(50,200,50);
		c.getSolde();
		((CompteASeuil) c).getSeuil();
		
		Compte[] cpt = client.getComptes();
		for(int i = 0; i < cpt.length;i++){
			Compte compte = cpt[i];
			
			if(compte instanceof ICompteRemunere){
				((ICompteRemunere) compte).verserInterets();
			}
		}
	}

}
