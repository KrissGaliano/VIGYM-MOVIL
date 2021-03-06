// Generated by view binder compiler. Do not edit!
package pe.edu.tecsup.ViGym.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pe.edu.tecsup.ViGym.R;

public final class ActivityMainRecupContraBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final EditText txtEmail;

  private ActivityMainRecupContraBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar progressBar, @NonNull EditText txtEmail) {
    this.rootView = rootView;
    this.progressBar = progressBar;
    this.txtEmail = txtEmail;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainRecupContraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainRecupContraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_recup_contra, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainRecupContraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.progressBar;
      ProgressBar progressBar = rootView.findViewById(id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.txtEmail;
      EditText txtEmail = rootView.findViewById(id);
      if (txtEmail == null) {
        break missingId;
      }

      return new ActivityMainRecupContraBinding((ConstraintLayout) rootView, progressBar, txtEmail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
