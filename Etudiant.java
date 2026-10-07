public class Etudiant{
    private int id;
    private String nom;
    private String prenom;
    private double moyenne;


    // contructeur de l'etudiant
    public Etudiant(int id,String nom,String prenom, double moyenne){
        this.id = id;
        this.nom = nom;
        this.prenom= prenom;
        this.moyenne = moyenne;
    }

    public int getId(){
        return id; // getter for id 
    }

    public void setId(int id){
        this.id=id; // setter for id
    }

    public String getNom(){
        return nom;
    }

    public void SetNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void SetPrenom(String prenom){
        this.prenom = prenom;
    }

    public double getMoyenne(){
        return moyenne;
    }

    public void setMoyenne(double moyenne){
        this.moyenne = moyenne;
    }

    @Override
    public String toString(){
        return String.format("ID: %-4d Nom: %-15s Prenom: %-15s Moyenne: %.2f/20", id,nom,prenom,moyenne);
    }
}   

