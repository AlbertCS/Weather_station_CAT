
public class LlistaEstacions {
	private Station[] llista;
	private int numEstacions;

	/**Constructor de la llista d'estacions
	 * @param num=mida de la llista d'estacions*/
	public  LlistaEstacions(int num){
		llista= new Station[num];
		numEstacions=0;
	}
	
	/**Getter de numEstacions
	 * @return numEstacions*/
	public int getNumEstacions() {
		return(numEstacions);
	}
	
	/**Metode per afegir una estacio
	 * @param p=estacio que es vol afegir*/
	public void addStation(Station p){	
		int i , pos=0;
		if(numEstacions<llista.length){
			if(numEstacions==0){
				llista[pos]=new Station (p.getLatitude(), p.getLongitude(), p.getName());
			}
			else{
				while((pos<numEstacions)&&(llista[pos].getLatitude()<=p.getLatitude())){
					if(llista[pos].getLatitude()==p.getLatitude()){
						if(llista[pos].getLongitude()<p.getLongitude()){
							pos++;
						}
					}
					pos++;
				}
				for(i=numEstacions;i>pos;i--){
					llista[i]=llista[i-1];
				}
				llista[pos]=new Station (p.getLatitude(), p.getLongitude(), p.getName());
			}
		numEstacions++;
		}
	}	
	
	/**Metode que serveix per buscar la posicio d'una estacio a partir del nom
	 * @param n=nom estacio
	 * @return posb=posicio on es troba l'estacio*/
	public int busca (String n){
		int posb=-1,i=0;
		String nom;
		boolean trobat=false;
		while((i<numEstacions)&&(!trobat)){
			nom=llista[i].getName();
			trobat=nom.equals(n);
			if(trobat==true){
			posb=i;
			}
			i++;
		}
		return(posb);
	}

	/**Metode que serveix per introduir dades a una estacio
	 * @param x=nom estacio
	 * @param temp=temperatura actual
	 * @param rain=pluja actual*/
	public void updateStation(String x, float temp, int rain){
		int pos;
		pos=busca(x);
		if (pos!=-1)
		llista[pos].update(temp, rain);
	}
	
	/**Metode que serveix per eliminar una estacio
	 * @param m=nom de l'estacio a eliminar*/
	public void removeStation(String m){
		int pos;
		pos=busca(m);
		if(pos!=-1){
				while(pos<numEstacions-1){
					llista[pos]=llista[pos+1];
					pos++;
				}
			numEstacions--;	
		}
	}
	
	/**Metode per consultar les dades d'una estacio
	 * @param m=nom estacio a consultar
	 * @return aux=instancia estacio retornada*/
	public Station consult(String m){
		int pos;
		Station aux = new Station(0,0, "No es troben valors registrats per aquesta estacio.");
		pos=busca(m);
		if(pos!=-1){
			aux=llista[pos];
		}
		return aux;
	}
	
	/**Metode que calcula el total de pluja de totes les estacion
	 * @return total_rain_global=pluja acumulada en totes les estacions*/
	public int totalrain(){
		int i, total_rain_global=0;
		for(i=0;i<numEstacions;i++){
			total_rain_global+=llista[i].getRaint();
		}
		return total_rain_global;
	}
	
	/**Metode que calcula l'estacio amb mes pluja
	 * @return name=nom de l'estacio amb mes pluja*/
	public String stationMostRain(){
		String name="a";
		int i=0, maxrain=0;
			while(i<numEstacions){
				if(maxrain<llista[i].getRaint()){
					maxrain=llista[i].getRaint();
					name=llista[i].getName();
				}
				i++;
			}
		return name;
	}
	
	/**Metode que calcula el risc de pluja entre un rang d'estacions
	 * @param min=rang minim
	 * @param max=rang maxim
	 * @return trobat=bolea que indica si hi ha una estacio amb risc de pluja*/
	public boolean riskRain(int min, int max ){
		boolean trobat=false;
		while((min<=max)&&(!trobat)){
			if((llista[min].getRain3()<llista[min].getRain2())&&(llista[min].getRain2()<llista[min].getRain1())){
				trobat=true;
			}
			min++;
		}
		return trobat;
	}
	
	/**Metode que calcula les estacions que tenen risc de nevades
	 * @return snow=llista d'estacions que tenen risc de nevades*/
	public Station[] riskSnow(){
		int i, j=0;
		Station[] snow;
		for(i=0;i<numEstacions;i++){
			if(llista[i].getTemp1()<0){
				if(llista[i].getRain1()>50){
					j++;
				}
			}	
		}
		snow=new Station[j];
		if(j!=0){
			j=0;
			for(i=0;i<numEstacions;i++){
				if(llista[i].getTemp1()<0){
					if(llista[i].getRain1()>50){
						snow[j]=new Station(0, 0, "No hi ha risc de neu");
						snow[j].copy(llista[i]);
						j++;
					}
				}	
			}	
		}
		return snow;
	}

	/**Metode que calcula la estacio situada més al nord que superi els 20º
	 * @return name=nom de l'estacio més al nord i que supera els 20º */
	public String nordStation(){
		String name="No hi ha estacio que superi els 20º";
		boolean trobat=false;
		int i=0;
		if(numEstacions<llista.length){
			while((!trobat)&&(i<numEstacions)){
				if(llista[i].getTemp1()>20){
					trobat=true;
					name=llista[i].getName();
				}
				i++;
			}
		}
		return name;
	}
}








 