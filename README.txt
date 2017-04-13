//layout.xml : on all buttons
android:onClick="onClick"

//MainActivity:
public void onClick(View v) {
	String plnt = res.getResourceEntryName(v.getId());
	plnt = plnt.substring(1, (plnt.length()-1));
	((Button)findViewById(v.getId())).setText("FeelTheVaro");
	
}
