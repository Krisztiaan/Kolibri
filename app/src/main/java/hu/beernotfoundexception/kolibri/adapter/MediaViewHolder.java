package hu.beernotfoundexception.kolibri.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import hu.beernotfoundexception.kolibri.data.MediaElement;

public abstract class MediaViewHolder<T extends MediaElement> extends RecyclerView.ViewHolder {

    public MediaViewHolder(View itemView) {
        super(itemView);
    }

    abstract void setMedia(T media);
}
