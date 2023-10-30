class Figura{
    private double arie;

    public Figura(double arie){
        this.arie=arie;
    }

    public double getArie(){
        return arie;
    }

}

class Desen{
    private String titluDesen;
    private Figura[] figuri=new Figura[1024];
    private int numarFiguri;

    public Desen(String titluDesen){
        this.titluDesen=titluDesen;
    }

    public boolean adaugaFigura(Figura figura){
        if(numarFiguri<figuri.length){
            for(int i=0; i<numarFiguri; i++){
                if(figuri[i].getArie()==figura.getArie()){
                    return false;
                }
            }
            figuri[numarFiguri]=figura;
            numarFiguri++;
            return true;
            }
        return false;
    }

    public String toString(){
        String aux="Titlu desen: "+titluDesen;
        for(int i=0; i<numarFiguri; i++){
            aux=aux+"Figura-Arie: "+figuri[i].getArie()+";";
        }
        return aux;
    }

    public double mediaAriilor(){
        if(numarFiguri==0.0){
            return numarFiguri;
        }else{
            double suma=0.0;
            for(int i=0; i<numarFiguri; i++){
                suma=suma+figuri[i].getArie();
            }
            return suma/numarFiguri;
        }
    }


}

class Main{
    public static void main(String[] args){
        Desen desen=new Desen("DESEN ");
        Figura figura1=new Figura(10);
        Figura figura2=new Figura(20);
        Figura figura3=new Figura(10);
        desen.adaugaFigura(figura1);
        desen.adaugaFigura(figura2);
        desen.adaugaFigura(figura3);
        System.out.println(desen);
        System.out.println(desen.mediaAriilor());
    }
}