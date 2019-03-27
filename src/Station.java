
public class Station {
	private float latitude, longitude, temp1, temp2, temp3;
	private int raint, rain1, rain2, rain3; 
	private String name;
	static private int  total_rain_global;

	/**Constructor de estacio
	 * @param latitude =latitut de l'estacio
	 * @param longitude =longitut de l'estacio
	 * @param n =nom de l'estacio*/
	public Station(float latitude, float longitude, String n) {
		this.latitude=latitude;
		this.longitude=longitude;
		this.name=n;
		this.temp1=0;
		this.temp2=0;
		this.temp3=0;
		this.rain1=0;
		this.rain2=0;
		this.rain3=0;
		this.raint=0;
	}
	
	/**Getter de la latitut
	 * @return latitut*/
	public float getLatitude() {
		return latitude;
	}

	/**Getter de la longitut
	 * @return longitut*/
	public float getLongitude() {
		return longitude;
	}

	/**Getter de la temperatura actual
	 * @return temperatura actual*/
	public float getTemp1() {
		return temp1;
	}

	/**Getter de la penultima temperatura 
	 * @return penultima temperatura*/
	public float getTemp2() {
		return temp2;
	}
	
	/**Getter de la antepenultima temperatura
	 * @return antepenultima temperatura*/
	public float getTemp3() {
		return temp3;
	}

	/**Getter de la pluja total
	 * @return pluja total */
	public int getRaint() {
		return raint;
	}

	/**Getter de la pluja actual
	 * @return pluja actual*/
	public int getRain1() {
		return rain1;
	}

	/**Getter de la pluja apenultima
	 * @return pluja penultima */
	public int getRain2() {
		return rain2;
	}

	/**Getter de la pluja antepenultima
	 * @return pluja antepenultima*/
	public int getRain3() {
		return rain3;
	}

	/**Getter del nom de l'estacio
	 * @return nom de l'estacio*/
	public String getName() {
		return name;
	}

	/**Getter de la temperatura actual
	 * @return total de pluja en totes les estacion*/
	public int getTotal_rain_global(){
		return total_rain_global;
	}
	
	/**Metode que actualitza les dades d'una estacio
	 * @param temp=temperatura actual
	 * @param rain=pluja actual*/
	public void update(float temp, int rain) {
		this.temp3=temp2;
		this.temp2=temp1;
		this.temp1=temp;
		this.rain3=rain2;
		this.rain2=rain1;
		this.rain1=rain;
		this.raint=rain1+rain2+rain3;
	}
	
	/** Method que retorna la estació amb més pluja.
	 * @param a=estacio a comparar
	 * @return l'instancia amb més pluja
	 */
	public Station mostRain(Station a) {
		Station soport = new Station (0.0f, 0.0f, "aux");
		if(this.raint > a.raint){
			soport.name=this.name;
			soport.latitude=this.latitude;
			soport.longitude=this.longitude;
			soport.temp1=this.temp1;
			soport.temp2=this.temp2;
			soport.temp3=this.temp3;
			soport.rain1=this.rain1;
			soport.rain2=this.rain2;
			soport.rain3=this.rain3;
			soport.raint=this.raint;
		}
		else
			soport = a;
		
		return (soport);
	}
	
	/**Metode que copia les dades d'una estacio pasada per referencia a l'actual estacio 
	 * @param a=estacio a copiar*/
	public void copy(Station a)
	{
		this.latitude=a.latitude;
		this.longitude=a.longitude;
		this.name=a.name;
		this.temp1=a.temp1;
		this.temp2=a.temp2;
		this.temp3=a.temp3;
		this.rain1=a.rain1;
		this.rain2=a.rain2;
		this.rain3=a.rain3;
		this.raint=a.raint;
	}
	
	/**Metode toString de l'estacio*/
	public String toString() {
		String message;
		message ="\nNom: "+name+" / Latitut:"+latitude+" / Longitut:"+longitude+" \n"
				+"Els 3 ultims valors de temperatura registrats (de mes actual a mes antic) son: "+temp1+"/"
				+temp2+"/"+temp3+"\nEls 3 ultims valors de pluja registrats (de mes actual a mes antic) son: "
				+rain1+"/"+rain2+"/"+rain3+" i el total de pluja acumulat en els tres darrers registres es: "+raint;
		return message;
	}
}
