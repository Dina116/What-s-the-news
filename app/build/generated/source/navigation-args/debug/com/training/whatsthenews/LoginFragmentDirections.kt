package com.training.whatsthenews

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_homeFragment)

    public fun actionLoginFragmentToSignupFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_signupFragment)

    public fun actionLoginFragmentToForgotPasswordFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_forgotPasswordFragment)
  }
}
