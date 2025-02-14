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

### Refleksi 2
1. Setelah saya mencoba membuat _unit test_, saya merasa kekhawatiran saya terhadap kode yang tidak berfungsi terasa lebih lega. Ketika melakukan pemrograman, saya biasanya akan merasa ada yang kurang dari program saya. Mungkin kurang validasi, mungkin ada _bug_ tersembunyi, mungkin ada kasus yang belum saya simulasikan. Namun dengan _unit test_ saya dapat menyimulasikan setiap kasus yang dapat saya pikirkan tanpa mencobanya secara langsung satu per satu.
   Menurut saya, jumlah _unit test_ yang ada pada sebuah _class_ tergantung pada kebutuhan. Semakin banyak kasus yang dapat ditemukan, tentunya akan membuat _unit test_ semakin kuat dan meningkatkan kepercayaan kita pada program yang telah dibuat.
   Cara untuk memastikan bahwa _unit test_ sudah cukup adalah dengan memikirkan setiap kasus dan menghitung apakah setiap kasus tersebut sudah ditangani oleh setidaknya satu _unit test_ atau tidak. Hal ini membutuhkan kalkulasi, simulasi, dan penalaran kita.
   Jika memiliki 100% _code coverage_, hal tersebut belum berarti bahwa program kita bebas dari _bug_. Hal ini dikarenakan _code coverage_ hanya menghitung apakah sebuah fungsi atau program lainnya sudah masuk dalam tes. Namun belum tentu tes yang dibuat cukup kuat untuk mencakup kasus ujung (_edge case_). Misalnya ketika terdapat sebuah tombol, kita membuat tes untuk menekan tombol tersebut. Namun terkadang terdapat kasus ujung misalnya bagaimana jika tombol ditahan, atau yang lainnya.
2. Memiliki variabel atau _setup_ yang sama akan sangat boros jika dibuat kembali. Hal ini sangat berkaitan dengan salah satu prinsip _clean code_ yang tidak ingin ada _redundancy_, salah satunya adalah kode yang berulang-ulang. Sehingga sebaiknya dibuat pada berkas yang sama. Selain itu, kode yang berulang juga dapat menyulitkan ketika perlu melakukan _maintenance_ karena kita akan melihat kode yang sama pada beberapa berkas.