package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class FamilyMemberAdapter<F> extends ArrayAdapter<FamilyMember> {

    private int colorId;

    public FamilyMemberAdapter(FamilyMembersActivity context, ArrayList<FamilyMember> familyMembers, int color) {
        super(context, 0,familyMembers);
        colorId = color;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items_file, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        FamilyMember family = getItem(position);

        // Find the TextView in the list_item.xml layout with the mivok text
        TextView mivokTextView = (TextView) view.findViewById(R.id.mivok_text);
        // Get the mivok Translation from the current Word object and
        // set this text on the mivok TextView
        mivokTextView.setText(family.getMivokTransistion());


        // Find the TextView in the list_item.xml layout with the english text
        TextView englishTextView = (TextView) view.findViewById(R.id.english_text);
        // Get the english transistion from the current Word object and
        // set this text on the english TextView
        englishTextView.setText(family.getEnglishTransistion());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) view.findViewById(R.id.images_view_id);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(family.getImageResourceId());

        /**
         * this is for the background color of the both text view
         */
        View textContainer = view.findViewById(R.id.both_text_color_container);
        int colorContain = ContextCompat.getColor(getContext(),colorId);
        textContainer.setBackgroundColor(colorContain);


        //       dafault return :-  return super.getView(position, convertView, parent);
        return view;

    }

}


