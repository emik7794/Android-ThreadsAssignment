package ar.edu.unc.famaf.redditreader.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ar.edu.unc.famaf.redditreader.R;

import ar.edu.unc.famaf.redditreader.model.PostModel;

public class PostAdapter extends ArrayAdapter<PostModel> {

    private List<PostModel> postList = null;

    public PostAdapter(Context context, int textViewResourseId, List<PostModel> postList) {
        super(context, textViewResourseId);
        this.postList = postList;
    }

    protected class DownloadPreviewImageAsyncTask extends AsyncTask<URL, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls){
            URL url = urls[0];
            Bitmap bitmap = null;
            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is,null,null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result){
            System.out.println("onPostExecute");
            ImageView iv = (ImageView) findViewById(R.id.asyncPreviewIV);
            iv.setImageBitmap(result);
        }
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
            ImageView asyncPreviewIV = (ImageView) convertView.findViewById(R.id.asyncPreviewIV);
            viewHolder = new ViewHolder(titleTV, authorTV, commentsTV, dateTV, asyncPreviewIV);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PostModel pm = postList.get(position);

        viewHolder.titleTV.setText(pm.getTitle());
        viewHolder.authorTV.setText(pm.getAuthor());
        viewHolder.commentsTV.setText(String.valueOf(pm.getComments()));
        viewHolder.dateTV.setText(pm.getDate());

        URL[] urlArray = new URL[1];
        urlArray[0] = pm.getUrlPreviewImage();
        DownloadPreviewImageAsyncTask dwnAsyncTask;
        dwnAsyncTask = new DownloadPreviewImageAsyncTask();
        dwnAsyncTask.execute(urlArray);

        //viewHolder.asyncPreviewIV.setImageResource();

        return convertView;
    }

    private class ViewHolder {
        public final TextView titleTV;
        public final TextView authorTV;
        public final TextView commentsTV;
        public final TextView dateTV;
        public final ImageView asyncPreviewIV;

        public ViewHolder(TextView titleTV, TextView authorTV, TextView commentsTV,
                          TextView dateTV, ImageView asyncPreviewIV) {

            this.titleTV = titleTV;
            this.authorTV = authorTV;
            this.commentsTV = commentsTV;
            this.dateTV = dateTV;
            this.asyncPreviewIV = asyncPreviewIV;
        }

    }

}
