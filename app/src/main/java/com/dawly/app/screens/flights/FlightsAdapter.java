package com.dawly.app.screens.flights;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Flight;
import com.dawly.app.views.DawlyButtonBold;

import java.util.List;

public class FlightsAdapter extends PagedListAdapter<Flight, FlightsAdapter.FlightsViewHolder> {
    private Context context;
    private List<Flight> flightList;

    public FlightsAdapter(Context context, List<Flight> flightList) {
        super(Flight.DIFF_CALLBACK);
        this.context = context;
        this.flightList = flightList;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View itemView;
        switch (itemType) {
            case 0:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight, viewGroup, false);
                return new FlightsViewHolder(itemView);
            case 1:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight_collapsed, viewGroup, false);
                return new FlightsViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight, viewGroup, false);
                return new FlightsViewHolder(itemView);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder viewHolder, int position) {
        viewHolder.bind(flightList.get(position));
        if (position % 2 == 0) {
            viewHolder.cardSide.setBackgroundColor(context.getResources().getColor(R.color.colorCardSide1));
        } else {
            viewHolder.cardSide.setBackgroundColor(context.getResources().getColor(R.color.colorCardSide2));
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (flightList.get(position).isExpanded())
            return 1;
        else
            return 0;
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    public class FlightsViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardSide;
        DawlyButtonBold close;
        CardView flightCard;

        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            cardSide = itemView.findViewById(R.id.cardSideLayout);
            flightCard = itemView.findViewById(R.id.flightCard);
            close = itemView.findViewById(R.id.closeBtn);
        }


        public void bind(Flight order) {
            flightCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (order.isExpanded()) {
                        order.setExpanded(false);
                        notifyDataSetChanged();
                    } else {
                        order.setExpanded(true);
                        notifyDataSetChanged();
                    }
                }
            });
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (order.isExpanded()) {
                        order.setExpanded(false);
                        notifyDataSetChanged();
                    } else {
                        order.setExpanded(true);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
