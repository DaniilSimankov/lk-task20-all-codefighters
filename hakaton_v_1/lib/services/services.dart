import 'dart:convert';
import 'package:http/http.dart' as http;

class ApiService {
  final String baseUrl = 'http://178.170.193.218:8080/api/';

  Future<dynamic> getMusic() async {
    final response =
        await http.get(Uri.parse(baseUrl + 'art-direction/name?abbr=music'));

    if (response.statusCode == 200) {
      final body = utf8.decode(response.bodyBytes);
      return jsonDecode(body);
    } else {
      throw Exception('Failed to load data');
    }
  }

  Future<dynamic> getHoreo() async {
    final response = await http
        .get(Uri.parse(baseUrl + 'art-direction/name?abbr=choreography'));

    if (response.statusCode == 200) {
      final body = utf8.decode(response.bodyBytes);
      return jsonDecode(body);
    } else {
      throw Exception('Failed to load data');
    }
  }

  Future<dynamic> getTeatre() async {
    final response =
        await http.get(Uri.parse(baseUrl + 'art-direction/name?abbr=theatre'));

    if (response.statusCode == 200) {
      final body = utf8.decode(response.bodyBytes);
      return jsonDecode(body);
    } else {
      throw Exception('Failed to load data');
    }
  }

  Future<dynamic> getArt() async {
    final response =
        await http.get(Uri.parse(baseUrl + 'art-direction/name?abbr=art'));

    if (response.statusCode == 200) {
      final body = utf8.decode(response.bodyBytes);
      return jsonDecode(body);
    } else {
      throw Exception('Failed to load data');
    }
  }

  Future<dynamic> getCircus() async {
    final response =
        await http.get(Uri.parse(baseUrl + 'art-direction/name?abbr=circus'));

    if (response.statusCode == 200) {
      final body = utf8.decode(response.bodyBytes);
      return jsonDecode(body);
    } else {
      throw Exception('Failed to load data');
    }
  }
}
