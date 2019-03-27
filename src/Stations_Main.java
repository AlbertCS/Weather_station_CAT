import java.util.Scanner;

public class Stations_Main {

	
	static Scanner keyboard=new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\n\n Options:");
		System.out.println("\n\t1. Add a Station to the list");
		System.out.println("\t2. Add new data to a Station");
		System.out.println("\t3. Delete a Station");
		System.out.println("\t4. Show one Station of the list");
		System.out.println("\t5. Show the total amount of rain among all the stations");
		System.out.println("\t6. Show the Station with the more rain");
		System.out.println("\t7. Risk of rainfall between a range of Stations");
		System.out.println("\t8. Stations with risk of significant snowfall");
		System.out.println("\t9. The northern Station with a temperature above 20º");
		System.out.println("\t10. Exit");
		System.out.print("\n\t\t\tChoose3 one option:\n");
	}
	
	public static void addStation(LlistaEstacions list) {
		String name;
		float latitude, longitude;
		System.out.print("\n\n\tIntroduce the Station name:\t");
		name=keyboard.nextLine();
		System.out.print("\n\n\tIntroduce its latitude:\t");
		latitude=Float.parseFloat(keyboard.nextLine());
		System.out.print("\n\n\tIntroduce its longitude:\t");
		longitude=Float.parseFloat(keyboard.nextLine());
		Station t=new Station(latitude, longitude, name);
		list.addStation(t);
	}
	
	public static void updateStation(LlistaEstacions list){
		String name;
		float temp; 
		int rain;
		System.out.print("\n\n\tIntroduce the Station name:\t");
		name=keyboard.nextLine();
		System.out.print("\n\n\tIntroduce its temperature:\t");
		temp=Float.parseFloat(keyboard.nextLine());
		System.out.print("\n\n\tIntroduce the amount of rain:\t");
		rain=Integer.parseInt(keyboard.nextLine());
		list.updateStation(name, temp, rain);
	}
	public static void deleteStation(LlistaEstacions list) {
		String s;
		System.out.print("\n\n\tIntroduce the Station:\t");
		s=keyboard.nextLine();
		list.removeStation(s);		
	}
	
	public static void consultStation(LlistaEstacions list) {
		String s;
		System.out.print("\n\n\tIntroduce the Station:\t");
		s=keyboard.nextLine();
		System.out.println(list.consult(s));
	}
	
	public static void totalRainStations(LlistaEstacions list) {
		System.out.println("\n\nThe amount of rain among all the Stations is: "+list.totalrain()+"\t");
	}
	
	public static void mostRainStation(LlistaEstacions list) {
		System.out.println("\n\nThe Station with more rain is: "+list.stationMostRain()+"\t");
	}
	
	public static void riskRain(LlistaEstacions list) {
		int x, y;
		System.out.println("\n\nDefine the range of Staions:\t");
		x=Integer.parseInt(keyboard.nextLine());
		y=Integer.parseInt(keyboard.nextLine());
		if(list.riskRain(x, y)==true){
			System.out.println("\n\nThere is a risk of rainfall.\t");
		}
		else {
			System.out.println("\n\nThere is not a risk of rainfall.\t");
		}
	}
	public static void riskSnow(LlistaEstacions list, int nStations) {
		int nSnow=0;
		Station[] snow = new Station[nStations];
		snow = (list.riskSnow());
		for(int i=0;i<snow.length;i++){
			nSnow++;
		}
		if(nSnow==0){
			System.out.println("\n\nThere is any Station with risk of a significant snowfall.\t");
		}
		else{
			System.out.println("\n\nThe following Stations are with significant risk of a snowfall:  ");
			for(int i=0;i<nSnow;i++){
				System.out.println(", "+snow[i].getName());
			}
		}	
	}
	
	public static void northernStation(LlistaEstacions list) {
		System.out.println("\n\nThe northern Station with a temperature above 20º is: "+list.nordStation()+"\t");
	}
	
	public static void main(String[] args) {
	int op, nStations=0;
	while(nStations<1){
		System.out.println("\n\nIntroduce the size of the list of Stations(minimum size 1):");
		nStations = Integer.parseInt(keyboard.nextLine());
	}
	LlistaEstacions list=new LlistaEstacions(nStations); 

	/* Afegim manualment 6 estacions.*/
	Station t=new Station(41.11f, 1.24f, "Tarragona");
	list.addStation(t);
	list.updateStation("Tarragona", 20.5f, 7); /*temp i rain*/
	list.updateStation("Tarragona", 18.1f, 3);
	list.updateStation("Tarragona", 15.0f, 1);
	if(nStations>1){
		Station g=new Station(41.43f, 2.16f, "Girona");
		list.addStation(g);
		list.updateStation("Girona", 17.3f, 0);
		list.updateStation("Girona", 24.1f, 0);
		list.updateStation("Girona", 22.6f, 0);
	}
	if(nStations>2){
		Station bar=new Station(42.50f, 0.80f, "Barruera");
		list.addStation(bar);
		list.updateStation("Barruera", 6.0f, 4);
		list.updateStation("Barruera", 2.35f, 13);
		list.updateStation("Barruera", 3.12f, 19);
	}
	if(nStations>3){
		Station bcn=new Station(41.38f, 2.16f, "Barcelona");
		list.addStation(bcn);
		list.updateStation("Barcelona", 19.6f, 1);
		list.updateStation("Barcelona", 22.9f, 1);
		list.updateStation("Barcelona", 22.7f, 0);
	}
	if(nStations>4){
		Station l=new Station(41.63f, 0.60f, "Lleida");
		list.addStation(l);
		list.updateStation("Lleida", 20.1f, 1);
		list.updateStation("Lleida", 17.2f, 2);
		list.updateStation("Lleida", 14.2f, 60);
	}
	if(nStations>5){
		Station v=new Station(41.30f, 1.23f, "Valls");
		list.addStation(v);
		list.updateStation("Valls", 15.8f, 3);
		list.updateStation("Valls", 17.2f, 2);
		list.updateStation("Valls", 15.0f, 0);
	}
	
	op= 0;
	while (op!=10) {
		showMenu();
		op= Integer.parseInt(keyboard.nextLine());
		switch(op) {
		case 1: addStation(list); break;
		case 2: updateStation(list); break;
		case 3: deleteStation(list); break;
		case 4: consultStation(list); break;
		case 5: totalRainStations(list); break;
		case 6: mostRainStation(list); break;
		case 7: riskRain(list); break;
		case 8: riskSnow(list, nStations); break;
		case 9: northernStation(list); break;
		}		
	}
	}
}
	
	
	
	
	

