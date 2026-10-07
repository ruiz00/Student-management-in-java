import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    private static final ArrayList<Etudiant> listeEtudiants = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean continuer = true;
        while (continuer){
            afficherMenu();
            int choix = lireEntier("Entrew votre choix: ");

            switch (choix){
                case 1 :
                    ajouterEtudiant();
                    break;
                case 2 :
                    listerEtudiants();
                    break;
                case 3 : 
                    modifierEtudiant();
                    break;
                case 4 :
                    supprimerEtudiant();
                    break;
                case 5 :
                    System.out.println("Exiting....");
                    continuer = false;
                    break;
                default :
                    System.out.println("Choix invalid, Entrez une option entre 1 et 5");
            }
        }
        scanner.close();
    }
    
private static void afficherMenu(){
    System.out.println("Bienvenue sur le gestionnaire d'etudiants");
    System.out.println("1. Ajouter un etudiant");
    System.out.println("2. Lister tous les etudiants");
    System.out.println("3. Modifier un etudiant");
    System.out.println("4. Supprimer un etudiant");
    System.out.println("5. Quitter l'application");

}

private static void ajouterEtudiant(){
    System.out.println("Ajouter un Etudiant ");
    int id = lireEntier("ID: ");
    
    if(trouverParId(id) != null){
        System.out.println("un etudiant possede deja cette ID");
        return;
    }
    System.out.println("Nom: ");
    String nom = scanner.nextLine();

    System.out.println("Prenom: ");
    String prenom = scanner.nextLine();

    double moyenne = lireDouble("Moyenne: ");

    listeEtudiants.add(new Etudiant(id,nom,prenom,moyenne));
    System.out.println("Etudiant ajoute");
}
/**
 *  fonction pour ajouter un etudiant dans listeEtudiant
 * on fais quelque check pour les verifier les entree sur 
 * et on verifie aussi si un etudiant ne possede pas deja un id pour le nouvel etudiant 
 * qu'on veut ajouter
 * 
 */

private static void listerEtudiants(){
    System.out.println("La liste des etudiants ");
    if(listeEtudiants.isEmpty()){
        System.out.println("Aucun etudiant enregistre");
        System.out.printf("\n");
        return;
    }
    for (Etudiant etudiant : listeEtudiants){
        System.out.println(etudiant);
    }
}

private static void modifierEtudiant(){
    System.out.println("Modifier un etudiant");
    int id = lireEntier("Entrew l'id de l'etudiant a modifier");
    
    Etudiant e = trouverParId(id);
    if (e == null){
        System.out.println("Etudiant introvable");
        return;
    }
    System.out.println("Etudiant actual: " + e);
    System.out.println("Nouveau nom (laissez vide pour conserver): ");
    String nouveauNom = scanner.nextLine();
    if(!nouveauNom.trim().isEmpty()){
        e.SetNom(nouveauNom);
    }

    
    System.out.println("Nouveau prenom (laissez vide pour conserver): ");
    String nouveauPrenom = scanner.nextLine();
    if(!nouveauPrenom.trim().isEmpty()){
        e.SetPrenom(nouveauPrenom);
    }


    System.out.println("Nouvelle moyenne (-1 pour conserver): ");
    double nouvelleMoyenne = lireDouble("");
    if(nouvelleMoyenne >=0){
        e.setMoyenne(nouvelleMoyenne);
    }

    System.out.println("Etudiant mis a jour avec succes");
}

private static void supprimerEtudiant(){
    System.out.println("Supprimer un etudiant");

    int id = lireEntier("Entrez l'id de l'etudiant a supprimer: ");
    
    Etudiant e = trouverParId(id);
    if (e == null){
        System.out.println("Etudiant introuvable");
        return;
    }
    listeEtudiants.remove(e);
    System.out.println("Etudiant supprime avec succes");
}

private static Etudiant trouverParId(int id){
    for (Etudiant e : listeEtudiants){
        if (e.getId() == id){
            return e;
        }
    }
    return null;
}

private static int lireEntier(String prompt){
    while(true){
        try{
            System.out.print(prompt);
            int valeur = Integer.parseInt(scanner.nextLine());
            return valeur;
        }catch (NumberFormatException e){
            System.out.println("Entrez un nombre entier valide");
        }
    }
}

private static double lireDouble(String prompt){
    while(true){
        try{
            System.out.print(prompt);
            double valeur = Double.parseDouble(scanner.nextLine());
            return valeur;
        }catch (NumberFormatException e){
            System.out.println("Entre un nombre decimale valide");
        }
    }
    }
}