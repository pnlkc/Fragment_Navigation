package com.example.fragmentwithnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentwithnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // viewBinding 사용 (Activity에서 사용하는 방식)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 구글 권장 방식
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // setContentView(binding.root) 해도 상관없음


        // onCreate 안에서는 findNavController로 NavController를 찾을 수 없음
        // 대신 아래처럼 findFragmentById를 사용하여 직접 검색해야됨
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController


        // stackoverflow에 따르면 build.gradle 에서 Fragment 1.4.0 이상이면 아래로 대체 가능
        val navController = binding.navHostFragment.getFragment<NavHostFragment>().navController
        // 위에 코드는 아래 코드 축약버젼인가?
//        val navHostFragment = binding.navHostFragment.getFragment<NavHostFragment>()
//        val navController = navHostFragment.navController


        // BottomNavMenu에 NavController를 설치해주면 화면 이동이 가능해짐
        // 아래 두 코드는 동일한 기능을 함
//        NavigationUI.setupWithNavController(binding.bottomNavMenu, navController)
        binding.bottomNavMenu.setupWithNavController(navController)

        // *** 주의할점 ***
        // nav_graph.xml의 fragment Id 와 bottom_navigation_menu.xml의 item Id가 동일해야 됨
    }
}