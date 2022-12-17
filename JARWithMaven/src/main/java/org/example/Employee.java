package org.example;

public class Employee extends Person{
        private Long id;

        private  String role;

        public Employee(String name,  Long id, String role){
            super(name);
            this.id = id;
            this.role = role;
        }
        public Employee(String name, gender genderType, Integer age, Long id, String role){
            super(name, genderType, age);
            this.id = id;
            this.role = role;
        }

}
