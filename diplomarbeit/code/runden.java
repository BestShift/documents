public int runden(float roh){
	float anzahl= round(roh/5);
	System.out.println("Gerundet:" + anzahl);
	int returnzahl=0;
	returnzahl= (int) (anzahl*5);
	return returnzahl;
}