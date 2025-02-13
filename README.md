## Modul 1
### Refleksi 1
Pada modul kali ini, saya belajar bahwa program yang dibuat sebaiknya dipisah dan dikelompokkan berdasarkan fungsinya masing-masing. Pembagian yang saya pelajari mengelompokkan program menjadi 5 bagian:
- Model
  Setiap _class_ yang akan digunakan sebagai objek untuk menyimpan data akan dikumpulkan pada _folder_ ini
- Repository
  Setiap fungsi yang akan mengakses _database_ akan dikumpulkan disini
- Service
  Semua _business logic_ dikumpulkan disini. Service biasanya akan mengakses Repository untuk mengakses _database_
- Controller
  Controller akan mengatur _requests_ dan _responses_ kemudian meneruskannya pada Service.
- Templates
  Semua halaman HTML dikumpulkan disini.

Dari sini terlihat bahwa program dibuat berlapis-lapis. Mulai dari Templates yang ditampilkan pada pengguna, kemudian ketika seorang pengguna akan menggunakan sebuah fitur akan diteruskan pada Controller, kemudian dari Controller diteruskan pada Service, Kemudian dari Service diteruskan pada Repository, dan cara penyimpanan data pada _database_ terlihat dari Model.

Prinsip _clean code_ yang sudah saya terapkan adalah:
- Struktur kode yang rapi dan pengelompokkan yang jelas
- Penggunaan nama variabel dan fungsi yang deskriptif
- Implementasi UUID untuk keamanan dan keunikan antar data
- Penggunaan Lombok untuk menghindari banyaknya fungsi yang berulang-ulang seperti _Setter_ dan _Getter_

Saya merasa kode saya kurang banyak melakukan validasi yang dapat sangat berpengaruh pada aspek keamanan proyek saya, sehingga kedepannya saya akan lebih banyak melakukan validasi untuk meningkatkan keamanan dan mencegah resiko peretasan.
