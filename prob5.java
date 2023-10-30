class Jucator{
    private String nume;
    private int numar;

    public Jucator(String nume, int numar){
        this.nume=nume;
        this.numar=numar;
    }


    public boolean equals(Object o){
        if(o instanceof Jucator){
            Jucator jucator=(Jucator) o;
            return this.numar==jucator.numar && this.nume.equals(jucator.nume);
        }
        return false;
    }

    public String toString(){
        return "(< "+nume+" >,< "+numar+" >)";
    }

}

class Echipa{
    private Jucator[] jucatoriRezerva;
    private Jucator[] jucatoriTitulari;

    public Echipa(Jucator[] jucatoriRezerva,Jucator[] jucatoriTitulari){
        this.jucatoriRezerva=jucatoriRezerva;
        this.jucatoriTitulari=jucatoriTitulari;
    }

    public boolean efectueazaSchimbare(Jucator rezerva, Jucator titular){
        for(int i=0; i<jucatoriRezerva.length; i++){
            if(jucatoriRezerva[i].equals(rezerva)){
                for(i=0; i<jucatoriTitulari.length; i++){
                    if(jucatoriTitulari[i].equals(titular)){
                        Jucator aux=jucatoriTitulari[i];
                        jucatoriTitulari[i]=jucatoriRezerva[i];
                        jucatoriRezerva[i]=aux;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString(){
        String aux1="Titulari: ";
        for(int i=0; i<jucatoriTitulari.length; i++){
            aux1=aux1+jucatoriTitulari[i];
        }
        String aux2="Rezerve: ";
        for(int i=0; i<jucatoriRezerva.length; i++){
            aux2=aux2+jucatoriRezerva[i];
        }
        return aux1+"; "+aux2;
    }
}

class Main{
    public static void main(String[] args){
        Jucator titular1=new Jucator("Messi", 10);
        Jucator titular2=new Jucator("Ronaldo", 7);
        Jucator rezerva1=new Jucator("Alin", 13);
        Jucator rezerva2=new Jucator("Paul", 27);

        Jucator[] jucatoriRezerva={rezerva1,rezerva2};
        Jucator[] jucatoriTitulari={titular1, titular2};

        Echipa echipa=new Echipa(jucatoriRezerva, jucatoriTitulari);
        System.out.println(echipa);
        echipa.efectueazaSchimbare(rezerva1, titular1);
        System.out.println(echipa);

    }
}