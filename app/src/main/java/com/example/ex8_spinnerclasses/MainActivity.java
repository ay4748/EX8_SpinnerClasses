package com.example.ex8_spinnerclasses;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner classSpinner;
    private ListView studentsListView;
    private TextView lastNameTextView, firstNameTextView, birthDateTextView, phoneNumberTextView;

    private Student[][] classStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        classSpinner = findViewById(R.id.class_spinner);
        studentsListView = findViewById(R.id.students_listview);
        lastNameTextView = findViewById(R.id.student_last_name);
        firstNameTextView = findViewById(R.id.student_first_name);
        birthDateTextView = findViewById(R.id.student_birth_date);
        phoneNumberTextView = findViewById(R.id.student_phone_number);

        // Initialize data
        classStudents = new Student[][] {
                {
                        new Student("Cohen", "Eitan", "15/01/2008", "050-123-4567"),
                        new Student("Levi", "Noam", "22/02/2008", "052-234-5678"),
                        new Student("Mizrahi", "Or", "08/03/2008", "053-345-6789"),
                        new Student("Peretz", "Ella", "19/04/2008", "054-456-7890"),
                        new Student("Biton", "Shira", "10/05/2008", "057-567-8901"),
                        new Student("Azoulay", "Yonatan", "25/06/2008", "058-678-9012"),
                        new Student("Goldberg", "Maya", "14/07/2008", "059-789-0123"),
                        new Student("Sharon", "Rami", "03/08/2008", "050-890-1234"),
                        new Student("Golan", "Roni", "28/09/2008", "051-901-2345"),
                        new Student("Baruch", "Amit", "11/10/2008", "053-012-3456")
                },
                {
                        new Student("Ben David", "Lior", "03/01/2008", "050-111-2222"),
                        new Student("Chaim", "Avi", "12/02/2008", "052-222-3333"),
                        new Student("Eliyahu", "Dana", "29/03/2008", "053-333-4444"),
                        new Student("Friedman", "Omer", "06/04/2008", "054-444-5555"),
                        new Student("Harari", "Talia", "17/05/2008", "057-555-6666"),
                        new Student("Israel", "Gil", "30/06/2008", "058-666-7777"),
                        new Student("Katz", "Adi", "22/07/2008", "059-777-8888"),
                        new Student("Levin", "Itay", "15/08/2008", "050-888-9999"),
                        new Student("Malka", "Erez", "09/09/2008", "051-999-0000"),
                        new Student("Natan", "Eyal", "26/10/2008", "053-000-1111")
                },
                {
                        new Student("Ozeri", "Michael", "08/01/2008", "050-121-2121"),
                        new Student("Perry", "Yael", "18/02/2008", "052-232-3232"),
                        new Student("Qedar", "David", "12/03/2008", "053-343-4343"),
                        new Student("Rosen", "Sara", "21/04/2008", "054-454-5454"),
                        new Student("Shamir", "Daniel", "28/05/2008", "057-565-6565"),
                        new Student("Tal", "Hila", "14/06/2008", "058-676-7676"),
                        new Student("Uzan", "Tom", "07/07/2008", "059-787-8787"),
                        new Student("Vaknin", "Hannah", "19/08/2008", "050-898-9898"),
                        new Student("Weiss", "Ariel", "24/09/2008", "051-909-0909"),
                        new Student("Zohar", "Noa", "04/10/2008", "053-101-0101")
                },
                {
                        new Student("Abraham", "Jacob", "27/01/2008", "050-112-3344"),
                        new Student("Barzilay", "Tal", "07/02/2008", "052-223-4455"),
                        new Student("Carmi", "Eden", "19/03/2008", "053-334-5566"),
                        new Student("Dahan", "Ori", "30/04/2008", "054-445-6677"),
                        new Student("Eldar", "Leah", "04/05/2008", "057-556-7788"),
                        new Student("Feinberg", "Ella", "18/06/2002008", "058-667-8899"),
                        new Student("Goldman", "Amir", "29/07/2008", "059-778-9900"),
                        new Student("Hazan", "Shay", "12/08/2008", "050-889-0011"),
                        new Student("Ilan", "Lior", "16/09/2008", "051-990-1122"),
                        new Student("Koren", "Tomer", "23/10/2008", "053-001-2233")
                }
        };

        // Set up Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[] { "Class 1", "Class 2", "Class 3", "Class 4" });
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(spinnerAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateStudentsListView(classStudents[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        studentsListView.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = (Student) parent.getItemAtPosition(position);
            displayStudentDetails(selectedStudent);
        });
    }

    private void updateStudentsListView(Student[] students) {
        ArrayAdapter<Student> studentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentsListView.setAdapter(studentsAdapter);
    }

    private void displayStudentDetails(Student student) {
        lastNameTextView.setText("Family name: " + student.getLastName());
        firstNameTextView.setText("First name: " + student.getFirstName());
        birthDateTextView.setText("Birth Date " + student.getBirthDate());
        phoneNumberTextView.setText("Number" + student.getPhoneNumber());
    }

    private static class Student {
        private final String lastName;
        private final String firstName;
        private final String birthDate;
        private final String phoneNumber;

        public Student(String lastName, String firstName, String birthDate, String phoneNumber) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.birthDate = birthDate;
            this.phoneNumber = phoneNumber;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
}
