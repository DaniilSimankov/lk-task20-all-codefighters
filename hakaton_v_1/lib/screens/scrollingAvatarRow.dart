import 'package:flutter/material.dart';

class ScrollingAvatarRow extends StatelessWidget {
  final List<AvatarItem> items;

  ScrollingAvatarRow({required this.items});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      child: Row(
        children: items.map((item) {
          return Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              children: [
                CircleAvatar(
                  backgroundImage: NetworkImage(item.imageUrl),
                  radius: 40,
                ),
                SizedBox(height: 8),
                Text(
                  item.label,
                  style: TextStyle(fontSize: 11),
                ),
              ],
            ),
          );
        }).toList(),
      ),
    );
  }
}

class AvatarItem {
  final String imageUrl;
  final String label;

  AvatarItem({required this.imageUrl, required this.label});
}