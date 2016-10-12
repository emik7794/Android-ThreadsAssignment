package ar.edu.unc.famaf.redditreader.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ar.edu.unc.famaf.redditreader.R;

import ar.edu.unc.famaf.redditreader.model.PostModel;

public class PostAdapter extends ArrayAdapter<PostModel> {

    private List<PostModel> postList = null;

    public PostAdapter(Context context, int textViewResourseId, List<PostModel> postList) {
        super(context, textViewResourseId);
        this.postList = postList;
    }


    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public int getPosition(PostModel item) {
        return postList.indexOf(item);
    }

    @Override
    public PostModel getItem(int position) {
        return postList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.post_row, null);

            TextView titleTV = (TextView) convertView.findViewById(R.id.titleTV);
            TextView authorTV = (TextView) convertView.findViewById(R.id.authorTV);
            TextView commentsTV = (TextView) convertView.findViewById(R.id.commentsTV);
            TextView dateTV = (TextView) convertView.findViewById(R.id.dateTV);
            ImageView previewIV = (ImageView) convertView.findViewById(R.id.previewIV);
            viewHolder = new ViewHolder(titleTV, authorTV, commentsTV, dateTV, previewIV);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PostModel pm = postList.get(position);

        viewHolder.titleTV.setText(pm.getTitle());
        viewHolder.authorTV.setText(pm.getAuthor());
        viewHolder.commentsTV.setText(String.valueOf(pm.getComments()));
        viewHolder.dateTV.setText(pm.getDate());
        viewHolder.previewIV.setImageResource(pm.getPreviewId());

        return convertView;
    }

    private class ViewHolder {
        public final TextView titleTV;
        public final TextView authorTV;
        public final TextView commentsTV;
        public final TextView dateTV;
        public final ImageView previewIV;

        public ViewHolder(TextView titleTV, TextView authorTV, TextView commentsTV,
                          TextView dateTV, ImageView previewIV) {

            this.titleTV = titleTV;
            this.authorTV = authorTV;
            this.commentsTV = commentsTV;
            this.dateTV = dateTV;
            this.previewIV = previewIV;
        }

    }


}
