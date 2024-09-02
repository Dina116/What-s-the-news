package com.training.whatsthenews

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class ForgotPasswordFragmentDirections private constructor() {
  public companion object {
    public fun actionForgotPasswordFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_forgotPasswordFragment_to_loginFragment)
  }
}
