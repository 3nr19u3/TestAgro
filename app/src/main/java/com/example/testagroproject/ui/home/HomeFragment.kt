package com.example.testagroproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.testagroproject.Items
import com.example.testagroproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val bundle = Bundle()

        val btn_cargar: Button = binding.btnCargar
        val imgView: ImageView = binding.imgvShow
        val imgMinView1: ImageView = binding.imageView
        val imgMinView2: ImageView = binding.imageView1
        val imgMinView3: ImageView = binding.imageView2
        val imgMinView4: ImageView = binding.imageView3
        val imgMinView5: ImageView = binding.imageView4
        val imgMinView6: ImageView = binding.imageView5
        val url : EditText = binding.edtextUrl
        val tamano : Int = 6
        var cont : Int = 0

        btn_cargar.setOnClickListener{
            val direccion = url.text.toString()
            Log.i("**k1k3**", direccion)
            Glide.with(this).load(direccion).placeholder(android.R.drawable.ic_delete).into(imgView)
            //Grabar imagen en la memoria
            try{
                var i=0
                //Definir un Arreglo que contengan todas las Url's
                var items: Array<String> = Array(tamano,{i->""})
                //Ingresamos direccion al Array
                items.set(i,direccion)
                //Recorrer Array y Setear Data en el imageView
                if(!items.isEmpty()){
                    for (item in items){
                        if(cont===0){
                            llenaArray(direccion, imgMinView1)
                            cont++
                            break;
                        }else if(cont===1){
                            llenaArray(direccion, imgMinView2)
                            cont++
                            break;
                        }else if(cont===2){
                            llenaArray(direccion, imgMinView3)
                            cont++
                            break;
                        }else if(cont===3){
                            llenaArray(direccion, imgMinView4)
                            cont++
                            break;
                        }else if(cont===4){
                            llenaArray(direccion, imgMinView5)
                            cont++
                            break;
                        }else if(cont===5){
                            llenaArray(direccion, imgMinView6)
                            cont++
                            break;
                        }else {
                            Toast.makeText(
                                activity,
                                "Numero de valores maximos alcanzados!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    bundle.putString("img$cont",direccion)
                    parentFragmentManager.setFragmentResult("key", bundle)
                }else{
                    Log.i("**ERROR**", "Array Vacio")
                }

            }catch(e: Exception){
                e.printStackTrace()
            }

        }

        return root
    }

    private fun llenaArray(item: String, imv: ImageView) {
        Glide.with(this).load(item).placeholder(android.R.drawable.ic_delete).into(imv)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}