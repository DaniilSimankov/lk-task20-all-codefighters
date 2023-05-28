import 'package:flutter/material.dart';
import 'package:hakaton_v_1/screens/bottomNavigationBar.dart';
import 'package:hakaton_v_1/screens/confirmation_screen.dart';
import 'package:hakaton_v_1/screens/registration_screen.dart';
import 'package:provider/provider.dart';
import 'package:hakaton_v_1/screens/login_screen.dart';
import 'package:hakaton_v_1/screens/home_screen.dart';
import 'package:hakaton_v_1/theme/app_theme.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (_) => ThemeChanger(ThemeData.light()),
      child: MaterialAppWithTheme(),
    );
  }
}

class MaterialAppWithTheme extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final theme = Provider.of<ThemeChanger>(context);

    return MaterialApp(
      initialRoute: '/home',
      routes: {
        '/login': (context) => LoginScreen(),
        '/registration': (context) => RegistrationScreen(),
        '/confirm': (context) => ConfirmationScreen(),
        '/home': (context) =>
            HomeScreen(), // Замените на ваш реальный HomeScreen.
      },
      theme: theme.getTheme(),
    );
  }
}
