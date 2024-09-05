package com.training.whatsthenews

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class FavoriteFragmentDirections private constructor() {
  public companion object {
    public fun actionFavoriteFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_favoriteFragment_to_homeFragment)
  }
}
