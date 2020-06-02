package com.example.online_veggie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExListAdapter extends BaseExpandableListAdapter
{

    Context context;
    List<String>YourItems;
    Map<String,List<String>> topics;

    public MyExListAdapter(Context context, List<String> yoursItems, Map<String, List<String>> topics) {
        this.context = context;
        YourItems = yoursItems;
        this.topics = topics;
    }

    @Override
    public int getGroupCount() {
        return YourItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return topics.get(YourItems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return YourItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return topics.get(YourItems.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

       String Items= (String) getGroup(groupPosition);
       if(convertView== null)
       {
           LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           convertView= inflater.inflate(R.layout.list_parent,null);

       }
        TextView txtparent= (TextView) convertView.findViewById(R.id.txtparent_item_id);
       txtparent.setText(Items);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String topic= (String) getChild(groupPosition,childPosition);

        if(convertView== null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.list_child,null);

        }

        TextView txtChild= (TextView) convertView.findViewById(R.id.txtchilditem_id);
        txtChild.setText(topic);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
