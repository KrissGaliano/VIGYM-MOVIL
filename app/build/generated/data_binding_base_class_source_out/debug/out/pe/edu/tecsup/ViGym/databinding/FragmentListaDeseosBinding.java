// Generated by view binder compiler. Do not edit!
package pe.edu.tecsup.ViGym.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pe.edu.tecsup.ViGym.R;

public final class FragmentListaDeseosBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final SwipeRefreshLayout refreshDeseos;

  @NonNull
  public final RecyclerView rvListDeseos;

  @NonNull
  public final TextView textView14;

  private FragmentListaDeseosBinding(@NonNull FrameLayout rootView,
      @NonNull SwipeRefreshLayout refreshDeseos, @NonNull RecyclerView rvListDeseos,
      @NonNull TextView textView14) {
    this.rootView = rootView;
    this.refreshDeseos = refreshDeseos;
    this.rvListDeseos = rvListDeseos;
    this.textView14 = textView14;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentListaDeseosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentListaDeseosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_lista_deseos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentListaDeseosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.refreshDeseos;
      SwipeRefreshLayout refreshDeseos = rootView.findViewById(id);
      if (refreshDeseos == null) {
        break missingId;
      }

      id = R.id.rvListDeseos;
      RecyclerView rvListDeseos = rootView.findViewById(id);
      if (rvListDeseos == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = rootView.findViewById(id);
      if (textView14 == null) {
        break missingId;
      }

      return new FragmentListaDeseosBinding((FrameLayout) rootView, refreshDeseos, rvListDeseos,
          textView14);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}