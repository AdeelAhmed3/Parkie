package com.example.parkie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ControlAdapter extends BaseAdapter {

    List<ControlBean> data;

    public ControlAdapter(List<ControlBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_layout,viewGroup,false);
       TextView txt = view.findViewById(R.id.txt_container_item);
        ImageView imageView = view.findViewById(R.id.image_control_item);
        txt.setText(data.get(position).getText());
        imageView.setImageDrawable(viewGroup.getContext().getDrawable(data.get(position).getImage()));
       return view;
    }
}
