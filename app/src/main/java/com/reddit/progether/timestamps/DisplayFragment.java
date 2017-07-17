package com.reddit.progether.timestamps;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reddit.progether.timestamps.databinding.FragmentDisplayBinding;
import com.reddit.progether.timestamps.timestamp.Timestamp;
import com.reddit.progether.timestamps.timestamp.TimestampStatus;
import com.reddit.progether.timestamps.timestamp.TimestampsLogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        FragmentDisplayBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display, container, false);
        RecyclerView recyclerview = binding.recyclerview;
        TimestampsLogic logic = new TimestampsLogic();
//        List<Timestamp> timestamps = logic.getTimestamps();
        List<Timestamp> timestamps = new ArrayList<>();
        timestamps.add(new Timestamp(new Date(System.currentTimeMillis()), TimestampStatus.Gestartet));
        timestamps.add(new Timestamp(new Date(System.currentTimeMillis()), TimestampStatus.Geschlossen));
        timestamps.add(new Timestamp(new Date(System.currentTimeMillis()), TimestampStatus.Gestartet));
        timestamps.add(new Timestamp(new Date(System.currentTimeMillis()), TimestampStatus.Geschlossen));
        timestamps.add(new Timestamp(new Date(System.currentTimeMillis()), TimestampStatus.Geschlossen));
        recyclerview.setAdapter(new MyAdapter(timestamps));
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        View root = binding.getRoot();
        return root;
    }

}
