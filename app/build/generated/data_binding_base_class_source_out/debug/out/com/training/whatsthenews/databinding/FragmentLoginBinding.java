// Generated by view binder compiler. Do not edit!
package com.training.whatsthenews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.training.whatsthenews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnForgotPass;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final TextInputEditText emailEt;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final TextView goToSignup;

  @NonNull
  public final TextInputEditText passET;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final TextView tvWelcome;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView btnForgotPass,
      @NonNull Button btnLogin, @NonNull TextInputEditText emailEt,
      @NonNull TextInputLayout emailLayout, @NonNull TextView goToSignup,
      @NonNull TextInputEditText passET, @NonNull TextInputLayout passwordLayout,
      @NonNull TextView tvWelcome) {
    this.rootView = rootView;
    this.btnForgotPass = btnForgotPass;
    this.btnLogin = btnLogin;
    this.emailEt = emailEt;
    this.emailLayout = emailLayout;
    this.goToSignup = goToSignup;
    this.passET = passET;
    this.passwordLayout = passwordLayout;
    this.tvWelcome = tvWelcome;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_forgot_pass;
      TextView btnForgotPass = ViewBindings.findChildViewById(rootView, id);
      if (btnForgotPass == null) {
        break missingId;
      }

      id = R.id.btn_login;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.emailEt;
      TextInputEditText emailEt = ViewBindings.findChildViewById(rootView, id);
      if (emailEt == null) {
        break missingId;
      }

      id = R.id.emailLayout;
      TextInputLayout emailLayout = ViewBindings.findChildViewById(rootView, id);
      if (emailLayout == null) {
        break missingId;
      }

      id = R.id.go_to_signup;
      TextView goToSignup = ViewBindings.findChildViewById(rootView, id);
      if (goToSignup == null) {
        break missingId;
      }

      id = R.id.passET;
      TextInputEditText passET = ViewBindings.findChildViewById(rootView, id);
      if (passET == null) {
        break missingId;
      }

      id = R.id.passwordLayout;
      TextInputLayout passwordLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordLayout == null) {
        break missingId;
      }

      id = R.id.tv_welcome;
      TextView tvWelcome = ViewBindings.findChildViewById(rootView, id);
      if (tvWelcome == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, btnForgotPass, btnLogin, emailEt,
          emailLayout, goToSignup, passET, passwordLayout, tvWelcome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
