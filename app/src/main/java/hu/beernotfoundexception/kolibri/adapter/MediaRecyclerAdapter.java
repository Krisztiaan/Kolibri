package hu.beernotfoundexception.kolibri.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.beernotfoundexception.kolibri.R;
import hu.beernotfoundexception.kolibri.data.MediaElement;

public class MediaRecyclerAdapter extends RecyclerView.Adapter<MediaViewHolder> {

    private List<MediaElement> mElements = new ArrayList<>();

    public MediaRecyclerAdapter(Collection<MediaElement> elements) {
        mElements.addAll(elements);
    }

    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // TODO: 2/28/2016 multiple types
        View root = inflater.inflate(R.layout.list_item_media, parent, false);
        return new PictureMediaViewHolder(root);
    }

    @Override
    public void onBindViewHolder(MediaViewHolder holder, int position) {
        // TODO: 2/28/2016 multiple types
        holder.setMedia(mElements.get(position));
    }

    @Override
    public int getItemCount() {
        return mElements.size();
    }
}
