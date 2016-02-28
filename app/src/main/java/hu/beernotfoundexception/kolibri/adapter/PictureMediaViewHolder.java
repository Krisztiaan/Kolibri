package hu.beernotfoundexception.kolibri.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hu.beernotfoundexception.kolibri.R;
import hu.beernotfoundexception.kolibri.data.SimpleImageElement;

public class PictureMediaViewHolder extends MediaViewHolder<SimpleImageElement> {

    ImageView imgMedia;

    TextView txtText;

    public PictureMediaViewHolder(View itemView) {
        super(itemView);

        imgMedia = (ImageView) itemView.findViewById(R.id.imgMediaItemPicture);

        txtText = (TextView) itemView.findViewById(R.id.txtMediaItemText);
    }

    @Override
    public void setMedia(SimpleImageElement imageElement) {
        imgMedia.setImageBitmap(imageElement.picture);
        txtText.setText(imageElement.text);
    }
}
