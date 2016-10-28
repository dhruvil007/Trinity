package in.djtrinity.www.trinity;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

import in.djtrinity.www.trinity.galleryHelper.AppConstant;
import in.djtrinity.www.trinity.galleryHelper.GridViewImageAdapter;
import in.djtrinity.www.trinity.galleryHelper.Utils;


public class GalleryFragment extends Fragment {

    private Utils utils;
    private boolean cancel_gallery = false;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    public GalleryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        gridView = (GridView) view.findViewById(R.id.grid_view);

        if (!isNetworkAvailable())
            Toast.makeText(getActivity(), "Internet Required To View The Gallery.", Toast.LENGTH_SHORT).show();
        else
            new GalleryDownload(getActivity(), gridView).execute();

        utils = new Utils(getActivity());
        InitilizeGridLayout();
        imagePaths = utils.getFilePaths();
        adapter = new GridViewImageAdapter(getActivity(), imagePaths,
                columnWidth);
        gridView.setAdapter(adapter);
        return view;
    }

    class GalleryDownload extends AsyncTask<Void, Void, Void> {
        ProgressDialog pd;
        Context c;
        GridView gridView;

        GalleryDownload(Context c, GridView gridView) {
            this.c = c;
            this.gridView = gridView;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(c);
            pd.setMessage("Loading...");
            pd.setCancelable(true);
            pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    cancel_gallery = true;
                }
            });
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                FTPClient ftpClient = new FTPClient();
                ftpClient.connect(InetAddress.getByName("199.241.184.166"), 21);//"http://www.djtrinity.in"));
                ftpClient.login("djtrinit", "b]sMa@2naTHU");
                Log.e("status :: ", ftpClient.getStatus());
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();

                try {
                    FTPFile[] files = ftpClient.listFiles("/android_images");
                    for (FTPFile filename : files) {
                        OutputStream out = null;
                        try {
                            File galleryDir = new File(getActivity().getExternalFilesDir(null).toString() + "/gallery");
                            if (!galleryDir.exists())
                                galleryDir.mkdir();
                            File outFile = new File(galleryDir, filename.getName());
                            if (!outFile.exists()) {
                                out = new BufferedOutputStream(new FileOutputStream(outFile));
                                if (ftpClient.retrieveFile("/android_images/" + filename.getName(), out))
                                if (out != null)
                                    out.close();
                            }
                        } catch (Exception e) {
                        }
                        if (cancel_gallery)
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            imagePaths = utils.getFilePaths();
            GridViewImageAdapter adapter = new GridViewImageAdapter(getActivity(), imagePaths,
                    columnWidth);
            gridView.setAdapter(adapter);
        }

        //gallery load method
        private void copyFile(InputStream in, OutputStream out) throws IOException {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
    }

    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                AppConstant.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - (2 * padding)) / AppConstant.NUM_OF_COLUMNS);

        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding(0, (int) padding, 0, (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
