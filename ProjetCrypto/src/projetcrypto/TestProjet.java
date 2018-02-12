package projetcrypto;

public class TestProjet {
    public static void main(String args[]){
        Carte jeuDeCarte[];
        char lettres[];
        char clefDeBase[];
        char clefCourante[];
        jeuDeCarte = new Carte[54];
        int val[] = new int[54];
        for(int i = 0; i < 54; i++)
            val[i] = i + 1;
        
        int k = 0;
        while(k != 54){
            int rnd = (int) (Math.random() * 54);
            if(val[rnd] != 0){
                jeuDeCarte[k] = new Carte(rnd);
                k++;
                val[rnd] = 0;
            }
        }
        for(int i = 0; i < 54; i++)
            System.out.print(jeuDeCarte[i].getValeur() + " ");
    }
}
