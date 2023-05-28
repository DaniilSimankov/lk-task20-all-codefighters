import 'package:flutter/material.dart';
import 'package:hakaton_v_1/screens/home_screen.dart';
import 'package:hakaton_v_1/screens/registration_screen.dart';

import 'bottomNavigationBar.dart';

class ConfirmationScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Size screenSize = MediaQuery.of(context).size;

    return Scaffold(
      body: Stack(
        children: [
          Positioned(
            left: 0.0, // Позиция от левого края экрана
            top: 0.0, // Позиция от верхнего края экрана
            child: Container(
              width: MediaQuery.of(context).size.width,
              height: MediaQuery.of(context).size.height,
              child: Image.asset(
                'assets/conf_bg_1.png',
                fit: BoxFit.cover,
              ),
            ),
          ),
          Positioned(
            right: 20.0, // Позиция от левого края экрана
            top: 65.0, // Позиция от верхнего края экрана
            child: Image.asset('assets/logo.png'),
          ),
          Positioned(
            left: 10.0, // Позиция от левого края экрана
            top: -100.0, // Позиция от верхнего края экрана
            child: Container(
              child: Image.asset(
                'assets/conf_img1.png',
                fit: BoxFit.cover,
              ),
            ),
          ),
          Positioned(
            left: MediaQuery.of(context).size.width * 0.25,
            // Позиция от левого края экрана
            top: MediaQuery.of(context).size.height *
                0.6, // Позиция от верхнего края экрана
            child: Center(
              child: Column(
                children: [
                  Text(
                    "Аккаунт создан",
                    style: TextStyle(
                      fontSize: 24.0,
                      color: Colors.black, // Цвет текста
                    ),
                  ),
                  SizedBox(
                    height: 12,
                  ),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.pushNamed(context, '/home');
                    },
                    child: Text('Перейти в приложение'),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
