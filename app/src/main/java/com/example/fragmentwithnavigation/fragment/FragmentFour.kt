package com.example.fragmentwithnavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentwithnavigation.R
import com.example.fragmentwithnavigation.databinding.FragmentFourBinding

// 클래스에 프래그먼트 클래스 상속
class FragmentFour : Fragment() {

    // viewBinding 사용 (Fragment에서 사용하는 방식)
    private var _binding: FragmentFourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 구글 권장 방식
        _binding = FragmentFourBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // return binding.root 해도 상관없음
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // textView를 클릭하면 fragment_one으로 화면이 바뀌는 코드
        binding.fourTextview.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentFour_to_fragmentOne)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        // Activity의 Destroyed 생명주기에 맞춰 _binding을 null로 초기화해주면서 메모리 누수를 방지
        // 자세한 생명주기는 res/drawable/lifecycle.png 참고
        // 사진 출처 = https://velog.io/@seokzoo/ViewBinding-%EC%97%90%EC%84%9C%EC%9D%98-null-%EC%B2%98%EB%A6%AC
        _binding = null
    }

}