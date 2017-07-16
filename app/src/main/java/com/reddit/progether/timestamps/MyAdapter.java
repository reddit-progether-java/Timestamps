package com.reddit.progether.timestamps;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.reddit.progether.timestamps.timestamp.Timestamp;
import com.reddit.progether.timestamps.timestamp.TimestampStatus;

import java.util.List;

/**
 * Created on 29.06.17.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Timestamp> list;

    public MyAdapter(List<Timestamp> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        DataBindingUtil.inflate(inflater, , parent, false);
        View view = inflater.inflate(R.layout.fragment_display_listitem, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.timestampTime.setText(list.get(position).getDate().toString());
        if (list.get(position).getStatus().equals(TimestampStatus.Geschlossen)) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.END;
            holder.timestampTime.setLayoutParams(params);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView timestampTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            timestampTime = (TextView) itemView.findViewById(R.id.item_timestamp_time);
        }
    }
}
