package com.android.jumper.frag;
 
import com.android.jumper.R;
import com.android.jumper.R.id;
import com.android.jumper.R.layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuListFragment extends ListFragment {
 
     
    public MenuListFragment(){
    }
 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, null);
    }
 
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        adapter.add(new SampleItem("Fragment1", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Fragment2",
                android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Fragment3", android.R.drawable.ic_menu_search));
 
        setListAdapter(adapter);
    }
 
    private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}
	}

 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
         
        switch (position) {
        case 0:
            ((BaseActivity)getActivity()).fragmentReplace(0);
            break;
        case 1:
            ((BaseActivity)getActivity()).fragmentReplace(1);
            break;
 
        case 2:
            ((BaseActivity)getActivity()).fragmentReplace(2);
            break;
        }
        super.onListItemClick(l, v, position, id);
    }
}