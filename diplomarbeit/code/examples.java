setContentView(R.layout.main);
actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.verbrauchwolke));
actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.komfort), true);
// Setzen des Tabs auf angeklickt mit True
actionbar.addTab(actionbar.newTab().setTabListener(this).setIcon(R.drawable.schaltvorschlag));
// Weiters werden Icons zu den Tabs hinzugefuegt.

<android.support.v4.view.ViewPager> </android.support.v4.view.ViewPager>

android:id="@+id/pager"

ViewPager viewpager;
FragmentPagerAdapter ft;
viewpager =(ViewPager) findViewById(R.id.pager);
ft = new FragementPageAdapter(getSupportFragmentManager());
viewpager.setAdapter(ft);