import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Person> persons = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static Long lastId = 3L;

    public static void main(String[] args) {
        int menu;

        addDummyData();

        do {
            System.out.println("-- OOP COURSE NET DOSEN DAN MAHASISWA --");
            System.out.println("========================================");
            System.out.println("Pilih Menu");
            System.out.println("1. Tambah Person");
            System.out.println("2. Tambah Dosen");
            System.out.println("3. Tambah Mahasiswa");
            System.out.println("4. Tampil Person");
            System.out.println("5. Tampil Dosen");
            System.out.println("6. Tampil Mahasiswa");
            System.out.println("7. Tampil Semua");
            System.out.println("8. Keluar");
            System.out.print("Menu : ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    addLecturer();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    showPersons();
                    break;
                case 5:
                    showLecturers();
                    break;
                case 6:
                    showStudents();
                    break;
                case 7:
                    showAll();
                    break;
                case 8:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        } while (menu != 8);
    }

    private static void addDummyData() {
        Person person1 = new Person(1L, "Budi", 20);
        persons.add(person1);

        Lacturer lacturer1 = new Lacturer(2L, "Susi", 30, 10000000L, "Fakultas Kedokteran");
        persons.add(lacturer1);

        Student student1 = new Student(3L, "Rudi", 19, 3.5, "Teknik Informatika");
        persons.add(student1);
    }

    private static void addPerson() {
        System.out.println("-- Tambah Person --");
        Long personId = getValidId();
        if (personId == null) {
            System.out.println("ID sudah ada");
            System.out.print("Ketik apa saja untuk melanjutkan : ");
            scanner.nextLine();
            return;
        }
        System.out.print("Nama: ");
        String personName = scanner.nextLine();
        System.out.print("Umur: ");
        int personAge = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(personId, personName, personAge);
        persons.add(person);
        System.out.println("Person berhasil ditambahkan.");
    }

    private static void addLecturer() {
        System.out.println("-- Tambah Dosen --");
        Long lecturerId = getValidId();
        if (lecturerId == null) {
            System.out.println("ID sudah ada");
            System.out.print("Ketik apa saja untuk melanjutkan : ");
            scanner.nextLine();
            return;
        }
        System.out.print("Nama: ");
        String lecturerName = scanner.nextLine();
        System.out.print("Umur: ");
        int lecturerAge = scanner.nextInt();
        System.out.print("Gaji: ");
        long lecturerSalary = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Fakultas: ");
        String lecturerFaculty = scanner.nextLine();

        Lacturer lecturer = new Lacturer(lecturerId, lecturerName, lecturerAge, lecturerSalary, lecturerFaculty);
        persons.add(lecturer);
        System.out.println("Dosen berhasil ditambahkan.");
    }

    private static void addStudent() {
        System.out.println("-- Tambah Mahasiswa --");
        Long studentId = getValidId();
        if (studentId == null) {
            System.out.println("ID sudah ada");
            System.out.print("Ketik apa saja untuk melanjutkan : ");
            scanner.nextLine();
            return;
        }
        System.out.print("Nama: ");
        String studentName = scanner.nextLine();
        System.out.print("Umur: ");
        int studentAge = scanner.nextInt();
        System.out.print("IPK: ");
        double studentGpa = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Jurusan: ");
        String studentMajor = scanner.nextLine();

        Student student = new Student(studentId, studentName, studentAge, studentGpa, studentMajor);
        persons.add(student);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void showPersons() {
        System.out.println("-- Tampil Person --");
        for (Person p : persons) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nama: " + p.getName());
            System.out.println("Umur: " + p.getAge());
            System.out.println();
        }
        System.out.print("Ketik apa saja untuk melanjutkan : ");
        scanner.nextLine();
    }

    private static void showLecturers() {
        System.out.println("-- Tampil Dosen --");
        for (Person p : persons) {
            if (p instanceof Lacturer) {
                Lacturer lecturerPerson = (Lacturer) p;
                System.out.println("ID: " + lecturerPerson.getId());
                System.out.println("Nama: " + lecturerPerson.getName());
                System.out.println("Umur: " + lecturerPerson.getAge());
                System.out.println("Gaji: " + lecturerPerson.getSalary());
                System.out.println("Fakultas: " + lecturerPerson.getFaculty());
                System.out.println();
            }
        }
        System.out.print("Ketik apa saja untuk melanjutkan : ");
        scanner.nextLine();
    }

    private static void showStudents() {
        System.out.println("-- Tampil Mahasiswa --");
        for (Person p : persons) {
            if (p instanceof Student) {
                Student studentPerson = (Student) p;
                System.out.println("ID: " + studentPerson.getId());
                System.out.println("Nama: " + studentPerson.getName());
                System.out.println("Umur: " + studentPerson.getAge());
                System.out.println("IPK: " + studentPerson.getGpa());
                System.out.println("Jurusan: " + studentPerson.getMajor());
                System.out.println();
            }
        }
        System.out.print("Ketik apa saja untuk melanjutkan : ");
        scanner.nextLine();
    }

    private static void showAll() {
        System.out.println("-- Tampil Semua --");

        if (persons.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }
        for (Person p : persons) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nama: " + p.getName());
            System.out.println("Umur: " + p.getAge());

            if (p instanceof Lacturer) {
                Lacturer lecturerPerson = (Lacturer) p;
                System.out.println("Gaji: " + lecturerPerson.getSalary());
                System.out.println("Fakultas: " + lecturerPerson.getFaculty());
            } else if (p instanceof Student) {
                Student studentPerson = (Student) p;
                System.out.println("IPK: " + studentPerson.getGpa());
                System.out.println("Jurusan: " + studentPerson.getMajor());
            }

            System.out.println();
        }
        System.out.print("Ketik apa saja untuk melanjutkan : ");
        scanner.nextLine();
    }

    private static Long getValidId() {
//        System.out.print("ID: ");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//
//        for (Person p : persons) {
//            if (p.getId().equals(id)) {
//                return null;
//            }
//        }
//        return id;

        lastId++; // Increment the last ID
        return lastId;
    }
}
