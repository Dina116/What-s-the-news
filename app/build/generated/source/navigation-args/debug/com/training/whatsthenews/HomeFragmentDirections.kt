package com.training.whatsthenews

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_loginFragment)

    public fun actionHomeFragmentToFavoriteFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_favoriteFragment)
  }
}
