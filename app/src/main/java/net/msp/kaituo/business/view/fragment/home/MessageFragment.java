package net.msp.kaituo.business.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.msp.kaituo.business.R;
import net.msp.kaituo.business.view.BaseFragment;

/**
 * Business
 *
 * @author kaituo:马世鹏
 * @create 2018/9/5 16:06
 * @since
 **/
public class MessageFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_layout,null,false);
        return view;
    }
}
