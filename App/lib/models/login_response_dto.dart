class LoginResponseDTO {
  final int id;
  final String firstName;
  final String lastName;
  final String email;
  final String role;
  final int status;
  final String message;

  const LoginResponseDTO({
    required this.id,
    required this.firstName,
    required this.lastName,
    required this.email,
    required this.role,
    required this.status,
    required this.message,
  });

  factory LoginResponseDTO.fromJson(Map<String, dynamic> json) {
    return LoginResponseDTO(
      id: json['id'],
      firstName: json['firstName'],
      lastName: json['lastName'],
      email: json['email'],
      role: json['role'],
      status: json['status'],
      message: json['message'],
    );
  }
}
