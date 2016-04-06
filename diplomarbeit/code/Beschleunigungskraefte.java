/**
 * Eine Klasse welches die Beschleunigungskraefte von den Sensoren ausliest und sie Grafisch
 * in einem Liniendiagramm einzeichnet.
 * Created by fitim on 09.12.2015.
 */
public class Beschleunigungskraefte extends Activity implements OnChartValueSelectedListener {
    private LineChart mlayout;
    private LineChart mLineChart;
    private MediaPlayer mpAudio;
    private MediaPlayer mpAudio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beschl);
        mLineChart = (LineChart) findViewById(R.id.chart1);
        mLineChart.setOnChartValueSelectedListener(this);

        // no description text
        mLineChart.setDescription("Beschleunigungskraefte");
        mLineChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable highlighting
        mLineChart.setHighlightEnabled(true);

        // enable touch gestures
        mLineChart.setTouchEnabled(true);

        // enable scaling and dragging
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);
        mLineChart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        mLineChart.setPinchZoom(true);

        // set an alternative background color
        mLineChart.setBackgroundColor(Color.WHITE);

		//Linedata Objekte werden erstellt
        LineData data = new LineData();
		//Die Daten welche angezeigt werden haben eine schwarze Farbe
        data.setValueTextColor(Color.BLACK);
        LineData data2 = new LineData();
        data2.setValueTextColor(Color.RED);

        // add empty data
        mLineChart.setData(data);
        mLineChart.setData(data2);




        // get the legend (only possible after setting data)
        Legend l = mLineChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);
		// Farbe zuteilen
        l.setTextColor(Color.BLACK);

        XAxis xl = mLineChart.getXAxis();

        xl.setTextColor(Color.BLACK);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);


        YAxis leftAxis = mLineChart.getAxisLeft();

        leftAxis.setTextColor(Color.BLACK);
        leftAxis.setAxisMaxValue(2f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setStartAtZero(false);
        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = mLineChart.getAxisRight();
        rightAxis.setEnabled(false);
		// Es wird auf ein TextView Atributt zugegriffen, das Atributt bekommt einen listener und gibt die MyActivity Klasse zurueck, wenn es angecklickt wird.
        TextView rl= (TextView) findViewById(R.id.frombeschtokommtext);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MyActivity.class);
                startActivity(intent);
            }
        });

    }
	/**
	*Zufaellige Daten werden generiert und dem Grafen hinzugefuegt 
	*
	*/
    private void addEntry() {
        LineData data=mLineChart.getData();

        if(data != null){
            LineDataSet set= data.getDataSetByIndex(0);
            if(set == null){

                set=createSet();
                data.addDataSet(set);
            }
            //add a new random value
            data.addXValue("" + set.getEntryCount());
			// Werte werden zwischen 2 und 0.1 generiert
            float a=(float) Math.random() * 2 + 0.1f;
            if(a>1.8){
                feedback1();
                mpAudio.start();
            }
            data.addEntry(new Entry(a, set.getEntryCount()), 0);

            mLineChart.notifyDataSetChanged();

            mLineChart.setVisibleXRange(6,0);

            mLineChart.moveViewToX(data.getXValCount() -7);
        }
    }
	/**
	* Die Methode feedback gibt einen ton und eine Nachricht aus.
	* Die Nachricht wird nicht sehr lange auf dem Device gezeigt da es nur anschlaegt wenn er 
	*eine groessere Bescheunigungskraft als 1.8g erreicht hat .
	*/
    private void feedback1(){
        Context context = getApplicationContext();
        CharSequence text = "Langsamer gehts auch";
        int duration=Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context, text, duration);
        toast.show();
        mpAudio=MediaPlayer.create(this, R.raw.sound);


    }

	/**
	*Eigenschaften der Daten also Linienfarbe werden eingestellt 
	*Wie z.B liniendicke, von Punkt die groesse usw.
	*/
    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Realtime Beschleunigungskraefte1");
        set.setDrawCubic(true);
        set.setCubicIntensity(0.2f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(Color.BLACK);
        set.setLineWidth(2f);
        set.setCircleSize(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setHighLightColor(Color.rgb(244, 117, 117));
        set.setValueTextColor(Color.BLACK);
        set.setValueTextSize(10f);
        return set;
    }  
}
   
  