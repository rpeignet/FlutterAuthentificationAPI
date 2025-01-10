// lib/screens/profile_screen.dart
import 'package:flutter/material.dart';
import 'package:tplogin/models/login_response_dto.dart';

class ProfileScreen extends StatelessWidget {
  final LoginResponseDTO user;

  const ProfileScreen({
    super.key,
    required this.user,
  });
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Profil de l\'Utilisateur'),
        actions: [
          IconButton(
            icon: const Icon(Icons.logout),
            onPressed: () {
              // Action de déconnexion
              Navigator.pop(context);
            },
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            // Affichage des informations du profil
            ListTile(
              leading: const Icon(Icons.person),
              title: const Text('Nom'),
              subtitle: Text('${user.firstName} ${user.lastName}'),
            ),
            ListTile(
              leading: const Icon(Icons.email),
              title: const Text('Email'),
              subtitle: Text(user.email),
            ),
            ListTile(
              leading: const Icon(Icons.security),
              title: const Text('Rôle'),
              subtitle: Text(user.role),
            ),
            const SizedBox(height: 24.0),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context);
              },
              child: const Text('Se déconnecter'),
            ),
          ],
        ),
      ),
    );
  }
}
