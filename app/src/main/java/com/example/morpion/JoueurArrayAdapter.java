package com.example.morpion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

public class JoueurArrayAdapter extends ArrayAdapter<joueur> {



    public JoueurArrayAdapter(Context context , List<joueur> joueurs){

        super(context , 0 , joueurs);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_joueur,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score);

            convertView.setTag(viewHolder);
        }


        joueur score = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.score.setText(score.getScore());
        viewHolder.nom.setText(score.getNom());


        return convertView;
    }

    private class TweetViewHolder{
        public TextView score;
        public TextView nom;

    }
}
