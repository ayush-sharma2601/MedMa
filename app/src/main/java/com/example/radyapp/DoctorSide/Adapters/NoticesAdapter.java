package com.example.radyapp.DoctorSide.Adapters;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radyapp.DoctorSide.ResponseModels.MedModel;
import com.example.radyapp.DoctorSide.ResponseModels.NoticeModel;
import com.example.radyapp.R;

import java.util.ArrayList;

public class NoticesAdapter extends RecyclerView.Adapter<NoticesAdapter.NoticeRVVH> {

    ArrayList<NoticeModel> noticeModels;


    public NoticesAdapter(ArrayList<NoticeModel> noticeModels) {
        this.noticeModels = noticeModels;
    }

    @NonNull
    @Override
    public NoticeRVVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NoticeRVVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_rv_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeRVVH holder, int position) {

        holder.populateDocAppointments(noticeModels.get(position));
    }

    private void cycleTextViewExpansion(TextView tv,TextView txt){
        int collapsedMaxLines = 4;
        String text = tv.getMaxLines()==collapsedMaxLines?"Read Less":"Read More";
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", tv.getMaxLines() == collapsedMaxLines? tv.getLineCount() : collapsedMaxLines);
        txt.setText(text);
        animation.setDuration(150).start();
    }

    @Override
    public int getItemCount() {
        return noticeModels.size();
    }

    public class NoticeRVVH extends RecyclerView.ViewHolder
    {
        TextView head,source,date,content,readMore;

        public NoticeRVVH(@NonNull View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.motice_head);
            source = itemView.findViewById(R.id.motice_source);
            date = itemView.findViewById(R.id.motice_date);
            readMore = itemView.findViewById(R.id.motice_read_more);
            content = itemView.findViewById(R.id.motice_content);

            readMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cycleTextViewExpansion(content,readMore);
                }
            });
        }

        public void populateDocAppointments(NoticeModel notice) {

            head.setText(notice.getHeading());
            source.setText(notice.getSource());
            date.setText(notice.getDate());
            content.setText(notice.getContent());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
