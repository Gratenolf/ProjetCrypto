/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcrypto;

/**
 *
 * @author ah154489
 */
public class CinqEtapes {
    private Carte[] jeuDeCartes;
    private char[] lettres;
    private char[] clefDeBase;
    private char[] clefCourante;
    
    //Initialisation des tableaux
    public CinqEtapes(Carte[] cartes){
        jeuDeCartes = new Carte[54];
        lettres = new char[26];
        System.out.println("Tableau Recopier ");
        for(int i=0;i<54;i++){
            jeuDeCartes[i] = cartes[i];
            System.out.print(jeuDeCartes[i].getValeur()+" ");
        }
        System.out.println("\n");
        for(int j=0;j<26;j++){
            lettres[j]=(char)('a'+j);
        }
    }
    
    //Retourne la position du joker noir
    public int Batman(){
        int position=-1;
        for(int i=0;i<54;i++)
        {
            if(jeuDeCartes[i].getValeur()==53){
                if(jeuDeCartes[i].getElement().equals("Noir")){
                    position=i;
                }
            }
        }
        return position;
    }
    
    //Retourne la position du joker rouge
    public int Robin(){
        int position=-1;
        for(int i=0;i<54;i++)
        {
            if(jeuDeCartes[i].getValeur()==53 && jeuDeCartes[i].getElement().equals("Rouge"))
                position=i;
        }
        return position;
    }
    
    //Echange la carte à la position posA avec celle à la position posB dans le tableau jeuDeCartes
    public void EchangeCartes(int posA,int posB){
        //System.out.println(""+jeuDeCartes[posA].getValeur());
        Carte tempo = new Carte(jeuDeCartes[posA].getValeur());
        tempo=jeuDeCartes[posA];
        jeuDeCartes[posA]=jeuDeCartes[posB];
        jeuDeCartes[posB]=tempo;
    }
    
    //Recule d'une case le joker noir
    public void Etape1(){
        //Recul JokerNoir 1 case
        int posJokerNoir = Batman();
        //System.out.println(""+posJokerNoir);
        if(posJokerNoir==-1) System.out.println("Erreur Etape1 Joker Noir non trouvé");
        else{
            if(posJokerNoir==53)//Verifier si jokerNoir en dernière position
                EchangeCartes(posJokerNoir,2);
            else
                EchangeCartes(posJokerNoir,posJokerNoir+1);
        }
    }
    
    //Recule de deux case le joker rouge
    public void Etape2(){
        int posJokerRouge = Robin();
        if(posJokerRouge==53)//Verifier si jokerRouge en dernière position
            EchangeCartes(posJokerRouge,3);
        else if(posJokerRouge==52)//Verifier si jokerRouge en avant-dernière position
            EchangeCartes(posJokerRouge,2);
        else
            EchangeCartes(posJokerRouge,posJokerRouge+2);
        //Recul JokerRouge 2 cases
    }
    
    public void Etape3(){
        //Repérage 2 jokers 
        int posJokerNoir = Batman();
        int posJokerRouge = Robin();
        int vartempo=0;
        
        int posJokerInf=Math.min(posJokerNoir,posJokerRouge);
        int posJokerSup=Math.max(posJokerNoir,posJokerRouge);
        
        System.out.println("Indice Joker Inf : "+posJokerInf);
        System.out.println("Indice Joker Sup : "+posJokerSup);
        Carte[] tabtempo = new Carte[54];
        for(int i=0;i<54;i++){
            if(i==posJokerInf||i==posJokerSup+1){
                vartempo=0;
                //System.out.println("Reset vartempo");
            }
            if(i<posJokerInf){
                tabtempo[tabtempo.length-(posJokerInf)+vartempo]=jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[tabtempo.length-(posJokerInf)+vartempo].getValeur());
                //System.out.println("");
                //System.out.println("Tableau - Joker Bas "+ (tabtempo.length-(posJokerInf)+vartempo));
            }
            else if(i<=posJokerSup){
                tabtempo[tabtempo.length-(posJokerSup+1)+vartempo]=jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[tabtempo.length-(posJokerSup)+vartempo].getValeur());
                //System.out.println("");
                //System.out.println("Tableau - JokerHaut "+ (tabtempo.length-(posJokerSup+1)+vartempo));
            }
            else{
                tabtempo[vartempo]=jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[vartempo].getValeur());
                //System.out.println("");
                //System.out.print(" "+vartempo);
            }
            vartempo+=1;
        }
        System.out.print("\n Tableau A Etape 3 \n");
        for(int j=tabtempo.length-(posJokerInf);j<=53;j++){
            
            System.out.print(" "+tabtempo[j].getValeur()+"("+j+")");
        }
        System.out.println("");
        
        System.out.print("\n Tableau B Etape 3 \n");
        for(int k=tabtempo.length-(posJokerSup)-1;k<tabtempo.length-(posJokerInf);k++){
            
            System.out.print(" "+tabtempo[k].getValeur()+"("+k+")");
        }
        System.out.println("");
        
        System.out.print("\n Tableau C Etape 3 \n");
        for(int k=0;k<tabtempo.length-(posJokerSup)-1;k++){
            
            System.out.print(" "+tabtempo[k].getValeur());
        }
        System.out.println("");
        
        System.out.println("Etape 3 Complet");
        for(int l=0;l<54;l++)
            System.out.print(" "+tabtempo[l].getValeur());
        System.out.println("");
    }
    
    public void Etape4(){
        
    }
    
    public void Etape5(){
        
    }
    
    public String toString(){
        String res="";
        //for(int i=0;i<lettres.length;i++)
        //    res+=lettres[i];
        
        res+=" \n ";
        for(int i=0;i<jeuDeCartes.length;i++){
            res+=jeuDeCartes[i].getValeur();
            res+=" ";
        }
        
        return res;
    }
    
}
