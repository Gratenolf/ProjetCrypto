package projetcrypto;

public class TestProjet {
    public static void main(String args[]){
        Carte jeuDeCarte[];
        char lettres[];
        char clefDeBase[];
        char clefCourante[];
        jeuDeCarte = new Carte[54];
        int val[] = new int[54];
        System.out.println("");
        for(int i = 0; i < 54; i++){
            val[i] = i + 1;
            System.out.print(val[i] + " ");
        }
        System.out.println("");
        int k = 0;
        while(k != 54){
            int rnd = (int) (Math.random() * 54)+1;
            if(val[rnd-1] != 0){
                jeuDeCarte[k] = new Carte(rnd);
                System.out.print(jeuDeCarte[k].getElement()+ " ");
                k++;
                val[rnd-1] = 0;
            }
        }
        System.out.println(" \n Tableau généré");
        for(int i = 0; i < 54; i++)
            System.out.print(jeuDeCarte[i].getValeur() + " ");
        System.out.println("\n");
        for(int i = 0; i < 54; i++)
            System.out.print(jeuDeCarte[i].getElement()+ " ");
        System.out.println("\n");
        CinqEtapes A = new CinqEtapes(jeuDeCarte);
        System.out.println("");
        
        boolean redo = false;
        do{
            A.Etape1();
            String affichageEtape1 = A.toString();
            System.out.println(" Etape 1 : "+affichageEtape1);



            A.Etape2();
            String affichageEtape2 = A.toString();
            System.out.println(" Etape 2 : "+affichageEtape2);

            A.Etape3();
            String affichageEtape3 = A.toString();
            System.out.println(" Etape 3 : "+affichageEtape3);
            System.out.println("");
            A.Etape4();
            System.out.println("\n \n Etape 5 : ");
            redo=A.Etape5();
        }while(redo == true); //Recommence tant que la carte trouvé à l'étape 5 est un joker
    }
}
