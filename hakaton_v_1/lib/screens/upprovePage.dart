import 'package:flutter/material.dart';

class UpprovePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage('assets/upprove.png'),
            fit: BoxFit.cover,
          ),
        ),
      ),
    );
  }
}