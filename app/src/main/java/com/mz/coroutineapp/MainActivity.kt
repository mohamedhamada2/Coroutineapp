package com.mz.coroutineapp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.mz.coroutineapp.api.BFEApi
import com.mz.coroutineapp.application.MyApplication
import com.mz.coroutineapp.databinding.ActivityMainBinding
import com.mz.coroutineapp.home.Image
import com.mz.coroutineapp.home.SliderAdapter
import kotlinx.coroutines.flow.collect
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var categoryViewModel:CategoryViewModel
    lateinit var categoryInHomeAdapter: CategoryAdapter
    lateinit var layoutmanger:RecyclerView.LayoutManager
    lateinit var dots: Array<ImageView>
    lateinit var viewPagerAdapter :SliderAdapter
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var bfeApi: BFEApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = setContentView(this,R.layout.activity_main)
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        (application as MyApplication).getNetComponent()!!.inject2(this)
        categoryInHomeAdapter = CategoryAdapter()
       // init_slider()
        layoutmanger = LinearLayoutManager(this)
        activityMainBinding.categoryRecycler.layoutManager = layoutmanger
        activityMainBinding.categoryRecycler.setHasFixedSize(true)
        activityMainBinding.categoryRecycler.adapter = categoryInHomeAdapter
        bfeApi = retrofit.create(BFEApi::class.java)
        categoryViewModel.get_all_data_in_page(bfeApi)
        categoryViewModel.mutableLiveData.observe(this,
            { categorymodel -> categoryInHomeAdapter.setList(categorymodel.data) })
        lifecycleScope.launchWhenStarted {
            categoryViewModel.mutablestateflow.collect {
                    categorymodel -> categoryInHomeAdapter.setList(categorymodel.data)
            }
        }
        categoryViewModel.mutableLiveData2.observe(this,
            {imagemodel -> viewPagerAdapter.setSliderList(imagemodel.data.images)})
    }

    /*fun init_slider() {
        try {
            viewPagerAdapter = SliderAdapter()
            activityMainBinding.sliderviewPager.setAdapter(viewPagerAdapter)
            val dots = arrayOfNulls<ImageView>(sliderList.size)
            for (i in sliderList.indices) {
                activityMainBinding.sliderviewPager.startAutoScroll()
                activityMainBinding.sliderviewPager.setInterval(2500)
                activityMainBinding.sliderviewPager.setCycle(true)
                activityMainBinding.sliderviewPager.setStopScrollWhenTouch(true)
                dots[i] = ImageView(this)
                dots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        getApplicationContext(),
                        R.drawable.non_active_dot
                    )
                )
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(8, 0, 8, 0)
                activityMainBinding.indecator.addView(dots[i], params)
            }

            dots[0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.active_dot
                )
            )

            activityMainBinding.sliderviewPager.addOnPageChangeListener(object :
                OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    for (i in sliderList.indices) {
                        dots[i]?.setImageDrawable(
                            ContextCompat.getDrawable(
                                getApplicationContext(),
                                R.drawable.non_active_dot
                            )
                        )
                    }
                    try{
                        dots[position]?.setImageDrawable(
                            ContextCompat.getDrawable(
                                getApplicationContext(),
                                R.drawable.active_dot
                            )
                        )
                    }catch (e: Exception) {
                        Log.d("slider_error", e.message.toString())
                    }
                }

                override fun onPageSelected(position: Int) {}
                override fun onPageScrollStateChanged(state: Int) {}
            })

        } catch (e: Exception) {
            Log.d("slider_error", e.message.toString())
        }
    }*/

}