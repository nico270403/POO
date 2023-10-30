class Card{
    private String numar;
    private double sold;

    public Card(String numar, double sold){
        this.numar=numar;
        this.sold=sold;
    }

    public String getNumarCard(){
        return numar;
    }

    public double getSoldCard(){
        return sold;
    }
    /* 
    public String toString(){
        return numar + " - " + sold;
    }*/


}


class Portofel{
    private String numeProprietar;
    private Card[] carduri=new Card[6];
    private int numarCarduri=0;   //asta e contorul
    
    public Portofel(String numeProprietar){
        this.numeProprietar=numeProprietar;
    }

    public boolean adaugaCard(String numarCard, double soldCard){
        if(numarCarduri<carduri.length){
            for(int i=0; i<numarCarduri; i++){
                if(carduri[i].getNumarCard().equals(numarCard)){
                    return false;
                }
            }
            Card cardNou=new Card(numarCard, soldCard);
            carduri[numarCarduri]=cardNou;
            numarCarduri++;
            return true;
        }
        return false;
    }

    public String toString(){
        String aux="Portofelul " + numeProprietar + ": ";
        for(int i=0; i<numarCarduri; i++){
            aux = aux + carduri[i].getNumarCard() + " - " + carduri[i].getSoldCard() + " ";
        }
        return aux;
    }

    public double calculeazaSold(){
        double soldTotal=0.0;
        for(int i=0; i<numarCarduri; i++){
            soldTotal=soldTotal+carduri[i].getSoldCard();
        }
        return soldTotal;
    }

}

class Main{
    public static void main(String[] args){
        Portofel portofel=new Portofel("Ana");
        portofel.adaugaCard("123",10.10);
        portofel.adaugaCard("456", 20.20);
        portofel.adaugaCard("789", 30.30);
        portofel.adaugaCard("123", 50.50);
        System.out.println(portofel);
        System.out.print("Soldul total este: " + portofel.calculeazaSold());
    }
}