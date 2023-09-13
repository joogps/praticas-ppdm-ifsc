package com.joogps.lista;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAlbumAdapter extends ArrayAdapter<ItemAlbum> {
    Context context;
    int resource;

    List<ItemAlbum> objects;

    public ItemAlbumAdapter(@NonNull Context context, int resource, @NonNull List<ItemAlbum> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.album_item_layout, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.capa);
        image.setImageResource(this.objects.get(position).capa);

        TextView title = convertView.findViewById(R.id.albumTitle);
        title.setText(this.objects.get(position).nome);

        TextView artist = convertView.findViewById(R.id.albumArtist);
        artist.setText(this.objects.get(position).artista);

        TextView year = convertView.findViewById(R.id.albumYear);
        year.setText(this.objects.get(position).ano);

        return convertView;
    }
}
