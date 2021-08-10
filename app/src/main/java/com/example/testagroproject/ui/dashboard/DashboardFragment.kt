package com.example.testagroproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.testagroproject.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*parentFragmentManager.setFragmentResultListener("key", this,
            { requestKey, result ->
                val value1 = result.getString("img1")
                Glide.with(this).load(value1).placeholder(android.R.drawable.ic_delete).into()
            })*/

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imgMinView6: ImageView=binding.imageView6
        val imgMinView7: ImageView=binding.imageView7
        val imgMinView8: ImageView=binding.imageView8
        val imgMinView9: ImageView=binding.imageView9
        val imgMinView10: ImageView=binding.imageView10
        val imgMinView11: ImageView=binding.imageView11

        //Glide.with(this).load("https://imagenes.elpais.com/resizer/FcU60fB_oYBSjBOezEmSyU3q3nY=/414x0/arc-anglerfish-eu-central-1-prod-prisa.s3.amazonaws.com/public/64DNMLCPWMN2WCBRWLXPDWBDHQ.jpg").placeholder(android.R.drawable.ic_delete).into(imgMinView6)

        parentFragmentManager.setFragmentResultListener("key", this,
            { requestKey, result ->
                val value1 = result.getString("img1")
                val value2 = result.getString("img2")
                val value3 = result.getString("img3")
                val value4 = result.getString("img4")
                val value5 = result.getString("img5")
                val value6 = result.getString("img6")
                Glide.with(this).load(value1).placeholder(android.R.drawable.ic_delete).into(imgMinView6)
                Glide.with(this).load(value2).placeholder(android.R.drawable.ic_delete).into(imgMinView7)
                Glide.with(this).load(value3).placeholder(android.R.drawable.ic_delete).into(imgMinView8)
                Glide.with(this).load(value4).placeholder(android.R.drawable.ic_delete).into(imgMinView9)
                Glide.with(this).load(value5).placeholder(android.R.drawable.ic_delete).into(imgMinView10)
                Glide.with(this).load(value6).placeholder(android.R.drawable.ic_delete).into(imgMinView11)
            })

        //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}