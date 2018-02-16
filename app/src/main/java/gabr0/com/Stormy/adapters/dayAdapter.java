package gabr0.com.Stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import gabr0.com.Stormy.R;
import gabr0.com.Stormy.weather.Day;

/**
 * Created by Gabr0 on 16/02/2018.
 */

public class dayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public dayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            //brand new
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) view.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) view.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) view.findViewById(R.id.dayNameLabel);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Day day = mDays[i];
        holder.iconImageView.setImageResource(day.getIconId());
        int tempC = day.getTemperatureMax() - 32;
        tempC = tempC * 5 / 9;
        holder.temperatureLabel.setText(String.format("%s", tempC));
        if (i == 0) {
            holder.dayLabel.setText(R.string.Today);
        } else {

            holder.dayLabel.setText(day.getDayOfTheWeek());
        }
        return view;
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }

}
