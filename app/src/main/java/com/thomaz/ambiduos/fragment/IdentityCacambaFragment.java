package com.thomaz.ambiduos.fragment;

import android.content.Intent;
import android.util.Log;

import com.thomaz.ambiduos.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * Created by thomaz on 22/10/2016.
 */
@EFragment(R.layout.fragment_identity_cacamba)
public class IdentityCacambaFragment extends CustomFragment {

    @Click
    protected void btIdentificar() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        intent.putExtra("PROMPT_MESSAGE", "Aponte para o QR Code");

        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == getActivity().RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                // String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                System.out.println("contents = " + contents);

            } else if (resultCode == getActivity().RESULT_CANCELED) {
                // Handle cancel
                Log.i("App","Scan unsuccessful");
            }
        }

    }
}
