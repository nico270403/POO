class Angajat{
    private String nume;
    private int salariu;

    public Angajat(String nume, int salariu){
        this.nume=nume;
        this.salariu=salariu;
    }

    public String getNume(){
        return nume;
    }

    public int getSalariu(){
        return salariu;
    }
}

class Firma{
    private String numeFirma;
    private int buget;
    private Angajat[] angajati=new Angajat[30];
    private int numarAngajati;

    public Firma(String numeFirma, int buget){
        this.numeFirma=numeFirma;
        this.buget=buget;
    }

    public boolean adaugaAngajat(Angajat angajatNou){
        if(numarAngajati<angajati.length){
            for(int i=0; i<numarAngajati; i++){
                if(angajati[i].getNume().equals(angajatNou.getNume()) && angajati[i].getSalariu()==angajatNou.getSalariu()){
                    return false;
                }
            }
            angajati[numarAngajati]=angajatNou;
            numarAngajati++;
            return true;
        }
        return false;
    }

    public String toString(){
        String aux=numeFirma+": ";
        for(int i=0; i<numarAngajati; i++){
            aux=aux+"< " + angajati[i].getNume() + " > - < " + angajati[i].getSalariu()+" > ";
        }
        return aux;
    }

    public void platesteSalarii(){
        int sumaSalarii=0;
        for(int i=0; i<numarAngajati; i++){
            sumaSalarii=sumaSalarii+angajati[i].getSalariu();
        }
        buget=buget-sumaSalarii;
    }

    public int getBuget(){
        return buget;
    }

}


class Main{
    public static void main(String[] args){
        Firma firma=new Firma("Nokia", 100);
        Angajat angajat1=new Angajat("Alin", 20);
        Angajat angajat2=new Angajat("Maria", 30);
        Angajat angajat3=new Angajat("Laura", 40);
        firma.adaugaAngajat(angajat1);
        firma.adaugaAngajat(angajat2);
        firma.adaugaAngajat(angajat3);
        firma.adaugaAngajat(angajat1);
        System.out.println(firma);
        firma.platesteSalarii();
        System.out.println(firma.getBuget());


    }
}