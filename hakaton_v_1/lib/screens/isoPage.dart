import 'package:flutter/material.dart';

import '../services/services.dart';

class IsoPage extends StatefulWidget {
  @override
  _IsoPageState createState() => _IsoPageState();
}

class _IsoPageState extends State<IsoPage> {
TextEditingController _textEditingController = TextEditingController();
  FocusNode _focusNode = FocusNode();
  bool _isLabelVisible = true;
  ApiService apiService = ApiService();
  var musicData;

  @override
  void initState() {
    super.initState();
    _fetchMusicData();
    _focusNode.addListener(() {
      setState(() {
        _isLabelVisible = !_focusNode.hasFocus;
      });
    });
  }

  void _fetchMusicData() async {
    try {
      musicData = await apiService.getArt();
      print(musicData);
      // Обработка полученных данных
    } catch (e) {
      // Обработка ошибки
      print('Failed to fetch music data: $e');
    }
  }

  @override
  void dispose() {
    _textEditingController.dispose();
    _focusNode.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.transparent,
      body: SingleChildScrollView(
        child: Column(
          children: [
            SizedBox(
              height: 18,
            ),
            Center(
              child: Container(
                width: MediaQuery.of(context).size.width *
                    0.9, // Занимает 80% ширины экрана
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(14),
                ),
                padding: EdgeInsets.only(
                  top: 13,
                  left: 12,
                  right: 12,
                  bottom: 7,
                ), // Внутренний отступ (паддинг) 10 пунктов со всех сторон
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      "О Направлении",
                      style: TextStyle(
                        fontSize: 18,
                        color: Colors.black,
                      ),
                    ),
                    SizedBox(
                      height: 4,
                    ),
                    FutureBuilder(
                      future: apiService.getArt(),
                      builder: (BuildContext context, AsyncSnapshot snapshot) {
                        if (snapshot.hasData) {
                          return Text(
                            snapshot.data['description'],
                            style: TextStyle(
                              fontSize: 14,
                              color: Colors.black,
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text("Error: ${snapshot.error}");
                        }

                        // By default, show a loading spinner.
                        return CircularProgressIndicator();
                      },
                    ),
                  ],
                ),
              ),
            ),
            SizedBox(
              height: 18,
            ),
            GestureDetector(
              onTap: () {
                if (_focusNode.hasFocus) {
                  _focusNode.unfocus();
                }
              },
              child: Container(
                width: MediaQuery.of(context).size.width * 0.9,
                child: TextField(
                  controller: _textEditingController,
                  focusNode: _focusNode,
                  decoration: InputDecoration(
                    labelText: _isLabelVisible ? 'Поиск по записям' : null,
                    contentPadding: EdgeInsets.symmetric(vertical: 10),
                    prefixIcon: Icon(Icons.search),
                    filled: true,
                    fillColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(14),
                    ),
                    enabledBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.transparent),
                      borderRadius: BorderRadius.circular(14),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.transparent),
                      borderRadius: BorderRadius.circular(14),
                    ),
                  ),
                ),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              width: MediaQuery.of(context).size.width * 0.9,
              child: Column(
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text(
                        "Школы",
                        style: TextStyle(
                          fontSize: 24,
                          color: Colors.black,
                        ),
                      ),
                      GestureDetector(
                        onTap: () {
                          _showModalBottomSheet(context);
                        },
                        child: Text(
                          'Все школы',
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.black,
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Container(
                    height: 120,
                    child: SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: ListView(
                        shrinkWrap: true,
                        scrollDirection: Axis.horizontal,
                        children: [
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                          SizedBox(
                            width: 16,
                          ),
                          _MyContainer(),
                        ],
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 18,
                  ),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Статьи",
                        style: TextStyle(
                          fontSize: 24,
                        ),
                      ),
                      _MyCardContainer(),
                      SizedBox(
                        height: 12,
                      ),
                      _MyCardContainer(),
                      SizedBox(
                        height: 12,
                      ),
                      _MyCardContainer(),
                      SizedBox(
                        height: 12,
                      ),
                      _MyCardContainer(),
                      SizedBox(
                        height: 12,
                      ),
                      _MyCardContainer(),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _MyContainer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 120,
      width: 88,
      decoration: BoxDecoration(
        color: Colors.grey[300],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Stack(
        alignment: Alignment.bottomLeft,
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: Image.asset(
              'assets/school_1.png', // Путь к вашей картинке
              fit: BoxFit.cover,
              height: 120,
              width: 88,
            ),
          ),
          Container(
            padding: EdgeInsets.all(8),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(8),
              gradient: LinearGradient(
                begin: Alignment.bottomCenter,
                end: Alignment.topCenter,
                colors: [
                  Colors.black.withOpacity(0.7),
                  Colors.transparent,
                ],
              ),
            ),
            child: Text(
              'Текст в две строки, которая может быть обрезана',
              style: TextStyle(
                fontSize: 12,
                color: Colors.white,
              ),
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
            ),
          ),
        ],
      ),
    );
  }
}

class _MyCardContainer extends StatefulWidget {
  @override
  _MyCardContainerState createState() => _MyCardContainerState();
}

class _MyCardContainerState extends State<_MyCardContainer> {
  bool _isExpanded = false;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 110,
      width: MediaQuery.of(context).size.width * 0.9,
      padding: EdgeInsets.all(10),
      decoration: BoxDecoration(
        color: Color.fromARGB(255, 58, 58, 58),
        borderRadius: BorderRadius.circular(14),
      ),
      child: Row(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: Image.asset(
              'assets/music_photo_1.png',
              fit: BoxFit.cover,
              height: 120,
              width: 88,
            ),
          ),
          Expanded(
            child: Padding(
              padding: EdgeInsets.symmetric(horizontal: 10),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "Ученик играет на гитаре ногами",
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 12,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(height: 6),
                  AnimatedCrossFade(
                    duration: const Duration(milliseconds: 200),
                    firstChild: Text(
                      "В школе им.Петрова Иван Иванович научил Петю играть ногами на гитаре а еще в школе им.Петрова Иван Иванович научил Петю играть ногами на гитаре",
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 10,
                      ),
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    secondChild: Text(
                      "В школе им.Петрова Иван Иванович научил Петю играть ногами на гитаре а еще в школе им.Петрова Иван Иванович научил Петю играть ногами на гитаре",
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 10,
                      ),
                    ),
                    crossFadeState: _isExpanded
                        ? CrossFadeState.showSecond
                        : CrossFadeState.showFirst,
                  ),
                  Spacer(),
                  GestureDetector(
                    onTap: () {
                      setState(() {
                        _isExpanded = !_isExpanded;
                      });
                    },
                    child: Text(
                      "Подробнее",
                      style: TextStyle(
                        color: Colors.green,
                      ),
                    ),
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

void _showModalBottomSheet(BuildContext context) {
  showModalBottomSheet(
    context: context,
    isScrollControlled: true,
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.vertical(top: Radius.circular(25.0)),
    ),
    builder: (context) {
      return Container(
        height: MediaQuery.of(context).size.height * 0.7,
        child: DraggableScrollableSheet(
          maxChildSize: 1,
          initialChildSize: 1,
          minChildSize: 1,
          builder: (BuildContext context, ScrollController scrollController) {
            return Container(
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20),
                  topRight: Radius.circular(20),
                ),
              ),
              child: ListView(
                controller: scrollController,
                children: [
                  // Иконка и текст
                  Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: [
                      IconButton(
                        icon: Icon(Icons.arrow_back),
                        onPressed: () => Navigator.pop(context),
                      ),
                      Text(
                        'Все школы',
                        style: TextStyle(
                            fontSize: 24, fontWeight: FontWeight.bold),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      SchoolComponent(),
                      SizedBox(
                        height: 16,
                      ),
                      SchoolComponent(),
                      SizedBox(
                        height: 16,
                      ),
                      SchoolComponent(),
                    ],
                  ),
                  // Контент

                  // SchoolComponent(),
                  // SchoolComponent(),
                  // SchoolComponent(),
                ],
              ),
            );
          },
        ),
      );
    },
  );
}

class SchoolComponent extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // Ваш код для обработки нажатия
        _showOneSchoolModalBottomSheet(
            context); // Пример вызова функции для открытия модального нижнего листа
      },
      child: Container(
        width: MediaQuery.of(context).size.width * 0.9,
        child: Row(
          children: [
            Container(
              width: 54,
              height: 70,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(8),
                color: Colors.grey[300],
              ),
              // Замените путь к картинке на свой
              child: Image.asset('assets/school_1.png', fit: BoxFit.cover),
            ),
            SizedBox(width: 10),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'Название школы',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 4),
                Text(
                  'Адрес этой школы',
                  style: TextStyle(fontSize: 14, color: Colors.grey[600]),
                ),
                SizedBox(height: 4),
                Row(
                  children: [
                    Icon(Icons.star_border, color: Colors.grey),
                    Icon(Icons.star_border, color: Colors.grey),
                    Icon(Icons.star_border, color: Colors.grey),
                    Icon(Icons.star_border, color: Colors.grey),
                    Icon(Icons.star_border, color: Colors.green),
                    SizedBox(
                      width: 10,
                    ),
                    Text(
                      "4.1",
                      style: TextStyle(fontSize: 14, color: Colors.black),
                    )
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

void _showOneSchoolModalBottomSheet(BuildContext context) {
  showModalBottomSheet(
    context: context,
    isScrollControlled: true,
    shape: RoundedRectangleBorder(
      borderRadius: BorderRadius.vertical(top: Radius.circular(25.0)),
    ),
    builder: (context) {
      return Container(
        height: MediaQuery.of(context).size.height * 0.7,
        child: DraggableScrollableSheet(
          maxChildSize: 1,
          initialChildSize: 1,
          minChildSize: 1,
          builder: (BuildContext context, ScrollController scrollController) {
            return Container(
              decoration: BoxDecoration(
                color: Color.fromRGBO(163, 200, 216, 1),
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20),
                  topRight: Radius.circular(20),
                ),
              ),
              child: ListView(
                controller: scrollController,
                children: [
                  // Иконка и текст
                  Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: [
                      IconButton(
                        icon: Icon(Icons.arrow_back),
                        onPressed: () => Navigator.pop(context),
                      ),
                      Text(
                        'Название школы',
                        style: TextStyle(
                            fontSize: 24, fontWeight: FontWeight.bold),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Container(
                    padding: EdgeInsets.only(
                        left: MediaQuery.of(context).size.width * 0.05),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Container(
                          width: MediaQuery.of(context).size.width * 0.9,
                          height: 180,
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(14),
                            image: DecorationImage(
                              image: AssetImage(
                                  'assets/one_school_1.png'), // Замените путь к вашей картинке
                              fit: BoxFit.cover,
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 16,
                        ),
                        Text(
                          "Адрес супер крутой, честно",
                          style: TextStyle(
                              fontSize: 20, fontWeight: FontWeight.bold),
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.start,
                          children: [
                            Text(
                              "phone",
                              style: TextStyle(fontSize: 14),
                            ),
                            SizedBox(
                              width: 60,
                            ),
                            Text(
                              "Email",
                              style: TextStyle(fontSize: 14),
                            ),
                          ],
                        ),
                        SizedBox(
                          height: 20,
                        ),
                        Text(
                          "Ближайшие мероприятия",
                          style: TextStyle(
                              fontSize: 20, fontWeight: FontWeight.bold),
                        ),
                        Container(
                          height: 90,
                          child: SingleChildScrollView(
                            scrollDirection: Axis.horizontal,
                            child: ListView(
                              shrinkWrap: true,
                              scrollDirection: Axis.horizontal,
                              children: [
                                _ActionContainer(),
                                SizedBox(
                                  width: 16,
                                ),
                                _ActionContainer(),
                                SizedBox(
                                  width: 16,
                                ),
                                _ActionContainer(),
                                SizedBox(
                                  width: 16,
                                ),
                                _ActionContainer(),
                                SizedBox(
                                  width: 16,
                                ),
                                _ActionContainer(),
                                SizedBox(
                                  width: 16,
                                ),
                              ],
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 24,
                        ),
                        Text(
                          "Рейтинг",
                          style: TextStyle(
                            fontSize: 18,
                          ),
                        ),
                        Row(
                          children: [
                            Icon(Icons.star_border, color: Colors.grey),
                            Icon(Icons.star_border, color: Colors.grey),
                            Icon(Icons.star_border, color: Colors.grey),
                            Icon(Icons.star_border, color: Colors.grey),
                            Icon(Icons.star_border, color: Colors.green),
                            SizedBox(
                              width: 10,
                            ),
                            Text(
                              "4.1",
                              style:
                                  TextStyle(fontSize: 14, color: Colors.black),
                            ),
                            SizedBox(
                              width: 30,
                            ),
                            ElevatedButton(
                              onPressed: () {
                                // Действия при нажатии кнопки
                              },
                              style: ElevatedButton.styleFrom(
                                primary: Color.fromRGBO(
                                    124, 114, 191, 1), // Цвет кнопки
                                onPrimary:
                                    Colors.white, // Цвет текста на кнопке
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(
                                      16), // Закругленные углы кнопки
                                ),
                              ),
                              child: Text(
                                'Перейти на сайт',
                                style: TextStyle(
                                  fontSize: 16,
                                ),
                              ),
                            ),
                          ],
                        ),
                      ],
                    ),
                  ),
                  // Контент

                  // SchoolComponent(),
                  // SchoolComponent(),
                  // SchoolComponent(),
                ],
              ),
            );
          },
        ),
      );
    },
  );
}

class _ActionContainer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 140,
      decoration: BoxDecoration(
        color: Colors.red,
        borderRadius: BorderRadius.circular(8),
      ),
      child: Stack(
        alignment: Alignment.bottomLeft,
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: Image.asset(
              'assets/action_1.png', // Путь к вашей картинке
              fit: BoxFit.fill,
              height: 90,
              width: 140,
            ),
          ),
          Container(
            padding: EdgeInsets.all(8),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(8),
              gradient: LinearGradient(
                begin: Alignment.bottomCenter,
                end: Alignment.topCenter,
                colors: [
                  Colors.black.withOpacity(0.7),
                  Colors.transparent,
                ],
              ),
            ),
            child: Text(
              'Текст в две строки, которая может быть обрезана',
              style: TextStyle(
                fontSize: 12,
                color: Colors.white,
              ),
              maxLines: 2,
              overflow: TextOverflow.ellipsis,
            ),
          ),
        ],
      ),
    );
  }
}