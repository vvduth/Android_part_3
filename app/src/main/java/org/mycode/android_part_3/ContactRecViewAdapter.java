package org.mycode.android_part_3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRecViewAdapter extends RecyclerView.Adapter<ContactRecViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();


    public ContactRecViewAdapter(){

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ContactRecViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() { // return the count of the different elements of your adapter
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged(); //notify the adapter that the data has been changed, refer the recycle view with the new data(the data that pass to this class)
    }

    private TextView txtName ;

    //hold the view for every item in recycle view, generating view objects
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            //because this is not main activity, we need to put itemView
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
