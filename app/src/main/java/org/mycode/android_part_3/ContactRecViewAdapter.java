package org.mycode.android_part_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRecViewAdapter extends RecyclerView.Adapter<ContactRecViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context ;

    public ContactRecViewAdapter(Context context){
        this.context = context ;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false); //inflate a layout
        // Inside the main, we can use getLayoutInflator but in a class, we can not, we use from and inflate instead
        // The View group is the parent of all the layouts, the view group can be used to group different views inside this
        // if the boolean is true, it will be redundant
        //if we not sure about the parent, or about where our view is going to be attached, use null

        ViewHolder holder = new ViewHolder(view);
        return holder ;
        // this holder after return will be pass into onBindViewHolder method
        // display all elements of the view holder class to recycle view
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ContactRecViewAdapter.ViewHolder holder, int position) {
        //this methods in the parents clas can access to al private attributes of the child class
        //position get from recViewadapter
        // the most important method, from this can set onlickListener to every UI elements
        holder.txtName.setText(contacts.get(position).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(position).getName() + " Selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { // return the count of the different elements of your adapter
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged(); //notify the adapter that the data has been changed, refer the recycle view with the new data(the data that pass to this class)
    }



    //hold the view for every item in recycle view, generating view objects
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName ;
        private RelativeLayout parent ;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            //because this is not main activity, we need to put itemView
            txtName = itemView.findViewById(R.id.txtName);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
