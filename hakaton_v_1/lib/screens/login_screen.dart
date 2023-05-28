import 'package:flutter/material.dart';
import 'package:hakaton_v_1/screens/registration_screen.dart';
import 'package:provider/provider.dart';
import 'package:hakaton_v_1/theme/app_theme.dart';
import 'package:flutter_svg/flutter_svg.dart';
// import 'package:hakaton_v_1/screens/second_screen.dart'; // Если у вас есть второй экран

class LoginScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final theme = Provider.of<ThemeChanger>(context);
    return Scaffold(
      body: Stack(
        children: [
          Positioned(
            right: 20.0, // Позиция от левого края экрана
            top: 65.0, // Позиция от верхнего края экрана
            child: Image.asset('assets/logo.png'),
          ),
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text('Приветствуем!'),
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
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Row(
                      children: [
                        Checkbox(value: false, onChanged: (_) {}),
                        Text('Запомнить меня'),
                      ],
                    ),
                    // TextButton(
                    //   onPressed: () {
                    //     Navigator.push(
                    //       context,
                    //       MaterialPageRoute(builder: (context) => SecondRoute()),
                    //     );
                    //   },
                    //   child: Text('Забыли пароль'),
                    // ),
                  ],
                ),
                ElevatedButton(
                  onPressed: () {},
                  child: Text('Войти'),
                ),
                TextButton(
                  onPressed: () {
                    Navigator.pushNamed(context, '/registration');
                  },
                  child: Text('Нет аккаунта? Зарегистрироваться'),
                ),
                GestureDetector(
                  onTap: () {},
                  child: Image.asset(
                    'assets/vklogo.png',
                    // Другие свойства изображения
                  ),
                ),
                TextButton(
                  onPressed: () {},
                  child: Text('Пропустить'),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
