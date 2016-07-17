package com.peacecorps.pcsa.support_services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.peacecorps.pcsa.MainActivity;
import com.peacecorps.pcsa.R;
import com.peacecorps.pcsa.safety_tools.SafetyPlanBasicsContentFragment;
import com.peacecorps.pcsa.safety_tools.SafetyPlanBasicsFragment;

/*
 * Support Services, main fragment
 *
 * @author rohan
 * @since 2016-07-15
 */
public class SupportServicesFragment extends Fragment {

    public final static String TAG = SupportServicesFragment.class.getSimpleName();
    FloatingActionButton helpSupportButton;
    Button benefitsButton,servicesButton,commitmentButton,afterButton,confidentialityButton,mythButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_support_services,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.support_services);

        benefitsButton = (Button) rootView.findViewById(R.id.benefitsButton);
        servicesButton = (Button) rootView.findViewById(R.id.servicesButton);
        commitmentButton = (Button) rootView.findViewById(R.id.commitmentButton);
        afterButton = (Button) rootView.findViewById(R.id.afterButton);
        confidentialityButton = (Button) rootView.findViewById(R.id.confidentialityButton);
        mythButton = (Button) rootView.findViewById(R.id.mythButton);
        helpSupportButton = (FloatingActionButton) rootView.findViewById(R.id.supportHelpFabButton);
        helpSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(null,getString(R.string.some_info));
            }
        });
        
        benefitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Swapping BenefitsFragment into the container
                BenefitsFragment benefitsFragment = new BenefitsFragment();
                MainActivity.swapFragmentIn(getActivity(),benefitsFragment,BenefitsFragment.TAG,true);                
            }
        });
        
        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Swapping AvailableFragment into the container
                AvailableFragment availableFragment = new AvailableFragment();
                MainActivity.swapFragmentIn(getActivity(),availableFragment,AvailableFragment.TAG,true);
            }
        });
        
        commitmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Swapping CommitmentFragment into the container
                CommitmentFragment commitmentFragment = new CommitmentFragment();
                MainActivity.swapFragmentIn(getActivity(),commitmentFragment,CommitmentFragment.TAG,true);
            }
        });
        return rootView;
    }

    /**
     * Populates the required data for the dialog box which appears
     * @param title title of the dialog box
     * @param contentToShow  data to be displayed
     */
    private void showDialog(String title,String contentToShow)
    {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        SafetyPlanBasicsContentFragment safetyPlanBasicsContentFragment = new SafetyPlanBasicsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SafetyPlanBasicsFragment.TITLE_KEY,title);
        bundle.putString(SafetyPlanBasicsFragment.CONTENT_KEY,contentToShow);
        safetyPlanBasicsContentFragment.setArguments(bundle);
        safetyPlanBasicsContentFragment.show(fm,getString(R.string.sample_fragment));
    }
}
