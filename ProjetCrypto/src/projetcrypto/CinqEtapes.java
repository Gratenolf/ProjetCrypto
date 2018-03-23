package projetcrypto;

public class CinqEtapes {
    private Carte[] jeuDeCartes;
    private char[] lettres;
    private char[] clefDeBase;
    private char[] clefCourante;
    private String messCrypt;
    private int ltIndiceCourant;
    private int[] messCryptInt;
    
    //Initialisation des tableaux
    public CinqEtapes(Carte[] cartes){
        jeuDeCartes = new Carte[54];
        lettres = new char[54];
        messCrypt = "";
        ltIndiceCourant = 0;
        messCryptInt = new int[54]; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //System.out.println("Tableau Recopier ");
        for(int i = 0;i < 54;i++){
            jeuDeCartes[i] = cartes[i];
            //System.out.print(jeuDeCartes[i].getValeur()+" ");
        }
        //System.out.println("\n");
        for(int j = 0;j < 54;j++){
            lettres[j] = 'a';
        }
    }
    
    public char[] getLettres(){
        return lettres;
    }
    
    public String getMessCrypt(){
        return messCrypt;
    }
    
    public int[] getMessCryptInt(){
        return messCryptInt;
    }
    
    
    //Retourne la position du joker noir
    public int Batman(){
        int position=-1;
        for(int i = 0;i < 54;i++)
        {
            if(jeuDeCartes[i].getValeur() == 53){
                if(jeuDeCartes[i].getElement().equals("Noir")){
                    position = i;
                }
            }
        }
        return position;
    }
    
    //Retourne la position du joker rouge
    public int Robin(){
        int position = -1;
        for(int i = 0;i < 54;i++)
        {
            if(jeuDeCartes[i].getValeur() == 53 && jeuDeCartes[i].getElement().equals("Rouge"))
                position = i;
        }
        return position;
    }
    
    //Echange la carte à la position posA avec celle à la position posB dans le tableau jeuDeCartes
    public void EchangeCartes(int posA,int posB){
        //System.out.println(""+jeuDeCartes[posA].getValeur());
        Carte tempo = new Carte(jeuDeCartes[posA].getValeur());
        tempo=jeuDeCartes[posA];
        jeuDeCartes[posA] = jeuDeCartes[posB];
        jeuDeCartes[posB] = tempo;
    }
    
    //Recule d'une case le joker noir
    public void Etape1(){
        //Recul JokerNoir 1 case
        int posJokerNoir = Batman();
        //System.out.println(""+posJokerNoir);
        if(posJokerNoir == -1) System.out.println("Erreur Etape1 Joker Noir non trouvé");
        else{
            if(posJokerNoir == 53)//Verifier si jokerNoir en dernière position
                EchangeCartes(posJokerNoir,2);
            else
                EchangeCartes(posJokerNoir,posJokerNoir+1);
        }
    }
    
    //Recule de deux case le joker rouge
    public void Etape2(){
        int posJokerRouge = Robin();
        if(posJokerRouge == 53)//Verifier si jokerRouge en dernière position
            EchangeCartes(posJokerRouge,3);
        else if(posJokerRouge == 52)//Verifier si jokerRouge en avant-dernière position
            EchangeCartes(posJokerRouge,2);
        else
            EchangeCartes(posJokerRouge,posJokerRouge+2);
        //Recul JokerRouge 2 cases
    }
    
    public void Etape3(){
        //Repérage 2 jokers 
        int posJokerNoir = Batman();
        int posJokerRouge = Robin();
        int vartempo = 0;
        
        int posJokerInf = Math.min(posJokerNoir,posJokerRouge);
        int posJokerSup = Math.max(posJokerNoir,posJokerRouge);
        
        //System.out.println("Indice Joker Inf : "+posJokerInf);
        //System.out.println("Indice Joker Sup : "+posJokerSup);
        Carte[] tabtempo = new Carte[54];
        for(int i = 0;i < 54;i++){
            if(i == posJokerInf||i == posJokerSup+1){
                vartempo = 0;
                //System.out.println("Reset vartempo");
            }
            if(i < posJokerInf){
                tabtempo[tabtempo.length-(posJokerInf)+vartempo] = jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[tabtempo.length-(posJokerInf)+vartempo].getValeur());
                //System.out.println("");
                //System.out.println("Tableau - Joker Bas "+ (tabtempo.length-(posJokerInf)+vartempo));
            }
            else if(i <= posJokerSup){
                tabtempo[tabtempo.length-(posJokerSup+1)+vartempo] = jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[tabtempo.length-(posJokerSup)+vartempo].getValeur());
                //System.out.println("");
                //System.out.println("Tableau - JokerHaut "+ (tabtempo.length-(posJokerSup+1)+vartempo));
            }
            else{
                tabtempo[vartempo] = jeuDeCartes[i];
                //System.out.print("getvaleur "+tabtempo[vartempo].getValeur());
                //System.out.println("");
                //System.out.print(" "+vartempo);
            }
            vartempo += 1;
        }
        /*System.out.print("\n Tableau tempo A Etape 3 \n");
        for(int j = tabtempo.length-(posJokerInf);j <= 53;j++){
            
            System.out.print(" "+tabtempo[j].getValeur()+"("+j+")");
        }
        System.out.println("");
        
        System.out.print("\n Tableau tempo B Etape 3 \n");
        for(int k = tabtempo.length-(posJokerSup)-1;k < tabtempo.length-(posJokerInf);k++){
            
            System.out.print(" "+tabtempo[k].getValeur()+"("+k+")");
        }
        System.out.println("");
        
        System.out.print("\n Tableau tempo C Etape 3 \n");
        for(int k = 0;k < tabtempo.length-(posJokerSup)-1;k++){
            
            System.out.print(" "+tabtempo[k].getValeur());
        }
        System.out.println("\n");
        
        System.out.println("Etape 3 tableau tempo complet");
        for(int l = 0;l < 54;l++)
            System.out.print(" "+tabtempo[l].getValeur());
        System.out.println("\n");
        
        System.out.println("Tableau tempo recopier dans tableau jeuDeCartes");*/
        for(int m = 0;m < 54;m++){
            jeuDeCartes[m] = tabtempo[m];
            //System.out.print(jeuDeCartes[m].getValeur()+" ");
        }
        //System.out.println("\n");
    }
    
    public int RechnbCarte(int carteRech){
        String Elem = jeuDeCartes[carteRech].getElement();
        String nomElem = jeuDeCartes[carteRech].getNom();
        int nbCarte = 0;
        switch (Elem) {
            case "Trefle":
                //1-13
                //System.out.println("Trefle"+" "+nomElem);
                if(!nomElem.equals("A") && !nomElem.equals("J") && !nomElem.equals("Q") && !nomElem.equals("K") )
                    nbCarte = Integer.parseInt(nomElem);
                else
                    if(nomElem.equals("J"))
                        nbCarte = 11;
                    else if(nomElem.equals("Q"))
                        nbCarte = 12;
                    else if(nomElem.equals("K"))
                        nbCarte = 13;
                    else if(nomElem.equals("A"))
                        nbCarte = 1;
                break;
            case "Carreau":
                //14-26
                //System.out.println("Carreau"+" "+nomElem);
                if(!nomElem.equals("A") && !nomElem.equals("J") && !nomElem.equals("Q") && !nomElem.equals("K"))
                    nbCarte=13+Integer.parseInt(nomElem);
                else
                    if(nomElem.equals("J"))
                        nbCarte = 13 + 11;
                    else if(nomElem.equals("Q"))
                        nbCarte = 13 + 12;
                    else if(nomElem.equals("K"))
                        nbCarte = 13 + 13;
                    else if(nomElem.equals("A"))
                        nbCarte = 13 + 1;
                break;
            case "Coeur":
                //27-39
                //System.out.println("Coeur"+" "+nomElem);
                if(!nomElem.equals("A") && !nomElem.equals("J") && !nomElem.equals("Q") && !nomElem.equals("K"))
                    nbCarte = 26 + Integer.parseInt(nomElem);
                else
                    if(nomElem.equals("J"))
                        nbCarte = 26 + 11;
                    else if(nomElem.equals("Q"))
                        nbCarte = 26 + 12;
                    else if(nomElem.equals("K"))
                        nbCarte = 26 + 13;
                    else if(nomElem.equals("A"))
                        nbCarte = 26 + 1;
                break;
            case "Pique":
                //40-52
                //System.out.println("Pique"+" "+nomElem);
                if(!nomElem.equals("A") && !nomElem.equals("J") && !nomElem.equals("Q") && !nomElem.equals("K"))
                    nbCarte = 39 + Integer.parseInt(nomElem);
                else
                    if(nomElem.equals("J"))
                        nbCarte = 39 + 11;
                    else if(nomElem.equals("Q"))
                        nbCarte = 39 + 12;
                    else if(nomElem.equals("K"))
                        nbCarte = 39 + 13;
                    else if(nomElem.equals("A"))
                        nbCarte = 39 + 1;
                break;
            default:
                nbCarte = 53;
                break;
        }
        return nbCarte;
    }
    
    public void Etape4(){
        String Elem = jeuDeCartes[53].getElement();
        String nomElem = jeuDeCartes[53].getNom();
        int nbCarte=0;
        Carte[] tabtempo = new Carte[54];
        
        nbCarte=RechnbCarte(53);
        
        int incDebTab = 0;
        int incFinTab = 1;
        for(int i = 0;i < 54;i++){
            
            if(i == 0){
                tabtempo[i] = jeuDeCartes[0];
            }
            if (i >= 1 && i <= nbCarte){
                tabtempo[i] = jeuDeCartes[jeuDeCartes.length-nbCarte+incDebTab];
                incDebTab++;
            }
            if(i>nbCarte){
                tabtempo[i] = jeuDeCartes[incFinTab];
                incFinTab++;
            }
        }
        /*System.out.println("Tableau temporaire Etape 4");
        for(int j = 0;j < 54;j++){
            System.out.print(" "+tabtempo[j].getValeur());
            
        }
        System.out.println("\n");
        System.out.println("Tableau tempo recopier dans tableau jeuDeCartes");*/
        for(int m = 0;m < 54;m++){
            jeuDeCartes[m] = tabtempo[m];
            //System.out.print(jeuDeCartes[m].getValeur()+" ");
        }
        
    }
    
    public boolean Etape5(){
        int n = RechnbCarte(0);
        //System.out.println("Numero Première Carte n "+n);
        if(n == 54)
            n = 1;
        int m = RechnbCarte(n);
        char lettre = 'A';
        lettre -= 1;
        boolean redo = false;
        //System.out.println("Numero Carte trouvé m "+m);
        if(m == 53)
            redo=true;//Refaire Etape 1/2/3/4/5
        else if(m > 26){
            m -= 26;
            for(int i = 0;i < m;i++)
                lettre += 1;
            //System.out.println("Lettre associee "+lettre);
            if(ltIndiceCourant < lettres.length){
                redo = true;
                lettres[ltIndiceCourant]=lettre;
                ltIndiceCourant = ltIndiceCourant + 1;
            }
        }
        else{
            for(int i = 0;i < m;i++)
                lettre += 1;
            //System.out.println("Lettre associee "+lettre);
            if(ltIndiceCourant < lettres.length){
                redo = true;
                lettres[ltIndiceCourant]=lettre;
                ltIndiceCourant = ltIndiceCourant + 1;
            }
        }
        if(!redo)
            ltIndiceCourant = 0;           
        return redo;
    }
    
    public void CodageDecodage(String message, String clef, boolean codage){
        if(message.length() < clef.length()){
            messCrypt="";
            int tabMess[] = new int[message.length()];
            int tabClef[] = new int[clef.length()];
            int messageCrypt[] = new int[message.length()];
            String messUperCase="";
            String clefUperCase="";
            
            messUperCase = message.toUpperCase();
            clefUperCase = clef.toUpperCase();
            
            //System.out.println("UPPER CASE MESS "+messUperCase);
            //System.out.println("UPPER CASE CLEF "+clefUperCase);
            
            //Conversion message(string) en int
            for(int i = 0;i < messUperCase.length();i++)
                tabMess[i] = (int)messUperCase.charAt(i)-64;
            
            //Conversion clef(string) en int
            for(int j = 0;j < clefUperCase.length();j++)
                tabClef[j] = (int)clefUperCase.charAt(j)-64;
                    
            /*for(int k = 0;k < message.length();k++)
                System.out.print(tabMess[k]);
            System.out.println("\n Fin message entier");
            for(int l = 0;l < clef.length();l++)
                System.out.print(tabClef[l]);
            System.out.println("\n Fin clef entier");*/
            
            if(codage){
                //System.out.println("codage");
                for(int m = 0;m < message.length();m++){
                    if(tabMess[m] + tabClef[m] > 26)
                        messageCrypt[m] = (tabMess[m] + tabClef[m]) - 26;
                    else
                        messageCrypt[m] = (tabMess[m] + tabClef[m]);
                }
            }
            else{
                //System.out.println("decodage");
                for(int n = 0;n < message.length();n++){
                    if(tabMess[n] - tabClef[n] < 1)
                        messageCrypt[n] = (tabMess[n] - tabClef[n]) + 26;
                    else
                        messageCrypt[n] = (tabMess[n] - tabClef[n]);
                }
            }
            
            messCryptInt = new int[messageCrypt.length];
            //System.out.println("messageCrypt INT");
            for(int o = 0;o < messageCrypt.length;o++){
                messCrypt += Character.toString((char)(messageCrypt[o] + 64));
                messCryptInt[o] = messageCrypt[o];
            }
            //String.valueOf(messageCrypt[o]);
            //convertir messageCrypt en string
            
            /*System.out.println("");
            
            for(int p = 0;p < messageCrypt.length;p++)
                System.out.print(messageCrypt[p]);
            
            System.out.println("\n");
            
            System.out.println("message crypt de l'instance CinqEtapes "+messCrypt);*/

        }
    }
    
    public String toString(){
        String res="";
        //for(int i=0;i<lettres.length;i++)
        //    res+=lettres[i];
        
        res+=" \n ";
        for(int i = 0;i < jeuDeCartes.length;i++){
            res += jeuDeCartes[i].getValeur();
            res += " ";
        }
        
        return res;
    }
    
}
