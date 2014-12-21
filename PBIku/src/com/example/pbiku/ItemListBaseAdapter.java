package com.example.pbiku;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter {
	private static ArrayList<ItemDetailsModel> itemDetailsrrayList;
	
	private Integer[] imgid = {
			R.drawable.aceh,
			R.drawable.lambang_sumatrautara,
			R.drawable.lambang_sumatrabarat,
			R.drawable.lambang_riau,
			R.drawable.lambang_jambi,
			R.drawable.lambang_sumatraselatan,
			R.drawable.lambang_bengkulu,
			R.drawable.lambang_lampung,
			R.drawable.lambang_bangkabelitung,
			R.drawable.lambang_kepulauanriau,
			R.drawable.lambang_jakarta,
			R.drawable.lambang_jawabarat,
			R.drawable.lambang_jawatengah,
			R.drawable.lambang_daerahistimewayogyakarta,
			R.drawable.lambang_jawatimur,
			R.drawable.lambang_banten,
			R.drawable.lambang_bali,
			R.drawable.lambang_nusatenggarabarat,
			R.drawable.lambang_nusatenggaratimur,
			R.drawable.lambang_kalimantanbarat,
			R.drawable.lambang_kalimantantengah,
			R.drawable.lambang_kalimantanselatan,
			R.drawable.lambang_kalimantantimur,
			R.drawable.lambang_sulawesiutara,
			R.drawable.lambang_sulawesitengah,
			R.drawable.lambang_sulawesiselatan,
			R.drawable.lambang_sulawesitenggara,
			R.drawable.lambang_sulawesibarat,
			R.drawable.lambang_gorontalo,
			R.drawable.lambang_maluku,
			R.drawable.lambang_malukuutara,
			R.drawable.lambang_papua,
			R.drawable.lambang_papuabarat,
			};
	
	private LayoutInflater l_Inflater;

	public ItemListBaseAdapter(Context context, ArrayList<ItemDetailsModel> results) {
		itemDetailsrrayList = results;
		l_Inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return itemDetailsrrayList.size();
	}

	public Object getItem(int position) {
		return itemDetailsrrayList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.item_view, null);
			holder = new ViewHolder();
			holder.nama = (TextView) convertView.findViewById(R.id.nama_prov);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.logo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.nama.setText(itemDetailsrrayList.get(position).getNama());
		holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);
		return convertView;
	}

	static class ViewHolder {
		TextView nama;
		ImageView itemImage;
	}
}
