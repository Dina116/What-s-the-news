package com.training.whatsthenews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.training.whatsthenews.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {

    //https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=b8cf8e3608cc463981aa21c1f53a317d usa
    //https://newsapi.org/v2/top-headlines?country=eg&category=general&apiKey=b8cf8e3608cc463981aa21c1f53a317d egypt
    //https://newsapi.org/v2/top-headlines?country=ed&category=general&apiKey=b8cf8e3608cc463981aa21c1f53a317d jermany
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up Toolbar as ActionBar
        val toolbar = binding.root.findViewById<Toolbar>(R.id.app_tool_bar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        // Disable default title
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        val title = toolbar.findViewById<TextView>(R.id.toolbar_title)
        val backBtn = toolbar.findViewById<ImageView>(R.id.back_btn)
        backBtn.isVisible = false
        title.text = "News/Categories"

        // adding menu option and favorite heart
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items
                menuInflater.inflate(R.menu.menu, menu)
            }

            // Handle the menu selection
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)

                        true
                    }

                    R.id.favorites_menu_list -> {
                        findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                        true
                    }

                    R.id.favorites_action_bar -> {
                        findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                        true
                    }
                    // for navigation to settings
//                    R.id.settings -> {
//                       // findNavController().navigate()
//                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        showCategories(loadCategories())
        loadNews()

        binding.swipeRefresh.setOnRefreshListener {
            loadNews()
        }
    }

    private fun loadNews() {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val c = retrofit.create(NewsCallable::class.java)
        val viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        viewModel.categoryImageView.observe(viewLifecycleOwner) { it ->
            when (it) {
                R.drawable.tech -> c.getTechnoNews().enqueue(object : Callback<News> {
                    override fun onResponse(p0: Call<News>, p1: Response<News>) {
                        val news = p1.body()
                        val articles = news?.articles!!
                       articles.removeAll {
                           it.title == "[Removed]"
                       }
                        showNews(articles)
                        binding.swipeRefresh.isRefreshing = false
                        binding.progressBar.isVisible = false
                        binding.textView1.text = "Technology News:"
                        Log.d("trace", "Articles: $articles")
                    }

                    override fun onFailure(p0: Call<News>, p1: Throwable) {
                        Log.d("trace", "Error: ${p1.message}")
                    }
                })

                R.drawable.health -> c.getHealthNews().enqueue(object : Callback<News> {
                    override fun onResponse(p0: Call<News>, p1: Response<News>) {
                        val news = p1.body()
                        val articles = news?.articles!!
                        articles.removeAll {
                            it.title == "[Removed]"
                        }
                        showNews(articles)
                        binding.swipeRefresh.isRefreshing = false
                        binding.progressBar.isVisible = false
                        binding.textView1.text = "Health News:"
                        Log.d("trace", "Articles: $articles")
                    }

                    override fun onFailure(p0: Call<News>, p1: Throwable) {
                        Log.d("trace", "Error: ${p1.message}")
                    }
                })

                R.drawable.sports -> c.getSportNews().enqueue(object : Callback<News> {
                    override fun onResponse(p0: Call<News>, p1: Response<News>) {
                        val news = p1.body()
                        val articles = news?.articles!!
                        articles.removeAll {
                            it.title == "[Removed]"
                        }
                        showNews(articles)
                        binding.swipeRefresh.isRefreshing = false
                        binding.progressBar.isVisible = false
                        binding.textView1.text = "Sports News:"

                        Log.d("trace", "Articles: $articles")
                    }

                    override fun onFailure(p0: Call<News>, p1: Throwable) {
                        Log.d("trace", "Error: ${p1.message}")
                    }
                })

                R.drawable.business -> c.getBusinessNews().enqueue(object : Callback<News> {
                    override fun onResponse(p0: Call<News>, p1: Response<News>) {
                        val news = p1.body()
                        val articles = news?.articles!!
                        articles.removeAll {
                            it.title == "[Removed]"
                        }
                        showNews(articles)
                        binding.swipeRefresh.isRefreshing = false
                        binding.progressBar.isVisible = false
                        binding.textView1.text = "Business News:"

                        Log.d("trace", "Articles: $articles")
                    }

                    override fun onFailure(p0: Call<News>, p1: Throwable) {
                        Log.d("trace", "Error: ${p1.message}")
                    }
                })
            }
        }

        c.getGeneralNews().enqueue(object : Callback<News> {
            override fun onResponse(p0: Call<News>, p1: Response<News>) {
                val news = p1.body()
                val articles = news?.articles!!
                articles.removeAll {
                    it.title == "[Removed]"
                }
                binding.swipeRefresh.isRefreshing = false
                binding.progressBar.isVisible = false
                Log.d("trace", "Articles: $articles")
            }

            override fun onFailure(p0: Call<News>, p1: Throwable) {
                Log.d("trace", "Error: ${p1.message}")
            }
        })
    }

    private fun showNews(articles: ArrayList<Article>) {
        val newsAdapter = NewsAdapter(this, articles)
        binding.newsRv.adapter = newsAdapter
    }

    private fun showCategories(categories: List<Category>) {
        val categoriesAdapter = CategoriesAdapter(this, categories)
        binding.categoryRv.adapter = categoriesAdapter
    }

    private fun loadCategories(): List<Category> {
        // Load categories and news
        val categories = arrayOf(
            R.drawable.tech,
            R.drawable.health,
            R.drawable.sports,
            R.drawable.business
        )
        val categoryNames = arrayOf(
            "Technology",
            "Health",
            "Sports",
            "Business"
        )
        val categoryList = mutableListOf<Category>()
        for (i in categories.indices) {
            categoryList.add(Category(categories[i], categoryNames[i]))
        }
        return categoryList
    }
}
