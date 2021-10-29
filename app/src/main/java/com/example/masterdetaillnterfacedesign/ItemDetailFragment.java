package com.example.masterdetaillnterfacedesign;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.example.masterdetaillnterfacedesign.placeholder.PlaceholderContent;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The placeholder content this fragment is presenting.
     */
    private PlaceholderContent.PlaceholderItem mItem;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTextView;

    private final View.OnDragListener dragListener = (v, event) -> {
        if (event.getAction() == DragEvent.ACTION_DROP) {
            ClipData.Item clipDataItem = event.getClipData().getItemAt(0);
            mItem = PlaceholderContent.ITEM_MAP.get(clipDataItem.getText().toString());
        }
        return true;
    };
    

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the placeholder content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            FragmentActivity activity = this.getActivity();
            CollapsingToolbarLayout appBarlayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarlayout !=null){
                appBarlayout.setTitle(mItem.fruitImage);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_detail, container, false);


        // Show the placeholder content as text in a TextView.
        if (mItem !=null) {
            switch (mItem.fruitName) {
                case "Apple":
                    ((ImageView)rootView.findViewById(R.id.item_detail_image)).setImageResource(R.drawable.apple);
                    break;
                case "Fresasy":
                    ((ImageView)rootView.findViewById(R.id.item_detail_image)).setImageResource(R.drawable.fresa);
                    break;
                case "Banana":
                    ((ImageView)rootView.findViewById(R.id.item_detail_image)).setImageResource(R.drawable.banana);
                    break;
                case "Uvas":
                    ((ImageView)rootView.findViewById(R.id.item_detail_image)).setImageResource(R.drawable.uvas);
                    break;

                default:
                    ((ImageView)rootView.findViewById(R.id.item_detail_image)).setImageResource(R.drawable.apple);
            }
        }
        return rootView;
    }


}