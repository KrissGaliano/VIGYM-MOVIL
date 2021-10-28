// Generated by view binder compiler. Do not edit!
package pe.edu.tecsup.ViGym.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pe.edu.tecsup.ViGym.R;

public final class ActivityShoppingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final RecyclerView rvCarrito;

  @NonNull
  public final TextView textTotalCarrito;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView6;

  private ActivityShoppingBinding(@NonNull ConstraintLayout rootView, @NonNull Button button,
      @NonNull RecyclerView rvCarrito, @NonNull TextView textTotalCarrito,
      @NonNull TextView textView4, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.button = button;
    this.rvCarrito = rvCarrito;
    this.textTotalCarrito = textTotalCarrito;
    this.textView4 = textView4;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityShoppingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityShoppingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_shopping, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityShoppingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = rootView.findViewById(id);
      if (button == null) {
        break missingId;
      }

      id = R.id.rvCarrito;
      RecyclerView rvCarrito = rootView.findViewById(id);
      if (rvCarrito == null) {
        break missingId;
      }

      id = R.id.textTotalCarrito;
      TextView textTotalCarrito = rootView.findViewById(id);
      if (textTotalCarrito == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityShoppingBinding((ConstraintLayout) rootView, button, rvCarrito,
          textTotalCarrito, textView4, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
