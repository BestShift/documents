/**
 * Eine Klasse welches einen Kreis zeichnet in dem fuer alle Richtungen die Beschleunigungskraefte angezeigt werden.
 * Diese Punkte werden im 5 grad Bereich eingezeichnet und werden von neueren Extremwerten ueberschreben. 
 * Created by fitim on 10.03.2016.
 */
    @Override
	/**
	* Die Methode onDraw Zeichnet die Ganzen Kreise mittels Canvas.
	*/
    protected void onDraw(Canvas canvas) {
        int w = getWidth() / 2;
        int h = getHeight() / 2;
		
		//Ein Paint Objekt wird erstellt womit man ihn eine Farbe und andere Eigrnschaften zuweisst.
        Paint drawblack = new Paint();
        drawblack.setColor(Color.BLACK);
        drawblack.setStyle(Paint.Style.STROKE);
        drawblack.setStyle(Paint.Style.FILL);
		
		//Neues Paint Objekt mit anderen Eigenschaften
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
		//Phi wert wird generiert 
        phi = (int) (Math.random() * (358  + 1) +0);
        
		// Die Runden Methode wird aufgerufen und der Winkel wird gerundet.
        int a=runden(phi);
        System.out.println("out:" + a);

		// Radius wird generiert
        radiusgeneriert=(int) (Math.random() * (radius  + 1) +0);
		
		// x,y wird aus den generierten radius berechnet.
        x= (float) (radiusgeneriert*Math.cos(a));
        y= (float) (radiusgeneriert*Math.sin(a));
		
		// Die Werte werden in einer Liste hinzugefuegt
        xvalues.add(x);
        yvalues.add(y);
        xvalues.toArray();
        yvalues.toArray();
		
		// Der Grosse Kreis wird gezeichnet 
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, p);
		
		// Ein Kleiner Kreis wird gezeichnet 
        canvas.drawCircle((getWidth() / 2) + x, (getHeight() / 2) + y, 10, drawblack);
        // Grafik wird mittels eines Threads eingefroren fuer 1 sec
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		// Daten werden Aktuallisiert.
        invalidate();
        postInvalidate();

		// Die Arrayliste wird durchgegangen und dadurch werden alle Punkte waehrendessen gezeichnet
        for (int i = 0; i < xvalues.size(); i++) {
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.FILL);
            canvas.drawCircle((getWidth() / 2) + xvalues.get(i), (getHeight() / 2) + yvalues.get(i), 3, p);
			// Hier wird die Grafik aktuallisiert
            invalidate();
            postInvalidate();
            if (xvalues.get(i) == null) {
                break;
            }

        }




    

