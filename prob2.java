class Masina{
    private String numarInmatriculare;
    private int litrii;

    public Masina(String numarInmatriculare, int litrii){
        this.numarInmatriculare=numarInmatriculare;
        this.litrii=litrii;
    }

    public int getLitrii(){
        return litrii;
    }

    public String getNumarInmatriculare(){
        return numarInmatriculare;
    }
}


class Benzinarie{
    private int litriiBenzinarie;
    private Masina[] coadaMasini=new Masina[10];
    private int numarMasini;

    public boolean alimenteazaMasina(Masina masina){
        if(litriiBenzinarie>=masina.getLitrii()){
            litriiBenzinarie=litriiBenzinarie-masina.getLitrii();
            return true;
        }else{
            if(numarMasini<coadaMasini.length){
                coadaMasini[numarMasini]=masina;
                numarMasini++;
                return true;
            }
        }
        return false;
    }    

    public String toString(){
        String aux="Coada benzinarie: ";
        for(int i=0; i<numarMasini; i++){
            aux=aux+coadaMasini[i].getNumarInmatriculare()+" - "+coadaMasini[i].getLitrii()+ "; ";
        }
        return aux;
    }

    public void alimenteazaBenzinarie(int litriiNoi){
        litriiBenzinarie=litriiBenzinarie+litriiNoi;
        if(numarMasini>0){
            for(int i=0; i<numarMasini; i++){
                while(coadaMasini[i].getLitrii()<=litriiBenzinarie){
                alimenteazaMasina(coadaMasini[i]);
                Masina aux=coadaMasini[i];
                for(int j=i; j<numarMasini-1; j++){
                    coadaMasini[j]=coadaMasini[j+1];
                }
                coadaMasini[coadaMasini.length-1]=null;
                numarMasini--;
                }
            }
        }
    }
}

class Main{
    public static void main(String[] args){
        Benzinarie benzinarie=new Benzinarie();
        Masina masina1=new Masina("BANANE", 5);
        Masina masina2=new Masina("MERE", 10);
        Masina masina3=new Masina("PERE", 15);
        benzinarie.alimenteazaMasina(masina1);
        benzinarie.alimenteazaMasina(masina2);
        benzinarie.alimenteazaMasina(masina3);
        System.out.print(benzinarie);
        benzinarie.alimenteazaBenzinarie(15);
        System.out.print(benzinarie);
    }
}