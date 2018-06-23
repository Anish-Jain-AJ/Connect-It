package aj.connectit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends android.support.v4.app.Fragment {

    private Button mLogoutBtn;

    //private CircleImageView mProfileImage;
    //private TextView mProfileName;


    private FirebaseAuth mAuth;
   // private FirebaseFirestore mFirestore;
    //private String mUserId;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth = FirebaseAuth.getInstance();
        //mFirestore = FirebaseFirestore.getInstance();
        //mUserId = mAuth.getCurrentUser().getUid();


        mLogoutBtn = (Button) view.findViewById(R.id.logout_btn);

       // mProfileImage =(CircleImageView)view.findViewById(R.id.profile_image);
        //mProfileName = (TextView)view.findViewById(R.id.profile_name);

        /*mFirestore.collection("Users").document(mUserId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String user_name = documentSnapshot.getString("name");
                String user_image = documentSnapshot.getString("image");

                mProfileName.setText(user_name);
            }
        });*/






        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Intent loginIntent = new Intent(container.getContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        return view;
    }

}
