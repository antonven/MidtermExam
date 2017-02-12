package myapps.wycoco.com.midtermexam;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import android.content.AsyncTaskLoader;
import myapps.wycoco.com.midtermexam.Models.AlbumsModel;


/**
 * Created by dell on 2/12/2017.
 */

public class AlbumsLoader extends AsyncTaskLoader<ArrayList<AlbumsModel>> {

    private String mUrl;
    private int requestCode;

    public AlbumsLoader(Context context, String mUrl, int requestCode) {
        super(context);
        this.mUrl = mUrl;
        this.requestCode = requestCode;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<AlbumsModel> loadInBackground() {
        if(mUrl == null)
            return null;

        return QueryUtility.fetchAlbumData(mUrl,requestCode);
    }
}
