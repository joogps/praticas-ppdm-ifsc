package com.joogps.launcher;

import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter  extends ArrayAdapter<ResolveInfo> {
    public AppAdapter(MainActivity mainActivity, int item_lista, List<ResolveInfo> packageInfoList) {
        super(mainActivity, item_lista, packageInfoList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_lista, parent, false);
        ResolveInfo info = getItem(position);
        TextView textViewAppName = view.findViewById(R.id.app_name);
        ImageView imageViewAppIcon = view.findViewById(R.id.app_icon);
        imageViewAppIcon.setImageDrawable(info.loadIcon(getContext().getPackageManager()));
        textViewAppName.setText(info.loadLabel(getContext().getPackageManager()));
        return view;
    }
}
