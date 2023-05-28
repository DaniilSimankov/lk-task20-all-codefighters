import 'package:flutter/material.dart';
import 'package:hakaton_v_1/screens/login_screen.dart';
import 'package:hakaton_v_1/screens/confirmation_screen.dart';

class RegistrationScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Positioned(
              right: 20.0, // Позиция от левого края экрана
              top: 65.0, // Позиция от верхнего края экрана
              child: Image.asset('assets/logo.png'),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              // children: [
              //   Image.asset('assets/logo.png'), // Замените на путь к вашему логотипу
              // ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                IconButton(
                  icon: Icon(Icons.arrow_back),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => LoginScreen()),
                    );
                  },
                ),
                Text('Регистрация'),
              ],
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Имя',
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Email',
              ),
            ),
            TextField(
              obscureText: true,
              decoration: InputDecoration(
                labelText: 'Пароль',
              ),
            ),
            TextField(
              obscureText: true,
              decoration: InputDecoration(
                labelText: 'Повторите Пароль',
              ),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, '/confirm');
              },
              child: Text('Зарегистрироваться'),
            ),
          ],
        ),
      ),
    );
  }
}
