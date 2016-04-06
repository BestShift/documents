public class MyActivity extends FragmentActivity implements ActionBar.TabListener {
    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPagerAdapter ft;
    /**
     * Das Hauptfenster der Android Applikation
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewpager =(ViewPager) findViewById(R.id.pager);


        ft = new FragementPageAdapter(getSupportFragmentManager());
        actionbar=getActionBar();
        viewpager.setAdapter(ft);
        // setzen der Navigation fuer die Tabs
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Background von tasks wird veraendert
        actionbar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#47708D")));

        //Fuerr die Farbe ober dem Tabs
       //actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#47708D")));


        // Tabs werden hinzugefuegt
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.verbrauchwolke));
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.komfort), true);
        actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.schaltvorschlag));

    }
}
