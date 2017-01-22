package techcare.xmlparsing.com.xmlparsing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<Data> {

	
	
	public Adapter(Context ctx, int textViewResourceId, List<Data> sites) {
		super(ctx, textViewResourceId, sites);



	}
	

	@Override
	public View getView(int pos, View convertView, ViewGroup parent){
		RelativeLayout row = (RelativeLayout)convertView;
		Log.i("StackSites", "getView pos = " + pos);
		if(null == row){

			LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = (RelativeLayout)inflater.inflate(R.layout.row_site, null);
		}

		final ImageView iconImg = (ImageView)row.findViewById(R.id.iconImg);
		TextView nameTxt = (TextView)row.findViewById(R.id.nameTxt);
		TextView aboutTxt = (TextView)row.findViewById(R.id.aboutTxt);
		final ProgressBar indicator = (ProgressBar)row.findViewById(R.id.progress);

		indicator.setVisibility(View.VISIBLE);
		iconImg.setVisibility(View.INVISIBLE);



				

		//Set the relavent text in our TextViews
		nameTxt.setText(getItem(pos).getTitle());
		aboutTxt.setText(getItem(pos).getDescription());
		
		
		
		return row;
				
				
	}

}
