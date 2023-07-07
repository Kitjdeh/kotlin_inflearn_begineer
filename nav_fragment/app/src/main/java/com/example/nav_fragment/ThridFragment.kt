package com.example.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class ThridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_thrid, container, false)
        // btn1을 클릭할 때 의 로직
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            it.findNavController().navigate(R.id.action_thridFragment_to_firstFragment)
        }
        // btn2을 클릭할 때 의 로직 action_firstFragment_to_secondFragment 로 정의된 이동(1->2)을 시킨다.
        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            it.findNavController().navigate(R.id.action_thridFragment_to_secondFragment)

        }
        // btn3을 클릭할 때 의 로직 action_firstFragment_to_thridFragment 로 정의된 이동(1->3)을 시킨다.
        view.findViewById<Button>(R.id.btn3).setOnClickListener {

        }
        return view
    }
}