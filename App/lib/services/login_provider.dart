import 'dart:convert';
import 'dart:developer';

import 'package:tplogin/models/login_request_dto.dart';
import 'package:tplogin/models/login_response_dto.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:riverpod_annotation/riverpod_annotation.dart';
import 'package:http/http.dart' as http;

part 'login_provider.g.dart';

@riverpod
Future<LoginResponseDTO> login(
  Ref ref, {
  required String email,
  required String password,
}) async {
  return await _checkLogin(
    data: LoginRequestDTO(
      email: email,
      password: password,
    ),
  );
}

Future<LoginResponseDTO> _checkLogin({required LoginRequestDTO data}) async {
  final url = Uri.parse('http://localhost:8080/api/auth/login');

  final httpResponse = await http.post(
    url,
    body: jsonEncode(data.toJson()),
    headers: {
      "Content-Type": "application/json",
    },
  );
  switch (httpResponse.statusCode) {
    case (200):
      log("Réponse OK de l'api");
      break;
    case (400):
      log("Erreur retourné par l'api");

      /// Dans le cas d'une erreur retournée par l'api,
      /// Le détail gérée par l'état de la valeur asynchrone 
      /// et est affichée sur la page avec une pop-up.
      break;
  }
  final responseRaw = json.decode(httpResponse.body);

  return LoginResponseDTO.fromJson(responseRaw);
}
