package com.example.crowdfunding.crowdfunding.UI.collecte_details_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crowdfunding.crowdfunding.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DonateFragment extends DialogFragment {
    @BindView(R.id.tv_frag_diag_somme_label)
    TextView tvFragDiagSommeLabel;
    @BindView(R.id.et_frag_diag_somme)
    EditText etFragDiagSomme;
    @BindView(R.id.fb_frag_diag_donate)
    FloatingActionButton fbFragDiagDonate;
    Unbinder unbinder;
    private EditText mEditText;

    public DonateFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static DonateFragment newInstance() {
        DonateFragment frag = new DonateFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_donate, container);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fb_frag_diag_donate)
    public void onViewClicked() {
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
