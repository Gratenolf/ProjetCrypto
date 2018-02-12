package projetcrypto;

public class Carte {
    private static final int N = 13;
    private int num;
    private String nom;
    private int valeur;
    private String element;
    private String[] nomElem = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
    public Carte(int valeur){
        this.valeur = valeur;
        if(valeur > 52){
            this.num = 53;
            this.nom = "Joker";
            if(valeur == 53)
                this.element = "Rouge";
            else
                this.element = "Noir";
        }
        else{
            if(valeur % N == 0)
                this.num = N;
            else
                this.num = valeur % N;
            this.nom = nomElem[this.num - 1];
            int valtmp = ((this.valeur - (this.valeur % N)) / N);
            switch(valtmp){
                case 0 : this.element = "Trefle";break;
                case 1 : this.element = "Carreau";break;
                case 2 : this.element = "Coeur";break;
                case 3 : this.element = "Pique";break;
            }
        }
    }
    
    public int getNum(){
        return this.num;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public int getValeur(){
        return this.valeur;
    }
    
    public String getElement(){
        return this.element;
    }
}