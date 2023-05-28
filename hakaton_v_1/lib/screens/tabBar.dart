import 'package:flutter/material.dart';
import 'package:hakaton_v_1/screens/cirkPage.dart';
import 'package:hakaton_v_1/screens/horeoPage.dart';
import 'package:hakaton_v_1/screens/isoPage.dart';
import 'package:hakaton_v_1/screens/login_screen.dart';
import 'package:hakaton_v_1/screens/musicPage.dart';
import 'package:hakaton_v_1/screens/teatrPage.dart';

class TabBarPage extends StatefulWidget {
  @override
  _TabBarPageState createState() => _TabBarPageState();
}

class _TabBarPageState extends State<TabBarPage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 5, vsync: this);
    _tabController.addListener(() {
      setState(() {}); // Это вызовет перерисовку виджета при изменении вкладки.
    });
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  String _getBackgroundImage() {
    switch (_tabController.index) {
      case 0:
        return "assets/tabBar_1.png";
      case 1:
        return "assets/tabBar_2.png";
      case 2:
        return "assets/tabBar_3.png";
      case 3:
        return "assets/tabBar_4.png";
      case 4:
        return "assets/tabBar_5.png";
      default:
        return "assets/tabBar_5.png"; // Путь к изображению по умолчанию
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Container(
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage(
                  _getBackgroundImage(),
                ),
                fit: BoxFit.cover,
              ),
            ),
          ),
          Column(
            children: [
              SizedBox(
                height: 50,
              ),
              Container(
                height: 80,
                child: SingleChildScrollView(
                  scrollDirection: Axis.horizontal,
                  child: ListView(
                    shrinkWrap: true,
                    scrollDirection: Axis.horizontal,
                    children: [
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                      Column(
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: AssetImage('assets/conf_bg_1.png'),
                          ),
                          Text("Посмотри!")
                        ],
                      ),
                      SizedBox(
                        width: 10,
                      ),
                    ],
                  ),
                ),
              ),
              Container(
                height: 40,
                color: Colors.transparent,
                child: TabBar(
                  controller: _tabController,
                  tabs: [
                    Tab(
                      child: Text(
                        'Музыка',
                        style: TextStyle(
                          fontSize: 10.0,
                          color: Colors.black,
                        ), // Уменьшаем размер текста
                      ),
                    ),
                    Tab(
                      child: Text(
                        'ИЗО',
                        style: TextStyle(
                          fontSize: 10.0,
                          color: Colors.black,
                        ), // Уменьшаем размер текста
                      ),
                    ),
                    Tab(
                      child: Text(
                        'Хореография',
                        style: TextStyle(
                          fontSize: 10.0,
                          color: Colors.black,
                        ), // Уменьшаем размер текста
                      ),
                    ),
                    Tab(
                      child: Text(
                        'Театр',
                        style: TextStyle(
                          fontSize: 10.0,
                          color: Colors.black,
                        ), // Уменьшаем размер текста
                      ),
                    ),
                    Tab(
                      child: Text(
                        'Цирк',
                        style: TextStyle(
                          fontSize: 10.0,
                          color: Colors.black,
                        ), // Уменьшаем размер текста
                      ),
                    ),
                  ],
                  indicatorColor: Colors.black,
                ),
              ),
              Expanded(
                child: TabBarView(
                  controller: _tabController,
                  children: [
                    // Содержимое для каждой вкладки
                    MusicPage(),
                    MusicPage(),
                    MusicPage(),
                    MusicPage(),
                    MusicPage(),
                    // IsoPage(),
                    // HoreoPage(),
                    // TeatrPage(),
                    // CirkPage(),
                  ],
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
