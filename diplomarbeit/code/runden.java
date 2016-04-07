public int runden(float roh){
	float anzahl= round(roh/5);
	int returnzahl=0;
	returnzahl= (int) (anzahl*5);
	return returnzahl;
}