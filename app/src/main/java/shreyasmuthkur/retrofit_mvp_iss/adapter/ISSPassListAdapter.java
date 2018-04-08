package shreyasmuthkur.retrofit_mvp_iss.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import shreyasmuthkur.retrofit_mvp_iss.R;
import shreyasmuthkur.retrofit_mvp_iss.model.ResponseModel;
import shreyasmuthkur.retrofit_mvp_iss.utils.AppConstants;

/**
 * Created by shreyasmp on 4/5/18.
 * <p>
 * Recycler view adapter for displaying the list of pass times for ISS at given coordinates of Lat/Lng
 * Using View holder pattern and butter knife for view binding
 */

public class ISSPassListAdapter extends RecyclerView.Adapter<ISSPassListAdapter.ViewHolder> implements AppConstants {

    private static final String TAG = ISSPassListAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<ResponseModel> responseModels;

    public ISSPassListAdapter(Context context, ArrayList<ResponseModel> responseModels) {
        this.context = context;
        this.responseModels = responseModels;
    }

    @Override
    public ISSPassListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iss_pass_list_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ISSPassListAdapter.ViewHolder holder, int position) {
        String durationInSeconds = String.valueOf(responseModels.get(position).getDuration()) + DURATION_SECONDS;
        holder.iss_duration.setText(durationInSeconds);

        // Converting epoch time to Local time
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.US);
        String formattedDate = format.format(new Date(responseModels.get(position).getRisetime() * 1000));
        holder.iss_riseTime.setText(formattedDate);
    }

    @Override
    public int getItemCount() {
        return responseModels == null ? 0 : responseModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Using ButterKnife view binding API for views

        @BindView(R.id.iss_pass_duration)
        TextView iss_duration;
        @BindView(R.id.iss_pass_risetime)
        TextView iss_riseTime;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
