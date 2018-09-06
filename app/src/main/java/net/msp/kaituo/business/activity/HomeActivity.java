package net.msp.kaituo.business.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.msp.kaituo.business.R;
import net.msp.kaituo.business.activity.base.BaseActivity;
import net.msp.kaituo.business.view.fragment.home.HomeFragment;
import net.msp.kaituo.business.view.fragment.home.MessageFragment;
import net.msp.kaituo.business.view.fragment.home.MineFragment;

/**
 * @fuction 创建首页所有的fragment ,以及fragment
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {
    /**
     * UI
     */
    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mMessageView;
    private TextView mMineView;
    private TextView mPondView;

    /**
     * fragment 相关
     */
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private android.support.v4.app.FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();
        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,mHomeFragment);
        fragmentTransaction.commit();



    }

    /**
     * 初始化
     */
    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mMessageView  = (TextView) findViewById(R.id.message_image_view);
        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 用来隐藏具体的fragment
     * @param fragment
     * @param ft
     */
    private void hidFragment(Fragment fragment,FragmentTransaction ft){
        if (fragment != null){
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                //隐藏其他fragment
                hidFragment(mMessageFragment,fragmentTransaction);
                hidFragment(mMineFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mHomeFragment == null){
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout,mHomeFragment);
                }else {
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                //隐藏其他fragment
                hidFragment(mHomeFragment,fragmentTransaction);
                hidFragment(mMineFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mMessageFragment == null){
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout,mMessageFragment);
                }else {
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);

                //隐藏其他fragment
                hidFragment(mHomeFragment,fragmentTransaction);
                hidFragment(mMessageFragment,fragmentTransaction);
                //将我们的HomeFragment显示出来
                if (mMineFragment == null){
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout,mMineFragment);
                }else {
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
